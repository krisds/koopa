package koopa.util;

import javax.swing.JTree;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("serial")
public class ASTJTree extends JTree {

	public ASTJTree(CommonTree t) {
		super(new ASTtoTreeModelAdapter(t));
	}

	public String convertValueToText(Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {

		CommonTree node = (CommonTree) value;

		return node.getText() + " [" + node.getType() + "]";
	}
}
