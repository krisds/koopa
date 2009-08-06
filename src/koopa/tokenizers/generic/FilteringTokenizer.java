package koopa.tokenizers.generic;

import koopa.tokenizers.Tokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

public class FilteringTokenizer implements Tokenizer {

	private Tokenizer tokenizer = null;

	private TokenFilter test = null;

	public FilteringTokenizer(Tokenizer tokenizer, final Object tag) {
		this(tokenizer, new TokenFilter() {
			public boolean accepts(Token token) {
				return token.hasTag(tag);
			}
		});

		assert (tag != null);
	}

	public FilteringTokenizer(Tokenizer tokenizer, TokenFilter test) {
		assert (tokenizer != null);
		assert (test != null);

		this.tokenizer = tokenizer;
		this.test = test;
	}

	public Token nextToken() {
		Token token = null;

		do {
			token = tokenizer.nextToken();
		} while (token != null && !test.accepts(token));

		return token;
	}

	public void quit() {
		tokenizer.quit();
	}
}
