package koopa.core.sources;

import koopa.core.data.Data;

/**
 * A source of {@linkplain Data}.
 */
public interface Source<T extends Data> {

	/**
	 * Get the next data item. Or <code>null</code> if there are no more.
	 */
	// TODO -> shift
	T next();

	/**
	 * Return a piece of data to this source, so that it becomes available again
	 * to be read. This is basically an "undo" option for {@linkplain #next()}.
	 */
	// TODO unshift ?
	// TODO Do we actually make use of this somewhere ?
	void unshift(T packet);

	/**
	 * Close this source, giving it a chance to clean up any resources. Any
	 * further requests from {@linkplain #next()} should return
	 * <code>null</code>.
	 */
	void close();
}
