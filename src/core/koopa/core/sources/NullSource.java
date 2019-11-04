package koopa.core.sources;

import koopa.core.data.Data;

public class NullSource extends BasicSource implements Source {

	@Override
	protected Data nxt1() {
		return null;
	}

	@Override
	public void close() {
	}
}
