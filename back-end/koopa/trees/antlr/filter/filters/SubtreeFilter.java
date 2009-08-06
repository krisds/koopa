package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteringTokenizer;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;

public class SubtreeFilter implements Filter {

	private int type;
	private Filter subtree;

	public SubtreeFilter(int type) {
		this(type, null);
	}

	public SubtreeFilter(int type, Filter subtree) {
		this.type = type;
		this.subtree = subtree;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		if (DEBUG) {
			Log.enter(this);
		}

		final Tree root = tokenizer.LA(1);

		if (root == null || root.getType() != this.type) {
			if (DEBUG) {
				Log.log("Bad subtree: " + root
						+ (root != null ? " (" + root.getType() + ")" : ""));
				Log.fail(this);
			}
			return false;
		}

		if (DEBUG) {
			Log.log("Subtree matches: " + root
					+ (root != null ? " (" + root.getType() + ")" : ""));
		}

		tokenizer.consume(1);

		final Tree down = tokenizer.LA(1);

		if (down == null || down.getType() != Token.DOWN) {
			if (DEBUG) {
				Log.log("No children.");
				Log.fail(this);
			}

			return false;
		}

		tokenizer.consume(1);

		if (DEBUG) {
			Log.log("Limiting further matches to subtree of " + root);
		}

		tokenizer.limitToCurrentSubtree();

		if (this.subtree != null) {
			boolean matched = false;

			while (tokenizer.hasToken()) {
				if (DEBUG) {
					// Log.log("Mark.");
				}
				tokenizer.mark();

				if (subtree.filter(tokenizer)) {
					if (DEBUG) {
						// Log.log("Inner filter matched.");
						// Log.log("Commit.");
					}

					matched = true;
					tokenizer.commit();
					break;

				} else {
					if (DEBUG) {
						// Log.log("Rolling back.");
						Log.log("Skipping one.");
					}

					tokenizer.rollback();
					tokenizer.skip(1);
				}
			}

			if (!matched) {
				return false;
			}
		}

		if (DEBUG) {
			Log.log("Skipping to end of subtree.");
			Log.log("Lifting subtree limit");
		}

		tokenizer.skipToEndOfSubtree();
		tokenizer.liftLimit();

		final Tree up = tokenizer.LA(1);

		if (up == null || up.getType() != Token.UP) {
			if (DEBUG) {
				Log.log("Bad end of subtree.");
				Log.fail(this);
			}

			return false;
		}

		tokenizer.consume(1);

		if (DEBUG) {
			Log.exit(this);
		}

		return true;
	}

	public String toString() {
		return "tree(" + this.type + ")";
	}
}
