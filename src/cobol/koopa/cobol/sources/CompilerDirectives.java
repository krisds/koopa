package koopa.cobol.sources;

import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.INDICATOR_AREA;
import static koopa.core.data.tags.AreaTag.SEQUENCE_NUMBER_AREA;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

import org.apache.log4j.Logger;

public class CompilerDirectives extends BasicSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.compiler-directives");

	private final Source<? extends Token> source;

	private final LinkedList<Token> queuedTokens = new LinkedList<Token>();

	private SourceFormat referenceFormat;

	public CompilerDirectives(Source<? extends Token> source,
			SourceFormat initialReferenceFormat) {
		super();

		assert (source != null);
		assert (initialReferenceFormat != null);

		this.source = source;
		this.referenceFormat = initialReferenceFormat;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Initial reference format: " + referenceFormat);
	}

	@Override
	public Token nxt1() {
		if (!queuedTokens.isEmpty())
			return queuedTokens.removeFirst();

		final Token token = source.next();

		if (token == null)
			return null;

		if (token.tagCount() > 0)
			return token.withTags(referenceFormat);

		if (isCompilerDirective(token))
			return queuedTokens.removeFirst();

		if (isLibrarianIncDirective(token))
			return queuedTokens.removeFirst();

		if (isMicroFocusCompilerDirective(token))
			return queuedTokens.removeFirst();

		if (isTitleStatement(token))
			return queuedTokens.removeFirst();

		if (isCblProcessStatement(token))
			return queuedTokens.removeFirst();

		return token.withTags(referenceFormat);
	}

	public void close() {
		source.close();
	}

	// ========================================================================

	private static final String INDICATOR = ">>|\\$";
	private static final String DIRECTIVE = "((?!\\*\\>).)*";
	private static final String INLINE_COMMENT = "\\*\\>.*";

	private static final Pattern FIXED_FORM_COMPILER_DIRECTIVE = Pattern
			.compile("^\\s{6}\\s\\s*(" + INDICATOR + ")\\s*(" + DIRECTIVE
					+ ")\\s*(" + INLINE_COMMENT + ")?$");

	private static final Pattern FREE_FORM_COMPILER_DIRECTIVE = Pattern
			.compile("^\\s*(" + INDICATOR + ")\\s*(" + DIRECTIVE + ")\\s*("
					+ INLINE_COMMENT + ")?$");

	private static final int DIRECTIVE_GROUP = 2;
	private static final int INLINE_COMMENT_GROUP = 4;

	/**
	 * Based on ISO/IEC 1989:20xx FCD 1.0 (E), section 7.3
	 * "Compiler directives".
	 */
	private boolean isCompilerDirective(Token token) {
		final String text = token.getText().toUpperCase();

		final Matcher matcher;
		if (referenceFormat == SourceFormat.FIXED)
			matcher = FIXED_FORM_COMPILER_DIRECTIVE.matcher(text);
		else
			matcher = FREE_FORM_COMPILER_DIRECTIVE.matcher(text);

		if (!matcher.find())
			return false;

		final SourceFormat format = referenceFormat;
		final String directive = matcher.group(DIRECTIVE_GROUP);
		if (isSourceFormatDirective(directive)) {
			// Yay.
		}

		Token comment = null;
		if (matcher.group(INLINE_COMMENT_GROUP) != null) {
			int start = matcher.start(INLINE_COMMENT_GROUP);
			comment = Tokens.subtoken(token, start).withTags(COMMENT, format);

			queuedTokens.addFirst(comment);
			token = Tokens.subtoken(token, 0, start);
		}

		token = token.withTags(COMPILER_DIRECTIVE, format);
		queuedTokens.addFirst(token);

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(token);
			if (comment != null)
				LOGGER.trace(comment);
		}

		return true;
	}

	// ========================================================================

	private static final Pattern LIBRARIAN_INC_DIRECTIVE = Pattern
			.compile("^-INC\\s+(\\S+).*$");

	private static final int LIBRARIAN_INC_TEXTNAME_GROUP = 1;

	/**
	 * Based on MicroFocus' <a href=
	 * "https://supportline.microfocus.com/documentation/books/sx40/lrcomp.htm"
	 * >Compiler-directing Statements, The ++INCLUDE and -INC Mechanisms</a>.
	 */
	private boolean isLibrarianIncDirective(Token token) {
		final String text = token.getText().toUpperCase();

		final Matcher matcher = LIBRARIAN_INC_DIRECTIVE.matcher(text);

		if (!matcher.find())
			return false;

		int start = matcher.start(LIBRARIAN_INC_TEXTNAME_GROUP);
		int end = matcher.end(LIBRARIAN_INC_TEXTNAME_GROUP);

		final Token inc = Tokens.subtoken(token, 0, 4).withTags(
				COMPILER_DIRECTIVE, referenceFormat);

		final Token ws = Tokens.subtoken(token, 4, start).withTags(
				COMPILER_DIRECTIVE, SEPARATOR, referenceFormat);

		final Token textName = Tokens.subtoken(token, start, end).withTags(
				COMPILER_DIRECTIVE, referenceFormat);

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace(inc);
			LOGGER.trace(ws);
			LOGGER.trace(textName);
		}

		if (end < token.getLength()) {
			final Token comment = Tokens.subtoken(token, end).withTags(COMMENT,
					referenceFormat);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace(comment);

			queuedTokens.addFirst(comment);
		}

		queuedTokens.addFirst(textName);
		queuedTokens.addFirst(ws);
		queuedTokens.addFirst(inc);

		return true;
	}

	// ========================================================================

	private static final Pattern SOURCE_FORMAT_DIRECTIVE = Pattern
			.compile("^SOURCE(\\s+FORMAT)?(\\s+IS)?\\s+(FREE|FIXED)\\s*$");

	private static final int FORMAT_GROUP = 3;

	private boolean isSourceFormatDirective(String directive) {
		final String text = directive.toUpperCase();

		final Matcher matcher = SOURCE_FORMAT_DIRECTIVE.matcher(text);

		if (!matcher.find())
			return false;

		String format = matcher.group(FORMAT_GROUP);
		if ("FREE".equals(format))
			referenceFormat = SourceFormat.FREE;
		else
			referenceFormat = SourceFormat.FIXED;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Reference format: " + referenceFormat);

		return true;
	}

	// ========================================================================

	// For the '$ SET SOURCEFORMAT'. A MicroFocus compiler directive.
	private static final Pattern MF_SET_DIRECTIVE = Pattern
			.compile("^\\s*\\$\\s*SET\\s+SOURCEFORMAT(\\s|\"|\\().*");

	private boolean isMicroFocusCompilerDirective(Token token) {
		// TODO Find some real documentation on this statement.
		// TODO When the directive sets the sourceformat, use that to switch the
		// Koopa tokenizer source referenceFormat ?
		final String text = token.getText();

		// TODO Make this match more exact ? Right now it can accept bad inputs,
		// but that may be fine...
		final Matcher matcher = MF_SET_DIRECTIVE.matcher(text.toUpperCase());

		if (!matcher.find()) {
			return false;
		}

		token = token.withTags(COMPILER_DIRECTIVE, referenceFormat);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("MicroFocus compiler directive: " + token);

		queuedTokens.addFirst(token);
		return true;
	}

	// ========================================================================

	private static final Pattern TITLE_STATEMENT = Pattern
			.compile("(^|\\s)TITLE\\s.*");

	private boolean isTitleStatement(Token token) {
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

		token = token.withTags(COMPILER_DIRECTIVE, referenceFormat);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Title statement: " + token);

		queuedTokens.addFirst(token);
		return true;
	}

	// ========================================================================

	// For the CBL/PROCESS compiler directive.
	private static final Pattern CBL_PROCESS_STATEMENT = Pattern
			.compile("(^|\\s)(CBL|PROCESS)\\s.*");

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
			final Token sequenceNumber = Tokens.subtoken(token, 0, 6) //
					.withTags(SEQUENCE_NUMBER_AREA, referenceFormat);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Sequence number: " + sequenceNumber);

			queuedTokens.add(sequenceNumber);
		}

		final int endOfToken = Math.min(text.length(), 72);
		final Token directive = Tokens
				.subtoken(token, startOfToken, endOfToken) //
				.withTags(COMPILER_DIRECTIVE, referenceFormat);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("CBL (PROCESS) statement: " + directive);

		queuedTokens.add(directive);

		if (endOfToken < text.length()) {
			// Extra identification area.
			final Token identification = Tokens.subtoken(token, 72, endOfToken)
					.withTags(INDICATOR_AREA, referenceFormat);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Identification: " + identification);

			queuedTokens.add(identification);
		}

		return true;
	}
}
