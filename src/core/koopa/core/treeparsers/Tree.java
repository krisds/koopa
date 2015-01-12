package koopa.core.treeparsers;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.trees.antlr.CommonKoopaToken;
import koopa.core.util.ANTLR;

import org.antlr.runtime.tree.CommonTree;

// TODO This should replace CommonTree entirely.
public class Tree {

	private final CommonTree tree;

	public Tree(CommonTree tree) {
		this.tree = tree;
	}

	public String getProgramText() {
		if (tree == null)
			return null;

		StringBuilder builder = new StringBuilder();

		gather(tree, builder);

		return builder.toString();
	}

	private static void gather(CommonTree node, StringBuilder builder) {
		final int count = node.getChildCount();
		if (count > 0) {
			for (int i = 0; i < count; i++)
				gather((CommonTree) node.getChild(i), builder);

		} else {
			Data data = ((CommonKoopaToken) node.getToken()).getKoopaData();
			if (data instanceof Token
					&& ((Token) data).hasTag(AreaTag.PROGRAM_TEXT_AREA))
				builder.append(node.getText());
		}
	}

	public Data getData() {
		return ((CommonKoopaToken) tree.getToken()).getKoopaData();
	}

	public Position getStart() {
		return ANTLR.getStart(tree);
	}
}
