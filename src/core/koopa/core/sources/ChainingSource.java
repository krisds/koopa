package koopa.core.sources;

/**
 * Base for implementing a {@linkplain Source} which builds on the output of
 * another.
 */
public abstract class ChainingSource extends BasicSource implements Source {

	protected Source source;

	public ChainingSource(Source source) {
		this.source = source;
	}

	public void setSource(Source source) {
		if (this.source != null)
			throw new IllegalStateException("Can not change source once it has been set.");

		this.source = source;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <S extends Source> S getSource(Class<S> clazz) {
		if (clazz.isAssignableFrom(this.getClass()))
			return (S) this;
		else if (source != null)
			return source.getSource(clazz);
		else
			return null;
	}

	@Override
	public void close() {
		source.close();
	}
}
