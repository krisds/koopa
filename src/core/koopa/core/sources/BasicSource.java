package koopa.core.sources;

import java.util.LinkedList;

import koopa.core.data.Data;

/**
 * Base for implementing a {@linkplain Source}. It takes care of the undo
 * behaviour, allowing subclasses to focus on the generation.
 */
public abstract class BasicSource<T extends Data> implements Source<T> {

	private final LinkedList<T> unseen = new LinkedList<T>();

	/**
	 * Returns the next piece of data, or <code>null</code> if there is no more.
	 * <p>
	 * <b>Subclasses should implement this.</b>
	 */
	// TODO -> better name
	protected abstract T nxt1();

	public T next() {
		if (unseen.isEmpty())
			return nxt1();
		else
			return unseen.removeFirst();
	}

	public void unshift(T packet) {
		if (packet != null)
			this.unseen.addFirst(packet);
	}
}
