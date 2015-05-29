package koopa.cobol.grammar.preprocessing;

import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.LinkedList;
import java.util.List;

import koopa.cobol.data.tags.SyntacticTag;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParseStack;
import koopa.core.parsers.ParseStream;
import koopa.core.parsers.Parser;

public abstract class CobolPreprocessingBaseGrammar extends KoopaGrammar {

	@Override
	protected String getNamespace() {
		return "cobol-pp";
	}

	private static final int DEFAULT_MAX_COBOL_WORD_LENGTH = 31;
	private static final int MAX_COBOL_WORD_LENGTH;

	static {
		String maxCobolWordLengthSetting = System.getProperty(
				"koopa.maxCobolWordLength", "" + DEFAULT_MAX_COBOL_WORD_LENGTH);

		int maxCobolWordLengthValue;
		try {
			maxCobolWordLengthValue = Integer
					.parseInt(maxCobolWordLengthSetting);

		} catch (NumberFormatException e) {
			System.err
					.println("Warning: value for koopa.maxCobolWordLength is not a number: "
							+ maxCobolWordLengthSetting);
			maxCobolWordLengthValue = DEFAULT_MAX_COBOL_WORD_LENGTH;
		}

		if (maxCobolWordLengthValue == 0)
			maxCobolWordLengthValue = DEFAULT_MAX_COBOL_WORD_LENGTH;

		MAX_COBOL_WORD_LENGTH = maxCobolWordLengthValue;
	}

	// ============================================================================
	// Program text and separators
	// ............................................................................

	public boolean isProgramText(Token token) {
		return token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
				&& !token.hasTag(AreaTag.COMMENT);
	}

	protected boolean isSeparator(String text) {
		return text.equals(",") || text.equals(";")
				|| text.trim().length() == 0;
	}

	public boolean isSeparator(Token token, ParseStack stack) {
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
		if (stack != null && ",".equals(text) && stack.isMatching("function"))
			return false;

		return isSeparator(text);
	}

	// ============================================================================
	// cobolWord
	// ............................................................................

	private Parser cobolWordParser = null;

	/*
	 * "A COBOL word is a character-string of not more than 31 characters that
	 * forms a compiler-directive word, a context-sensitive word, an
	 * intrinsic-function-name, a reserved word, a system-name, or a
	 * user-defined word. Each character of a COBOL word that is not a special
	 * character word shall be selected from the set of basic letters, basic
	 * digits, extended letters, and the basic special characters hyphen and
	 * underscore. The hyphen or underscore shall not appear as the first or
	 * last character in such words."
	 * 
	 * ------------------------------------------------------------------------
	 * Except where specific rules apply, the hyphen (-) and the underline (_)
	 * are treated as the same character in a user- defined word. The underline
	 * (_), however, can begin or end a user-defined word, and the hyphen (-)
	 * cannot.
	 * 
	 * Description from: HP COBOL Reference Manual http://h71000.
	 * www7.hp.com/doc/82final/6296/6296pro_002.html
	 */
	public Parser cobolWord() {
		if (cobolWordParser == null) {
			FutureParser future = scoped("cobolWord");
			cobolWordParser = future;
			future.setParser(new Parser() {
				public boolean matches(ParseStream stream) {
					skipSeparators(stream);

					List<Token> parts = new LinkedList<Token>();
					while (true) {
						Token token = stream.forward();

						if (token == null)
							break;

						if (!token.hasTag(PROGRAM_TEXT_AREA)
								|| !token.hasTag(CHARACTER_STRING)
								|| !isCobolWordPart(token.getText())) {
							stream.rewind(token);
							break;
						}

						parts.add(token);
					}

					if (parts.isEmpty())
						return false;

					Token cobolWord = new Token(parts, CHARACTER_STRING,
							PROGRAM_TEXT_AREA);

					String text = cobolWord.getText();
					if (!isCobolWord(cobolWord.getText()))
						return false;

					if (stream.getStack().isKeyword(text))
						return false;

					returnToken(cobolWord);
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

				private boolean isCobolWord(String text) {
					final int len = text.length();
					if (len < 1
							|| (MAX_COBOL_WORD_LENGTH > 0 && len > MAX_COBOL_WORD_LENGTH))
						return false;

					if (text.charAt(0) == '-')
						return false;

					if (text.charAt(len - 1) == '-')
						return false;

					for (int i = 0; i < len; i++) {
						final char c = text.charAt(i);

						if (c < '0' || c > '9')
							return true;
					}

					return false;
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

	private Parser integerLiteralParser = null;

	public Parser integerLiteral() {
		if (integerLiteralParser == null) {
			FutureParser future = scoped("integerLiteral");
			integerLiteralParser = future;
			future.setParser(new Parser() {
				public boolean matches(ParseStream stream) {
					skipSeparators(stream);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
						if (token.hasTag(SyntacticTag.INTEGER_LITERAL)) {

							returnToken(token);
							return true;

						} else
							return false;

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

	private Parser booleanLiteralParser = null;

	public Parser booleanLiteral() {
		if (booleanLiteralParser == null) {
			FutureParser future = scoped("booleanLiteral");
			booleanLiteralParser = future;
			future.setParser(new Parser() {
				public boolean matches(ParseStream stream) {
					skipSeparators(stream);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
						if (token.hasTag(SyntacticTag.BOOLEAN_LITERAL)) {

							returnToken(token);
							return true;

						} else
							return false;

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

	private Parser hexadecimalParser = null;

	public Parser hexadecimal() {
		if (hexadecimalParser == null) {
			FutureParser future = scoped("hexadecimal");
			hexadecimalParser = future;
			future.setParser(new Parser() {
				public boolean matches(ParseStream stream) {
					skipSeparators(stream);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
						if (token.hasTag(SyntacticTag.HEXADECIMAL_LITERAL)) {

							returnToken(token);
							return true;

						} else
							return false;

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

	private Parser alphanumericLiteralParser = null;

	public Parser alphanumericLiteral() {
		if (alphanumericLiteralParser == null) {
			FutureParser future = scoped("alphanumericLiteral");
			alphanumericLiteralParser = future;
			future.setParser(new Parser() {
				public boolean matches(ParseStream stream) {
					skipSeparators(stream);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
						if (token.hasTag(SyntacticTag.STRING_LITERAL)) {

							returnToken(token);
							return true;

						} else
							return false;

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

	private Parser pseudoLiteralParser = null;

	public Parser pseudoLiteral() {
		if (pseudoLiteralParser == null) {
			FutureParser future = scoped("pseudoLiteral");
			pseudoLiteralParser = future;
			future.setParser(new Parser() {
				public boolean matches(ParseStream stream) {
					skipSeparators(stream);

					Token token = stream.forward();

					if (token != null
							&& token.hasTag(SyntacticTag.CHARACTER_STRING)) {
						if (token.hasTag(SyntacticTag.PSEUDO_LITERAL)) {

							returnToken(token);
							return true;

						} else
							return false;

					} else
						return false;
				}
			});
		}
		return pseudoLiteralParser;
	}

}