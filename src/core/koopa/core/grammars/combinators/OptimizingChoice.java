package koopa.core.grammars.combinators;

import java.util.Map;

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
	private Dispatched dispatched = null;

	public OptimizingChoice(Grammar grammar, ParserCombinator... parsers) {
		super(parsers);
		this.grammar = grammar;
	}

	@Override
	public boolean matches(Parse parse) {
		if (!optimizerRan) {
			useLookahead = Optimizer.canUseLookaheadInChoice(parsers);
			if (useLookahead) {
				final Map<String, ParserCombinator> dispatchTable //
						= Optimizer.dispatchTable(parsers);
				dispatched = new Dispatched(grammar, dispatchTable);
			}

			optimizerRan = true;
		}

		if (useLookahead)
			return dispatched.matches(parse);
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