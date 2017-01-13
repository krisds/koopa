package koopa.core.sources;

import koopa.core.data.Replaced;
import koopa.core.data.Token;

/**
 * Marks all {@linkplain Token}s as replacing something {@linkplain Replaced}.
 */
public class AsReplacing extends ChainingSource<Token, Token>
		implements Source<Token> {

	private Replaced replaced;

	public AsReplacing(Source<Token> source, Replaced replaced) {
		super(source);
		this.replaced = replaced;
	}

	@Override
	protected Token nxt1() {
		Token token = source.next();

		if (token == null)
			return null;

		return token.asReplacing(replaced);
	}
}
