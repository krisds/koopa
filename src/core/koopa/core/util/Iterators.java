package koopa.core.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import koopa.core.data.Data;

public class Iterators {

	/**
	 * Equivalent to Collections.emptyIterator() in later versions of Java.
	 */
	public static Iterator<Data> emptyIterator() {
		return new Iterator<Data>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Data next() {
				throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				throw new IllegalStateException();
			}
		};
	}

	/**
	 * Equivalent (I hope) to LinkedList.descendingIterator() in later versions
	 * of Java.
	 */
	public static <T> Iterator<T> descendingIterator(final LinkedList<T> list) {
		return new Iterator<T>() {
			private int i = list.size() - 1;
			private boolean removed = false;

			@Override
			public boolean hasNext() {
				return i >= 0;
			}

			@Override
			public T next() {
				removed = false;
				return list.get(i--);
			}

			@Override
			public void remove() {
				if (removed || i + 1 >= list.size())
					throw new IllegalStateException();

				list.remove(i + 1);
				removed = true;
			}
		};
	}

	/**
	 * Equivalent (I hope) to LinkedList.listIterator(int index) in later
	 * versions of Java.
	 */
	public static <T> Iterator<T> listIterator(final LinkedList<T> list,
			final int index) {
		return new Iterator<T>() {
			private int i = index;

			@Override
			public boolean hasNext() {
				return i < list.size();
			}

			@Override
			public T next() {
				return list.get(i++);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static <T> Iterator<T> forEnumeration(
			final Enumeration<T> enumeration) {
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return enumeration.hasMoreElements();
			}

			@Override
			public T next() {
				return enumeration.nextElement();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
