package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

public class RepeatedFilter implements Filter {

	private Filter filter;

	public RepeatedFilter(Filter filter) {
		this.filter = filter;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		if (this.filter == null) {
			return true;
		}

		if (DEBUG) {
			Log.enter(this);
		}

		// if (!this.filter.filter(tokenizer)) {
		// return false;
		// }

		if (DEBUG) {
			// Log.log("Mark last match.");
		}

		// M1:
		tokenizer.mark();

		while (tokenizer.hasToken()) {
			if (DEBUG) {
				// Log.log("Mark tentative match.");
			}

			// M2:
			tokenizer.mark();

			if (this.filter.filter(tokenizer)) {
				if (DEBUG) {
					// Log.log("Committing both marks.");
					Log.log("Marking last match.");
				}

				// M2:
				tokenizer.commit();
				// M1:
				tokenizer.commit();

				if (DEBUG) {
					// Log.log("Mark tentative match.");
				}

				// M1:
				tokenizer.mark();

			} else {
				if (DEBUG) {
					// Log.log("Rolling back to tentative mark.");
					Log.log("Skipping one.");
				}

				// M2:
				tokenizer.rollback();
				tokenizer.skip(1);
			}
		}

		if (DEBUG) {
			Log.log("Rolling back to last match.");
		}

		// M1:
		tokenizer.rollback();

		if (DEBUG) {
			Log.exit(this);
		}

		return true;
	}

	public String toString() {
		return "*(" + this.filter + ")";
	}
}
