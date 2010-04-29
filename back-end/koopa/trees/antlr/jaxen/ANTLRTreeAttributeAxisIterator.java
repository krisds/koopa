package koopa.trees.antlr.jaxen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import koopa.tokens.Token;
import koopa.trees.antlr.CommonKoopaToken;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class ANTLRTreeAttributeAxisIterator implements
		Iterator<ANTLRTreeAttribute> {

	private final List<ANTLRTreeAttribute> attributes;
	private int index = 0;

	public ANTLRTreeAttributeAxisIterator(Tree tree) {
		this.attributes = new ArrayList<ANTLRTreeAttribute>();

		this.attributes.add(new ANTLRTreeAttribute(tree, "line", ""
				+ tree.getLine()));

		if (tree instanceof CommonTree) {
			final CommonTree commonTree = (CommonTree) tree;
			final CommonKoopaToken token = (CommonKoopaToken) commonTree
					.getToken();
			final Token koopa = token.getKoopaToken();

			final Set<Object> tags = koopa.getTags();
			if (tags != null) {
				for (Object tag : tags) {
					this.attributes.add(new ANTLRTreeAttribute(tree, "tag", tag
							.toString()));

				}
			}
		}
	}

	public boolean hasNext() {
		return this.index < this.attributes.size();
	}

	public ANTLRTreeAttribute next() {
		return this.attributes.get(this.index++);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
