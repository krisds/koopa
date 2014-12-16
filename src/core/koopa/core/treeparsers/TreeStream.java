package koopa.core.treeparsers;

import java.util.LinkedList;

import koopa.core.data.Data;
import koopa.core.trees.antlr.CommonKoopaToken;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;

public class TreeStream {

	protected static final Logger LOGGER = Logger.getLogger("treestream");

	private TreeStream parentStream;

	private final CommonTree tree;

	private CommonTree last;
	private CommonTree node;

	private final LinkedList<CommonTree> bookmarks;

	public TreeStream(CommonTree tree) {
		this(null, tree);
	}

	public TreeStream(TreeStream parentStream, CommonTree tree) {
		this.parentStream = parentStream;

		this.tree = tree;
		this.node = tree;

		this.bookmarks = new LinkedList<CommonTree>();
	}

	/**
	 * Get the next {@linkplain Data} of a given type in the tree.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Data> T forward(Class<T> clazz) {
		while (true) {
			Data next = forward();

			if (next == null)
				return null;

			if (clazz.isInstance(next))
				return (T) next;
		}
	}

	/**
	 * Get the next {@linkplain Data} in the tree.
	 */
	public Data forward() {
		last = node;

		if (node == null)
			return null;

		CommonKoopaToken wrapper = (CommonKoopaToken) node.getToken();
		Data datum = wrapper.getKoopaData();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Next data: " + datum);

		step();

		return datum;
	}

	private void step() {
		if (node == null)
			return;

		if (stepToFirstChild())
			return;

		if (!canStepOut())
			return;

		if (stepToNextSibling())
			return;

		if (stepToNextAncestralSibling())
			return;

		stepToEnd();
	}

	private boolean stepToFirstChild() {
		if (node.getChildCount() > 0) {
			// The node has child nodes. => Move to the first child.
			node = (CommonTree) node.getChild(0);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("[" + tree + "] Stepped to first child: " + node);

			return true;
		}

		return false;
	}

	private boolean canStepOut() {
		CommonTree parent = (CommonTree) node.getParent();
		if (parent == null) {
			// The node has no children and no parent. => We're done.
			node = null;

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("[" + tree + "] There was only one node.");

			return false;
		}

		return true;
	}

	private boolean stepToNextSibling() {
		CommonTree parent = (CommonTree) node.getParent();

		if (node.getChildIndex() + 1 < parent.getChildCount()) {
			// The node has more siblings. => Move to the next sibling.
			node = (CommonTree) parent.getChild(node.getChildIndex() + 1);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("[" + tree + "] Stepped to next sibling: " + node);

			return true;
		}

		return false;
	}

	private boolean stepToNextAncestralSibling() {
		CommonTree parent = (CommonTree) node.getParent();

		// The node has no more siblings. So we try to find the first ancestor
		// node which does.
		do {
			node = parent;
			parent = (CommonTree) node.getParent();

			if (parent != null
					&& node.getChildIndex() + 1 < parent.getChildCount()) {
				// This ancestor has more siblings. => Move to the next sibling.
				node = (CommonTree) parent.getChild(node.getChildIndex() + 1);

				if (LOGGER.isTraceEnabled())
					LOGGER.trace("[" + tree
							+ "] Stepped to next sibling of ancestor: " + node);

				return true;
			}
		} while (parent != null && parent != tree);

		return false;
	}

	private void stepToEnd() {
		node = null;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] No more nodes.");
	}

	/**
	 * Get a new {@linkplain TreeStream} which is limited to the subtree at the
	 * current node.
	 */
	public TreeStream forSubtree() {
		if (last == null)
			return null;

		final TreeStream subStream = new TreeStream(this, last);
		// We step because we don't want the root to get matched again.
		subStream.step();
		return subStream;
	}

	/**
	 * Bookmark the current position in the stream. This will impact the
	 * behaviour of {@linkplain TreeStream#rewind()} and
	 * {@linkplain TreeStream#commit()}.
	 */
	public void bookmark() {
		bookmarks.add(node);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Bookmarking: " + node);
	}

	/**
	 * Moves the stream back towards the last bookmark, or to the last commit.
	 */
	public void rewind() {
		node = bookmarks.removeLast();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Rewinding.");
	}

	/**
	 * Commit the latest bookmark (in effect removing it). You won't be able to
	 * rewind beyond this point again.
	 */
	public void commit() {
		bookmarks.removeLast();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Committing.");
	}

	/**
	 * Makes sure the parent stream is where we left it. Which is easy since we
	 * won't have touched it.
	 */
	public void rewindSubtree() {
		assert (this.parentStream != null);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Rewinding subtree.");

		this.parentStream = null;
	}

	/**
	 * Updates the parent stream to have skipped this subtree.
	 */
	public void commitSubtree() {
		assert (this.parentStream != null);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Committing subtree.");

		if (parentStream.node == null)
			return;

		if (!parentStream.canStepOut())
			return;

		if (parentStream.stepToNextSibling())
			return;

		if (parentStream.stepToNextAncestralSibling())
			return;

		parentStream.stepToEnd();

		parentStream = null;
	}

	public Tree getTree() {
		return new Tree(last);
	}
}
