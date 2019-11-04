package koopa.core.trees.iterators;

import java.util.Iterator;

import koopa.core.data.Token;
import koopa.core.trees.TokenFilter;
import koopa.core.trees.Tree;

/**
 * Cfr. {@link Tree#allTokens()} and {@link Tree#allTokens(TokenFilter)}.
 */
public class DepthFirstTokenIterator implements Iterator<Token> {

	private final Tree root;
	private final TokenFilter filter;

	private Tree current;

	public DepthFirstTokenIterator(Tree root) {
		this(root, null);
	}

	public DepthFirstTokenIterator(Tree root, TokenFilter filter) {
		this.root = root;
		this.filter = filter != null ? filter : token -> true;

		this.current = root;

		if (!current.isToken())
			moveToNextToken();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Token next() {
		Token next = (Token) current.getData();
		moveToNextMatchingToken();
		return next;
	}

	private void moveToNextMatchingToken() {
		do {
			moveToNextToken();
		} while (current != null && !filter.include((Token) current.getData()));
	}

	private void moveToNextToken() {
		do {
			moveToNextLeaf();
		} while (current != null && !current.isToken());
	}

	private void moveToNextLeaf() {
		do {
			moveToNextNode();
		} while (current != null && current.hasChildren());
	}

	private void moveToNextNode() {
		// The next node is either the first child...
		if (current.hasChildren()) {
			current = current.getChild(0);
			return;
		}

		// Or it's the next sibling...
		while (current != null) {
			final Tree parent = current.getParent();

			// Do we have a parent ?
			if (parent == null) {
				current = null;
				return;
			}

			final int childIndex = current.getChildIndex();

			// Can we move to a sibling ?
			if (childIndex + 1 < parent.getChildCount()) {
				current = parent.getChild(childIndex + 1);
				return;
			}
			// Can we move to a parent's sibling ?
			else if (parent != root)
				current = parent;
			// We have hit our starting point.
			else
				current = null;
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
