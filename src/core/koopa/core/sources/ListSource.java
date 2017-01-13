package koopa.core.sources;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;

/**
 * This is a {@linkplain Source} which is backed by a {@linkplain List}.
 */
public class ListSource<T extends Data> implements Source<T> {

	private LinkedList<T> data = new LinkedList<T>();

	public ListSource(List<T> data) {
		this.data.addAll(data);
	}

	/**
	 * Convenience constructor when the list has but a single element.
	 */
	public ListSource(T d) {
		this.data.add(d);
	}

	public T next() {
		if (data.isEmpty())
			return null;
		else
			return data.removeFirst();
	}

	public void unshift(T d) {
		if (d != null)
			data.addFirst(d);
	}

	public void close() {
	}

	@SuppressWarnings("unchecked")
	public <S extends Source<? extends Data>> S getSource(Class<S> clazz) {
		if (clazz.isInstance(this))
			return (S) this;
		else
			return null;
	}
}
