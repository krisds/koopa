package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

public class AssignResultTo extends ParserCombinator {

	private final String name;
	private final ParserCombinator parser;

	public AssignResultTo(String name, ParserCombinator parser) {
		this.name = name;
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		parse.getStack().getScope().setLValue(name);
		boolean accepts = parser.accepts(parse);
		parse.getStack().getScope().setLValue(null);
		return accepts;
	}

	public String toString() {
		return name + " = ...";
	}
}