package sandbox.tokenizer;

import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

/**
 * This is an example custom tokenizer which filters out all tokens with text
 * "EJECT" (case does not have to match).
 */
public class MyFilteringTokenizer extends FilteringTokenizer {

	public MyFilteringTokenizer() {
		super(new TokenFilter() {
			public boolean accepts(Token token) {
				// System.out.print(".");
				return !token.getText().equalsIgnoreCase("EJECT");
			}
		});
	}
}
