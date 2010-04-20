package koopa.tokenizers.cobol;

import koopa.tokenizers.Tokenizer;
import koopa.tokens.Token;

public class TokenTrackerTokenizer implements Tokenizer {
	private Tokenizer tokenizer = null;

	private TokenTracker tokenTracker = null;

	public TokenTrackerTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
		this.tokenTracker = new TokenTracker();
	}

	public Token nextToken() {
		final Token token = tokenizer.nextToken();

		if (token != null) {
			this.tokenTracker.add(token);
		}

		return token;
	}

	public void quit() {
		tokenizer.quit();
	}

	public TokenTracker getTokenTracker() {
		return tokenTracker;
	}
}
