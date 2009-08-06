package koopa.tokenizers.cobol;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.PseudoTag;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.Token;

public class ContinuationsTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {

	private Tokenizer tokenizer = null;

	private Token previous = null;
	private List<Token> skippable = null;

	public ContinuationsTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
		this.skippable = new LinkedList<Token>();
	}

	protected void tokenize() throws IOException {
		while (!hasQuit()) {
			final Token token = tokenizer.nextToken();

			if (token == null) {
				// End of input reached. Flush whatever tokens are still
				// waiting.
				if (previous != null) {
					enqueue(previous);
				}

				for (Token t : skippable) {
					enqueue(t);
				}

				skippable.clear();

				// Then exit the loop, and call it a day.
				break;

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				// Program text. Keep hold of this, and don't push it yet. If
				// there was another piece of program text being held, that may
				// now get pushed, as well as the non program text.
				if (previous != null) {
					enqueue(previous);
				}

				for (Token t : skippable) {
					enqueue(t);
				}

				skippable.clear();

				previous = token;

			} else if (token.hasTag(AreaTag.INDICATOR_AREA)) {
				// Indicator area. Check for value!
				if (token.getText().equals("-")) {
					this.previous.addTag(PseudoTag.CONTINUED);
					skippable.clear();

				} else {
					skippable.add(token);
				}

			} else {
				skippable.add(token);
			}
		}
	}

	public void quit() {
		quitMe();
		tokenizer.quit();
	}
}
