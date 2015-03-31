package koopa.cobol.grammar;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.ArrayList;
import java.util.List;

import koopa.cobol.cics.grammar.CICSGrammar;
import koopa.cobol.data.tags.SyntacticTag;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.sql.grammar.SQLGrammar;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParseStream;
import koopa.core.parsers.Parser;

public class CobolBaseGrammar extends CobolPreprocessingGrammar {

	@Override
	protected String getNamespace() {
		return "cobol";
	}

	// ============================================================================
	// pictureString
	// ............................................................................

	private Parser pictureStringParser = null;

	public Parser pictureString() {
		if (pictureStringParser == null) {
			FutureParser future = scoped("pictureString");
			pictureStringParser = future;
			future.setParser(new Parser() {
				public boolean accepts(ParseStream stream) {
					skipSeparators(stream);

					int numberOfTokens = 0;
					List<Token> picture = new ArrayList<Token>();

					while (true) {
						final Token token = stream.forward();

						if (token == null) {
							break;
						}

						if (!isProgramText(token)) {
							stream.rewind(token);
							break;
						}

						if (isSeparator(token)
								&& token.getText().trim().length() == 0) {
							stream.rewind(token);
							break;
						}

						picture.add(token);
						numberOfTokens += 1;
					}

					if (numberOfTokens == 0) {
						return false;
					}

					final Token lastToken = picture.get(numberOfTokens - 1);
					if (lastToken.hasTag(SyntacticTag.SEPARATOR)
							&& lastToken.getText().equals(".")) {
						picture.remove(numberOfTokens - 1);
						stream.rewind(lastToken);
					}

					returnToken(new Token(picture));
					return true;
				}
			});
		}
		return pictureStringParser;
	}

	// ============================================================================
	// levelNumber
	// ............................................................................

	private Parser levelNumberParser = null;

	public Parser levelNumber() {
		if (levelNumberParser == null) {
			FutureParser future = scoped("levelNumber");
			levelNumberParser = future;
			future.setParser(new Parser() {
				public boolean accepts(ParseStream stream) {
					skipSeparators(stream);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)
							&& isLevelNumber(token.getText())) {

						returnToken(token);
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
	public Parser sqlStatement() {
		if (sqlGrammar == null)
			sqlGrammar = new SQLGrammar();

		return sqlGrammar.sqlStatement();
	}

	// ============================================================================
	// cicsStatement
	// ............................................................................

	private CICSGrammar cicsGrammar = null;

	// TODO This is a poor man's version of grammar composition...
	public Parser cicsStatement() {
		if (cicsGrammar == null)
			cicsGrammar = new CICSGrammar();

		return cicsGrammar.cicsStatement();
	}

	// ============================================================================
	// commentEnry
	// ............................................................................

	// This is a deprecated language feature, but one which appears quite
	// prominently in the testsuite.

	// Following is based on a description found here:
	// http://supportline.microfocus.com/documentation/books/sx20books/lrpdfx.htm

	private Parser commentEntryParser = null;

	public Parser commentEntry() {
		if (commentEntryParser == null) {
			FutureParser future = scoped("commentEntry");
			commentEntryParser = future;
			future.setParser(new Parser() {
				public boolean accepts(ParseStream stream) {
					boolean sawSomething = false;

					while (true) {
						Token token = stream.forward();

						if (token == null)
							return sawSomething;

						if (!token.hasTag(PROGRAM_TEXT_AREA))
							continue;

						if (token.hasTag(AreaTag.COMMENT))
							continue;

						if (token.getText().trim().length() == 0)
							continue;
						
						// Area B = 12..72, or 11-71 when zero-based.
						if (token.getStart().getPositionInLine() < 11) {
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
