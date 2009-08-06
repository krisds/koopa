package koopa.trees.antlr.filter;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.TreeNodeStream;

public class FilteringTokenizer {

	private static final boolean DEBUG = false;

	private TreeNodeStream stream = null;

	private LinkedList<Tree> consumed = new LinkedList<Tree>();

	private int depth = 0;

	private Stack<Integer> limits = new Stack<Integer>();

	private int limit = 0;

	private Stack<Integer> markers = new Stack<Integer>();

	private Stack<Tree> consumedWhenMarked = new Stack<Tree>();
	private Stack<Integer> depthWhenMarked = new Stack<Integer>();
	private Stack<Integer> limitWhenMarked = new Stack<Integer>();
	private Stack<Stack<Integer>> limitsWhenMarked = new Stack<Stack<Integer>>();

	public FilteringTokenizer(Tree tree) {
		this.stream = new CommonTreeNodeStream(tree);
	}

	private Tree consumeOne() {
		Tree token = (Tree) this.stream.LT(1);

		if (token == null) {
			return null;
		}

		if (token.getType() == Token.EOF) {
			return null;
		}

		if (token.getType() == Token.UP && this.depth == this.limit) {
			if (DEBUG) {
				System.out.println(this.depth
						+ ": Consume at end of current limit.");
			}

			return null;
		}

		this.stream.consume();

		if (token.getType() == Token.DOWN) {
			this.depth += 1;

		} else if (token.getType() == Token.UP) {
			this.depth -= 1;
		}

		return token;
	}

	public Tree LA(int offset) {
		if (offset < 1) {
			return null;
		}

		int futureDepth = this.depth;

		Tree token = null;
		for (int i = 1; i <= offset; i++) {
			token = (Tree) this.stream.LT(i);

			if (token.getType() == Token.UP && futureDepth == this.limit) {
				if (DEBUG) {
					System.out.println("LA(" + offset + ") => " + null);
				}
				return null;
			}

			if (token.getType() == Token.DOWN) {
				futureDepth += 1;

			} else if (token.getType() == Token.UP) {
				futureDepth -= 1;
			}
		}

		if (DEBUG) {
			System.out.println("LA(" + offset + ") => " + token);
		}

		return token;
	}

	public void skip(int count) {
		for (int i = 0; i < count; i++) {
			Tree token = consumeOne();
			if (DEBUG) {
				System.out.println(this.depth + ": Skipping " + token);
			}
		}
	}

	public void consume(int count) {
		for (int i = 0; i < count; i++) {
			Tree token = consumeOne();
			if (DEBUG) {
				System.out.println(this.depth + ": Consuming " + token);
			}
			this.consumed.add(token);
		}
	}

	public void limitToCurrentSubtree() {
		this.limits.push(this.limit);
		this.limit = this.depth;
		if (DEBUG) {
			System.out.println(this.depth + ": Limit set at " + this.limit);
		}
	}

	public void skipToEndOfSubtree() {
		while (true) {
			Tree token = LA(1);

			if (token == null) {
				if (DEBUG) {
					System.out.println(this.depth + ": At end of subtree.");
				}
				return;

			} else if (token.getType() == Token.EOF) {
				if (DEBUG) {
					System.out.println(this.depth
							+ ": At end of file. Unbalanced tree ?");
				}
				return;

			} else {
				consumeOne();
				if (DEBUG) {
					System.out.println(this.depth + ": Skipping " + token);
				}
			}
		}
	}

	public void liftLimit() {
		this.limit = this.limits.pop();
		if (DEBUG) {
			System.out.println(this.depth + ": Limit lifted. Back at "
					+ this.limit);
		}
	}

	public List<Tree> getConsumedTokens() {
		return this.consumed;
	}

	public void mark() {
		this.markers.push(this.stream.mark());

		if (this.consumed.size() == 0) {
			this.consumedWhenMarked.push(null);
		} else {
			this.consumedWhenMarked.push(this.consumed.getLast());
		}

		this.depthWhenMarked.push(this.depth);
		this.limitWhenMarked.push(this.limit);
		this.limitsWhenMarked.push(this.limits);
		this.limits = new Stack<Integer>();
		this.limits.addAll(this.limitsWhenMarked.peek());

		if (DEBUG) {
			System.out.println(this.depth + ": Marking "
					+ this.consumedWhenMarked.peek() + " at "
					+ this.markers.peek() + "; depth = " + this.depth
					+ "; limit = " + this.limit);
		}
	}

	public void commit() {
		this.stream.release(this.markers.pop());
		this.consumedWhenMarked.pop();
		this.depthWhenMarked.pop();
		this.limitWhenMarked.pop();
		this.limitsWhenMarked.pop();

		if (DEBUG) {
			System.out.println(this.depth + ": Committed last mark.");
		}
	}

	public void rollback() {
		final int mark = this.markers.pop();

		this.stream.rewind(mark);

		final Tree lastConsumedToken = this.consumedWhenMarked.pop();
		this.depth = this.depthWhenMarked.pop();
		this.limit = this.limitWhenMarked.pop();

		if (DEBUG) {
			System.out.println(this.depth + ": Rolling back to "
					+ lastConsumedToken + " at " + mark + "; depth = "
					+ this.depth + "; limit = " + this.limit);
		}

		while (!this.consumed.isEmpty()
				&& this.consumed.getLast() != lastConsumedToken) {
			Tree token = this.consumed.removeLast();
			if (DEBUG) {
				System.out.println(this.depth + ": Undoing " + token);
			}
		}

		this.limits = this.limitsWhenMarked.pop();
	}

	public boolean hasToken() {
		final Tree next = LA(1);
		return next != null && next.getType() != Token.EOF;
	}

	public TreeAdaptor getTreeAdaptor() {
		return this.stream.getTreeAdaptor();
	}
}
