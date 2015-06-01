package koopa.core.sources;

import koopa.core.data.Data;

public class NullSource<T extends Data> extends BasicSource<T> implements
		Source<T> {

	@Override
	protected T nxt1() {
		return null;
	}

	public void close() {
	}
}
