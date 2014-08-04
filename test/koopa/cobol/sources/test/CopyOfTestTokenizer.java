package koopa.cobol.sources.test;

import java.io.StringReader;

import koopa.cobol.data.tags.AreaTag;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.LineSplitter;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.Separators;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Token;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

import org.apache.log4j.Logger;

/**
 * While used only in tests, this thing has grown beyond the simple tokenizer it
 * originally was.
 */
public class CopyOfTestTokenizer extends BasicSource<Token> implements Source<Token> {

	private static final Logger LOGGER = Logger.getLogger("tokenising.test");

	public static final String MARKER_TEXT = "#";

	private Source<Token> source;

	private Token markerToken = null;
	private Token tokenFollowingMarker = null;

	public CopyOfTestTokenizer(String data) {
		this(SourceFormat.FREE, data);
	}

	public CopyOfTestTokenizer(SourceFormat format, String data) {
		// The tokenizers in this sequence should generate the expected tokens.
		// TOCO Reuse setup from CobolParser somehow ?
		Source<Token> source = new LineSplitter(new StringReader(data));
		source = new CompilerDirectives(source, format);
		source = new ProgramArea(source, format);
		source = new SourceFormattingDirectives(source);

		if (format == SourceFormat.FIXED) {
			source = new LineContinuations(source);
			source = new ContinuationWelding(source);
		}

		source = new Separators(source);
		source = new PseudoLiterals(source);

		this.source = source;
	}

	@Override
	protected Token nxt1() {
		Token nextToken = source.next();
		
		if (nextToken != null && nextToken.getText().equals(MARKER_TEXT)) {

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("> " + nextToken);

			markerToken = nextToken;
			nextToken = source.next();
			tokenFollowingMarker = nextToken;
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("> " + nextToken);

		return nextToken;
	}

	@Override
	public void close() {
		source.close();
	}

	@Override
	public void unshift(Token token) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("< " + token);

		super.unshift(token);

		if (tokenFollowingMarker != null && tokenFollowingMarker == token) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("< " + markerToken);

			source.unshift(markerToken);

			markerToken = null;
			tokenFollowingMarker = null;
		}
	}

	public boolean isWhereExpected() {
		if (markerToken != null) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("At marker token.");

			return true;
		}

		Token nextToken = null;
		while (true) {
			nextToken = next();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("@ " + nextToken);

			if (nextToken == null)
				break;

			if (!nextToken.hasTag(AreaTag.PROGRAM_TEXT_AREA))
				continue;

			String text = nextToken.getText();
			if (",".equals(text) || ";".equals(text)
					|| text.trim().length() == 0)
				continue;

			break;
		}

		return nextToken == null || nextToken.getText().equals(MARKER_TEXT);
	}
}
