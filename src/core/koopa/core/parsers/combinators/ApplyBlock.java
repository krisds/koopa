package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

public class ApplyBlock extends ParserCombinator {
	private final Block func;

	public ApplyBlock(Block func) {
		this.func = func;
	}

	public boolean matches(Parse parse) {
		func.apply(parse);
		return true;
	}

	public String toString() {
		return "fn()";
	}
}