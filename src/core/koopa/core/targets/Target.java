package koopa.core.targets;

import koopa.core.data.Data;

/**
 * This is the counterpart to {@linkplain Source}s. They provide a place for
 * data to go. During parsing we will basically be taking data from a source,
 * transforming it, and passing it to a target.
 */
public interface Target<T extends Data> {

	/**
	 * Add a data item to this target.
	 */
	void push(T data);

	// TODO Needed ? T pop();
}
