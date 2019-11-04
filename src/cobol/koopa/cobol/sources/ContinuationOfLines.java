package koopa.cobol.sources;

import static koopa.cobol.data.tags.CobolAreaTag.INDICATOR_AREA;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.VARIABLE;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.AreaTag.SKIPPED;
import static koopa.core.data.tags.SyntacticTag.INCOMPLETE;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.STRING;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;
import koopa.core.sources.Sources;
import koopa.core.sources.TokenSeparationLogic;
import koopa.core.util.Iterators;

public class ContinuationOfLines extends ChainingSource
		implements Source {

	private static final Logger LOGGER //
			= Logger.getLogger("source.cobol.continuations");

	/**
	 * This is a tag which may be applied to fixed indicators to show that they
	 * have been handled. This is needed as in the case of
	 * {@linkplain ContinuationOfLines#handleClosedLiteralContinuation(LinkedList, LinkedList)}
	 * the continuing line (which has the indicator) will be made pending, but
	 * we should take care not to handle the indicator a second time.
	 */
	private static enum StatusOfIndicator {
		HANDLED
	};

	private final LinkedList<Data> pending = new LinkedList<>();

	private final LinkedList<LinkedList<Data>> pendingLines = new LinkedList<>();

	public ContinuationOfLines(Source source) {
		super(source);
	}

	@Override
	protected Data nxt1() {
		while (true) {
			if (!pending.isEmpty())
				return withoutInternalStatus(pending.removeFirst());

			final LinkedList<Data> line = getLogicalLine();
			if (line == null)
				return null;

			pending.addAll(line);

			return withoutInternalStatus(pending.removeFirst());
		}
	}

	/**
	 * The data which gets return from this source should not be leaking tags
	 * used for internal processing.
	 */
	private Data withoutInternalStatus(Data d) {
		if (d == null || !(d instanceof Token))
			return d;
		else
			return ((Token) d).withoutTags(StatusOfIndicator.HANDLED);
	}

	private LinkedList<Data> getLogicalLine() {
		while (true) {
			final LinkedList<Data> line = getPendingLine();

			// No more lines ?
			if (line == null)
				return null;

			// If it's a blank line, we return it as is.
			if (isBlank(line))
				return line;

			// Does the line have an incomplete literal, or one with a floating
			// continuation indicator ?
			if (hasIncompleteToken(line)) {
				// It does.
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("Needs continuation: " + line);

				// We need the next (non-empty, non-comment) source line to
				// build the continuation.
				final LinkedList<Data> continuation = grabNextSourceLine();

				if (continuation == null) {
					// There isn't one ? That's bad, so we just bail out.
					LOGGER.error("No next source line, so can not continue "
							+ "(wrong source format ?): " + line);
					return line;
				}

				// Resolve the continuation, then make the entire line pending
				// for another pass.
				pendingLines
						.addFirst(handleIncompleteToken(line, continuation));
				continue;
			}

			// The line itself does not say it needs to be continued. But the
			// next (non-empty, non-comment) source line may still choose to
			// continue it.
			final LinkedList<Data> nextSourceLine = grabNextSourceLine();
			final Token fixedIndicator = findFixedIndicator(nextSourceLine);
			if (isFixedContinuationIndicator(fixedIndicator)) {
				// It does act as a continuation. We will resolve that
				// continuation, then make the entire line pending for another
				// pass.
				pendingLines.addFirst(handleFixedContinuation(fixedIndicator,
						line, nextSourceLine));
				continue;
			}

			// So the line neither wants to be continued, nor is continued.
			// We make the extra line we read pending.
			pendingLines.add(nextSourceLine);

			// Add we return the line we started with.
			return line;
		}
	}

	private LinkedList<Data> handleIncompleteToken(
			LinkedList<Data> continuedLine, LinkedList<Data> continuingLine) {

		final LinkedList<Data> logicalLine = new LinkedList<>();

		final Token incomplete = shiftToIncompleteToken(continuedLine,
				logicalLine);
		assert (incomplete != null);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Incomplete token: " + incomplete);

		if (isLiteralWithFloatingContinuationIndicator(incomplete)) {
			// Floating continuation indicator.
			return handleFloatingContinuationIndicator(logicalLine, incomplete,
					continuedLine, continuingLine);

		} else {
			// Incomplete string literal.
			return handleIncompleteStringLiteral(logicalLine, incomplete,
					continuedLine, continuingLine);
		}
	}

	private LinkedList<Data> handleFloatingContinuationIndicator(
			final LinkedList<Data> logicalLine, final Token incomplete,
			LinkedList<Data> continuedLine, LinkedList<Data> continuingLine) {

		// "In the case of continuation with [a] floating literal continuation
		// indicator, the next line that is not a comment line or a blank line
		// is the continuation line. The first nonspace character in the
		// program-text area of the continuation line shall be a quotation
		// symbol matching the quotation symbol used in the opening delimiter.
		// The continuation starts with the character immediately after the
		// quotation symbol in the continuation line."

		final LinkedList<Data> skipped = new LinkedList<>();
		final Token firstNonBlank = shiftToFirstNonBlank(continuingLine,
				skipped);

		if (!firstNonBlank.hasTag(STRING)) {
			// We need a string to continue the floating one...
			// We'll ignore the continuation and try to carry on.

			// Restore the continuingLine...
			continuingLine.addFirst(firstNonBlank);
			while (!skipped.isEmpty())
				continuingLine.addFirst(skipped.removeLast());
			pendingLines.add(continuingLine);

			// Restore the logicalLine...
			logicalLine.add(incomplete);
			logicalLine.addAll(continuedLine);

			return logicalLine;
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Continuing floating literal " + incomplete + " with "
					+ firstNonBlank);

		final int positionOfFloatingIndicator = incomplete.getLength() - 2;
		final Token startOfLiteral //
				= Tokens.subtoken(incomplete, 0, positionOfFloatingIndicator)
						.withoutTags(INCOMPLETE);

		// TODO Add floating indicator tag ?
		final Token floatingIndicator //
				= Tokens.subtoken(incomplete, positionOfFloatingIndicator)
						.withoutTags(PROGRAM_TEXT_AREA, INCOMPLETE)
						.withTags(SKIPPED);

		final Token leadingQuote = Tokens.subtoken(firstNonBlank, 0, 1)
				.withTags(SKIPPED).withoutTags(INCOMPLETE, PROGRAM_TEXT_AREA);
		final Token continuationOfLiteral = Tokens.subtoken(firstNonBlank, 1);

		logicalLine.addLast(startOfLiteral);
		logicalLine.addLast(floatingIndicator);
		shiftAllAndSkip(continuedLine, logicalLine);
		shiftAllAndSkip(skipped, logicalLine);
		logicalLine.addLast(leadingQuote);
		logicalLine.addLast(continuationOfLiteral);
		logicalLine.addAll(continuingLine);

		return logicalLine;
	}

	private LinkedList<Data> handleIncompleteStringLiteral(
			final LinkedList<Data> logicalLine, final Token incomplete,
			LinkedList<Data> continuedLine, LinkedList<Data> continuingLine) {

		// This can only occur in FIXED or VARIABLE format.
		final SourceFormat format = SourceFormat.forToken(incomplete);

		assert (format == FIXED || format == VARIABLE) //
		: "Unexpected source format on incomplete string literal: "
				+ incomplete;

		// The continuation line should have a fixed continuation indicator.
		final Token indicator = findFixedIndicator(continuingLine);

		if (!isFixedContinuationIndicator(indicator)) {
			// No continuation indicator ? That's unexpected, but not
			// impossible. The testsuite actually has incomplete string
			// literals inside "pseudo text", which don't require the same
			// treatment as program text.

			// TODO No warning level ?
			if (LOGGER.isInfoEnabled())
				LOGGER.info(
						"Did not find a continuation for incomplete literal: "
								+ incomplete);

			handleMissingContinuation(logicalLine, incomplete, continuedLine,
					continuingLine);

			return logicalLine;
		}

		// 'The continuation line must contain a hyphen in the indicator
		// area, and the first nonblank character must be a quotation mark.
		// The continuation of the literal begins with the character
		// immediately following the quotation mark.'
		//
		// We know the indicator is already there, so we can cross that of
		// the list. Next is to find the first non-blank character.

		final LinkedList<Data> skipped = new LinkedList<>();
		final Token continuation = shiftToFirstNonBlank(continuingLine,
				skipped);

		if (continuation == null || !continuation.hasTag(STRING)) {
			// Well, this is not according to spec. We'll ignore the
			// continuation and try to carry on.

			// TODO No warning level ?
			if (LOGGER.isInfoEnabled())
				LOGGER.info(
						"Did not find a string continuation for incomplete literal: "
								+ incomplete);

			// First restore the continuing line, then handle the problem.

			if (continuation != null)
				continuingLine.addFirst(continuation);

			while (!skipped.isEmpty())
				continuingLine.addFirst(skipped.removeLast());

			handleMissingContinuation(logicalLine, incomplete, continuedLine,
					continuingLine);

			return logicalLine;
		}

		composeFullLiteral(format, logicalLine, incomplete, continuedLine,
				skipped, continuation, continuingLine);

		return logicalLine;
	}

	private void handleMissingContinuation(final LinkedList<Data> logicalLine,
			final Token incomplete, LinkedList<Data> continuedLine,
			LinkedList<Data> continuingLine) {
		// We will split of the opening quotation character and split
		// the incomplete literal into tokens. Then push everything we
		// have, except for the next source line as the logical line.

		// TODO Verify this case with CobolSourcesValidationTest.

		// So, the leading quote...
		final Token openingQuote = Tokens.subtoken(incomplete, 0, 1)
				.withTags(SEPARATOR).withoutTags(INCOMPLETE);
		logicalLine.add(openingQuote);

		// The tokens inside the incomplete literal...
		final List<Token> tokens = TokenSeparationLogic
				.apply(Tokens.subtoken(incomplete, 1).withoutTags(INCOMPLETE));
		if (tokens != null && !tokens.isEmpty())
			logicalLine.addAll(tokens);

		// The remainder of the line.
		logicalLine.addAll(continuedLine);
		continuedLine.clear();

		// The line we expected to have a continuation will be made
		// pending, as it may still contain something to be continued
		// itself.
		pendingLines.add(continuingLine);
	}

	private void composeFullLiteral(final SourceFormat format,
			final LinkedList<Data> logicalLine, final Token incomplete,
			LinkedList<Data> continuedLine, final LinkedList<Data> skipped,
			final Token continuation, LinkedList<Data> continuingLine) {

		final Token leadingQuote = Tokens.subtoken(continuation, 0, 1)
				.withTags(SKIPPED).withoutTags(INCOMPLETE, PROGRAM_TEXT_AREA);
		final Token continuationOfLiteral = Tokens.subtoken(continuation, 1);

		logicalLine.addLast(incomplete.withoutTags(INCOMPLETE));
		shiftAllAndSkip(continuedLine, logicalLine);
		while (!pendingLines.isEmpty())
			logicalLine.addAll(pendingLines.removeFirst());
		shiftAllAndSkip(skipped, logicalLine);
		logicalLine.addLast(leadingQuote);
		logicalLine.addLast(continuationOfLiteral);
		logicalLine.addAll(continuingLine);
	}

	private LinkedList<Data> handleFixedContinuation(Token fixedIndicator,
			LinkedList<Data> continuedLine, LinkedList<Data> continuingLine) {

		// 'If there is a hyphen in the indicator area of a line, the first
		// nonblank character of the continuation line immediately follows the
		// last nonblank character of the continued line without an intervening
		// space.'
		//
		// Easy. Except that:
		//
		// 'If an alphanumeric or national literal that is to be continued on
		// the next line has as its last character a quotation mark in column
		// 72, the continuation line must start with two consecutive quotation
		// marks. This will result in a single quotation mark as part of the
		// value of the literal.'
		// (Source: Enterprise COBOL for z/OS, Language Reference, Version 4
		// Release 2, p.56)
		//
		// So let's check that first.

		final Token lastToken = findLastProgramTextOtherThenEOLN(continuedLine);
		if (lastToken == null) {
			// Are we continuing an empty line ? That shouldn't happen, right ?
			// I guess we'll ignore the issue and the continuation then.

			if (LOGGER.isInfoEnabled())
				LOGGER.info("Unexpected continuation of an empty line: "
						+ fixedIndicator);

			pendingLines.add(continuingLine);
			return continuedLine;
		}

		if (!lastToken.hasTag(STRING)) {
			// So we're not in a special case, and just need to handle blanks.
			return handleBasicNonBlankContinuation(continuedLine,
					continuingLine);

		} else {
			// It is a string literal.
			return handleClosedLiteralContinuation(continuedLine,
					continuingLine);
		}
	}

	private LinkedList<Data> handleBasicNonBlankContinuation(
			LinkedList<Data> continuedLine, LinkedList<Data> continuingLine) {

		final LinkedList<Data> skipped = new LinkedList<>();
		final Token lastNonBlank = unshiftToLastNonBlank(continuedLine,
				skipped);
		final Token firstNonBlank = shiftToFirstNonBlank(continuingLine,
				skipped);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(
					"Continuing " + lastNonBlank + " with " + firstNonBlank);

		final LinkedList<Data> fullLine = new LinkedList<>();
		fullLine.addAll(continuedLine);
		fullLine.add(lastNonBlank);
		shiftAllAndSkip(skipped, fullLine);
		fullLine.add(firstNonBlank);
		fullLine.addAll(continuingLine);

		return fullLine;
	}

	private LinkedList<Data> handleClosedLiteralContinuation(
			LinkedList<Data> continuedLine, LinkedList<Data> continuingLine) {

		final LinkedList<Data> endOfContinuedLine = new LinkedList<>();
		final Token closedLiteral = unshiftToLastProgramTextOtherThenEOLN(
				continuedLine, endOfContinuedLine);

		// Now, the COBOL z/OS spec states:
		// 'If an alphanumeric or national literal that is to be continued on
		// the next line has as its last character a quotation mark in column
		// 72, the continuation line must start with two consecutive quotation
		// marks. This will result in a single quotation mark as part of the
		// value of the literal.'
		// (Source: Enterprise COBOL for z/OS, Language Reference, Version 4
		// Release 2, p.56)
		//
		// I am going to ignore the condition on column 72 for two reasons:
		// 1. I don't want to bother with the complexity of tabs in this place.
		// 2. Lines may exceed column 72 in VARIABLE formatting.
		// I may get back to this at some point if it proves to be causing
		// problems.

		final LinkedList<Data> startOfContinuingLine = new LinkedList<>();
		final Token firstNonBlank = shiftToFirstNonBlank(continuingLine,
				startOfContinuingLine);

		// The first non-blank, according to the spec, must start with two
		// consecutive quotation marks. Which means that it should appear here
		// as a string of length two, given how the token separation works.

		if (!firstNonBlank.hasTag(STRING) || firstNonBlank.getLength() != 2) {
			// So it does not adhere to the spec. We'll ignore the continuation
			// and try to carry on.

			// TODO No warning level ?
			if (LOGGER.isInfoEnabled())
				LOGGER.info(
						"Did not find a string continuation for closed literal: "
								+ closedLiteral);

			continuedLine.add(closedLiteral);
			continuedLine.addAll(endOfContinuedLine);

			// Despite failing to handle the continuation we will still mark the
			// continuation indicator as having been handled, just so we don't
			// try to handle it again.
			markFixedIndicatorAsHandled(startOfContinuingLine);

			continuingLine.addFirst(firstNonBlank);
			while (!startOfContinuingLine.isEmpty())
				continuingLine.addFirst(startOfContinuingLine.removeLast());
			pendingLines.add(continuingLine);

			return continuedLine;
		}

		// Now, because the initial quote was meant to be discarded, this means
		// that the entire line has been separated in the wrong way. Which means
		// we have to redo that separation, with the leading quote removed.

		final Token firstQuote = Tokens.subtoken(firstNonBlank, 0, 1)
				.withTags(SKIPPED).withoutTags(INCOMPLETE, PROGRAM_TEXT_AREA);

		final Token secondQuote = Tokens.subtoken(firstNonBlank, 1)
				.withoutTags(PROGRAM_TEXT_AREA);

		final LinkedList<Data> endOfContinuingLine = new LinkedList<>();

		final Token lastText = unshiftToLastProgramTextOtherThenEOLN(
				continuingLine, endOfContinuingLine);
		if (lastText != null)
			continuingLine.addLast(lastText);
		continuingLine.addFirst(secondQuote);

		final SourceFormat format = SourceFormat.forToken(firstNonBlank);

		final Token continuingProgramText = Tokens.join(tokens(continuingLine),
				format, PROGRAM_TEXT_AREA);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Retokenizing: " + continuingProgramText);

		final LinkedList<Token> continuingTokens = new LinkedList<>();
		continuingTokens.addAll( //
				TokenSeparationLogic.apply(continuingProgramText));

		final Token furtherLiteral = continuingTokens.removeFirst();

		continuedLine.addLast(closedLiteral);
		shiftAllAndSkip(endOfContinuedLine, continuedLine);

		markFixedIndicatorAsHandled(startOfContinuingLine);

		continuingLine.clear();
		shiftAllAndSkip(startOfContinuingLine, continuingLine);
		continuingLine.add(firstQuote);
		continuingLine.add(furtherLiteral);
		continuingLine.addAll(continuingTokens);
		continuingLine.addAll(endOfContinuingLine);

		pendingLines.add(continuingLine);

		return continuedLine;
	}

	private LinkedList<Token> tokens(LinkedList<Data> data) {
		final LinkedList<Token> tokens = new LinkedList<>();

		for (Data d : data)
			if (d instanceof Token)
				tokens.add((Token) d);

		return tokens;
	}

	private Token shiftToIncompleteToken(LinkedList<Data> line,
			final LinkedList<Data> skipped) {

		while (true) {
			if (line.isEmpty())
				return null;

			final Data d = line.removeFirst();
			if (isIncompleteToken(d))
				return (Token) d;
			else
				skipped.add(d);
		}
	}

	private void shiftAllAndSkip(LinkedList<Data> line,
			final LinkedList<Data> skipped) {

		while (!line.isEmpty()) {
			final Data d = line.removeFirst();
			// TODO I'm removing TEXT from SKIPPED. Seems ok ?
			if (d instanceof Token) // && ((Token) d).hasTag(PROGRAM_TEXT_AREA))
				skipped.addLast(((Token) d).withTags(SKIPPED)
						.withoutTags(PROGRAM_TEXT_AREA));
			else
				skipped.addLast(d);
		}
	}

	private Token shiftToFirstNonBlank(LinkedList<Data> line,
			LinkedList<Data> skipped) {
		while (true) {
			if (line.isEmpty())
				return null;

			final Data d = line.removeFirst();
			if (d instanceof Token) {
				final Token t = (Token) d;
				// TODO Refer to Grammar methods for this.
				// TODO Add a Grammar.isBlank(Token) ?
				// TODO Use WHITESPACE text instead of trim ?
				if (t.hasTag(PROGRAM_TEXT_AREA) && !t.hasTag(COMMENT)
						&& t.getText().trim().length() > 0)
					return t;
			}

			skipped.add(d);
		}
	}

	private Token unshiftToLastNonBlank(LinkedList<Data> line,
			LinkedList<Data> unshifted) {

		while (true) {
			if (line.isEmpty())
				return null;

			final Data d = line.removeLast();
			if (d instanceof Token) {
				final Token t = (Token) d;
				// TODO Refer to Grammar methods for this.
				// TODO Add a Grammar.isBlank(Token) ?
				// TODO Use WHITESPACE text instead of trim ?
				if (t.hasTag(PROGRAM_TEXT_AREA) && !t.hasTag(COMMENT)
						&& t.getText().trim().length() > 0)
					return t;
			}

			unshifted.addFirst(d);
		}
	}

	private Token unshiftToLastProgramTextOtherThenEOLN(LinkedList<Data> line,
			LinkedList<Data> unshifted) {

		while (true) {
			if (line.isEmpty())
				return null;

			final Data d = line.removeLast();
			if (d instanceof Token) {
				final Token t = (Token) d;
				// TODO Refer to Grammar methods for this.
				if (t.hasTag(PROGRAM_TEXT_AREA)
						&& !t.hasAnyTag(COMMENT, END_OF_LINE))
					return t;
			}

			unshifted.addFirst(d);
		}
	}

	private LinkedList<Data> grabNextSourceLine() {
		// Check the pending lines for a source line.
		ListIterator<LinkedList<Data>> i = pendingLines.listIterator();
		while (i.hasNext()) {
			final LinkedList<Data> nextLine = i.next();
			if (nextLine == null || !isBlank(nextLine)) {
				// Hey, we found one. Remove it from the pending lines and
				// return it.
				i.remove();
				return nextLine;
			}
		}

		// If there isn't one in the pending lines, then grab more from the
		// source.
		while (true) {
			final LinkedList<Data> nextLine = Sources.getLine(source);
			if (nextLine == null || !isBlank(nextLine))
				return nextLine;

			pendingLines.addLast(nextLine);
		}
	}

	private LinkedList<Data> getPendingLine() {
		if (pendingLines.isEmpty())
			return Sources.getLine(source);
		else
			return pendingLines.removeFirst();
	}

	private boolean hasIncompleteToken(LinkedList<Data> line) {
		final Iterator<Data> i = Iterators.descendingIterator(line);
		while (i.hasNext())
			if (isIncompleteToken(i.next()))
				return true;

		return false;
	}

	private Token findFixedIndicator(LinkedList<Data> line) {
		if (line == null)
			return null;

		for (Data d : line)
			if (isFixedIndicator(d))
				return (Token) d;

		return null;
	}

	private Token findLastProgramTextOtherThenEOLN(LinkedList<Data> line) {
		final Iterator<Data> i = Iterators.descendingIterator(line);
		while (i.hasNext()) {
			final Data d = i.next();

			if (!(d instanceof Token))
				continue;

			final Token t = (Token) d;

			if (t.hasTag(PROGRAM_TEXT_AREA)
					&& !t.hasAnyTag(COMMENT, END_OF_LINE))
				return t;
		}

		return null;
	}

	private boolean isBlank(LinkedList<Data> line) {
		for (Data d : line)
			if (d instanceof Token) {
				final Token t = (Token) d;
				// TODO Refer to Grammar methods for this.
				// TODO Add a Grammar.isBlank(Token) ?
				if (t.hasTag(PROGRAM_TEXT_AREA) && !t.hasTag(COMMENT)
						&& t.getText().trim().length() > 0)
					return false;
			}

		return true;
	}

	private boolean isIncompleteToken(Data d) {
		if (d == null || !(d instanceof Token))
			return false;

		final Token t = (Token) d;

		// TODO Use Grammar methods.
		return t.hasTags(PROGRAM_TEXT_AREA, INCOMPLETE) && !t.hasTag(COMMENT);
	}

	private boolean isFixedIndicator(Data d) {
		return d != null && d instanceof Token
				&& ((Token) d).hasTag(INDICATOR_AREA);
	}

	/**
	 * Whether the token {@link #isFixedContinuationIndicator(Token)} whose
	 * contents is a dash and which has not been
	 * {@linkplain StatusOfIndicator#HANDLED}.
	 */
	private boolean isFixedContinuationIndicator(final Token t) {
		return isFixedIndicator(t) && !t.hasTag(StatusOfIndicator.HANDLED)
				&& "-".equals(t.getText());
	}

	private boolean isLiteralWithFloatingContinuationIndicator(Token t) {
		if (t == null || t.getLength() < 2)
			return false;

		final char l1 = t.charAt(t.getLength() - 1);
		final char l2 = t.charAt(t.getLength() - 2);
		return '-' == l1 && (l2 == '"' || l2 == '\'');
	}

	/**
	 * Scan the line for any token which
	 * {@link #isFixedContinuationIndicator(Token)} and mark those as
	 * {@linkplain StatusOfIndicator#HANDLED}.
	 */
	private void markFixedIndicatorAsHandled(LinkedList<Data> line) {
		LinkedList<Data> tmp = new LinkedList<>();

		while (!line.isEmpty()) {
			final Data d = line.removeFirst();
			if (d instanceof Token && isFixedContinuationIndicator((Token) d))
				tmp.addLast(((Token) d).withTags(StatusOfIndicator.HANDLED));
			else
				tmp.addLast(d);
		}

		line.addAll(tmp);
	}
}
