package koopa.trees.antlr.jaxen;

import org.antlr.runtime.tree.Tree;

public class ANTLRTreeAttribute {

	private final Tree tree;
	private final String name;
	private final String value;

	public ANTLRTreeAttribute(Tree tree, String name, String value) {
		this.tree = tree;
		this.name = name;
		this.value = value;
	}

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
