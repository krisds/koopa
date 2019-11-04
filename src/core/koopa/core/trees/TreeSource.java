package koopa.core.trees;

import koopa.core.data.Data;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

/**
 * A {@linkplain Source} which iterates over the children of a given {@link Tree}.
 */
public class TreeSource extends BasicSource implements Source {

	private final Tree tree;
	private int next;

	public TreeSource(Tree tree) {
		assert (tree != null);
		this.tree = tree;
		this.next = 0;
	}

	@Override
	protected Data nxt1() {
		if (next >= tree.getChildCount())
			return null;

		final Tree child = tree.getChild(next);
		next += 1;

		if (child.isToken())
			return child.getData();
		else
			return child;
	}

	@Override
	public void close() {
		next = tree.getChildCount();
	}
}
