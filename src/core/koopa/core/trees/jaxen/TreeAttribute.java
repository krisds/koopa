package koopa.core.trees.jaxen;

import koopa.core.trees.Tree;

public class TreeAttribute {

	private final Tree tree;
	private final String name;
	private final String value;

	public TreeAttribute(Tree tree, String name, String value) {
		this.tree = tree;
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return name + " = " + value;
	}

	public Tree getTree() {
		return this.tree;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}
}
