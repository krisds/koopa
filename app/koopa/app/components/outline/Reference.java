package koopa.app.components.outline;

import javax.swing.Icon;

import koopa.tokens.Position;
import koopa.tokens.Token;
import koopa.trees.antlr.CommonKoopaToken;

import org.antlr.runtime.tree.CommonTree;
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
		return getToken(this.tree);
	}

	private Token getToken(Tree tree) {
		if (!(tree instanceof CommonTree)) {
			return null;
		}

		final org.antlr.runtime.Token token = ((CommonTree) tree).getToken();
		if (!(token instanceof CommonKoopaToken)) {
			return null;
		}

		final CommonKoopaToken koopa = (CommonKoopaToken) token;
		return koopa.getKoopaToken();
	}

	public int getPositionInFile() {
		return getPositionInFile(this.tree);
	}

	private int getPositionInFile(Tree root) {
		final Position start = getToken(root).getStart();

		if (start != null) {
			return start.getPositionInFile();
		}

		for (int i = 0; i < root.getChildCount(); i++) {
			int position = getPositionInFile(root.getChild(i));

			if (position >= 0) {
				return position;
			}
		}

		return -1;
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
