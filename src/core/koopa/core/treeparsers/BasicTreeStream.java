package koopa.core.treeparsers;

import java.util.Stack;

import koopa.core.data.Data;

import org.apache.log4j.Logger;

public class BasicTreeStream implements TreeStream {

	protected static final Logger LOGGER = Logger.getLogger("treestream");

	private TreeStream parentStream;

	private final Stack<TreeWalker.State> bookmarks;

	private final TreeWalker walker;

	public BasicTreeStream(Tree tree) {
		this(null, tree);
	}

	public BasicTreeStream(TreeStream parentStream, Tree tree) {
		this.parentStream = parentStream;
		this.walker = new TreeWalker(tree);

		this.bookmarks = new Stack<TreeWalker.State>();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(trace("NEW"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Data forward() {
		Tree current = walker.next();

		if (current == null)
			return null;

		Data datum = current.getData();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(trace(" -> " + datum));

		return datum;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BasicTreeStream forSubtree() {
		if (walker.getCurrent() == null)
			return null;

		final BasicTreeStream subStream = new BasicTreeStream(this,
				walker.getCurrent());

		// We step because we don't want the root to get matched again.
		subStream.forward();
		return subStream;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void bookmark() {
		bookmarks.push(walker.getState());

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(trace("bookmarked"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void rewind() {
		walker.setState(bookmarks.pop());

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(trace("rewound"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commit() {
		bookmarks.pop();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(trace("committed"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void rewindSubtree() {
		assert (this.parentStream != null);

		this.parentStream = null;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(trace("rewound subtree"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commitSubtree() {
		assert (this.parentStream != null);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("[" + walker.getScope() + "] committing subtree on ["
					+ parentStream.getTree() + "]");

		parentStream.skipCurrentTree();

		parentStream = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tree getTree() {
		return walker.getCurrent();
	}

	private String trace(String msg) {
		String label;
		if (parentStream == null)
			label = "[" + walker.getScope() + "] ";
		else
			label = "[" + parentStream.getTree() + "//" + walker.getScope()
					+ "] ";

		return label + msg + " - " + " // " + bookmarks.size() + "."
				+ (bookmarks.isEmpty() ? "" : bookmarks.peek());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void skipCurrentTree() {
		walker.skipRemainderOfTree(walker.getCurrent());
	}
}
