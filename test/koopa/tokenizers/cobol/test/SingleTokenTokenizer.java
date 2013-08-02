package koopa.tokenizers.cobol.test;

import koopa.tokenizers.Tokenizer;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;

public class SingleTokenTokenizer implements Tokenizer {

	private String text;

	public SingleTokenTokenizer(String text) {
		this.text = text;
	}

	@Override
	public Token nextToken() {
		if (text == null)
			return null;

		Token token = new BasicToken(text, new Position(0, 0, 0), new Position(
				0, 0, text.length()));
		text = null;
		return token;
	}

	@Override
	public void quit() {
	}
}
