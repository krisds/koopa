package koopa.util;

import org.antlr.runtime.tree.Tree;

public class ANTLR {
	public static String getText(Tree node) {
		if (node == null) {
			return null;
		}

		StringBuilder builder = new StringBuilder();

		gather(node, builder);

		return builder.toString();
	}

	private static void gather(Tree node, StringBuilder builder) {
		final int count = node.getChildCount();

		if (count > 0) {
			for (int i = 0; i < count; i++) {
				gather(node.getChild(i), builder);
			}

		} else {
			builder.append(node.getText());
		}
	}
}
