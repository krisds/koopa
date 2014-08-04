package koopa.cobol.sources;

import static koopa.cobol.data.tags.AreaTag.COMMENT;
import static koopa.cobol.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.cobol.data.tags.AreaTag.END_OF_LINE;
import static koopa.cobol.data.tags.AreaTag.INDICATOR_AREA;
import static koopa.cobol.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.cobol.data.tags.ContinuationsTag.CONTINUED;
import static koopa.cobol.data.tags.ContinuationsTag.CONTINUING;
import static koopa.cobol.data.tags.ContinuationsTag.LEADING_QUOTE;
import static koopa.cobol.data.tags.ContinuationsTag.SKIPPED;

import java.io.IOException;
import java.util.LinkedList;

import koopa.cobol.data.tags.ContinuationsTag;
import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

import org.apache.log4j.Logger;

/**
 * This tokenizer takes tokens coming in and takes care of continuation lines
 * found within them. It will split continued and continuing lines as needed,
 * and tag them and the intermediate parts appropriately (using
 * {@link ContinuationsTag#CONTINUED}, {@link ContinuationsTag#CONTINUING} and
 * {@link ContinuationsTag#SKIPPED}).
 */
public class LineContinuations extends ThreadedSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.continuations");

	private Source<? extends Token> source = null;
	private LinkedList<Token> buffer = null;
	private LinkedList<Token> skippedByContinuation = null;

	public LineContinuations(Source<? extends Token> source) {
		assert (source != null);
		this.source = source;
		this.buffer = new LinkedList<Token>();
		this.skippedByContinuation = new LinkedList<Token>();
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			final Token token = source.next();

			if (token == null) {
				// End of the input. We enqueue everything which is still in the
				// buffer, then call it a day.
				enqueueAll();
				break;
			}

			if (token.hasTag(INDICATOR_AREA) && token.getText().equals("-")) {
				// Found a continuing line. We take care of this in a separate
				// method.
				handleContinuation(token);
				continue;
			}

			if ((token.hasTag(INDICATOR_AREA) && ProgramArea
					.indicatesComment(token.getText().charAt(0)))
					|| token.hasTag(COMMENT)
					|| token.hasTag(COMPILER_DIRECTIVE)) {
				// Possible intervening comment line. Buffer all up to next
				// line.
				buffer(token);
				bufferUpToNextLine();
				continue;
			}

			if (token.hasTag(END_OF_LINE)) {
				// We can only continue the previous line. So if we start
				// processing a new line the current line becomes the line to be
				// continued, and we can enqueue the lines before that one.
				enqueueUpToLine(token.getStart().getLinenumber());
			}

			// Buffer the new token.
			buffer(token);
		}
	}

	private void bufferUpToNextLine() {
		while (true) {
			final Token token = source.next();

			if (token == null)
				return;

			buffer(token);

			if (token.hasTag(END_OF_LINE))
				return;
		}
	}

	private void handleContinuation(final Token continuationIndicator) {
		// The line which is being continued:
		final Token continuedLine = rewindToContinuedLine(continuationIndicator);

		if (continuedLine == null) {
			// TODO ERROR.
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("ERROR while handling continuation: continuedLine == null");

			return;
		}

		// TODO Continued line can not be blank either, right ?

		// The line which is doing the continuation:
		final Token continuingLine = source.next();

		if (continuingLine == null || !continuingLine.hasTag(PROGRAM_TEXT_AREA)
				|| continuingLine.hasTag(COMMENT)
				|| continuingLine.hasTag(COMPILER_DIRECTIVE)) {
			// TODO ERROR.
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("ERROR while handling continuation: continuingLine == null"
						+ " || !continuingLine.hasTag(AreaTag.PROGRAM_TEXT_AREA)"
						+ " || || continuingLine.hasTag(AreaTag.COMMENT)");

			return;
		}

		// Now for the tricky part. According to the Enterprise COBOL for z/OS,
		// Language Reference, Version 4 Release 2, p.56:
		//
		// 'If there is a hyphen in the indicator area of a line, the first
		// nonblank character of the continuation line immediately follows the
		// last nonblank character of the continued line without an intervening
		// space.'
		//
		// All of that goes out the window with string literals. So the first
		// thing we're going to check is whether the continued line contains an
		// open string literal.
		final boolean hasOpenLiteral = hasOpenLiteral(continuedLine);

		if (hasOpenLiteral) {
			// We're continuing an open literal...
			handleContinuationOfOpenLiteral(continuedLine, continuingLine);
			return;
		}

		// That's not all though; even a closed literal may be continued:
		//
		// 'If an alphanumeric or national literal that is to be continued on
		// the next line has as its last character a quotation mark in column
		// 72, the continuation line must start with two consecutive quotation
		// marks. This will result in a single quotation mark as part of the
		// value of the literal.'

		final String rawContinuedLine = continuedLine.getText();
		final char lastCharInContinuedLine = rawContinuedLine
				.charAt(rawContinuedLine.length() - 1);

		// TODO Only in fixed format.
		final boolean endsWithClosedLiteral = !hasOpenLiteral
				&& continuedLine.getEnd().getPositionInLine() == 72
				&& (lastCharInContinuedLine == '"' || lastCharInContinuedLine == '\'');

		if (endsWithClosedLiteral) {
			// If the closed literal is to be continued 'the continuation line
			// must start with two consecutive quotation marks'

			final String rawContinuingLine = continuingLine.getText();
			final int startOfContinuingLine = firstNonBlank(rawContinuingLine);

			if (startOfContinuingLine < 0) {
				// Continuing line is all blanks. So there is no special
				// continuation rule.
				handleDefaultContinuation(continuedLine, continuingLine);
				return;
			}

			if (startOfContinuingLine == rawContinuingLine.length() - 1) {
				// No chance of there being two consecutive quotes, as there is
				// only one non-blank on the line. So no special continuation
				// rule.
				// TODO Check if the one non-blank is a quote ?
				handleDefaultContinuation(continuedLine, continuingLine);
				return;
			}

			final char firstCharInContinuingLine = rawContinuingLine
					.charAt(startOfContinuingLine);
			// TODO Should this match the delimiter of the open literal ?
			if (!isQuotationMark(firstCharInContinuingLine)) {
				// No quotation mark, so no special continuation rule.
				handleDefaultContinuation(continuedLine, continuingLine);
				return;
			}

			final char secondCharInContinuingLine = rawContinuingLine
					.charAt(startOfContinuingLine + 1);
			// Q. Should this match the delimiter of the open literal ?
			// A. I'm assuming it should, as otherwise you don't really have a
			// quoted quote.
			if (secondCharInContinuingLine != lastCharInContinuedLine) {
				// We have only a single quotation mark. This is another special
				// case. Here's why:
				//
				// 'If the last character on the continued line of an
				// alphanumeric or national literal is a single quotation mark
				// in Area B, the continuation line can start with a single
				// quotation mark. This will result in two consecutive literals
				// instead of one continued literal.'
				//
				// This will need some special treatment.
				handleContinuationOfClosedLiteralWithAConsecutiveLiteral(
						continuedLine, continuingLine);
				return;
			}

			// At this point we have two consecutive quotation marks, and so are
			// continuing the closed literal from the continued line.
			handleContinuationOfClosedLiteral(continuedLine, continuingLine,
					startOfContinuingLine);
			return;
		}

		// If we reach this place then there is no special continuation magic
		// involving string literals required.

		handleDefaultContinuation(continuedLine, continuingLine);
	}

	private void handleContinuationOfOpenLiteral(Token continuedLine,
			Token continuingLine) {
		// 'If the continued line contains an alphanumeric or national
		// literal without a closing quotation mark, all spaces at the end
		// of the continued line (through column 72) are considered to be
		// part of the literal.'

		final Token correctedContinuedLine = continuedLine;

		// 'The continuation line must contain a hyphen in the indicator
		// area, and the first nonblank character must be a quotation mark.
		// The continuation of the literal begins with the character
		// immediately following the quotation mark.'
		//
		// We know the indicator is already there, so we can cross that of
		// the list. Next is to find the first non-blank character.
		final String rawContinuingLine = continuingLine.getText();
		final int startOfContinuingLine = firstNonBlank(rawContinuingLine);

		if (startOfContinuingLine < 0) {
			// The line is all blanks...
			// TODO Throw error.
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("ERROR while handling continuation: continuation is all blanks.");
			}
			return;
		}

		// TODO Should this match the delimiter of the open literal ?
		if (!isQuotationMark(rawContinuingLine.charAt(startOfContinuingLine))) {
			// No quotation mark...
			// TODO Throw error.
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("ERROR while handling continuation: "
						+ "expected quotation mark as start of the continuation");
			}
			return;
		}

		final Token[] splitContinuingLine = Tokens.split(continuingLine,
				startOfContinuingLine);

		final Token skippedStartOfContinuingLine = splitContinuingLine[0];
		final Token correctedContinuingLine = splitContinuingLine[1];

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Continue open literal in " + correctedContinuedLine);
			LOGGER.trace("    with " + correctedContinuingLine);
		}

		buffer(continued(correctedContinuedLine));
		bufferSkippedByContinuation();
		buffer(skipped(skippedStartOfContinuingLine));
		buffer(continuing(correctedContinuingLine, true));
	}

	private void handleContinuationOfClosedLiteralWithAConsecutiveLiteral(
			Token continuedLine, Token continuingLine) {

		final String continuedText = continuedLine.getText();

		final int endOfContinuedLine = lastNonBlank(continuedText) + 1;
		final Token[] splitContinuedLine = Tokens.split(continuedLine,
				endOfContinuedLine);

		final Token correctedContinuedLine = splitContinuedLine[0];
		final Token skippedEndOfContinuedLine = splitContinuedLine[1];

		final int startOfContinuingLine = firstNonBlank(continuingLine
				.getText());

		final Token[] splitContinuingLine = Tokens.split(continuingLine,
				startOfContinuingLine);

		final Token skippedStartOfContinuingLine = splitContinuingLine[0];
		final Token correctedContinuingLine = splitContinuingLine[1];

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Continue closed literal in " + correctedContinuedLine);
			LOGGER.trace("   with a consecutive literal in "
					+ correctedContinuingLine);
		}

		// We need an extra token to keep the two literals separated.
		final Token spacer = new Token(" ", correctedContinuedLine.getEnd(),
				correctedContinuedLine.getEnd());

		buffer(continued(correctedContinuedLine));
		buffer(continuing(continued(spacer)));
		buffer(skipped(skippedEndOfContinuedLine));
		bufferSkippedByContinuation();
		buffer(skipped(skippedStartOfContinuingLine));
		buffer(continuing(correctedContinuingLine));
	}

	private void handleContinuationOfClosedLiteral(final Token continuedLine,
			final Token continuingLine, final int startOfContinuingLine) {
		final Token correctedContinuedLine = continuedLine;

		final Token[] splitContinuingLine = Tokens.split(continuingLine,
				startOfContinuingLine);

		final Token skippedStartOfContinuingLine = splitContinuingLine[0];
		final Token correctedContinuingLine = splitContinuingLine[1];

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Continue closed literal in " + correctedContinuedLine);
			LOGGER.trace("    with " + correctedContinuingLine);
		}

		buffer(continued(correctedContinuedLine));
		bufferSkippedByContinuation();
		buffer(skipped(skippedStartOfContinuingLine));
		buffer(continuing(correctedContinuingLine, true));
	}

	private void handleDefaultContinuation(Token continuedLine,
			Token continuingLine) {

		// For reference, here again is the default case:
		//
		// 'If there is a hyphen in the indicator area of a line, the first
		// nonblank character of the continuation line immediately follows the
		// last nonblank character of the continued line without an intervening
		// space.'

		final String continuedText = continuedLine.getText();

		final int endOfContinuedLine = lastNonBlank(continuedText) + 1;
		final Token[] splitContinuedLine = Tokens.split(continuedLine,
				endOfContinuedLine);

		final Token correctedContinuedLine = splitContinuedLine[0];
		final Token skippedEndOfContinuedLine = splitContinuedLine[1];

		final int startOfContinuingLine = firstNonBlank(continuingLine
				.getText());

		final Token[] splitContinuingLine = Tokens.split(continuingLine,
				startOfContinuingLine);

		final Token skippedStartOfContinuingLine = splitContinuingLine[0];
		final Token correctedContinuingLine = splitContinuingLine[1];

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Continue " + correctedContinuedLine);
			LOGGER.trace("    with " + correctedContinuingLine);
		}

		buffer(continued(correctedContinuedLine));
		buffer(skipped(skippedEndOfContinuedLine));
		bufferSkippedByContinuation();
		buffer(skipped(skippedStartOfContinuingLine));
		buffer(continuing(correctedContinuingLine));
	}

	private Token rewindToContinuedLine(final Token continuationIndicator) {
		// The line number of the continuing line:
		final int lineNumber = buffer.getFirst().getStart().getLinenumber();

		// We skip past the continuation indicator.
		skippedByContinuation.addFirst(continuationIndicator);

		Token last = buffer.removeLast();

		while (last != null && last.getStart().getLinenumber() >= lineNumber) {

			if (last.hasTag(PROGRAM_TEXT_AREA))
				return last;

			// Keep track of skipped tokens in the order in which they appear in
			// the text.
			skippedByContinuation.addFirst(last);
			last = buffer.removeLast();
		}

		return null;
	}

	private void buffer(final Token token) {
		if (token != null)
			buffer.addLast(token);
	}

	private void bufferSkippedByContinuation() {
		while (!skippedByContinuation.isEmpty()) {
			final Token token = skippedByContinuation.removeFirst();
			buffer.addLast(skipped(token));
		}
	}

	private Token skipped(Token token) {
		if (token == null)
			return null;

		// TODO I would prefer to leave the PTA tag in place.
		if (token.hasTag(PROGRAM_TEXT_AREA))
			token = token.replacingTag(PROGRAM_TEXT_AREA, COMMENT);

		token = token.withTags(SKIPPED);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Skipped " + token);

		return token;
	}

	private Token continued(Token token) {
		if (token == null)
			return null;

		token = token.withTags(CONTINUED);
		return token;
	}

	private Token continuing(Token token) {
		return continuing(token, false);
	}

	private Token continuing(Token token, boolean hasLeadingQuote) {
		if (token == null)
			return null;

		token = token.withTags(CONTINUING);

		if (hasLeadingQuote)
			token = token.withTags(LEADING_QUOTE);

		return token;
	}

	private void enqueueAll() {
		while (!buffer.isEmpty())
			enqueue(buffer.removeFirst());
	}

	private void enqueueUpToLine(int linenumber) {
		while (!buffer.isEmpty()) {
			final Token token = buffer.getFirst();

			if (token.getStart().getLinenumber() >= linenumber)
				return;

			buffer.removeFirst();
			enqueue(token);
		}
	}

	private boolean hasOpenLiteral(final Token token) {
		final String text = token.getText();

		int pos = 0;
		boolean inLiteral = false;
		char delimiter = '"';

		// TODO Check for quoted quotes ? Should work anyway, right ?
		while (pos < text.length()) {
			char c = text.charAt(pos);

			if (inLiteral) {
				if (c == delimiter)
					inLiteral = false;

			} else if (c == '"' || c == '\'') {
				inLiteral = true;
				delimiter = c;
			}

			pos += 1;
		}

		return inLiteral;
	}

	private int firstNonBlank(String text) {
		for (int i = 0; i < text.length(); i++)
			if (!Character.isWhitespace(text.charAt(i)))
				return i;

		return -1;
	}

	private int lastNonBlank(String text) {
		for (int i = text.length() - 1; i >= 0; i--)
			if (!Character.isWhitespace(text.charAt(i)))
				return i;

		return -1;
	}

	private boolean isQuotationMark(final char c) {
		return c == '"' || c == '\'';
	}

	@Override
	public void close() {
		super.close();
		source.close();
	}
}
