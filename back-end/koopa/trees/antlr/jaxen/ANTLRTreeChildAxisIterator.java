package koopa.trees.antlr.jaxen;

import java.util.Iterator;

import org.antlr.runtime.tree.Tree;

public class ANTLRTreeChildAxisIterator implements Iterator<Tree> {

	private final Tree parent;
	private final int count;
	private int index = 0;

	public ANTLRTreeChildAxisIterator(Tree parent) {
		this.parent = parent;
		this.count = (parent != null) ? parent.getChildCount() : -1;
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
