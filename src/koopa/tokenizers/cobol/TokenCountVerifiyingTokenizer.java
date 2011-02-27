package koopa.tokenizers.cobol;

import java.util.LinkedList;
import java.util.List;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.ContinuationsTag;
import koopa.tokens.Token;

import org.apache.log4j.Logger;

public class TokenCountVerifiyingTokenizer implements Tokenizer {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.count_verifying");

	private Tokenizer tokenizer = null;
	private int count = 0;

	private List<String> errorMessages = null;

	public TokenCountVerifiyingTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
		this.errorMessages = new LinkedList<String>();
	}

	public Token nextToken() {
		Token token = tokenizer.nextToken();

		if (token != null) {
			if (token.hasTag(ContinuationsTag.SKIPPED)) {
				// Do nothing.

			} else if (token.hasTag(AreaTag.END_OF_LINE)) {
				count = 0;

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				count += 1;

			} else if (token.hasTag(AreaTag.IDENTIFICATION_AREA)) {
				String text = token.getText();
				int pos = text.indexOf(':');
				if (pos != -1) {
					int expected = Integer.parseInt(text.substring(pos + 1)
							.trim());

					if (expected != count) {
						LOGGER.error("Line " + token.getStart().getLinenumber()
								+ ": found " + count + " token(s); expected "
								+ expected + ".");
					}
				}
			}
		}

		return token;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void quit() {
		tokenizer.quit();
	}
}
