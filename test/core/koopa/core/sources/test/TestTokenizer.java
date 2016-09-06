package koopa.core.sources.test;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

/**
 * A {@linkplain Source} which can tell you whether or not it has reached an
 * expected endpoint. That point is either indicated by an explicit marker (see
 * {@linkplain #MARKER_TEXT}, or just the end of regular input.
 */
public class TestTokenizer extends ChainingSource<Token, Token> implements Source<Token> {

	private static final Logger LOGGER = Logger.getLogger("source.test");

	public static final String MARKER_TEXT = "#";

	private Token marker;
	private LinkedList<Token> tokensSinceMarker = new LinkedList<Token>();

	public TestTokenizer(Source<Token> source) {
		super(source);
	}

	@Override
	protected Token nxt1() {
		Token next = source.next();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("%% " + next);

		return next;
	}

	@Override
	public Token next() {
		Token token = super.next();

		if (token == null)
			return null;

		if (MARKER_TEXT.equals(token.getText())) {
			marker = token;

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("+> MARKER ");

			token = super.next();
		}

		if (marker != null && token != null)
			tokensSinceMarker.add(token);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("> " + token);

		return token;
	}

	public void close() {
		source.close();
	}

	@Override
	public void unshift(Token token) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("<<< " + token);

		super.unshift(token);

		if (marker != null) {
			Token last = tokensSinceMarker.removeLast();
			assert (token == last);

			if (tokensSinceMarker.isEmpty()) {
				if (LOGGER.isTraceEnabled())
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
			Token token = next();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("@ " + (marker == null ? "" : "#") + token);

			if (marker != null)
				return true;

			if (token == null)
				return true;

			// TODO Would prefer to fall back on
			// KoopaGrammar.isProgramText/isSeparator.

			if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA))
				continue;

			final String text = token.getText();

			if (text.trim().length() > 0)
				return false;
		}
	}

	private boolean isAtMarker() {
		for (Token token : tokensSinceMarker) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("M@ " + token);

			// TODO Would prefer to fall back on
			// KoopaGrammar.isProgramText/isSeparator.

			if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA))
				continue;

			if (token.getText().trim().length() > 0)
				return false;
		}

		return true;
	}
}
