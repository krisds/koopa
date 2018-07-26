package koopa.core.grammars.combinators;

import org.apache.log4j.Logger;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Optimizer;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Choice;

/**
 * This {@linkplain ParserCombinator} is equivalent to a {@linkplain Choice},
 * except that it checks to see if it can use lookahead to speed up picking the
 * right alternative. If it can this uses a {@linkplain Dispatched} parser to
 * make that work.
 */
public class OptimizingChoice extends Choice {

	private static final Logger LOGGER = Logger.getLogger("optimization");

	private final Grammar grammar;
	private boolean optimizerRan = false;
	private ParserCombinator optimized = null;

	public OptimizingChoice(Grammar grammar, ParserCombinator... parsers) {
		super(parsers);
		this.grammar = grammar;
	}

	@Override
	public boolean matches(Parse parse) {
		if (!optimizerRan) {
			optimizerRan = true;

			final int count = Optimizer
					.countLeadingParsersAllowingLookahead(parsers);

			if (count == parsers.length) {
				// Best case: all alternatives allow lookahead, so a single
				// dispatch table will do.

				if (LOGGER.isTraceEnabled()) {
					final Scoped scope = parse.getStack().getScope();
					LOGGER.trace("choice in "
							+ (scope == null ? "??" : scope.getName())
							+ " : full dispatch of " + parsers.length
							+ " alternatives.");
				}

				optimized = Optimizer.dispatched(grammar, parsers);

			} else if (count > 2) {
				// No point setting up dispatch for a single alternative.
				// But not much point for just two cases either.
				// Not sure what a good minimum is, but lets say three or more.

				if (LOGGER.isTraceEnabled()) {
					final Scoped scope = parse.getStack().getScope();
					LOGGER.trace("choice in "
							+ (scope == null ? "??" : scope.getName())
							+ " : dispatching first " + count + " of "
							+ parsers.length + " alternatives.");
				}

				// We'll replace the leading parsers with a single dispatch.

				final ParserCombinator[] reduced //
						= new ParserCombinator[parsers.length - count + 1];
				reduced[0] = Optimizer.dispatched(grammar, parsers, 0, count);
				for (int i = 1; i < reduced.length; i++)
					reduced[i] = parsers[count + i - 1];
				optimized = new Choice(reduced);
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