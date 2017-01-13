package koopa.core.sources;

import koopa.core.data.Token;

/**
 * Tags all tokens coming from the source with the given tags.
 */
public class TagAll extends ChainingSource<Token, Token> implements
		Source<Token> {

	private Object[] tags;

	public TagAll(Source<Token> source, Object... tags) {
		super(source);
		this.tags = tags;
	}

	@Override
	protected Token nxt1() {
		Token token = source.next();

		if (token == null)
			return null;

		return token.withTags(tags);
	}
}
