package koopa.app.components.outline;


import javax.swing.Icon;

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
