package koopa.core.grammars.combinators;

import java.util.Map;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Optimizer;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Counting;
import koopa.core.parsers.combinators.Once;
import koopa.core.parsers.combinators.Permuted;
import koopa.core.parsers.combinators.Plus;

/**
 * This {@linkplain ParserCombinator} is equivalent to a {@linkplain Permuted},
 * except that it checks to see if it can use lookahead to speed up picking the
 * right branch.
 */
public class OptimizingPermuted extends Permuted {

	private final Grammar grammar;
	private boolean optimizerRan = false;
	private boolean useLookahead = false;
	private Counting counting = null;

	public OptimizingPermuted(Grammar grammar, ParserCombinator... parsers) {
		super(parsers);
		this.grammar = grammar;
	}

	@Override
	public boolean matches(Parse parse) {
		if (!optimizerRan) {
			useLookahead = Optimizer.canUseLookaheadInChoice(parsers);
			if (useLookahead) {
				final ParserCombinator[] onces = new ParserCombinator[parsers.length];
				for (int i = 0; i < parsers.length; i++)
					onces[i] = new Once(parsers[i]);

				final Map<String, ParserCombinator> dispatchTable //
						= Optimizer.dispatchTable(onces);
				final Dispatched dispatched = new Dispatched(grammar,
						dispatchTable);
				final Plus star = new Plus(dispatched);
				counting = new Counting(star);
			}

			optimizerRan = true;
		}

		if (useLookahead)
			return counting.accepts(parse);
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