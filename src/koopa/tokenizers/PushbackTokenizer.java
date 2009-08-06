package koopa.tokenizers;

import koopa.tokens.Token;

public interface PushbackTokenizer extends Tokenizer {

	public void pushback(Token token);
}
