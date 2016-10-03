package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator}, but only if we're not inside an unbalanced
 * context (as determined via {@linkplain Balancing.Balancer#isBalanced()}).
 */
public class NotNested extends UnaryParserDecorator {

	private static final String SYMBOL = "%notnested";

	public NotNested(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		final Frame frame = parse.getStack().find(Balancing.Balancer.class);
		final Balancing.Balancer balancer = (frame == null ? null
				: (Balancing.Balancer) frame.getParser());
		final boolean balanced = balancer == null || balancer.isBalanced();

		if (parse.getTrace().isEnabled())
			parse.getTrace().add(
					balancer == null ? "no balancer" : balancer.getReport());

		if (!balanced) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(
						SYMBOL + " : no, unbalanced, dixit " + balancer);

			return false;
		}

		final boolean accepts = parser.accepts(parse);

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : "
					+ (accepts ? "yes, dixit " + balancer : "no"));

		return accepts;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}