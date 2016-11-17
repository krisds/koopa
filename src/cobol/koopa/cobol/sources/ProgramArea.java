package koopa.cobol.sources;

import static koopa.cobol.data.tags.CobolAreaTag.IDENTIFICATION_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.INDICATOR_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.io.IOException;

import org.apache.log4j.Logger;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

public class ProgramArea extends ThreadedSource<Token, Token>
		implements Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.program_area");

	private static final String TAB_SIZE_KEY = "koopa.tabLength";
	private static final int DEFAULT_TAB_LENGTH = 1;
	private static int tabLength = DEFAULT_TAB_LENGTH;

	static {
		final String definition = System.getProperty(TAB_SIZE_KEY);
		if (definition != null) {
			try {
				setTabLength(Integer.parseInt(definition));

			} catch (NumberFormatException e) {
				tabLength = DEFAULT_TAB_LENGTH;
				System.err.println("Warning: value for " + TAB_SIZE_KEY
						+ " was not an unsigned integer: '" + definition
						+ "'. Using " + DEFAULT_TAB_LENGTH + " instead.");
			}
		}
	}

	public ProgramArea(Source<Token> source) {
		super(source);

		assert (source != null);
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			final Token token = source.next();

			if (token == null)
				return;

			if (token.hasTag(END_OF_LINE)) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("End of line: " + token);

				enqueue(token.withTags(PROGRAM_TEXT_AREA));
				continue;
			}

			if (token.hasTag(COMMENT) || token.hasTag(COMPILER_DIRECTIVE)) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("Whitespace: " + token);

				enqueue(token);
				continue;
			}

			final String text = token.getText();

			final int length = text.length();
			if (length == 0) {
				// No text. Shouldn't really happen; but better safe than sorry.
				continue;
			}

			final SourceFormat format = SourceFormat.forToken(token);

			if (format == FREE) {
				int c = text.charAt(0);

				if (c == 'D' || c == 'd') {
					// This is only an indicator if it gets followed by a space.
					// Otherwise it's program text.
					if (text.charAt(1) == ' ') {
						extract(token, 0, 1, INDICATOR_AREA, format);
						extract(token, 1, length, COMMENT, format);

					} else {
						extract(token, PROGRAM_TEXT_AREA);
					}

				} else if (indicatesComment(c)) {
					// These are definitely indicators.
					//
					// Note: Keep this after the debug line check, as the
					// indicatesComment method accepts 'd' and 'D' as well.
					extract(token, 0, 1, INDICATOR_AREA, format);
					extract(token, 1, length, COMMENT, format);

				} else {
					extract(token, PROGRAM_TEXT_AREA);
				}

			} else if (format == FIXED) {
				extract(token, 0, 6, SEQUENCE_NUMBER_AREA, format);

				final Token indicator = extract(token, 6, 7, INDICATOR_AREA,
						format);
				final boolean lineIsComment = indicator != null
						&& indicatesComment(indicator.charAt(0));

				extract(token, 7, 72,
						lineIsComment ? COMMENT : PROGRAM_TEXT_AREA, format);

				extract(token, 72, length, IDENTIFICATION_AREA, format);

			} else if (format == VARIABLE) {
				extract(token, 0, 6, SEQUENCE_NUMBER_AREA, format);

				final Token indicator = extract(token, 6, 7, INDICATOR_AREA,
						format);
				final boolean lineIsComment = indicator != null
						&& indicatesComment(indicator.charAt(0));

				extract(token, 7, length,
						lineIsComment ? COMMENT : PROGRAM_TEXT_AREA, format);

			} else {
				// Unexpected referenceFormat.
				System.err.println("Unexpected referenceFormat: " + format);
				// TODO Should throw an exception instead. Exiting hard is not
				// nice.
				System.exit(1);
			}
		}
	}

	private Token extract(Token token, int start, int end, Object tag,
			final SourceFormat format) {
		final int columns = columns(token);

		if (start >= columns)
			return null;

		int startIndex = characterIndexForColumn(token, start);
		int endIndex = characterIndexForColumn(token, end);

		if (endIndex <= startIndex)
			return null;

		final Token extracted = tokenizeArea(token, startIndex, endIndex, tag,
				format);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(tag + ": " + extracted);

		enqueue(extracted);
		return extracted;
	}

	private Token extract(Token token, Object tag) {
		Token extracted = token.withTags(tag);
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(tag + ": " + extracted);

		enqueue(extracted);
		return extracted;
	}

	public static boolean indicatesComment(int c) {
		return c == '*' || c == '/' || c == '$' || c == 'D' || c == 'd';
	}

	private Token tokenizeArea(Token token, int begin, int end,
			Object... tags) {
		return Tokens.subtoken(token, begin, end).withTags(tags);
	}

	private int columns(Token token) {
		final String text = token.getText();

		if (tabLength == 1)
			return text.length();

		int columns = 0;

		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == '\t')
				columns += tabLength;
			else
				columns += 1;

		return columns;
	}

	private int characterIndexForColumn(Token token, int column) {
		if (column <= 0)
			return 0;

		final String text = token.getText();
		int columns = 0;

		for (int i = 0; i < text.length(); i++) {
			if (column <= columns)
				return i;

			if (text.charAt(i) == '\t')
				columns += tabLength;
			else
				columns += 1;
		}

		return text.length();
	}

	public static int getTabLength() {
		return tabLength;
	}

	public static void setTabLength(int length) {
		if (tabLength == 0) {
			System.err.println("Warning: value for " + TAB_SIZE_KEY
					+ " is zero. Using " + DEFAULT_TAB_LENGTH + " instead.");
			tabLength = DEFAULT_TAB_LENGTH;

		} else if (tabLength < 0) {
			System.err.println("Warning: value for " + TAB_SIZE_KEY
					+ " is negative (" + length + "). Using "
					+ DEFAULT_TAB_LENGTH + " instead.");
			tabLength = DEFAULT_TAB_LENGTH;

		} else
			tabLength = length;
	}
}
