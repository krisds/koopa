package koopa.core.trees.jaxen;

import java.util.Iterator;

import org.apache.log4j.Logger;

import koopa.core.trees.Tree;

public class ParentAxisIterator implements Iterator<Tree> {

	private static final Logger LOGGER = Logger.getLogger("xpath");

	private final Tree tree;
	private boolean seen = false;

	public ParentAxisIterator(Tree tree) {
		this.tree = tree;
	}

	@Override
	public boolean hasNext() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("ParentAxisIterator(" + tree + ").hasNext()");

		final boolean hasNext = !seen && tree.getParent() != null;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + hasNext);

		return hasNext;
	}

	@Override
	public Tree next() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("ParentAxisIterator(" + tree + ").next()");

		final Tree next = tree.getParent();
		seen = true;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + next);

		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
