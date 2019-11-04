package koopa.core.trees.jaxen;

import java.util.Iterator;

import koopa.core.trees.Tree;

import org.apache.log4j.Logger;

public class FollowingSibilingAxisIterator implements Iterator<Tree> {

	private static final Logger LOGGER = Logger.getLogger("xpath");

	private final Tree parent;
	private int index;

	public FollowingSibilingAxisIterator(Tree child) {
		this.parent = child.getParent();
		this.index = child.getChildIndex() + 1;
	}

	@Override
	public boolean hasNext() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("FollowingSibilingAxisIterator(" + parent
					+ ").hasNext()");

		final boolean hasNext = index < parent.getChildCount();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + hasNext);

		return hasNext;
	}

	@Override
	public Tree next() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("FollowingSibilingAxisIterator(" + parent + ").next()");

		final Tree next;
		if (index < parent.getChildCount())
			next = parent.getChild(index++);
		else
			next = null;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + next);

		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
