package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Scope;

/**
 * This {@linkplain ParserCombinator} sets the return value of the current scope
 * to be the value of a given variable.
 */
public class ReturningValue extends ParserCombinator {

	private final String name;

	public ReturningValue(String name) {
		this.name = name;
	}

	@Override
	public boolean matches(Parse parse) {
		Scope scope = parse.getStack().getScope();
		scope.setReturnValue(scope.getValue(name));
		return true;
	}

	@Override
	public String toString() {
		return "return " + name;
	}
}