package koopa.core.targets;

import koopa.core.data.Data;

/**
 * A {@linkplain Target} which just discards all the data it receives.
 */
public class NullTarget implements Target {

	@Override
	public void push(Data packet) {
	}

	@Override
	public void done() {
	}
}
