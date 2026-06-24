package koopa.core.trees.jaxen;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import koopa.core.trees.Tree;

public class ChildAxisIterator implements Iterator<Tree> {

	private static final Logger LOGGER = LogManager.getLogger("xpath");

	private final Tree parent;
	private final int count;
	private int index = 0;

	public ChildAxisIterator(Tree parent) {
		this.parent = parent;
		this.count = (parent != null) ? parent.getChildCount() : -1;
	}

	@Override
	public boolean hasNext() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("ChildAxisIterator(" + parent + ").hasNext()");

		final boolean hasNext = this.index < this.count;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + hasNext);

		return hasNext;
	}

	@Override
	public Tree next() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("ChildAxisIterator(" + parent + ").next()");

		if (!hasNext())
			throw new NoSuchElementException("Called next on an iterator with no more elements");

		final Tree next = this.parent.getChild(this.index++);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + next);

		return next;
	}

}
