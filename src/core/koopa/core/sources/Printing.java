package koopa.core.sources;

import koopa.core.data.Data;

public class Printing<T extends Data> extends ChainingSource
		implements Source {

	private final String prefix;

	public Printing(Source source, String prefix) {
		super(source);
		this.prefix = prefix;
	}

	@Override
	protected Data nxt1() {
		final Data data = source.next();
		// TODO Configurable PrintStream.
		System.out.println(prefix + data);
		return data;
	}
}
