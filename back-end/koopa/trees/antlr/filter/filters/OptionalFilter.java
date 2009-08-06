package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

public class OptionalFilter implements Filter {

	private Filter filter;

	public OptionalFilter(Filter filter) {
		this.filter = filter;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		if (this.filter == null) {
			return true;
		}

		if (DEBUG) {
			Log.enter(this);
		}

		// M1:
		tokenizer.mark();

		while (tokenizer.hasToken()) {
			// M2:
			tokenizer.mark();

			if (this.filter.filter(tokenizer)) {
				// M2:
				tokenizer.commit();
				// M1:
				tokenizer.commit();

				if (DEBUG) {
					Log.exit(this);
				}

				return true;

			} else {
				if (DEBUG) {
					Log.log("Skipping one.");
				}

				// M2:
				tokenizer.rollback();
				tokenizer.skip(1);
			}
		}

		if (DEBUG) {
			Log.log("Rolling back to start.");
		}
		// M1:
		tokenizer.rollback();

		if (DEBUG) {
			Log.exit(this);
		}
		return true;
	}

	public String toString() {
		return "?(" + this.filter + ")";
	}
}
