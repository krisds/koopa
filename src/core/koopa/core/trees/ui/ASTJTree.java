package koopa.core.trees.ui;

import java.util.LinkedList;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import koopa.core.data.Token;
import koopa.core.trees.Tree;

public class ASTJTree extends JTree {

	private static final long serialVersionUID = 1L;

	private final Tree tree;

	public ASTJTree(Tree tree) {
		super(new ASTtoTreeModelAdapter(tree));
		this.tree = tree;
	}

	@Override
	public String convertValueToText(Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {

		Tree node = (Tree) value;
		if (node.getData() instanceof Token) {
			Token token = (Token) node.getData();
			if (token.getReplaced() == null)
				return token.getText() + " | "
						+ token.getStart().getLinenumber() + ":"
						+ token.getStart().getPositionInLine();
			else
				return token.getText() + " | "
						+ token.getStart().getLinenumber() + ":"
						+ token.getStart().getPositionInLine() + " in "
						+ token.getStart().getResourceName();
		}

		return node.toString();
	}

	public void select(Token token) {
		Tree node = tree.find(token);

		if (node == null)
			return;

		final TreePath treePath = getTreePathToNode(node);
		setSelectionPath(treePath);
		scrollPathToVisible(treePath);
	}

	private TreePath getTreePathToNode(Tree node) {
		final LinkedList<Tree> path = new LinkedList<>();
		while (node != null) {
			path.addFirst(node);
			node = node.getParent();
		}

		final TreePath treePath = new TreePath(path.toArray(new Object[path
				.size()]));
		return treePath;
	}
}
