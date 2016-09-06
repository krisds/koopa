package koopa.core.grammars.combinators;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * A {@linkplain ParserCombinator} which uses {@linkplain Grammar} knowledge.
 * <p>
 * This will skip all intermediate separators (except, optionally, a given one)
 * before the actual matching.
 */
public abstract class GrammaticalCombinator extends ParserCombinator {

	protected final Grammar grammar;
	private final String dontSkip;

	public GrammaticalCombinator(Grammar grammar) {
		this(grammar, null);
	}

	public GrammaticalCombinator(Grammar grammar, String dontSkip) {
		this.grammar = grammar;
		this.dontSkip = dontSkip;
	}

	@Override
	public boolean matches(Parse parse) {
		if (dontSkip == null)
			grammar.skipAll(parse);
		else
			grammar.skipOther(parse, dontSkip);

		return matchesAfterSkipped(parse);
	}

	protected abstract boolean matchesAfterSkipped(Parse parse);
}