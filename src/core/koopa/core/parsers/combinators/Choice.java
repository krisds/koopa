package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This {@linkplain ParserCombinator} tries to match a list of
 * {@linkplain ParserCombinator}s, stopping on the first success.
 */
public class Choice extends NAryParserDecorator {

	private static final String SYMBOL = "(...|...)";

	public Choice(ParserCombinator... parsers) {
		super(parsers);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		for (int i = 0; i < parsers.length; i++) {
			final ParserCombinator parser = parsers[i];

			stream.bookmark();
			if (parser.accepts(parse)) {
				if (parse.getTrace().isEnabled())
					parse.getTrace().dedent(SYMBOL + " : yes");

				stream.commit();
				return true;

			} else {
				stream.rewind();
			}
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : no");

		return false;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}