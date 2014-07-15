package koopa.parsers.test;

import koopa.tokenizers.Tokenizer;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;

/**
 * Simple tokenizer which accepts a list of strings and tags, and returns them
 * in sequence as tokens. Token positions are calculated from the length of the
 * individual strings. Tags are added to the following string.
 * <p>
 * <b>For testing purposes only.</b>
 */
class VerbatimTestTokenizer implements Tokenizer {

	private final Object[] tagsAndTokens;
	private int index;
	private Position position;

	public VerbatimTestTokenizer(Object... tagsAndTokens) {
		this.tagsAndTokens = tagsAndTokens;
		this.index = 0;
		this.position = new Position(0, 0, 0);
	}

	@Override
	public Token nextToken() {
		if (index >= tagsAndTokens.length)
			return null;

		position = position.offsetBy(1);

		int from = index;

		String text = null;
		while (index < tagsAndTokens.length) {
			if (tagsAndTokens[index] instanceof String) {
				text = (String) tagsAndTokens[index];
				break;
			}

			index += 1;
		}

		if (text == null)
			return null;

		final Position end = position.offsetBy(text.length());
		final BasicToken token = new BasicToken(text, position, end);

		for (; from < index; from++) {
			token.addTag(tagsAndTokens[from]);
		}

		index += 1;

		return token;
	}

	@Override
	public void quit() {
	}
}
