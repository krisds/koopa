package koopa.core.sources;

import koopa.core.data.Data;

/**
 * Base for implementing a {@linkplain Source} which builds on the output of
 * another.
 */
public abstract class ChainingSource<U extends Data, T extends Data> extends BasicSource<T> implements Source<T> {

	protected Source<U> source;

	public ChainingSource(Source<U> source) {
		this.source = source;
	}

	public void setSource(Source<U> source) {
		if (this.source != null)
			throw new IllegalStateException("Can not change source once it has been set.");

		this.source = source;
	}

	@SuppressWarnings("unchecked")
	public <S extends Source<? extends Data>> S getSource(Class<S> clazz) {
		if (clazz.isAssignableFrom(this.getClass()))
			return (S) this;
		else if (source != null)
			return source.getSource(clazz);
		else
			return null;
	}

	public void close() {
		source.close();
	}
}
