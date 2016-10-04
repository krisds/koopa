package koopa.cobol.grammar;

import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.NUMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import koopa.cobol.cics.grammar.CICSGrammar;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sql.grammar.SQLGrammar;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class CobolBaseGrammar extends CobolPreprocessingGrammar {

	public String getNamespace() {
		return "cobol";
	}

	// ============================================================================
	// pictureString
	// ............................................................................

	private ParserCombinator pictureStringParser = null;

	public ParserCombinator pictureString() {
		if (pictureStringParser == null) {
			FutureParser future = scoped("pictureString");
			pictureStringParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipAll(parse);

					int numberOfTokens = 0;
					List<Token> picture = new ArrayList<Token>();

					while (true) {
						final Token token = stream.forward();

						if (token == null)
							break;

						if (!isProgramText(token)) {
							stream.rewind(token);
							break;
						}

						String text = token.getText();
						// Semicolons are not legal picture characters.
						// Neither is whitespace.
						if (";".equals(text) || text.trim().length() == 0) {
							stream.rewind(token);
							break;
						}

						picture.add(token);
						numberOfTokens += 1;
					}

					if (numberOfTokens == 0)
						return false;

					final Token lastToken = picture.get(numberOfTokens - 1);
					if (lastToken.getText().equals(".")) {
						picture.remove(numberOfTokens - 1);
						stream.rewind(lastToken);
					}

					return true;
				}
			});
		}
		return pictureStringParser;
	}

	// ============================================================================
	// levelNumber
	// ............................................................................

	private ParserCombinator levelNumberParser = null;

	public ParserCombinator levelNumber() {
		if (levelNumberParser == null) {
			FutureParser future = scoped("levelNumber");
			levelNumberParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipAll(parse);

					Token token = stream.forward();

					// TODO @NUMBER _, but with extra semantic check ? Or list
					// all possibilities ?
					if (token != null && token.hasTag(NUMBER)
							&& isLevelNumber(token.getText())) {

						return true;

					} else
						return false;
				}

				private boolean isLevelNumber(String text) {
					/*
					 * The level number is a special numeric literal consisting
					 * of one to two digits. A level number which is less than
					 * 10 may be written either as a single digit or with a
					 * leading zero.
					 * 
					 * Description from: Fujitsu Siemens, document
					 * U41112-J-Z125-3-76.
					 */
					final int len = text.length();
					if (len == 0 || len > 2) {
						return false;
					}

					final char c = text.charAt(0);
					if (c < '0' || c > '9') {
						return false;
					}

					if (len == 2) {
						final char d = text.charAt(0);
						if (d < '0' || d > '9') {
							return false;
						}
					}

					int val = Integer.parseInt(text);

					return (val > 0 && val <= 49) || (val == 77);
				}
			});
		}
		return levelNumberParser;
	}

	// ============================================================================
	// sqlStatement
	// ............................................................................

	private SQLGrammar sqlGrammar = null;

	// TODO This is a poor man's version of grammar composition...
	public ParserCombinator sqlStatement() {
		if (sqlGrammar == null)
			sqlGrammar = new SQLGrammar();

		return sqlGrammar.sqlStatement();
	}

	// ============================================================================
	// cicsStatement
	// ............................................................................

	private CICSGrammar cicsGrammar = null;

	// TODO This is a poor man's version of grammar composition...
	public ParserCombinator cicsStatement() {
		if (cicsGrammar == null)
			cicsGrammar = new CICSGrammar();

		return cicsGrammar.cicsStatement();
	}

	// ============================================================================
	// commentEntry
	// ............................................................................

	/**
	 * OSVS allows a comment entry to have words in area A, except for ones in
	 * this list.
	 */
	private static final List<String> END_OF_COMMENT_ENTRY_MARKERS //
	= Collections.unmodifiableList(Arrays.asList(new String[] { //
			"PROGRAM-ID", "AUTHOR", "INSTALLATION", "DATE-WRITTEN",
					"DATE-COMPILED", "SECURITY", "ENVIRONMENT", "DATA",
					"PROCEDURE" }));

	private ParserCombinator commentEntryParser = null;

	/**
	 * This is a deprecated language feature, but one which appears quite
	 * prominently in the testsuite.
	 * <p>
	 * The implementation is based on a description found here: <a href=
	 * "http://supportline.microfocus.com/documentation/books/sx20books/lrpdfx.htm"
	 * >Micro Focus COBOL - 5.1 Identification Division</a>.
	 */
	public ParserCombinator commentEntry() {
		if (commentEntryParser == null) {
			FutureParser future = scoped("commentEntry");
			commentEntryParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					// First thing we need to know is the format being used.
					Token peek = stream.peek();

					// Of course, if we're at the end of the stream, there's not
					// much point.
					if (peek == null)
						return false;

					// So, what is it ?
					final SourceFormat format = peek.hasTag(FREE) ? FREE
							: FIXED;

					// We want to only confirm a comment entry match if we saw
					// something other than whitespace.
					boolean sawSomething = false;

					while (true) {
						final Token token = stream.forward();

						if (token == null)
							return sawSomething;

						// "If the Compiler directive SOURCEFORMAT is
						// specified as FREE, the comment-entry cannot be
						// continued; the next line will begin the next
						// non-comment entry." - MF
						if (format == FREE && token.hasTag(END_OF_LINE)) {
							stream.rewind(token);
							return sawSomething;
						}

						if (!token.hasTag(PROGRAM_TEXT_AREA))
							continue;

						if (token.hasTag(AreaTag.COMMENT))
							continue;

						final String text = token.getText().toUpperCase();
						if (text.trim().length() == 0)
							continue;

						// "If the Compiler directive SOURCEFORMAT is specified
						// as or defaulted to FIXED, the comment-entry can be
						// contained on one or more lines but is restricted to
						// area B of those lines; the next line commencing in
						// area A will begin the next non-comment entry." - MF
						//
						// For OSVS though: "The comment-entry can be contained
						// in either area A or area B of the comment-entry
						// lines. However, the next occurrence in area A of any
						// one of the following COBOL words or phrases will
						// terminate the comment-entry and begin the next
						// paragraph or division: PROGRAM-ID, AUTHOR,
						// INSTALLATION, DATE-WRITTEN, DATE-COMPILED, SECURITY,
						// ENVIRONMENT, DATA, PROCEDURE." - MF
						//
						// We're allowing words in area A, except for those
						// mentioned by OSVS. It seems like a reasonable
						// default.
						if (format == FIXED
								&& token.getStart().getPositionInLine() < 11
								&& END_OF_COMMENT_ENTRY_MARKERS.contains(text)) {
							stream.rewind(token);
							return sawSomething;
						}

						sawSomething = true;
					}
				}
			});
		}

		return commentEntryParser;
	}
}
