package koopa.tokenizers;

import koopa.tokens.Token;

public interface Tokenizer {
	public Token nextToken();

	public void quit();
}
