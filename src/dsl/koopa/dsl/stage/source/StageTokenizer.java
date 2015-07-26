package koopa.dsl.stage.source;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.isWhitespace;
import static koopa.core.data.tags.AreaTag.END_OF_LINE;
import static koopa.dsl.stage.tags.StageTag.COMMENT;
import static koopa.dsl.stage.tags.StageTag.IDENTIFIER;
import static koopa.dsl.stage.tags.StageTag.SAMPLE;
import static koopa.dsl.stage.tags.StageTag.TEXT;
import static koopa.dsl.stage.tags.StageTag.WHITESPACE;
import static koopa.dsl.stage.tags.StageTag.WORD;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

public class StageTokenizer extends BasicSource<Token> implements Source<Token> {

	private static final String OPERATOR_CHARACTERS = ".;+-";

	private final Source<Token> source;

	private Token token = null;
	private int index = 0;

	public StageTokenizer(Source<Token> source) {
		this.source = source;
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
		else if (c == '[')
			return sample();
		else if (isWhitespace(c))
			return whitespace();
		else if (isLetter(c))
			return word();
		else if (isOperator(c))
			return operator();
		else
			return unknown(c);
	}

	private Token comment() {
		int start = index;
		index = token.getLength();

		return Tokens.subtoken(token, start, index).withTags(COMMENT);
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

		while (index < token.getLength()) {
			char c = token.charAt(index);

			if (c == '-' || c == '_' || isLetterOrDigit(c)) {
				index += 1;

			} else
				break;
		}

		return Tokens.subtoken(token, start, index).withTags(TEXT, WORD,
				IDENTIFIER);
	}

	private boolean isOperator(char c) {
		return OPERATOR_CHARACTERS.indexOf(c) >= 0;
	}

	private Token operator() {
		int start = index;
		index += 1;

		return Tokens.subtoken(token, start, index).withTags(TEXT);
	}

	private Token sample() {
		List<Token> parts = new LinkedList<Token>();

		int start = index;
		index += 1;

		int nesting = 1;
		while (nesting > 0 && token != null) {
			Token part = token;

			if (!token.hasTag(END_OF_LINE)) {

				while (index < token.getLength() && nesting > 0) {
					char c = token.charAt(index);

					if (c == '[')
						nesting += 1;
					else if (c == ']')
						nesting -= 1;

					index += 1;
				}

				part = Tokens.subtoken(token, start, index);
			}

			parts.add(part);

			if (nesting > 0) {
				token = source.next();
				index = 0;
			}
		}

		return Tokens.join(parts, TEXT, SAMPLE);
	}

	private Token unknown(char c) {
		int start = index;
		index = token.getLength();
		System.err.println("Unexpected character at line "
				+ token.getStart().getLinenumber() + " column " + start + ": '"
				+ c + "'");
		return Tokens.subtoken(token, start);
	}

	public void close() {
		source.close();
	}
}
