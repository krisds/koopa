package koopa.core.sources;

import koopa.core.data.Data;

// TODO Apply to more sources ?
public abstract class ChainableSource<T extends Data> extends BasicSource<T>
		implements Source<T> {

	protected Source<T> source = null;

	public void setSource(Source<T> source) {
		this.source = source;
	}

	public void close() {
		if (this.source != null)
			this.source.close();
	}
}
