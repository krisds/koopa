package koopa.core.trees.jaxen;

import java.util.Iterator;

import koopa.core.treeparsers.Tree;

public class FollowingSibilingAxisIterator implements Iterator<Tree> {

	private final Tree parent;
	private int index;

	public FollowingSibilingAxisIterator(Tree child) {
		this.parent = child.getParent();
		this.index = child.getChildIndex() + 1;
	}

	public boolean hasNext() {
		return index < parent.getChildCount();
	}

	public Tree next() {
		if (index < parent.getChildCount())
			return parent.getChild(index++);
		else
			return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
