package koopa.core.treeparsers;

import java.util.LinkedList;

import koopa.core.data.Data;

import org.apache.log4j.Logger;

public class TreeStream {

	protected static final Logger LOGGER = Logger.getLogger("treestream");

	private final class Bookmark {
		public final Tree current;
		public final boolean started;

		public Bookmark(Tree tree, boolean started) {
			this.current = tree;
			this.started = started;
		}
	}

	private TreeStream parentStream;

	private final Tree tree;
	private Tree current;
	private boolean started = false;

	private final LinkedList<Bookmark> bookmarks;

	private boolean skip = false;

	public TreeStream(Tree tree) {
		this(null, tree);
	}

	public TreeStream(TreeStream parentStream, Tree tree) {
		this.parentStream = parentStream;

		this.tree = tree;
		this.current = null;

		this.bookmarks = new LinkedList<Bookmark>();
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
		step();

		if (started && current == null)
			return null;

		Data datum = current.getData();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Next data: " + datum);

		return datum;
	}

	private void step() {
		if (!started) {
			current = tree;
			started = true;
			return;
		}

		if (current == null)
			return;

		if (!skip) {
			if (stepToFirstChild())
				return;
		}
		
		skip = false;

		if (!canStepOut())
			return;

		if (stepToNextSibling())
			return;

		if (stepToNextAncestralSibling())
			return;

		stepToEnd();
	}

	private boolean stepToFirstChild() {
		if (current.getChildCount() > 0) {
			// The node has child nodes. => Move to the first child.
			current = (Tree) current.getChild(0);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("[" + tree + "] Stepped to first child: "
						+ current);

			return true;
		}

		return false;
	}

	private boolean canStepOut() {
		Tree parent = (Tree) current.getParent();
		if (parent == null) {
			// The node has no children and no parent. => We're done.
			current = null;

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("[" + tree + "] There was only one node.");

			return false;
		}

		return true;
	}

	private boolean stepToNextSibling() {
		Tree parent = (Tree) current.getParent();

		if (current.getChildIndex() + 1 < parent.getChildCount()) {
			// The node has more siblings. => Move to the next sibling.
			current = (Tree) parent.getChild(current.getChildIndex() + 1);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("[" + tree + "] Stepped to next sibling: "
						+ current);

			return true;
		}

		return false;
	}

	private boolean stepToNextAncestralSibling() {
		Tree parent = (Tree) current.getParent();

		// The node has no more siblings. So we try to find the first ancestor
		// node which does.
		while (parent != null && parent != tree) {
			current = parent;
			parent = (Tree) current.getParent();

			if (parent != null
					&& current.getChildIndex() + 1 < parent.getChildCount()) {
				// This ancestor has more siblings. => Move to the next sibling.
				current = (Tree) parent.getChild(current.getChildIndex() + 1);

				if (LOGGER.isTraceEnabled())
					LOGGER.trace("[" + tree
							+ "] Stepped to next sibling of ancestor: "
							+ current);

				return true;
			}
		}

		return false;
	}

	private void stepToEnd() {
		current = null;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] No more nodes.");
	}

	/**
	 * Get a new {@linkplain TreeStream} which is limited to the subtree at the
	 * current node.
	 */
	public TreeStream forSubtree() {
		if (current == null)
			return null;

		final TreeStream subStream = new TreeStream(this, current);
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
		bookmarks.add(new Bookmark(current, started));

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + tree + "] Bookmarking: " + current);
	}

	/**
	 * Moves the stream back towards the last bookmark, or to the last commit.
	 */
	public void rewind() {
		Bookmark bookmark = bookmarks.removeLast();

		current = bookmark.current;
		started = bookmark.started;

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
			LOGGER.trace("[" + tree + "] Committing subtree on ["
					+ parentStream.tree + "]");

		parentStream.skip = true;
		parentStream = null;
	}

	public Tree getTree() {
		return current;
	}
}
