package koopa.core.sources.test;

import java.util.Arrays;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

/**
 * Simple source of tokens which accepts a list of strings and tags, and returns
 * them in sequence as tokens. Token positions are calculated from the length of
 * the individual strings. Tags are added to the following string.
 * <p>
 * <b>For testing purposes only.</b>
 */
public class HardcodedSource extends BasicSource<Token> implements
		Source<Token> {

	private final List<Object> tagsAndTokens;
	private int index;
	private Position position;

	public HardcodedSource(List<Object> tagsAndTokens) {
		this.tagsAndTokens = tagsAndTokens;
		this.index = 0;
		this.position = new Position(0, 0, 0);
	}

	@Override
	public Token nxt1() {
		if (index >= tagsAndTokens.size())
			return null;

		position = position.offsetBy(1);

		int from = index;

		String text = null;
		while (index < tagsAndTokens.size()) {
			if (tagsAndTokens.get(index) instanceof String) {
				text = (String) tagsAndTokens.get(index);
				break;
			}

			index += 1;
		}

		if (text == null)
			return null;

		final Position end = position.offsetBy(text.length());
		Token token = new Token(text, position, end);

		for (; from < index; from++)
			token = token.withTags(tagsAndTokens.get(from));

		index += 1;

		return token;
	}

	@Override
	public void close() {
	}

	public static HardcodedSource from(Object[] tagsAndTokens) {
		return new HardcodedSource(Arrays.asList(tagsAndTokens));
	}
}
