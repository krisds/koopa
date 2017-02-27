package koopa.core.sources;

import koopa.core.data.Data;
import koopa.core.data.Token;

/**
 * Tags all tokens coming from the source with the given tags.
 */
public class TagAll extends ChainingSource implements
		Source {

	private Object[] tags;

	public TagAll(Source source, Object... tags) {
		super(source);
		this.tags = tags;
	}

	@Override
	protected Data nxt1() {
		final Data d = source.next();

		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;

		return t.withTags(tags);
	}
}
