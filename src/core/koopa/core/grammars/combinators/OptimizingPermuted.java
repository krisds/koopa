package koopa.core.grammars.combinators;

import org.apache.log4j.Logger;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Optimizer;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Choice;
import koopa.core.parsers.combinators.Counting;
import koopa.core.parsers.combinators.Once;
import koopa.core.parsers.combinators.Permuted;
import koopa.core.parsers.combinators.Plus;

/**
 * This {@linkplain ParserCombinator} is equivalent to a {@linkplain Permuted},
 * except that it checks to see if it can use lookahead to speed up picking the
 * right alternative. If it can this uses a {@linkplain Dispatched} parser to
 * make that work.
 */
public class OptimizingPermuted extends Permuted {

	private static final Logger LOGGER = Logger.getLogger("optimization");

	private final Grammar grammar;
	private boolean optimizerRan = false;
	private ParserCombinator optimized = null;

	public OptimizingPermuted(Grammar grammar, ParserCombinator... parsers) {
		super(parsers);
		this.grammar = grammar;
	}

	@Override
	public boolean matches(Parse parse) {
		if (!optimizerRan) {
			optimizerRan = true;

			int count = Optimizer.countLeadingParsersAllowingLookahead(parsers);
			if (count == parsers.length) {
				// Best case: all alternatives allow lookahead, so a single
				// dispatch table will do. We need to combine this with Once and
				// Counting to make sure any alternative is not applied twice.

				if (LOGGER.isTraceEnabled()) {
					final Scoped scope = parse.getStack().getScope();
					LOGGER.trace("permutation in "
							+ (scope == null ? "??" : scope.getName())
							+ " : full dispatch of " + parsers.length
							+ " alternatives.");
				}

				final ParserCombinator[] onces = new ParserCombinator[parsers.length];
				for (int i = 0; i < parsers.length; i++)
					onces[i] = new Once(parsers[i]);

				final Dispatched dispatched = Optimizer.dispatched(grammar,
						onces);
				final Plus star = new Plus(dispatched);
				optimized = new Counting(star);

			} else if (count > 2) {
				// No point setting up dispatch for a single alternative.
				// But not much point for just two cases either.
				// Not sure what a good minimum is, but lets say three or more.

				if (LOGGER.isTraceEnabled()) {
					final Scoped scope = parse.getStack().getScope();
					LOGGER.trace("permutation in "
							+ (scope == null ? "??" : scope.getName())
							+ " : dispatching first " + count + " of "
							+ parsers.length + " alternatives.");
				}

				// We'll replace the leading parsers with a single dispatch.

				final ParserCombinator[] onces = new ParserCombinator[parsers.length];
				for (int i = 0; i < parsers.length; i++)
					onces[i] = new Once(parsers[i]);

				final ParserCombinator[] reduced = new ParserCombinator[onces.length
						- count + 1];
				reduced[0] = Optimizer.dispatched(grammar, onces, 0, count);
				for (int i = 1; i < reduced.length; i++)
					reduced[i] = parsers[count + i - 1];
				final Plus star = new Plus(new Choice(reduced));
				optimized = new Counting(star);
			}

			// TODO Is it worth looking for other sets of alternatives in the
			// parsers ?
		}

		if (optimized != null)
			return optimized.accepts(parse);
		else
			return super.matches(parse);
	}

	@Override
	public String toString() {
		return optimized == null ? super.toString() : optimized.toString();
	}
}