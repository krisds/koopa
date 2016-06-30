package koopa.dsl.kg.source;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.isWhitespace;
import static koopa.core.data.tags.AreaTag.END_OF_LINE;
import static koopa.dsl.kg.tags.KGTag.COMMENT;
import static koopa.dsl.kg.tags.KGTag.IDENTIFIER;
import static koopa.dsl.kg.tags.KGTag.LITERAL;
import static koopa.dsl.kg.tags.KGTag.NATIVE_CODE_BLOCK;
import static koopa.dsl.kg.tags.KGTag.NUMBER;
import static koopa.dsl.kg.tags.KGTag.QUOTED_LITERAL;
import static koopa.dsl.kg.tags.KGTag.TEXT;
import static koopa.dsl.kg.tags.KGTag.WHITESPACE;
import static koopa.dsl.kg.tags.KGTag.WORD;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

public class KGTokenizer extends ChainingSource<Token, Token> implements Source<Token> {

	private static final String OPERATOR_CHARACTERS = "()[]|+*=->!$:.@%,";
	public static final char SCOPE_SEPARATOR_CHARACTER = '$';

	private Token token = null;
	private int index = 0;

	public KGTokenizer(Source<Token> source) {
		super(source);
	}

	@Override
	protected Token nxt1() {
		// Grab a new token if needed.
		if (token == null || index >= token.getLength()) {
			index = 0;
			token = source.next();
		}

		// Return null if there is none.
		if (token == null)
			return null;

		// Line separators are forwarded as they are.
		if (token.hasTag(END_OF_LINE)) {
			index = token.getLength();
			return token;
		}

		char c = token.charAt(index);

		if (c == '#')
			return comment();
		else if (c == '\'')
			return quotedLiteral();
		else if (c == '{')
			return nativeCodeBlock();
		else if (isWhitespace(c))
			return whitespace();
		else if (isLetter(c))
			return word();
		else if (isDigit(c))
			return number();
		else if (isOperator(c))
			return operator();
		else if (c == '_')
			return any();
		else
			return unknown(c);
	}

	private Token unknown(char c) {
		int start = index;
		index = token.getLength();
		System.err.println("Unexpected character at line "
				+ token.getStart().getLinenumber() + " column " + start + ": '"
				+ c + "'");
		return Tokens.subtoken(token, start);
	}

	private Token comment() {
		int start = index;
		index = token.getLength();

		return Tokens.subtoken(token, start, index).withTags(COMMENT);
	}

	private Token quotedLiteral() {
		int start = index;
		index += 1;

		while (index < token.getLength() && token.charAt(index) != '\'')
			index += 1;

		if (index >= token.getLength())
			System.err
					.println("Warning, incomplete quoted literal. Starts line "
							+ token.getStart().getLinenumber() + " column "
							+ start + ".");
		else
			index += 1;

		return Tokens.subtoken(token, start, index).withTags(TEXT,
				QUOTED_LITERAL);
	}

	private Token nativeCodeBlock() {
		int start = index;
		index += 1;

		int nesting = 1;
		while (index < token.getLength() && nesting > 0) {
			char c = token.charAt(index);

			if (c == '{')
				nesting += 1;
			else if (c == '}')
				nesting -= 1;

			index += 1;
		}

		if (nesting > 0)
			System.err.println("Warning, incomplete native code. Starts line "
					+ token.getStart().getLinenumber() + " column " + start
					+ ".");

		return Tokens.subtoken(token, start, index).withTags(TEXT,
				NATIVE_CODE_BLOCK);
	}

	private Token whitespace() {
		int start = index;
		index += 1;

		while (index < token.getLength() && isWhitespace(token.charAt(index)))
			index += 1;

		return Tokens.subtoken(token, start, index).withTags(TEXT, WHITESPACE);
	}

	private Token word() {
		int start = index;
		boolean allUppercase = true;

		while (index < token.getLength()) {
			char c = token.charAt(index);

			if (c == '-' || c == '_' || isLetterOrDigit(c)
					|| c == SCOPE_SEPARATOR_CHARACTER) {
				if (isLetter(c))
					allUppercase = allUppercase && isUpperCase(c);

				index += 1;

			} else
				break;
		}

		return Tokens.subtoken(token, start, index).withTags(TEXT, WORD,
				allUppercase ? LITERAL : IDENTIFIER);
	}

	private Token number() {
		int start = index;
		index += 1;

		while (index < token.getLength() && isDigit(token.charAt(index)))
			index += 1;

		return Tokens.subtoken(token, start, index).withTags(TEXT, NUMBER);
	}

	private boolean isOperator(char c) {
		return OPERATOR_CHARACTERS.indexOf(c) >= 0;
	}

	private Token operator() {
		int start = index;
		index += 1;

		return Tokens.subtoken(token, start, index).withTags(TEXT);
	}

	private Token any() {
		int start = index;
		index += 1;

		return Tokens.subtoken(token, start, index).withTags(TEXT, WORD);
	}

	public void close() {
		source.close();
	}
}
