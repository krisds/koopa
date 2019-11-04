package koopa.core.trees.iterators;

import java.util.Iterator;

import koopa.core.trees.Tree;

/**
 * Cfr.{@link Tree#childTrees()}.
 */
public class ChildTreeIterator implements Iterator<Tree> {

	private final Tree root;

	private int index = 0;

	public ChildTreeIterator(Tree root) {
		this.root = root;

		if (index < root.getChildCount() && !root.getChild(index).isNode())
			moveToNextNode();
	}

	@Override
	public boolean hasNext() {
		return index < root.getChildCount();
	}

	@Override
	public Tree next() {
		Tree next = root.getChild(index);
		moveToNextNode();
		return next;
	}

	private void moveToNextNode() {
		index += 1;
		while (index < root.getChildCount() && !root.getChild(index).isNode())
			index += 1;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
