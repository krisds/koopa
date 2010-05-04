package koopa.app.components.outline;

import javax.swing.Icon;

import koopa.tokens.Position;
import koopa.tokens.Token;
import koopa.util.ANTLR;

import org.antlr.runtime.tree.Tree;

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

	public Token getToken() {
		return ANTLR.getToken(this.tree);
	}

	public int getPositionInFile() {
		final Position start = ANTLR.getStart(this.tree);
		return start != null ? start.getPositionInFile() : -1;
	}

	public String getDescription() {
		return description;
	}

	public Icon getIcon() {
		return this.icon;
	}

	public String toString() {
		return description;
	}
}
