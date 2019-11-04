package koopa.core.trees.jaxen;

import java.util.Iterator;

import koopa.core.trees.Tree;

public class DescendantOrSelfAxisIterator implements Iterator<Tree> {

	private final Tree root;
	private Tree next;

	public DescendantOrSelfAxisIterator(Tree root) {
		this.root = root;
		this.next = root;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public Tree next() {
		final Tree tree = this.next;

		moveOn();

		return tree;
	}

	private void moveOn() {
		if (this.next == null)
			return;

		if (this.next.getChildCount() > 0) {
			this.next = this.next.getChild(0);
			return;
		}

		while (true) {
			final Tree parent = this.next.getParent();

			if (parent == null) {
				this.next = null;
				return;
			}

			final int indexForNextSibling = this.next.getChildIndex() + 1;
			final int count = parent.getChildCount();
			if (indexForNextSibling < count) {
				this.next = parent.getChild(indexForNextSibling);
				return;
			}

			if (parent == this.root) {
				this.next = null;
				return;
			}

			this.next = parent;
		}
	}

	@Override
	public void remove() {
		new UnsupportedOperationException();
	}
}
