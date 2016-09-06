package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator} as many times as it can.
 */
public class Star extends UnaryParserDecorator {

	private static final String SYMBOL = "...*";

	public Star(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

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
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}