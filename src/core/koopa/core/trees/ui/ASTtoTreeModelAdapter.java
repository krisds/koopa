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

	@Override
	public Object getChild(Object parent, int index) {
		return ((Tree) parent).getChild(index);
	}

	@Override
	public int getChildCount(Object parent) {
		return ((Tree) parent).getChildCount();
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent == null || child == null)
			return -1;

		return ((Tree) child).getChildIndex();
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public boolean isLeaf(Object node) {
		return !((Tree) node).hasChildren();
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
	}
}
