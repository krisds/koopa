package koopa.core.sources;

import java.io.Reader;

import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;

/**
 * This class takes a {@link Reader} and spits out tokens. The tokens are either
 * "end of lines" which have an {@link AreaTag#END_OF_LINE} tag, or contain one
 * line of text (without tags).
 */
public class Printing extends ChainingSource<Token, Token> implements Source<Token> {

	private final String prefix;

	public Printing(Source<Token> source, String prefix) {
		super(source);
		this.prefix = prefix;
	}

	@Override
	protected Token nxt1() {
		Token token = source.next();

		System.out.println(prefix + token);

		return token;
	}
}
