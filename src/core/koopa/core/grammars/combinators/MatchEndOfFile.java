package koopa.core.grammars.combinators;

import koopa.core.data.Data;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Accepts when the token stream is at the end of the input (ignoring
 * separators).
 */
public class MatchEndOfFile extends GrammaticalCombinator {

	private static final String SYMBOL = "eof";

	public MatchEndOfFile(Grammar grammar) {
		super(grammar);
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Data d = parse.getStream().forward();
		final boolean atEndOfFile = d == null;

		if (parse.getTrace().isEnabled())
			parse.getTrace().add(
					SYMBOL + " : " + (atEndOfFile ? "yes" : "no") + ", " + d);

		return atEndOfFile;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}