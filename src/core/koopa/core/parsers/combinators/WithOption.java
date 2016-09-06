package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This {@linkplain ParserCombinator} sets an {@linkplain Opt} for the duration
 * of matching another {@linkplain ParserCombinator}. The option will be
 * restored to its original state afterwards.
 */
public class WithOption extends UnaryParserDecorator {

	private final Opt opt;

	public WithOption(Opt opt, ParserCombinator parser) {
		super(parser);
		this.opt = opt;
	}

	@Override
	public boolean matches(Parse parse) {
		if (parse.getTrace().isEnabled())
			parse.getTrace().add(toString() + " : on");

		final boolean originalState = parse.isSet(opt);
		parse.set(opt, true);
		final boolean accepts = parser.accepts(parse);
		parse.set(opt, originalState);

		if (parse.getTrace().isEnabled())
			parse.getTrace().add(
					toString() + " : " + (originalState ? "on" : "off"));

		return accepts;
	}

	@Override
	public String toString() {
		return "option " + opt.toString();
	}
}