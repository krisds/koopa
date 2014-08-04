package koopa.cobol.sources;

import static koopa.cobol.data.tags.AreaTag.COMMENT;
import static koopa.cobol.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.cobol.data.tags.SyntacticTag.BOOLEAN_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;
import static koopa.cobol.data.tags.SyntacticTag.DECIMAL_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.HEXADECIMAL_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.INTEGER_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.cobol.data.tags.SyntacticTag.SIGNED;
import static koopa.cobol.data.tags.SyntacticTag.STRING_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.UNSIGNED;

import java.io.IOException;

import koopa.cobol.data.tags.AreaTag;
import koopa.cobol.data.tags.SyntacticTag;
import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

import org.apache.log4j.Logger;

public class Separators extends ThreadedSource<Token> implements Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.separators");

	private Source<? extends Token> source = null;

	public Separators(Source<? extends Token> tokenizer) {
		super();

		assert (tokenizer != null);
		this.source = tokenizer;
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			final Token token = source.next();

			if (token == null) {
				break;

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					&& !token.hasTag(AreaTag.COMMENT)
					&& !token.hasTag(AreaTag.COMPILER_DIRECTIVE)) {
				separate(token);

			} else {
				enqueue(token);
			}
		}
	}

	private void separate(final Token token) {
		final String text = token.getText();
		final int length = text.length();

		int position = 0;

		while (position < length) {
			final char c = text.charAt(position);

			// NOTE. The following cases are repeated in the 'other' method. If
			// you update these cases then also update that method!
/*
			if (isSeparatorFollowedBySpace(text, length, position, c)) {
				// SEPARATOR.

				// Based on following definition:
				// "Commas and semicolons can only be used as separators when
				// they are immediately followed by a space."
				// "A period can only be used as a separator when immediately
				// followed by a space."
				//
				// Source: fujcob2k-cob2_bs.pdf, section 2.4.2 (p. 55)
				// Also confirmed in the Yellow Books by Ebbinkhuijsen.
				//
				// Note: I consider end-of-line as a space here, so that periods
				// may be the last character in the line.

				// I choose to split the separator into two parts. The first
				// part is the comma, semicolon or dot. The second part is the
				// following sequence of spaces. I do this so that punctuation
				// remains separate, which I hope will make further processing
				// easier.

				position = separator(token, c, position);

				if (position < length) {
					position = whitespace(token, text, position, length);
				}

			} else 
*/				
			if (isSeparator(c)) {
				// SEPARATOR.
				position = separator(token, c, position);

			} else if (isWhitespace(c)) {
				// SEPARATOR.
				position = whitespace(token, text, position, length);

			} else if (startOfInlineComment(text, position, length, c)) {
				// COMMENT.
				position = inlineComment(token, position, length);

			} else if (startsStringLiteral(c)) {
				// STRING LITERAL.
				position = stringLiteral(token, text, position, 0, length);

			} else if (startOfNullTerminatedString(text, length, position, c)) {
				// NULL-TERMINATED STRING LITERAL: z"String"
				position = stringLiteral(token, text, position, 1, length);

			} else if (startOfNationalString(text, length, position, c)) {
				// NATIONAL STRING LITERAL: n"String"
				position = stringLiteral(token, text, position, 1, length);

			} else if (isPseudoLiteralMarker(text, length, position, c)) {
				// PSEUDO LITERAL (marker)
				position = pseudoLiteral(token, position);

			} else if (startOfBoolean(text, length, position, c)) {
				// NUMERIC BOOLEAN LITERAL: b"01"
				position = booleanLiteral(token, text, position, 1, length);

			} else if (startOfBooleanHexadecimal(text, length, position, c)) {
				// NUMERIC BOOLEAN HEXADECIMAL LITERAL: bx"0A"
				position = booleanLiteral(token, text, position, 2, length);

			} else if (startOfHexadecimal(text, length, position, c)) {
				// NUMERIC HEXADECIMAL LITERAL: h"00"
				position = hexadecimal(token, text, position, 1, length, false);

			} else if (startOfAlphanumericHexadecimal(text, length, position, c)) {
				// ALPHANUMERIC HEXADECIMAL LITERAL: x"00"
				position = hexadecimal(token, text, position, 1, length, true);

			} else if (startOfNationalHexadecimal(text, length, position, c)) {
				// NATIONAL ALPHANUMERIC HEXADECIMAL LITERAL: nx"00"
				position = hexadecimal(token, text, position, 2, length, true);

			} else if (startOfSignedNumber(text, position, length, c)) {
				// SIGNED NUMERIC LITERAL.
				position = signedNumber(token, text, position, length);
/*
			} else if (startsDotDecimal(text, length, position, c)) {
				// UNSIGNED DECIMAL LITERAL.
				position = dotDecimal(token, text, position, length);
*/
			} else if (isLetterOrDigit(c)) {
				// UNSIGNED NUMERIC LITERAL or COBOL WORD.
				position = cobolWordOrNumber(token, text, position, length);

			} else {
				// OTHER.
				position = other(token, text, position, length);
			}
		}
	}

	private boolean startsDotDecimal(final String text, final int length,
			int position, final char c) {
		return c == '.' && position + 1 < length
				&& isDigit(text.charAt(position + 1));
	}

	private boolean isPseudoLiteralMarker(final String text, final int length,
			int position, final char c) {
		return c == '=' && position + 1 < length
				&& text.charAt(position + 1) == '=';
	}

	private boolean startsStringLiteral(final char c) {
		return c == '"' || c == '\'';
	}

	private boolean isWhitespace(final char c) {
		return c == ' ' || c == '\t';
	}

	private boolean isSeparator(final char c) {
		return c == '(' || c == ')' || c == ':' || c == ',' || c == ';' || c == '.';
	}

	private boolean isSeparatorFollowedBySpace(final String text,
			final int length, int position, final char c) {
		return (c == ',' || c == ';' || c == '.')
				&& (position + 1 == length || text.charAt(position + 1) == ' ');
	}

	private boolean startOfNullTerminatedString(final String text,
			final int length, int position, final char c) {
		return (c == 'z' || c == 'Z')
				&& position + 1 < length
				&& (text.charAt(position + 1) == '"' || text
						.charAt(position + 1) == '\'');
	}

	private boolean startOfNationalString(final String text, final int length,
			int position, final char c) {
		return (c == 'n' || c == 'N')
				&& position + 1 < length
				&& (text.charAt(position + 1) == '"' || text
						.charAt(position + 1) == '\'');
	}

	private boolean startOfBoolean(final String text, final int length,
			int position, final char c) {
		return (c == 'b' || c == 'B')
				&& position + 1 < length
				&& (text.charAt(position + 1) == '"' || text
						.charAt(position + 1) == '\'');
	}

	private boolean startOfBooleanHexadecimal(final String text,
			final int length, int position, final char c) {
		return (c == 'b' || c == 'B')
				&& position + 2 < length
				&& (text.charAt(position + 1) == 'x' || text
						.charAt(position + 1) == 'X')
				&& (text.charAt(position + 2) == '"' || text
						.charAt(position + 2) == '\'');
	}

	private boolean startOfHexadecimal(final String text, final int length,
			int position, final char c) {
		return (c == 'h' || c == 'H')
				&& position + 1 < length
				&& (text.charAt(position + 1) == '"' || text
						.charAt(position + 1) == '\'');
	}

	private boolean startOfAlphanumericHexadecimal(final String text,
			final int length, int position, final char c) {
		return (c == 'x' || c == 'X')
				&& position + 1 < length
				&& (text.charAt(position + 1) == '"' || text
						.charAt(position + 1) == '\'');
	}

	private boolean startOfNationalHexadecimal(final String text,
			final int length, int position, final char c) {
		return (c == 'n' || c == 'N')
				&& position + 2 < length
				&& (text.charAt(position + 1) == 'x' || text
						.charAt(position + 1) == 'X')
				&& (text.charAt(position + 2) == '"' || text
						.charAt(position + 2) == '\'');
	}

	private boolean startOfInlineComment(final String text, int position,
			final int length, final char c) {
		return c == '*' && position + 1 < length
				&& text.charAt(position + 1) == '>';
	}

	private boolean startOfSignedNumber(final String text, final int position,
			final int length, final char first) {
		if (first != '+' && first != '-') {
			return false;
		}

		if (position + 1 >= length) {
			return false;
		}

		final char d = text.charAt(position + 1);
		if (isDigit(d)) {
			return true;
		}

		if (d != '.') {
			return false;
		}

		if (position + 2 >= length) {
			return false;
		}

		final char e = text.charAt(position + 2);

		return isDigit(e);
	}

	private int separator(final Token token, final char c, final int start) {
		final Token separator = Tokens.subtoken(token, start, start + 1)
				.withTags(PROGRAM_TEXT_AREA, SEPARATOR);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Separator: " + separator);

		enqueue(separator);
		return start + 1;
	}

	private int whitespace(final Token token, final String text,
			final int start, final int length) {

		int position = start + 1;
		while (position < length && isWhitespace(text.charAt(position))) {
			position += 1;
		}

		final Token separator = Tokens.subtoken(token, start, position)
				.withTags(PROGRAM_TEXT_AREA, SEPARATOR);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Separator: " + separator);

		enqueue(separator);

		return position;
	}

	private int stringLiteral(final Token token, final String text,
			final int start, final int prefixLength, final int length) {

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
						.withTags(PROGRAM_TEXT_AREA, CHARACTER_STRING,
								STRING_LITERAL);

				if (LOGGER.isTraceEnabled())
					LOGGER.trace("String literal: " + stringliteral);

				enqueue(stringliteral);
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
					position + 1).withTags(PROGRAM_TEXT_AREA, CHARACTER_STRING,
					STRING_LITERAL);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("String literal: " + stringliteral);

			enqueue(stringliteral);
			return position + 1;
		}

		// TODO Incomplete string literal. Throw error?
		final Token stringliteral = Tokens.subtoken(token, start).withTags(
				PROGRAM_TEXT_AREA, CHARACTER_STRING, STRING_LITERAL);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Incomplete string literal: " + stringliteral);

		enqueue(stringliteral);
		return length;
	}

	private int inlineComment(final Token token, final int start,
			final int length) {
		final Token comment = Tokens.subtoken(token, start).withTags(
				PROGRAM_TEXT_AREA, COMMENT, CHARACTER_STRING);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Inline comment: " + comment);

		enqueue(comment);
		return length;
	}

	private int pseudoLiteral(final Token token, final int start) {
		final Token pseudoLiteral = Tokens.subtoken(token, start, start + 2)
				.withTags(PROGRAM_TEXT_AREA, SyntacticTag.SEPARATOR);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Pseudo literal separator: " + pseudoLiteral);

		enqueue(pseudoLiteral);
		return start + 2;
	}

	private int booleanLiteral(final Token token, final String text,
			final int start, final int prefixLength, final int length) {

		final char quotationMark = text.charAt(start + prefixLength);

		int position = start + prefixLength + 2;

		while (position < length) {
			final char c = text.charAt(position);
			if (c != quotationMark) {
				// TODO Check if legal character ?
				position += 1;
				continue;
			}

			final Token booleanLiteral = Tokens.subtoken(token, start,
					position + 1).withTags(PROGRAM_TEXT_AREA, CHARACTER_STRING,
					BOOLEAN_LITERAL);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Boolean: " + booleanLiteral);

			enqueue(booleanLiteral);
			return position + 1;
		}

		// TODO Incomplete hexadecimal. Throw error ?

		final Token booleanLiteral = Tokens.subtoken(token, start).withTags(
				PROGRAM_TEXT_AREA, CHARACTER_STRING, BOOLEAN_LITERAL);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Incomplete boolean: " + booleanLiteral);

		enqueue(booleanLiteral);
		return length;
	}

	private int hexadecimal(final Token token, final String text,
			final int start, final int prefixLength, final int length,
			final boolean isAlphanumeric) {

		final char quotationMark = text.charAt(start + prefixLength);

		int position = start + prefixLength + 2;
		while (position < length) {
			final char c = text.charAt(position);
			if (c != quotationMark) {
				// TODO Check if legal character ?
				position += 1;
				continue;
			}

			// TODO Subtoken should include prefix.

			Token hexadecimal = Tokens.subtoken(token, start, position + 1);

			hexadecimal = hexadecimal.withTags(PROGRAM_TEXT_AREA,
					CHARACTER_STRING, HEXADECIMAL_LITERAL);
			if (isAlphanumeric)
				hexadecimal = hexadecimal.withTags(SyntacticTag.STRING_LITERAL);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Hexadecimal: " + hexadecimal);

			enqueue(hexadecimal);
			return position + 1;
		}

		// TODO Incomplete hexadecimal. Throw error ?

		Token hexadecimal = Tokens.subtoken(token, start);

		hexadecimal = hexadecimal.withTags(PROGRAM_TEXT_AREA, CHARACTER_STRING,
				HEXADECIMAL_LITERAL);

		if (isAlphanumeric)
			hexadecimal = hexadecimal.withTags(SyntacticTag.STRING_LITERAL);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Incomplete hexadecimal: " + hexadecimal);

		enqueue(hexadecimal);
		return length;
	}

	private int signedNumber(final Token token, final String text,
			final int start, final int length) {

		final int lengthOfNumber = tryNumericLiteral(text, start + 1, length);

		Token numericLiteral = Tokens.subtoken(token, start, start + 1
				+ lengthOfNumber);

		numericLiteral = numericLiteral.withTags(PROGRAM_TEXT_AREA,
				CHARACTER_STRING,
				(isDecimal(numericLiteral) ? SyntacticTag.DECIMAL_LITERAL
						: SyntacticTag.INTEGER_LITERAL), SIGNED);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Signed numeric literal: " + numericLiteral);

		enqueue(numericLiteral);

		return start + 1 + lengthOfNumber;
	}

	private int dotDecimal(final Token token, final String text,
			final int start, final int length) {

		int position = start + 1;
		while (position < length) {
			final char c = text.charAt(position);

			if (isDigit(c)) {
				position += 1;
				continue;
			}

			final Token dotDecimal = Tokens.subtoken(token, start, position)
					.withTags(PROGRAM_TEXT_AREA, CHARACTER_STRING,
							DECIMAL_LITERAL, UNSIGNED);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Dot decimal: " + dotDecimal);

			enqueue(dotDecimal);
			return position;
		}

		final Token dotDecimal = Tokens.subtoken(token, start).withTags(
				PROGRAM_TEXT_AREA, CHARACTER_STRING, DECIMAL_LITERAL, UNSIGNED);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Dot decimal: " + dotDecimal);

		enqueue(dotDecimal);
		return length;
	}

	private int cobolWordOrNumber(final Token token, final String text,
			final int start, final int length) {

		int match = tryCobolWord(text, start, length);
		if (match > 0) {
			// TODO Cobol word.
			final Token cobolWord = Tokens
					.subtoken(token, start, start + match).withTags(
							PROGRAM_TEXT_AREA, CHARACTER_STRING);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Cobol word: " + cobolWord);

			enqueue(cobolWord);
			return start + match;
		}

		match = tryNumericLiteral(text, start, length);
		if (match > 0) {
			// TODO Cobol word.
			Token numericLiteral = Tokens.subtoken(token, start, start + match);

			numericLiteral = numericLiteral.withTags(PROGRAM_TEXT_AREA,
					CHARACTER_STRING,
					(isDecimal(numericLiteral) ? DECIMAL_LITERAL
							: INTEGER_LITERAL), UNSIGNED);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Unsigned numeric literal: " + numericLiteral);

			enqueue(numericLiteral);
			return start + match;
		}

		return start;
	}

	private boolean isDecimal(Token numericLiteral) {
		final String text = numericLiteral.getText();
		return text.indexOf('.') >= 0 || text.indexOf(',') >= 0;
	}

	private int tryCobolWord(final String text, final int start,
			final int length) {
		boolean sawLetter = false;
		int lastLetterOrDigit = start - 1;

		int position = start;
		while (position < length) {
			final char c = text.charAt(position);

			if (isLetter(c)) {
				sawLetter = true;
				lastLetterOrDigit = position;
				position += 1;
				continue;
			}

			if (isDigit(c)) {
				lastLetterOrDigit = position;
				position += 1;
				continue;
			}

			if (c == '-' || c == '_') {
				// Enterprise COBOL for z/OS, Version 4 Release 2, allows
				// underscores as part of user defined words. See
				// http://publibfp.boulder.ibm.com/epubs/pdf/c2386120.pdf .
				// (With thanks to Peter Tang for finding this.)
				position += 1;
				continue;
			}

			// Not a legal Cobol word character.
			break;
		}

		if (position == start || !sawLetter) {
			// No match.
			return 0;
		}

		// Matched something with at least one letter.
		return lastLetterOrDigit - start + 1;
	}

	private int tryNumericLiteral(final String text, final int start,
			final int length) {

		boolean seenDecimalPoint = false;
		int lastDigit = start - 1;

		int position = start;
		while (position < length) {
			final char c = text.charAt(position);
			if (isDigit(c)) {
				lastDigit = position;
				position += 1;
				continue;
			}
/*
			if (c == '.' || c == ',') {
				if (seenDecimalPoint) {
					break;
				}

				seenDecimalPoint = true;
				position += 1;
				continue;
			}
*/
			// Not a valid character for a number.
			break;
		}

		if (position == start) {
			// No match.
			return 0;
		}

		return lastDigit - start + 1;
	}

	private boolean isLetterOrDigit(char c) {
		return isLetter(c) || isDigit(c);
	}

	private boolean isLetter(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}

	private boolean isDigit(char c) {
		return '0' <= c && c <= '9';
	}

	private int other(final Token token, final String text, final int start,
			final int length) {

		int position = start;
		while (position < length) {
			final char c = text.charAt(position);

			// NOTE. The following is a repetition of the cases in the tokenize
			// method. If you update the cases there you should also update them
			// here.

			if (isSeparatorFollowedBySpace(text, length, position, c)) {
				// SEPARATOR.
				break;

			} else if (isSeparator(c)) {
				// SEPARATOR.
				break;

			} else if (isWhitespace(c)) {
				// SEPARATOR.
				break;

			} else if (startOfInlineComment(text, position, length, c)) {
				// COMMENT.
				break;

			} else if (startsStringLiteral(c)) {
				// STRING LITERAL.
				break;

			} else if (startOfNationalString(text, length, position, c)) {
				// NATIONAL STRING.
				break;

			} else if (startOfNullTerminatedString(text, length, position, c)) {
				// NULL-TERMINATED STRING
				break;

			} else if (isPseudoLiteralMarker(text, length, position, c)) {
				// PSEUDO LITERAL (marker)
				break;

			} else if (startOfBoolean(text, length, position, c)) {
				// BOOLEAN LITERAL
				break;

			} else if (startOfHexadecimal(text, length, position, c)) {
				// HEXADECIMAL LITERAL.
				break;

			} else if (startOfAlphanumericHexadecimal(text, length, position, c)) {
				// ALPHANUMERIC HEXADECIMAL LITERAL.
				break;

			} else if (startOfNationalHexadecimal(text, length, position, c)) {
				// NATIONAL ALPHANUMERIC HEXADECIMAL LITERAL.
				break;

			} else if (startOfSignedNumber(text, position, length, c)) {
				// SIGNED NUMERIC LITERAL.
				break;

			} else if (startsDotDecimal(text, length, position, c)) {
				// UNSIGNED DECIMAL LITERAL.
				break;

			} else if (isLetterOrDigit(c)) {
				// UNSIGNED NUMERIC LITERAL or COBOL WORD.
				break;

			} else {
				// OTHER.
				position += 1;
			}
		}

		final Token separator = Tokens.subtoken(token, start, position)
				.withTags(PROGRAM_TEXT_AREA, CHARACTER_STRING);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Other: " + separator);

		enqueue(separator);
		return position;
	}

	@Override
	public void close() {
		super.close();
		source.close();
	}
}
