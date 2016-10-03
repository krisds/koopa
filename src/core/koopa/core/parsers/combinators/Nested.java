package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator}, but only if we're inside an unbalanced context
 * (as determined via {@linkplain Balancing.Balancer#isBalanced()}).
 */
public class Nested extends UnaryParserDecorator {

	private static final String SYMBOL = "%nested";

	public Nested(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		final Frame frame = parse.getStack().find(Balancing.Balancer.class);
		final Balancing.Balancer balancer = (frame == null ? null
				: (Balancing.Balancer) frame.getParser());
		final boolean balanced = balancer != null && balancer.isBalanced();

		if (balanced) {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.dedent(SYMBOL + " : no, balanced, dixit " + balancer);

			return false;
		}

		final boolean accepts = parser.accepts(parse);

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : " + (accepts ? "yes" : "no"));

		return accepts;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}