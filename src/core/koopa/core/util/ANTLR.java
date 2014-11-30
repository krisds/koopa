package koopa.core.util;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.trees.antlr.CommonKoopaToken;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public final class ANTLR {
	private ANTLR() {
	}

	public static String getText(Tree node) {
		if (node == null)
			return null;

		StringBuilder builder = new StringBuilder();

		gather(node, builder);

		return builder.toString();
	}

	private static void gather(Tree node, StringBuilder builder) {
		final int count = node.getChildCount();

		if (count > 0) {
			for (int i = 0; i < count; i++)
				gather(node.getChild(i), builder);

		} else {
			builder.append(node.getText());
		}
	}

	public static Data getToken(Tree tree) {
		if (!(tree instanceof CommonTree))
			return null;

		final org.antlr.runtime.Token token = ((CommonTree) tree).getToken();
		if (!(token instanceof CommonKoopaToken))
			return null;

		final CommonKoopaToken koopa = (CommonKoopaToken) token;
		return koopa.getKoopaData();
	}

	public static Position getStart(Tree root) {
		final Data data = getToken(root);

		final Position start = (data instanceof Token) ? ((Token) data)
				.getStart() : null;

		if (start != null)
			return start;

		for (int i = 0; i < root.getChildCount(); i++) {
			Position position = getStart(root.getChild(i));

			if (position != null)
				return position;
		}

		return null;
	}

	public static Position getEnd(Tree root) {
		final Data data = getToken(root);

		final Position end = (data instanceof Token) ? ((Token) data).getEnd()
				: null;

		if (end != null)
			return end;

		for (int i = root.getChildCount() - 1; i >= 0; i--) {
			Position position = getEnd(root.getChild(i));

			if (position != null)
				return position;
		}

		return null;
	}
}