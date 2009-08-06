package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

import org.antlr.runtime.tree.Tree;

public class NodeFilter implements Filter {

	private int type;

	public NodeFilter(int type) {
		this.type = type;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		final Tree upcoming = tokenizer.LA(1);

		if (DEBUG) {
			Log.enter(this);
		}

		if (upcoming == null || upcoming.getType() != this.type) {
			if (DEBUG) {
				Log.log("Bad node: "
						+ upcoming
						+ (upcoming == null ? "" : " (" + upcoming.getType()
								+ ")"));
				Log.fail(this);
			}
			return false;

		} else {
			tokenizer.consume(1);
			if (DEBUG) {
				Log.log("Right node: " + upcoming + " (" + upcoming.getType()
						+ ")");
				Log.exit(this);
			}
			return true;
		}
	}

	public String toString() {
		return "node(" + this.type + ")";
	}
}
