package koopa.core.targets;

import koopa.core.data.Data;

/**
 * A {@linkplain Target} which just discards all the data it receives.
 */
public class NullTarget implements Target {

	public void push(Data packet) {
	}

	public void done() {
	}
}
