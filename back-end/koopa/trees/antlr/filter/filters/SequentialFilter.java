package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

public class SequentialFilter implements Filter {

	private Filter[] filters;

	public SequentialFilter(Filter... filters) {
		this.filters = filters;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		if (this.filters == null || this.filters.length == 0) {
			return true;
		}

		if (DEBUG) {
			Log.enter(this);
		}

		if (!this.filters[0].filter(tokenizer)) {
			if (DEBUG) {
				Log.fail(this);
			}
			return false;
		}

		if (DEBUG) {
			Log.log("Matching next.");
		}

		int i = 1;

		// Try all filters while there are tokens left.
		matching: while (i < this.filters.length) {
			final Filter filter = this.filters[i];

			while (tokenizer.hasToken()) {
				tokenizer.mark();

				if (filter.filter(tokenizer)) {
					if (DEBUG) {
						Log.log("Matching next.");
					}

					tokenizer.commit();
					i += 1;
					continue matching;

				} else {
					if (DEBUG) {
						Log.log("Skipping one.");
					}

					tokenizer.rollback();
					tokenizer.skip(1);
				}
			}

			break matching;
		}

		if (DEBUG) {
			if (!tokenizer.hasToken()) {
				Log.log("At end of subtree or stream.");
			}
		}

		// Try remaining filters while there are no more tokens.
		while (i < this.filters.length) {
			final Filter filter = this.filters[i];

			if (filter.filter(tokenizer)) {
				if (DEBUG) {
					Log.log("Matching next.");
				}

				i += 1;

			} else {
				if (DEBUG) {
					Log.fail(this);
				}

				return false;
			}
		}

		if (DEBUG) {
			Log.exit(this);
		}
		return true;
	}

	public String toString() {
		String s = "(";
		for (Filter f : this.filters) {
			if (s.length() > 1) {
				s += ", ";
			}
			s += f.toString();
		}
		s += ")";

		return s;
	}
}
