package koopa.core.trees.ui;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import koopa.core.trees.Tree;

public class ASTtoTreeModelAdapter implements TreeModel {

	private final Tree root;

	public ASTtoTreeModelAdapter(Tree t) {
		this.root = t;
	}

	public Object getChild(Object parent, int index) {
		return ((Tree) parent).getChild(index);
	}

	public int getChildCount(Object parent) {
		return ((Tree) parent).getChildCount();
	}

	public int getIndexOfChild(Object parent, Object child) {
		if (parent == null || child == null)
			return -1;

		return ((Tree) child).getChildIndex();
	}

	public Object getRoot() {
		return root;
	}

	public boolean isLeaf(Object node) {
		return !((Tree) node).hasChildren();
	}

	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}

	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
	}
}
