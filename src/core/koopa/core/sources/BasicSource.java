package koopa.core.sources;

import java.util.LinkedList;

import koopa.core.data.Data;

/**
 * Base for implementing a {@linkplain Source}. It takes care of the undo
 * behaviour, allowing subclasses to focus on the generation.
 */
public abstract class BasicSource implements Source {

	private final LinkedList<Data> unseen = new LinkedList<>();

	/**
	 * Returns the next piece of data, or <code>null</code> if there is no more.
	 * <p>
	 * <b>Subclasses should implement this.</b>
	 */
	// TODO -> better name
	protected abstract Data nxt1();

	@Override
	public Data next() {
		if (unseen.isEmpty())
			return nxt1();
		else
			return unseen.removeFirst();
	}

	@Override
	public void unshift(Data packet) {
		if (packet != null)
			this.unseen.addFirst(packet);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <S extends Source> S getSource(Class<S> clazz) {
		if (clazz.isAssignableFrom(this.getClass()))
			return (S) this;
		else
			return null;
	}
}
