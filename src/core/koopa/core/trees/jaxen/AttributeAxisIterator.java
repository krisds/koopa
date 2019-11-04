package koopa.core.trees.jaxen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.trees.Tree;

public class AttributeAxisIterator implements Iterator<TreeAttribute> {

	private final List<TreeAttribute> attributes;
	private int index = 0;

	public AttributeAxisIterator(Tree tree) {
		this.attributes = new ArrayList<>();

		this.attributes
				.add(new TreeAttribute(tree, "line", "" + tree.getLine()));

		final Data data = tree.getData();

		if (data instanceof Start)
			this.attributes.add(new TreeAttribute(tree, "ns", ((Start) data)
					.getNamespace()));

		else if (data instanceof End)
			this.attributes.add(new TreeAttribute(tree, "ns", ((End) data)
					.getNamespace()));

		else if (data instanceof Token) {
			final Set<Object> tags = ((Token) data).getTags();
			if (tags != null)
				for (Object tag : tags)
					this.attributes.add(new TreeAttribute(tree, "tag", tag
							.toString()));
		}
	}

	@Override
	public boolean hasNext() {
		return this.index < this.attributes.size();
	}

	@Override
	public TreeAttribute next() {
		return this.attributes.get(this.index++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
