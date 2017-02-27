package koopa.core.sources;

import koopa.core.data.Data;
import koopa.core.targets.Target;

/**
 * This is the counterpart to {@linkplain Target}s. They provide a place where
 * {@linkplain Data} comes from. During parsing we will basically be taking data
 * from a {@linkplain Source}, transforming it, and passing it to a
 * {@linkplain Target}.
 */
public interface Source {

	/**
	 * Get the next data item. Or <code>null</code> if there are no more.
	 */
	// TODO -> shift ?
	Data next();

	/**
	 * Return a piece of data to this source, so that it becomes available again
	 * to be read. This is basically an "undo" option for {@linkplain #next()}.
	 */
	// TODO Deprecate this ? Can we get rid of it ?
	void unshift(Data packet);

	/**
	 * Close this source, giving it a chance to clean up any resources. Any
	 * further requests from {@linkplain #next()} should return
	 * <code>null</code>.
	 */
	void close();

	/**
	 * If this is a source of a matching class type, return <code>this</code>.
	 * If not, look for it upstream.
	 */
	<S extends Source> S getSource(Class<S> clazz);
}
