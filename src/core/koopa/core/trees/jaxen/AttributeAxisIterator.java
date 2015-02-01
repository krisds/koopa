package koopa.core.trees.jaxen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.treeparsers.Tree;

public class AttributeAxisIterator implements Iterator<TreeAttribute> {

	private final List<TreeAttribute> attributes;
	private int index = 0;

	public AttributeAxisIterator(Tree tree) {
		this.attributes = new ArrayList<TreeAttribute>();

		this.attributes
				.add(new TreeAttribute(tree, "line", "" + tree.getLine()));

		final Data koopa = tree.getData();

		if (koopa instanceof Token) {
			final Set<Object> tags = ((Token) koopa).getTags();
			if (tags != null)
				for (Object tag : tags)
					this.attributes.add(new TreeAttribute(tree, "tag", tag
							.toString()));
		}
	}

	public boolean hasNext() {
		return this.index < this.attributes.size();
	}

	public TreeAttribute next() {
		return this.attributes.get(this.index++);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
