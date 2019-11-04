package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator} once, but still pass if it couldn't.
 */
public class Optional extends UnaryParserDecorator {

	private static final String SYMBOL = "[...]";

	public Optional(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		stream.bookmark();

		boolean accepts = parser.accepts(parse);
		if (accepts) {
			stream.commit();

		} else {
			stream.rewind();
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : " + (accepts ? "yes" : "no"));

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