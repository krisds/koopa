package koopa.core.util;

import java.util.Enumeration;
import java.util.Iterator;

public class Iterables {

	public static <T> Iterable<T> forEnumeration(
			final Enumeration<T> enumeration) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return Iterators.forEnumeration(enumeration);
			}
		};
	}
}
