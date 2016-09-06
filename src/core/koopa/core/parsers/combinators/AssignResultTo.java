package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This {@linkplain ParserCombinator} will assign the result of another
 * {@linkplain ParserCombinator} (if there is one) to a given variable.
 */
public class AssignResultTo extends UnaryParserDecorator {

	private final String name;

	public AssignResultTo(String name, ParserCombinator parser) {
		super(parser);
		this.name = name;
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