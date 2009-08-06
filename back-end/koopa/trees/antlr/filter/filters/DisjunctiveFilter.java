package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

public class DisjunctiveFilter implements Filter {

	private Filter[] filters;

	public DisjunctiveFilter(Filter... filters) {
		this.filters = filters;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		if (this.filters == null || this.filters.length == 0) {
			return true;
		}

		if (DEBUG) {
			Log.enter(this);
		}

		while (tokenizer.hasToken()) {
			for (Filter filter : this.filters) {
				tokenizer.mark();

				if (filter.filter(tokenizer)) {
					if (DEBUG) {
						Log.exit(this);
					}
					tokenizer.commit();
					return true;

				} else {
					tokenizer.rollback();
				}
			}

			if (DEBUG) {
				Log.log("Skipping one.");
			}

			tokenizer.skip(1);
		}

		if (DEBUG) {
			Log.fail(this);
		}

		return false;
	}

	public String toString() {
		String s = "(";
		for (Filter f : this.filters) {
			if (s.length() > 1) {
				s += " | ";
			}
			s += f.toString();
		}
		s += ")";

		return s;
	}
}
