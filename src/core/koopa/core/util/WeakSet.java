package koopa.core.util;

import java.util.WeakHashMap;

/**
 * Because the standard Java library doesn't have this. This is the (minimal)
 * Set equivalent of {@linkplain WeakHashMap}. Heck, it is just a
 * {@linkplain WeakHashMap} with a reduced interface.
 */
public class WeakSet<T> {

	private final WeakHashMap<T, WeakSet<T>> memoized = new WeakHashMap<>();

	public boolean has(T token) {
		return memoized.containsKey(token);
	}

	public void put(T token) {
		memoized.put(token, this);
	}
}
