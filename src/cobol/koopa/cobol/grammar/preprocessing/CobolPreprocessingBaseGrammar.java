package koopa.cobol.grammar.preprocessing;

import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;
import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.LinkedList;
import java.util.List;

import koopa.cobol.CobolWords;
import koopa.cobol.Copybooks;
import koopa.cobol.data.tags.SyntacticTag;
import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.data.tags.AreaTag;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public abstract class CobolPreprocessingBaseGrammar extends KoopaGrammar {

	public String getNamespace() {
		return "cobol-pp";
	}

	public boolean isCaseSensitive() {
		return false;
	}

	// ============================================================================
	// Program text and separators
	// ............................................................................

	public boolean isProgramText(Token token) {
		return token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
				&& !token.hasTag(AreaTag.COMMENT);
	}

	public boolean isComment(Token token) {
		return token.hasTag(AreaTag.COMMENT);
	}

	public boolean isSeparator(String text) {
		return text.equals(",") || text.equals(";")
				|| text.trim().length() == 0;
	}

	public boolean isSeparator(Token token, Parse parse) {
		if (!token.hasTag(SyntacticTag.SEPARATOR))
			return false;

		String text = token.getText();

		// "Whereas in other contexts, the comma, semicolon, and space can be
		// used interchangeably as separators, the comma has special relevance
		// in the argument lists of intrinsic functions. It is sometimes
		// necessary to use commas as separators between arguments to resolve
		// ambiguity." - Compaq COBOL Reference Manual
		// http://h30266.www3.hp.com/odl/vax/progtool/cobol57a/6296/6296_profile_037.html
		//
		// The testsuite has an example in which this is relevant. Unfortunately
		// I could not find the explanation for this in the standard. The above
		// quote made the difference clear though.
		if (parse != null && ",".equals(text)
				&& parse.getStack().isMatching("function"))
			return false;

		return isSeparator(text);
	}

	// ============================================================================
	// cobolWord
	// ............................................................................

	private ParserCombinator cobolWordParser = null;

	/**
	 * <i>"A COBOL word is a character-string of not more than 31 characters
	 * that forms a compiler-directive word, a context-sensitive word, an
	 * intrinsic-function-name, a reserved word, a system-name, or a
	 * user-defined word. Each character of a COBOL word that is not a special
	 * character word shall be selected from the set of basic letters, basic
	 * digits, extended letters, and the basic special characters hyphen and
	 * underscore. The hyphen or underscore shall not appear as the first or
	 * last character in such words."</i>
	 * 
	 * <hr/>
	 * <i>"Except where specific rules apply, the hyphen (-) and the underline
	 * (_) are treated as the same character in a user- defined word. The
	 * underline (_), however, can begin or end a user-defined word, and the
	 * hyphen (-) cannot."</i>
	 * 
	 * Description from: <a
	 * href="http://h71000.www7.hp.com/doc/82final/6296/6296pro_002.html">HP
	 * COBOL Reference Manual - Character Strings</a>.
	 * 
	 * <hr/>
	 * Because anything in a copybook can be replaced via the COPY statement,
	 * some COBOL words may contain characters which are not legal otherwise. We
	 * allow this behaviour to be configured via
	 * {@linkplain Copybooks#useExtendedCharactersInCopybooks()} and
	 * {@linkplain Copybooks#isExtendedPart(String)}.
	 */
	public ParserCombinator cobolWord() {
		if (cobolWordParser == null) {
			FutureParser future = scoped("cobolWord");
			cobolWordParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					boolean extendedRules = CobolWords
							.useExtendedCharactersInCopybooks()
							&& parse.getStack().isMatching("copybook");

					Stream stream = parse.getStream();

					skipSeparators(parse);

					List<Token> parts = new LinkedList<Token>();
					while (true) {
						Token token = stream.forward();

						if (token == null) {
							break;

						} else if (extendedRules
								&& token.hasTag(PROGRAM_TEXT_AREA)
								&& token.hasTag(SEPARATOR)
								&& CobolWords.isExtendedPart(token.getText())) {
							// Allowing this separator to be part of a COBOL
							// word.

						} else if (!token.hasTag(PROGRAM_TEXT_AREA)
								|| !token.hasTag(CHARACTER_STRING)
								|| !isCobolWordPart(token.getText())) {
							stream.rewind(token);
							break;
						}

						parts.add(token);
					}

					if (parts.isEmpty())
						return false;

					final Token cobolWord = Tokens.join(parts,
							CHARACTER_STRING, PROGRAM_TEXT_AREA);

					final String text = cobolWord.getText();
					if (!CobolWords.accepts(text)) {
						if (parse.getTrace().isEnabled())
							parse.getTrace().add(
									"no; illegal cobol word: " + text);

						return false;
					}

					if (parse.getStack().isKeyword(text.toUpperCase())) {
						if (parse.getTrace().isEnabled())
							parse.getTrace().add("no; keyword: " + text);

						return false;
					}

					parse.getStack().getScope().setReturnValue(cobolWord);
					return true;
				}

				private boolean isCobolWordPart(String text) {
					final int len = text.length();

					for (int i = 0; i < len; i++) {
						final char c = text.charAt(i);

						if (c >= 'A' && c <= 'Z')
							continue;

						if (c >= 'a' && c <= 'z')
							continue;

						if (c >= '0' && c <= '9')
							continue;

						if (c == '-' || c == '_')
							continue;

						return false;
					}

					return true;
				}

				public String toString() {
					return "cobol-pp:cobolWord";
				}
			});
		}
		return cobolWordParser;
	}

	// ============================================================================
	// integerLiteral
	// ............................................................................

	private ParserCombinator integerLiteralParser = null;

	public ParserCombinator integerLiteral() {
		if (integerLiteralParser == null) {
			FutureParser future = scoped("integerLiteral");
			integerLiteralParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipSeparators(parse);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)
							&& token.hasTag(SyntacticTag.INTEGER_LITERAL)) {

						parse.getStack().getScope().setReturnValue(token);
						return true;

					} else
						return false;
				}
			});
		}
		return integerLiteralParser;
	}

	// ============================================================================
	// booleanLiteral
	// ............................................................................

	private ParserCombinator booleanLiteralParser = null;

	public ParserCombinator booleanLiteral() {
		if (booleanLiteralParser == null) {
			FutureParser future = scoped("booleanLiteral");
			booleanLiteralParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipSeparators(parse);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)
							&& token.hasTag(SyntacticTag.BOOLEAN_LITERAL)) {

						parse.getStack().getScope().setReturnValue(token);
						return true;

					} else
						return false;
				}
			});
		}
		return booleanLiteralParser;
	}

	// ============================================================================
	// hexadecimal
	// ............................................................................

	private ParserCombinator hexadecimalParser = null;

	public ParserCombinator hexadecimal() {
		if (hexadecimalParser == null) {
			FutureParser future = scoped("hexadecimal");
			hexadecimalParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipSeparators(parse);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)
							&& token.hasTag(SyntacticTag.HEXADECIMAL_LITERAL)) {

						parse.getStack().getScope().setReturnValue(token);
						return true;

					} else
						return false;
				}
			});
		}
		return hexadecimalParser;
	}

	// ============================================================================
	// alphanumericLiteral
	// ............................................................................

	private ParserCombinator alphanumericLiteralParser = null;

	public ParserCombinator alphanumericLiteral() {
		if (alphanumericLiteralParser == null) {
			FutureParser future = scoped("alphanumericLiteral");
			alphanumericLiteralParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipSeparators(parse);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)
							&& token.hasTag(SyntacticTag.STRING_LITERAL)) {

						parse.getStack().getScope().setReturnValue(token);
						return true;

					} else
						return false;
				}
			});
		}
		return alphanumericLiteralParser;
	}

	// ============================================================================
	// pseudo literal
	// ............................................................................

	private ParserCombinator pseudoLiteralParser = null;

	public ParserCombinator pseudoLiteral() {
		if (pseudoLiteralParser == null) {
			FutureParser future = scoped("pseudoLiteral");
			pseudoLiteralParser = future;
			future.setParser(new ParserCombinator() {
				public boolean matches(Parse parse) {
					Stream stream = parse.getStream();

					skipSeparators(parse);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)
							&& token.hasTag(SyntacticTag.PSEUDO_LITERAL)) {

						parse.getStack().getScope().setReturnValue(token);
						return true;

					} else
						return false;
				}
			});
		}
		return pseudoLiteralParser;
	}
}