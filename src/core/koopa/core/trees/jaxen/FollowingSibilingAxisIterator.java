package koopa.core.trees.jaxen;

import java.util.Iterator;

import koopa.core.treeparsers.Tree;

public class FollowingSibilingAxisIterator implements Iterator<Tree> {

	private final Tree parent;
	private final int count;
	private int index;

	public FollowingSibilingAxisIterator(Tree child) {
		this.parent = child.getParent();
		this.count = (parent != null) ? parent.getChildCount() : -1;
		this.index = child.getChildIndex();
	}

	public boolean hasNext() {
		return this.index < this.count;
	}

	public Tree next() {
		return this.parent.getChild(this.index++);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
