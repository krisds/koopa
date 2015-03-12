package koopa.app.components.astview;

import javax.swing.JTree;

import koopa.core.treeparsers.Tree;

public class ASTJTree extends JTree {

	private static final long serialVersionUID = 1L;

	public ASTJTree(Tree t) {
		super(new ASTtoTreeModelAdapter(t));
	}

	public String convertValueToText(Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {

		Tree node = (Tree) value;

		return node.toString();
	}
}
