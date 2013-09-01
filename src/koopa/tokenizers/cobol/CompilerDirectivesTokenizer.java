package koopa.tokenizers.cobol;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokens.BasicToken;
import koopa.tokens.Token;

// TODO Set up unit tests for these...
public class CompilerDirectivesTokenizer implements Tokenizer {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.compiler-directives");

	// For the '$ SET SOURCEFORMAT'. A Micro Focus compiler directive.
	private static final Pattern MF_SET_DIRECTIVE = Pattern
			.compile("^\\s*\\$\\s*SET\\s+SOURCEFORMAT(\\s|\"|\\().*");

	// For the CBL/PROCESS compiler directive.
	private static final Pattern CBL_PROCESS_STATEMENT = Pattern
			.compile("(^|\\s)(CBL|PROCESS)\\s.*");

	private static final Pattern TITLE_STATEMENT = Pattern
			.compile("(^|\\s)TITLE\\s.*");

	private static final Pattern FIXED_FORM_COMPILER_DIRECTIVE = Pattern
			.compile("^.{6}\\s\\s*(>>|$).*");

	private static final Pattern FREE_FORM_COMPILER_DIRECTIVE = Pattern
			.compile("^\\s*(>>|$).*");

	private final SourceFormat format;

	private final Tokenizer tokenizer;

	private final LinkedList<Token> queuedTokens = new LinkedList<Token>();

	public CompilerDirectivesTokenizer(Tokenizer tokenizer, SourceFormat format) {
		super();

		assert (tokenizer != null);
		assert (format != null);

		this.tokenizer = tokenizer;
		this.format = format;
	}

	public Token nextToken() {
		if (!this.queuedTokens.isEmpty()) {
			return this.queuedTokens.removeFirst();
		}

		final Token token = this.tokenizer.nextToken();

		if (token == null) {
			return null;
		}

		if (token.tagCount() > 0) {
			return token;
		}

		if (isCompilerDirective(token)) {
			return this.queuedTokens.removeFirst();
		}

		if (isMicroFocusCompilerDirective(token)) {
			return this.queuedTokens.removeFirst();
		}

		if (isTitleStatement(token)) {
			return this.queuedTokens.removeFirst();
		}

		if (isCblProcessStatement(token)) {
			return this.queuedTokens.removeFirst();
		}

		return token;
	}

	private boolean isMicroFocusCompilerDirective(final Token token) {
		// TODO Find some real documentation on this statement.
		// TODO When the directive sets the sourceformat, use that to switch the
		// Koopa tokenizer source format ?
		final String text = token.getText();

		// TODO Make this match more exact ? Right now it can accept bad inputs,
		// but that may be fine...
		final Matcher matcher = MF_SET_DIRECTIVE.matcher(text.toUpperCase());

		if (!matcher.find()) {
			return false;
		}

		token.addTag(AreaTag.COMPILER_DIRECTIVE);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("MicroFocus compiler directive: " + token);

		this.queuedTokens.addFirst(token);
		return true;
	}

	private boolean isTitleStatement(final Token token) {
		// Enterprise COBOL for z/OS V4.2 Language Reference, p571:
		// 'The TITLE statement specifies a title to be printed at the top of
		// each page of the source listing produced during compilation.'
		final String text = token.getText();

		// TODO Make this match more exact ? Right now it can accept bad inputs,
		// but that may be fine...
		final Matcher matcher = TITLE_STATEMENT.matcher(text.toUpperCase());

		if (!matcher.find()) {
			return false;
		}

		token.addTag(AreaTag.COMPILER_DIRECTIVE);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Title statement: " + token);

		this.queuedTokens.addFirst(token);
		return true;
	}

	private boolean isCblProcessStatement(final Token token) {
		// Enterprise COBOL for z/OS V4.2 Language Reference, p554:
		// "With the CBL (PROCESS) statement, you can specify compiler options
		// to be used in the compilation of the program."

		// Note. This statement can only appear before the identification
		// division header of an outermost program. As we're testing for this
		// statement in the lexer stage only, however, this is something we
		// can't easily check for.

		final String text = token.getText();

		final Matcher matcher = CBL_PROCESS_STATEMENT.matcher(text
				.toUpperCase());

		if (!matcher.find()) {
			return false;
		}

		final int startOfStatement = matcher.start(2);

		final int startOfToken;
		if (startOfStatement > 6) {
			// Possibly preceded by a sequence number.

			final String possibleSequenceNumber = text.substring(0, 6);
			final String trimmed = possibleSequenceNumber.trim();

			if (trimmed.length() > 0 && !Character.isDigit(trimmed.charAt(0))) {
				// Not a valid sequence number.
				return false;
			}

			startOfToken = 6;

		} else {
			// No preceding sequence number.
			startOfToken = 0;
		}

		final String leading = text.substring(startOfToken, startOfStatement)
				.trim();

		if (leading.length() > 0) {
			// Invalid lead.
			return false;
		}

		// At this point we know that we're dealing wit a valid CBL/PROCESS
		// statement. We now prepare all tokens.

		if (startOfToken > 0) {
			final Token sequenceNumber = new BasicToken(text.substring(0,
					startOfToken), token.getStart(), token.getStart().offsetBy(
					5));
			sequenceNumber.addTag(AreaTag.SEQUENCE_NUMBER_AREA);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Sequence number: " + sequenceNumber);

			this.queuedTokens.add(sequenceNumber);
		}

		final int endOfToken = Math.min(text.length(), 72);
		final Token directive = new BasicToken(text.substring(startOfToken,
				endOfToken), token.getStart().offsetBy(startOfToken), token
				.getStart().offsetBy(endOfToken - 1));

		directive.addTag(AreaTag.COMPILER_DIRECTIVE);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("CBL (PROCESS) statement: " + directive);

		this.queuedTokens.add(directive);

		if (endOfToken < text.length()) {
			// Extra identification area.
			final Token identification = new BasicToken(text.substring(72),
					token.getStart().offsetBy(endOfToken), token.getEnd());
			identification.addTag(AreaTag.INDICATOR_AREA);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Identification: " + identification);

			this.queuedTokens.add(identification);
		}

		return true;
	}

	/**
	 * Based on ISO/IEC 1989:20xx FCD 1.0 (E), section 7.3
	 * "Compiler directives".
	 */
	private boolean isCompilerDirective(final Token token) {
		final String text = token.getText().toUpperCase();

		final Matcher matcher;
		if (format == SourceFormat.FIXED) {
			matcher = FIXED_FORM_COMPILER_DIRECTIVE.matcher(text);
			// TODO Separate out the sequence number and indicator areas.

		} else {
			matcher = FREE_FORM_COMPILER_DIRECTIVE.matcher(text);
		}

		if (matcher.find()) {
			token.addTag(AreaTag.COMPILER_DIRECTIVE);
			this.queuedTokens.addFirst(token);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Compiler directive: " + token);

			return true;
		}

		return false;
	}

	public void quit() {
		this.tokenizer.quit();
	}
}
