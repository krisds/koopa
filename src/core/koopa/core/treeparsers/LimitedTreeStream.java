package koopa.core.treeparsers;

import koopa.core.data.Data;

import org.apache.log4j.Logger;

public class LimitedTreeStream implements TreeStream {

	private static final Logger LOGGER = Logger.getLogger("treestream");

	private final TreeStream stream;
	private final TreeParser limiter;

	public LimitedTreeStream(TreeStream stream, TreeParser limiter) {
		this.stream = stream;
		this.limiter = limiter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Data forward() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("checking limit");

		stream.bookmark();

		if (limiter.accepts(stream)) {
			stream.rewind();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("limit reached");

			return null;
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("limit not reached");

		stream.rewind();

		return stream.forward();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreeStream forSubtree() {
		if (stream.getTree() == null)
			return null;

		final TreeStream subStream = new BasicTreeStream(this, stream.getTree());
		// We step because we don't want the root to get matched again.
		subStream.forward();
		return subStream;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void bookmark() {
		stream.bookmark();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void rewind() {
		stream.rewind();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commit() {
		stream.commit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void rewindSubtree() {
		stream.rewindSubtree();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commitSubtree() {
		stream.commitSubtree();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tree getTree() {
		return stream.getTree();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void skipCurrentTree() {
		stream.skipCurrentTree();
	}
}
