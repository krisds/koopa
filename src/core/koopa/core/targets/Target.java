package koopa.core.targets;

import koopa.core.data.Data;
import koopa.core.sources.Source;

/**
 * This is the counterpart to {@linkplain Source}s. They provide a place for
 * {@linkplain Data} to go. During parsing we will basically be taking data from
 * a {@linkplain Source}, transforming it, and passing it to a
 * {@linkplain Target}.
 */
public interface Target<T extends Data> {

	/**
	 * Add a data item to this target.
	 */
	void push(T data);

	/**
	 * Lets us know the parse is done.
	 */
	void done();
}
