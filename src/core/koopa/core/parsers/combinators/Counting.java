package koopa.core.parsers.combinators;

import java.util.HashMap;
import java.util.Map;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This {@linkplain ParserCombinator} sets up a context during parsing for
 * counting the number of matches a given {@linkplain ParserCombinator} has
 * within that context.
 */
public class Counting extends UnaryParserDecorator {

	public Counting(ParserCombinator parser) {
		super(parser);
	}

	@Override
	protected boolean matches(Parse parse) {
		final Counter counter = new Counter(parser);
		final boolean accepts = counter.accepts(parse);
		counter.clear();
		return accepts;
	}

	@Override
	public String toString() {
		return "%counting " + parser;
	}

	public class Counter extends UnaryParserDecorator {
		private Map<ParserCombinator, Integer> counts = new HashMap<>();

		public Counter(ParserCombinator parser) {
			super(parser);
		}

		@Override
		protected boolean matches(Parse parse) {
			return parser.accepts(parse);
		}

		private void clear() {
			counts.clear();
		}

		/**
		 * Get the number of matches for the given parser. Returns zero if we
		 * haven't seen it yet.
		 */
		public int getCount(ParserCombinator parser) {
			if (counts.containsKey(parser))
				return counts.get(parser);
			else
				return 0;
		}

		/**
		 * Increment the number of matches for the given parser.
		 */
		public void increment(ParserCombinator parser) {
			counts.put(parser, getCount(parser) + 1);
		}
	}
}
