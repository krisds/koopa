package koopa.app.components.outline;

import javax.swing.Icon;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.trees.Tree;

public class Reference {
	private Tree tree = null;
	private String description = null;
	private Icon icon = null;

	public Reference(Tree tree, String description, Icon icon) {
		this.tree = tree;
		this.description = description;
		this.icon = icon;
	}

	public Tree getTree() {
		return tree;
	}

	public Data getToken() {
		return tree.getData();
	}

	public int getPositionInFile() {
		final Position start = tree.getStartPosition();
		return start != null ? start.getPositionInFile() : -1;
	}

	public String getDescription() {
		return description;
	}

	public Icon getIcon() {
		return this.icon;
	}

	@Override
	public String toString() {
		return description;
	}
}
