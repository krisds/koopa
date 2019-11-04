package koopa.core.sources;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;

/**
 * This is a {@linkplain Source} which is backed by a {@linkplain List}.
 */
public class ListSource implements Source {

	private LinkedList<Data> data = new LinkedList<>();

	public ListSource() {
	}

	public ListSource(List<Data> data) {
		this.data.addAll(data);
	}

	/**
	 * Convenience constructor when the list has but a single element.
	 */
	public ListSource(Data d) {
		this.data.add(d);
	}

	@Override
	public Data next() {
		if (data.isEmpty())
			return null;
		else
			return data.removeFirst();
	}

	@Override
	public void unshift(Data d) {
		if (d != null)
			data.addFirst(d);
	}

	@Override
	public void close() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public <S extends Source> S getSource(Class<S> clazz) {
		if (clazz.isInstance(this))
			return (S) this;
		else
			return null;
	}

	public boolean addAll(List<Data> c) {
		return data.addAll(c);
	}

	public void clear() {
		data.clear();
	}
}
