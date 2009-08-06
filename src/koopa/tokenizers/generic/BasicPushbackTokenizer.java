package koopa.tokenizers.generic;


import java.util.Stack;

import koopa.tokenizers.PushbackTokenizer;
import koopa.tokenizers.Tokenizer;
import koopa.tokens.Token;

public class BasicPushbackTokenizer implements PushbackTokenizer {

	private Stack<Token> stack = null;

	private Tokenizer tokenizer = null;

	public BasicPushbackTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.stack = new Stack<Token>();
		this.tokenizer = tokenizer;
	}

	public void pushback(Token token) {
		assert (token != null);
		stack.push(token);
	}

	public Token nextToken() {
		if (stack.isEmpty())
			return tokenizer.nextToken();
		else
			return stack.pop();
	}

	public void quit() {
		tokenizer.quit();
	}
}
