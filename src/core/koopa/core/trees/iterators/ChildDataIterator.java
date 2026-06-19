package koopa.core.trees.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

	@Override
	public boolean hasNext() {
		return index < root.getChildCount();
	}

	@Override
	public Data next() {
		if (!hasNext())
			throw new NoSuchElementException("Called next on an iterator with no more elements");

		Data data = root.getChild(index).getData();
		index += 1;
		return data;
	}

}
