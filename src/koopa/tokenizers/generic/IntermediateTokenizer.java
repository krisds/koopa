package koopa.tokenizers.generic;

import koopa.tokenizers.Tokenizer;

public abstract class IntermediateTokenizer implements Tokenizer {

	protected Tokenizer previousTokenizer = null;

	public void setPreviousTokenizer(Tokenizer previous) {
		this.previousTokenizer = previous;
	}

	public void quit() {
		if (this.previousTokenizer != null) {
			this.previousTokenizer.quit();
		}
	}
}
