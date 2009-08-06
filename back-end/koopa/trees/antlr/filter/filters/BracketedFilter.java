package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

import org.antlr.runtime.Token;

public class BracketedFilter implements Filter {

	private Filter filter = null;

	public BracketedFilter(Filter filter) {
		this.filter = filter;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		if (this.filter == null) {
			return true;
		}

		if (DEBUG) {
			Log.enter(this);
		}

		while (tokenizer.hasToken()) {
			if (tokenizer.LA(1).getType() == Token.EOF) {
				return false;
			}

			if (DEBUG) {
				// Log.log("Mark.");
			}

			tokenizer.mark();

			if (this.filter.filter(tokenizer)) {
				if (DEBUG) {
					// Log.log("Commit and finish.");
				}

				tokenizer.commit();
				finish(tokenizer);

				if (DEBUG) {
					Log.exit(this);
				}

				return true;

			} else {
				if (DEBUG) {
					Log.log("Skipping one.");
				}

				tokenizer.rollback();
				tokenizer.skip(1);
			}
		}

		if (DEBUG) {
			Log.fail(this);
		}

		return false;
	}

	private void finish(FilteringTokenizer tokenizer) {
		while (tokenizer.hasToken()) {
			if (tokenizer.LA(1).getType() == Token.EOF) {
				tokenizer.consume(1);
				return;

			} else {
				tokenizer.skip(1);
			}
		}
	}

	public String toString() {
		return "{" + this.filter + "}";
	}
}
