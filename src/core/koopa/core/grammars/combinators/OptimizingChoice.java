package koopa.core.grammars.combinators;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Optimizer;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Choice;

/**
 * This {@linkplain ParserCombinator} is equivalent to a {@linkplain Choice},
 * except that it checks to see if it can use lookahead to speed up picking the
 * right branch. If it can this becomes a {@linkplain Dispatched} parser
 * instead.
 */
public class OptimizingChoice extends Choice {

	private final Grammar grammar;
	private boolean optimizerRan = false;
	private boolean useLookahead = false;
	private ParserCombinator optimized = null;

	public OptimizingChoice(Grammar grammar, ParserCombinator... parsers) {
		super(parsers);
		this.grammar = grammar;
	}

	@Override
	public boolean matches(Parse parse) {
		if (!optimizerRan) {
			int lead = Optimizer.countLeadingLookaheadInChoice(parsers);
			if (lead == parsers.length) {
				optimized = Optimizer.dispatched(grammar, parsers);
			
			} else if (lead > 2) {
				final ParserCombinator[] reduced = new ParserCombinator[parsers.length
						- lead + 1];
				reduced[0] = Optimizer.dispatched(grammar, parsers, 0, lead);
				for (int i = 1; i < reduced.length; i++)
					reduced[i] = parsers[lead + i - 1];
				optimized = new Choice(reduced);
			}

			optimizerRan = true;
		}

		if (optimized != null)
			return optimized.accepts(parse);
		else
			return super.matches(parse);
	}

	@Override
	public String toString() {
		if (!optimizerRan)
			return super.toString() + "<<?>>";
		else if (useLookahead)
			return super.toString() + "<<+>>";
		else
			return super.toString() + "<<->>";
	}
}