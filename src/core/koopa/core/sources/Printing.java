package koopa.core.sources;

import koopa.core.data.Data;

public class Printing<T extends Data> extends ChainingSource<T, T>
		implements Source<T> {

	private final String prefix;

	public Printing(Source<T> source, String prefix) {
		super(source);
		this.prefix = prefix;
	}

	@Override
	protected T nxt1() {
		T token = source.next();
		System.out.println(prefix + token);
		return token;
	}
}
