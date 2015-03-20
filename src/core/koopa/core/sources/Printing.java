package koopa.core.sources;

import java.io.Reader;

import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;

/**
 * This class takes a {@link Reader} and spits out tokens. The tokens are either
 * "end of lines" which have an {@link AreaTag#END_OF_LINE} tag, or contain one
 * line of text (without tags).
 */
public class Printing extends BasicSource<Token> implements Source<Token> {

	private final Source<Token> source;
	private final String prefix;

	public Printing(Source<Token> source, String prefix) {
		this.source = source;
		this.prefix = prefix;
	}

	public void close() {
		source.close();
	}

	@Override
	protected Token nxt1() {
		Token token = source.next();

		System.out.println(prefix + token);

		return token;
	}
}
