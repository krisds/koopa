package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;

/**
 * A {@linkplain ParserCombinator} which tries to match another one, but never
 * more than once within an active {@linkplain Counting}'s context.
 */
public class Once extends UnaryParserDecorator {

	private static final String SYMBOL = "%once";

	public Once(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		final Frame frame = parse.getStack().find(Counting.Counter.class);
		assert (frame != null);

		final Counting.Counter counter = (Counting.Counter) frame.getParser();

		final int count = counter.getCount(this);
		if (count >= 1) {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.add(toString() + " : no, " + count + " time(s)");

			return false;
		}

		final boolean accepts = parser.accepts(parse);

		if (accepts)
			counter.increment(this);

		return accepts;
	}

	@Override
	public String toString() {
		return SYMBOL + " " + parser;
	}
}