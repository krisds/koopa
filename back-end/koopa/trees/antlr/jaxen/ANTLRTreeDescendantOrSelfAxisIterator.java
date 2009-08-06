package koopa.trees.antlr.jaxen;

import java.util.Iterator;

import org.antlr.runtime.tree.Tree;

public class ANTLRTreeDescendantOrSelfAxisIterator implements Iterator<Tree> {

	private final Tree root;
	private Tree next;

	public ANTLRTreeDescendantOrSelfAxisIterator(Tree root) {
		this.root = root;
		this.next = root;
	}

	public boolean hasNext() {
		return this.next != null;
	}

	public Tree next() {
		final Tree tree = this.next;

		moveOn();

		return tree;
	}

	private void moveOn() {
		if (this.next == null) {
			return;
		}

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

	public void remove() {
		new UnsupportedOperationException();
	}
}
