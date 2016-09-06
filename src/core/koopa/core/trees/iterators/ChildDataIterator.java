package koopa.core.trees.iterators;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.trees.Tree;

/**
 * Cfr.{@link Tree#childData()}.
 */
public class ChildDataIterator implements Iterator<Data> {

	private final Tree root;

	private int index = 0;

	public ChildDataIterator(Tree root) {
		this.root = root;
	}

	public boolean hasNext() {
		return index < root.getChildCount();
	}

	public Data next() {
		Data data = root.getChild(index).getData();
		index += 1;
		return data;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
