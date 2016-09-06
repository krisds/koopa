package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator} as many times as it can, with a minimum of 1.
 */
public class Plus extends UnaryParserDecorator {

	private static final String SYMBOL = "...+";

	public Plus(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		stream.bookmark();

		if (!parser.accepts(parse)) {
			stream.rewind();

			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(SYMBOL + " : no");

			return false;
		}

		stream.commit();

		while (true) {
			stream.bookmark();

			if (!parser.accepts(parse)) {
				stream.rewind();
				break;
			}

			stream.commit();
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : yes");

		return true;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}