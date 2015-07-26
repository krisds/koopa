package koopa.core.treeparsers;

import koopa.core.data.Data;
import koopa.core.trees.Tree;

public interface TreeStream {

	/**
	 * Get the next {@linkplain Data} in the tree.
	 */
	public Data forward();

	/**
	 * Get a new {@linkplain TreeStream} which is limited to the subtree at the
	 * current node.
	 */
	public TreeStream forSubtree();

	/**
	 * Bookmark the current position in the stream. This will impact the
	 * behaviour of {@linkplain TreeStream#rewind()} and
	 * {@linkplain TreeStream#commit()}.
	 */
	public void bookmark();

	/**
	 * Moves the stream back towards the last bookmark, or to the last commit.
	 */
	public void rewind();

	/**
	 * Commit the latest bookmark (in effect removing it). You won't be able to
	 * rewind beyond this point again.
	 */
	public void commit();

	/**
	 * Makes sure the parent stream is where we left it. Which is easy since we
	 * won't have touched it.
	 */
	public void rewindSubtree();

	/**
	 * Updates the parent stream to have skipped this subtree.
	 */
	public void commitSubtree();

	/**
	 * Get the (sub)tree at the current location in the stream.
	 */
	public Tree getTree();

	/**
	 * Make the stream skip the contents of the current tree.
	 */
	public void skipCurrentTree();
}
