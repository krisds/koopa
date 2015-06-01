package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

public class WithOption extends ParserCombinator {

	private final Opt opt;
	private final ParserCombinator parser;

	public WithOption(Opt opt, ParserCombinator parser) {
		this.opt = opt;
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		boolean prv = false;

		switch (opt) {
		case NOSKIP:
			prv = parse.isSet(Opt.NOSKIP);
			parse.set(Opt.NOSKIP, true);
			if (parse.getTrace().isEnabled())
				parse.getTrace().add("%noskip: on");
			break;
		}

		final boolean accepts = parser.accepts(parse);

		switch (opt) {
		case NOSKIP:
			parse.set(Opt.NOSKIP, prv);
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(
						"%noskip: " + (parse.isSet(Opt.NOSKIP) ? "on" : "off"));
			break;
		}

		return accepts;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}

	public String toString() {
		return "%" + opt.toString();
	}
}