package koopa.core.grammars.combinators;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Accepts any and all tokens. Will only fail when there are no more tokens on
 * the token stream (ignoring separators).
 */
public class MatchAny extends GrammaticalCombinator {

	private static final String SYMBOL = "_";

	public MatchAny(Grammar grammar) {
		super(grammar);
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Token token = parse.getStream().forward();

		if (token == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(SYMBOL + " : no, null");

			return false;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(SYMBOL + " : yes, " + token);

			return true;
		}
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}