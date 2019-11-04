package koopa.core.sources.test;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

/**
 * A {@linkplain Source} which can tell you whether or not it has reached an
 * expected endpoint. That point is either indicated by an explicit marker (see
 * {@linkplain #MARKER_TEXT}, or just the end of regular input.
 */
public class TestTokenizer extends ChainingSource
		implements Source {

	private static final Logger LOGGER = Logger.getLogger("source.test");
	private static final boolean TRACE = LOGGER.isTraceEnabled();

	public static final String MARKER_TEXT = "^";

	private Token marker;
	private LinkedList<Data> dataSinceMarker = new LinkedList<>();

	public TestTokenizer(Source source) {
		super(source);
	}

	@Override
	protected Data nxt1() {
		Data d = source.next();

		if (TRACE)
			LOGGER.trace("%% " + d);

		return d;
	}

	@Override
	public Data next() {
		Data d = super.next();

		if (d == null)
			return null;

		if (d instanceof Token && MARKER_TEXT.equals(((Token) d).getText())) {
			marker = (Token) d;

			if (TRACE)
				LOGGER.trace("+> MARKER ");

			d = super.next();
		}

		if (marker != null && d != null)
			dataSinceMarker.add(d);

		if (TRACE)
			LOGGER.trace("> " + d);

		return d;
	}

	@Override
	public void close() {
		source.close();
	}

	@Override
	public void unshift(Data token) {
		if (TRACE)
			LOGGER.trace("<<< " + token);

		super.unshift(token);

		if (marker != null) {
			Data last = dataSinceMarker.removeLast();

			assert (token == last);

			if (dataSinceMarker.isEmpty()) {
				if (TRACE)
					LOGGER.trace("<- MARKER");

				super.unshift(marker);
				marker = null;
			}
		}
	}

	public boolean isWhereExpected() {
		if (marker == null)
			return isAtMarkerOrEndOfSource();
		else
			return isAtMarker();
	}

	private boolean isAtMarkerOrEndOfSource() {
		while (true) {
			Data d = next();

			if (TRACE)
				LOGGER.trace("@ " + (marker == null ? "" : "#") + d);

			if (marker != null)
				return true;

			if (d == null)
				return true;

			// TODO Would prefer to fall back on
			// KoopaGrammar.isProgramText/isSeparator.

			if (d instanceof Token) {
				final Token t = (Token)d;
				
				if (!t.hasTag(AreaTag.PROGRAM_TEXT_AREA))
					continue;
				
				final String text = t.getText();
				
				if (text.trim().length() > 0)
					return false;
			}
		}
	}

	private boolean isAtMarker() {
		for (Data d : dataSinceMarker) {
			if (TRACE)
				LOGGER.trace("M@ " + d);

			if (!(d instanceof Token))
				continue;
			
			// TODO Would prefer to fall back on
			// KoopaGrammar.isProgramText/isSeparator.

			final Token t = (Token) d;
			
			if (!t.hasTag(AreaTag.PROGRAM_TEXT_AREA))
				continue;

			if (t.getText().trim().length() > 0)
				return false;
		}

		return true;
	}
}
