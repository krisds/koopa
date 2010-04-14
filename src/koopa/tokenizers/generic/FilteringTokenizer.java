package koopa.tokenizers.generic;

import koopa.tokenizers.Tokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

public class FilteringTokenizer extends IntermediateTokenizer implements
		Tokenizer {

	private TokenFilter test = null;

	public FilteringTokenizer(Tokenizer tokenizer, final Object tag) {
		this(tokenizer, new TokenFilter() {
			public boolean accepts(Token token) {
				return token.hasTag(tag);
			}
		});

		assert (tag != null);
	}

	public FilteringTokenizer(TokenFilter test) {
		this(null, test);
	}

	public FilteringTokenizer(Tokenizer tokenizer, TokenFilter test) {
		assert (test != null);

		this.previousTokenizer = tokenizer;
		this.test = test;
	}

	public Token nextToken() {
		Token token = null;

		do {
			token = this.previousTokenizer.nextToken();
		} while (token != null && !test.accepts(token));

		return token;
	}
}
