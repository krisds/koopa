package koopa.core.targets;

import koopa.core.data.Data;

/**
 * A {@linkplain Target} which just discards all the data it receives.
 */
public class NullTarget<T extends Data> implements Target<T> {

	public void push(T packet) {
	}
}
