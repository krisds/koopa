package koopa.cobol.sources;

import static koopa.cobol.data.tags.CobolAreaTag.IDENTIFICATION_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.INDICATOR_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import koopa.cobol.data.tags.CobolAreaTag;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;
import koopa.core.util.Strings;
import koopa.core.util.TabStops;

/**
 * This {@linkplain Source} takes individual lines, and splits them up into the
 * different program areas (cfr. {@linkplain AreaTag} and
 * {@linkplain CobolAreaTag}) as defined by the {@linkplain SourceFormat}.
 */
public class ProgramArea extends ChainingSource implements Source {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.program_area");

	private final int tabLength;
	private final TabStops tabStops;

	private final LinkedList<Token> pendingTokens = new LinkedList<>();

	private final boolean cheapTabs;

	public ProgramArea(Source source, int tabLength, TabStops tabStops) {
		super(source);
		this.tabLength = tabLength;
		this.tabStops = tabStops;

		this.cheapTabs = tabLength == 1 && tabStops.undefined();
	}

	@Override
	protected Data nxt1() {
		if (!pendingTokens.isEmpty())
			return pendingTokens.removeFirst();

		final Data d = source.next();
		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;

		// End of lines are marked as program text, as they count towards
		// whitespace.
		if (t.hasTag(END_OF_LINE))
			return t.withTags(PROGRAM_TEXT_AREA);

		// Anything which has already been marked with program area information
		// gets passed along as-is to prevent it from being split erroneously.
		//
		// This may happen when COPY statements are expanded, in which case we
		// may see parts of the line the COPY statement was on more than once.
		if (AreaTag.isDefinedOn(t) || CobolAreaTag.isDefinedOn(t))
			return t;

		tokenizeLine(t);
		return pendingTokens.removeFirst();
	}

	protected void tokenizeLine(Token line) {
		final String text = line.getText();

		final int length = text.length();
		if (length == 0) {
			// No text. Shouldn't really happen; but better safe than sorry.
			pendingTokens.add(line);
			return;
		}

		final SourceFormat format = SourceFormat.forToken(line);

		if (format == FREE) {
			int c = text.charAt(0);

			if (c == 'D' || c == 'd') {
				// This is only an indicator if it gets followed by a space.
				// Otherwise it's program text.
				if (text.charAt(1) == ' ') {
					extract(line, 0, 1, INDICATOR_AREA, format);
					extract(line, 1, -1, COMMENT, format);

				} else {
					extract(line, PROGRAM_TEXT_AREA);
				}

			} else if (indicatesComment(c)) {
				// These are definitely indicators.
				//
				// Note: Keep this after the debug line check, as the
				// indicatesComment method accepts 'd' and 'D' as well.
				extract(line, 0, 1, INDICATOR_AREA, format);
				extract(line, 1, -1, COMMENT, format);

			} else {
				extract(line, PROGRAM_TEXT_AREA);
			}

		} else if (format == FIXED) {
			extract(line, 0, 6, SEQUENCE_NUMBER_AREA, format);

			final Token indicator = extract(line, 6, 7, INDICATOR_AREA, format);
			final boolean lineIsComment = indicator != null
					&& indicatesComment(indicator.charAt(0));

			extract(line, 7, 72, lineIsComment ? COMMENT : PROGRAM_TEXT_AREA,
					format);

			extract(line, 72, -1, IDENTIFICATION_AREA, format);

		} else if (format == VARIABLE) {
			extract(line, 0, 6, SEQUENCE_NUMBER_AREA, format);

			final Token indicator = extract(line, 6, 7, INDICATOR_AREA, format);
			final boolean lineIsComment = indicator != null
					&& indicatesComment(indicator.charAt(0));

			extract(line, 7, -1, lineIsComment ? COMMENT : PROGRAM_TEXT_AREA,
					format);

		} else {
			throw new UnsupportedOperationException(
					"Unexpected referenceFormat: " + format);
		}
	}

	private Token extract(Token line, int start, int end, Object tag,
			final SourceFormat format) {
		final int columns = getWidthInColumns(line);

		if (start >= columns)
			return null;

		int startIndex = characterIndexForColumn(line, start);
		int endIndex = end >= 0 ? characterIndexForColumn(line, end)
				: line.getText().length();

		if (endIndex <= startIndex)
			return null;

		final Token extracted = tokenizeArea(line, startIndex, endIndex, tag,
				format);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(tag + ": " + extracted);

		pendingTokens.add(extracted);
		return extracted;
	}

	private Token extract(Token line, Object tag) {
		Token extracted = line.withTags(tag);
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(tag + ": " + extracted);

		pendingTokens.add(extracted);
		return extracted;
	}

	public static boolean indicatesComment(int c) {
		return c == '*' || c == '/' || c == '$' || c == 'D' || c == 'd';
	}

	private Token tokenizeArea(Token token, int begin, int end,
			Object... tags) {
		return Tokens.subtoken(token, begin, end).withTags(tags);
	}

	/**
	 * How many columns wide is the given line ?
	 * <p>
	 * This differs from the raw length of a token in that we want to apply tab
	 * stops and tab length definitions to any tab characters found in the line.
	 * <p>
	 * Tab stops take precedence. If no tab stop can be found for a tab
	 * character then we count using tab length instead.
	 */
	private int getWidthInColumns(Token line) {
		final String text = line.getText();

		if (cheapTabs)
			return Strings.getWidthInColumns(text);

		int columns = 0;

		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == '\t') {
				final int stop = tabStops.tabStopAfter(columns);
				if (stop > columns)
					columns = stop;
				else
					columns += tabLength;
			} else
				columns += Strings.getWidthInColumns(text.charAt(i));

		return columns;
	}

	/**
	 * See {@linkplain #getWidthInColumns(Token)}. This calculates the inverse. Given a
	 * column number, what character index matches that ?
	 */
	private int characterIndexForColumn(Token line, int column) {
		if (column <= 0)
			return 0;

		final String text = line.getText();
		final int textWidth = Strings.getWidthInColumns(text);

		if (cheapTabs)
			return column < textWidth
					? Strings.getCharIndexForColumn(text, column)
					: text.length();

		int columns = 0;
		for (int i = 0; i < text.length(); i++) {
			if (column <= columns)
				return i;

			if (text.charAt(i) == '\t') {
				final int stop = tabStops.tabStopAfter(columns);
				if (stop > columns)
					columns = stop;
				else
					columns += tabLength;
			} else
				columns += Strings.getWidthInColumns(text.charAt(i));
		}

		return text.length();
	}
}
