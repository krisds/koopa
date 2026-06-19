package koopa.core.trees.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
		if (!hasNext())
			throw new NoSuchElementException("Called next on an iterator with no more elements");

		Tree next = root.getChild(index);
		moveToNextNode();
		return next;
	}

	private void moveToNextNode() {
		index += 1;
		while (index < root.getChildCount() && !root.getChild(index).isNode())
			index += 1;
	}

}
