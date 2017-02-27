package koopa.core.sources;

import koopa.core.data.Data;
import koopa.core.data.Replaced;
import koopa.core.data.Token;

/**
 * Marks all {@linkplain Token}s as replacing something {@linkplain Replaced}.
 */
public class AsReplacing extends ChainingSource
		implements Source {

	private Replaced replaced;

	public AsReplacing(Source source, Replaced replaced) {
		super(source);
		this.replaced = replaced;
	}

	@Override
	protected Data nxt1() {
		final Data d = source.next();

		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;
		
		return t.asReplacing(replaced);
	}
}
