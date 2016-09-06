package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.data.tags.SyntacticTag.WORD;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.data.tags.SyntacticTag;

import org.apache.log4j.Logger;

/**
 * This class knows how to split up a {@linkplain Token} into its basic
 * elements, as defined in {@linkplain SyntacticTag}.
 */
public class TokenSeparationLogic {

	private static final Logger LOGGER = Logger.getLogger("token_separation");

	public static List<Token> apply(final Token token) {
		final List<Token> tokens = new LinkedList<Token>();

		final String text = token.getText();
		final int length = text.length();

		int position = 0;

		while (position < length) {
			final char c = text.charAt(position);

			if (isWhitespace(c)) {
				position = whitespace(token, text, position, length, tokens);

			} else if (startsString(c)) {
				// STRING LITERAL.
				position = string(token, text, position, 0, length, tokens);

			} else if (isDigit(c)) {
				position = number(token, text, position, length, tokens);

			} else if (isLetter(c)) {
				position = word(token, text, position, length, tokens);

			} else {
				// Everything else...
				position = separator(token, text, position, length, tokens);
			}
		}

		return tokens;
	}

	private static boolean startsString(final char c) {
		return c == '"' || c == '\'';
	}

	private static boolean isWhitespace(final char c) {
		return c == ' ' || c == '\t';
	}

	private static int whitespace(final Token token, final String text,
			final int start, final int length, List<Token> tokens) {

		int position = start + 1;
		while (position < length && isWhitespace(text.charAt(position))) {
			position += 1;
		}

		final Token separator = Tokens.subtoken(token, start, position)
				.withTags(PROGRAM_TEXT_AREA, SEPARATOR, WHITESPACE);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Separator: " + separator);

		tokens.add(separator);

		return position;
	}

	private static int string(final Token token, final String text,
			final int start, final int prefixLength, final int length,
			List<Token> tokens) {

		final char quotationMark = text.charAt(start + prefixLength);

		int position = start + prefixLength + 1;
		while (position < length) {
			final char c = text.charAt(position);

			if (c != quotationMark) {
				// Still in string literal.
				position += 1;
				continue;
			}

			if (position + 1 == length) {
				final Token stringliteral = Tokens.subtoken(token, start)
						.withTags(PROGRAM_TEXT_AREA, STRING);

				if (LOGGER.isTraceEnabled())
					LOGGER.trace("String literal: " + stringliteral);

				tokens.add(stringliteral);
				return position + 1;
			}

			final char d = text.charAt(position + 1);

			if (d == quotationMark) {
				// Escaped quotation mark.
				position += 2;
				continue;
			}

			// Completed string literal.
			final Token stringliteral = Tokens.subtoken(token, start,
					position + 1).withTags(PROGRAM_TEXT_AREA, STRING);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("String literal: " + stringliteral);

			tokens.add(stringliteral);
			return position + 1;
		}

		// TODO Incomplete string literal. Throw error?
		final Token stringliteral = Tokens.subtoken(token, start).withTags(
				PROGRAM_TEXT_AREA, STRING);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Incomplete string literal: " + stringliteral);

		tokens.add(stringliteral);
		return length;
	}

	private static int word(final Token token, final String text,
			final int start, final int length, List<Token> tokens) {

		int position = start + 1;
		while (position < length) {
			char c = text.charAt(position);
			if (!isLetter(c) && c != '-')
				break;
			position += 1;
		}

		final Token word = Tokens.subtoken(token, start, position).withTags(
				PROGRAM_TEXT_AREA, WORD);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Word: " + word);

		tokens.add(word);
		return position;
	}

	private static int number(final Token token, final String text,
			final int start, final int length, List<Token> tokens) {

		int position = start + 1;
		while (position < length) {
			char c = text.charAt(position);
			if (!isDigit(c))
				break;
			position += 1;
		}

		Token number = Tokens.subtoken(token, start, position).withTags(
				PROGRAM_TEXT_AREA, NUMBER);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Number: " + number);

		tokens.add(number);
		return position;
	}

	private static boolean isLetter(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	private static boolean isDigit(char c) {
		return '0' <= c && c <= '9';
	}

	private static int separator(final Token token, final String text,
			final int start, final int length, List<Token> tokens) {

		int position = start + 1;
		final Token separator = Tokens.subtoken(token, start, position)
				.withTags(PROGRAM_TEXT_AREA, SEPARATOR);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Other: " + separator);

		tokens.add(separator);
		return position;
	}
}
