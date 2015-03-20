package koopa.cobol.sources;

import static koopa.cobol.data.tags.ContinuationsTag.CONTINUED;
import static koopa.cobol.data.tags.ContinuationsTag.CONTINUING;
import static koopa.cobol.data.tags.ContinuationsTag.LEADING_QUOTE;
import static koopa.cobol.data.tags.ContinuationsTag.SKIPPED;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

import org.apache.log4j.Logger;

public class ContinuationWelding extends BasicSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.continuation-welding");

	private Source<? extends Token> source = null;
	private LinkedList<Token> buffer = null;

	public ContinuationWelding(Source<? extends Token> source) {
		assert (source != null);
		this.source = source;
		this.buffer = new LinkedList<Token>();
	}

	@Override
	public Token nxt1() {
		// First return the buffered tokens...
		if (!buffer.isEmpty())
			return buffer.removeFirst();

		// Then fetch new tokens...
		Token token = source.next();
		if (token == null) {
			// No more tokens. Return null.
			return null;
		}

		// Check if the token is continued...
		if (!token.hasTag(CONTINUED)) {
			// It's not, so we just return that token.
			return token;
		}

		// The token is being continued. We build up the complete token from its
		// parts.
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(token);

		// While the token is being continued...
		while (token != null && token.hasTag(CONTINUED)) {
			// Get the next token.
			token = source.next();

			// Skip all skipped tokens...
			while (token != null && token.hasTag(SKIPPED)) {
				// ... but add them to the buffer.
				buffer.addLast(token);

				// Try another token.
				token = source.next();
			}

			if (token == null || !token.hasTag(CONTINUING)) {
				// TODO Throw error.
				return null;
			}

			// Split of the starting quotation character if there is one.
			if (token.hasTag(LEADING_QUOTE)) {
				final Token[] split = Tokens.split(token, 1);

				// TODO Would prefer to keep the area tag.
				final Token quotationMark = split[0].replacingTag(
						PROGRAM_TEXT_AREA, COMMENT);
				buffer.addLast(quotationMark);

				token = split[1];
			}

			// Then add the new part to the composed token.
			if (token != null)
				tokens.add(token);
		}

		final Token composedToken = new Token(tokens, PROGRAM_TEXT_AREA);

		// Add the composed token.
		buffer.addLast(composedToken);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Welded token: " + composedToken);

		// Return whichever token is first up (there should be at least one).
		return buffer.removeFirst();
	}

	public void close() {
		source.close();
	}
}
