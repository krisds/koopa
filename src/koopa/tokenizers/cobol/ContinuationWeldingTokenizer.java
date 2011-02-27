package koopa.tokenizers.cobol;

import java.util.LinkedList;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.ContinuationsTag;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;

import org.apache.log4j.Logger;

public class ContinuationWeldingTokenizer implements Tokenizer {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.continuation-welding");

	private Tokenizer tokenizer = null;
	private LinkedList<Token> buffer = null;

	public ContinuationWeldingTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
		this.buffer = new LinkedList<Token>();
	}

	public Token nextToken() {
		// First return the buffered tokens...
		if (!this.buffer.isEmpty()) {
			return this.buffer.removeFirst();
		}

		// Then fetch new tokens...
		Token token = this.tokenizer.nextToken();
		if (token == null) {
			// No more tokens. Return null.
			return null;
		}

		// Check if the token is continued...
		if (!token.hasTag(ContinuationsTag.CONTINUED)) {
			// It's not, so we just return that token.
			return token;
		}

		// The token is being continued. We build up the complete token from its
		// parts.
		final CompositeToken composedToken = new CompositeToken();
		composedToken.addTag(AreaTag.PROGRAM_TEXT_AREA);
		composedToken.addToken(token);

		// While the token is being continued...
		while (token != null && token.hasTag(ContinuationsTag.CONTINUED)) {
			// Get the next token.
			token = this.tokenizer.nextToken();

			// Skip all skipped tokens...
			while (token != null && token.hasTag(ContinuationsTag.SKIPPED)) {
				// ... but add them to the buffer.
				this.buffer.addLast(token);

				// Try another token.
				token = this.tokenizer.nextToken();
			}

			if (token == null || !token.hasTag(ContinuationsTag.CONTINUING)) {
				// TODO Throw error.
				return null;
			}

			// Split of the starting quotation character if there is one.
			if (token.hasTag(ContinuationsTag.LEADING_QUOTE)) {
				final Token[] split = token.split(1);

				final Token quotationMark = split[0];
				quotationMark.removeTag(AreaTag.PROGRAM_TEXT_AREA);
				quotationMark.addTag(AreaTag.COMMENT);
				this.buffer.addLast(quotationMark);

				token = split[1];
			}

			// Then add the new part to the composed token.
			if (token != null) {
				composedToken.addToken(token);
			}
		}

		// Add the composed token.
		this.buffer.addLast(composedToken);

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Welded token: " + composedToken);
		}

		// Return whichever token is first up (there should be at least one).
		return this.buffer.removeFirst();
	}

	public void quit() {
		tokenizer.quit();
	}
}
