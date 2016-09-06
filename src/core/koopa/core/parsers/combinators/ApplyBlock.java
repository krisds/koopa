package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This {@linkplain ParserCombinator} will call a {@linkplain Block} when
 * reached, then accept the match.
 */
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