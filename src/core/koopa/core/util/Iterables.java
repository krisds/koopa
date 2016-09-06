package koopa.core.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterables {

	/**
	 * Turns an {@linkplain Enumeration} into an {@linkplain Iterable}.
	 */
	public static <T> Iterable<T> forEnumeration(
			final Enumeration<T> enumeration) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return Iterators.forEnumeration(enumeration);
			}
		};
	}

	/**
	 * Collects all elements returned by an {@linkplain Iterable} into a
	 * {@linkplain List}.
	 */
	public static <T> List<T> collect(Iterable<T> iterable) {
		final List<T> list = new LinkedList<T>();

		for (T t : iterable)
			list.add(t);

		return list;
	}
}
