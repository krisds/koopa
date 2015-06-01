package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Scope;

public class ReturningValue extends ParserCombinator {

	private final String name;

	public ReturningValue(String name) {
		this.name = name;
	}

	public boolean matches(Parse parse) {
		Scope scope = parse.getStack().getScope();
		scope.setReturnValue(scope.getValue(name));
		return true;
	}

	public String toString() {
		return "return " + name;
	}
}