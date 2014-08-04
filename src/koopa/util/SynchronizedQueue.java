package koopa.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Pretty much as advertised, this is a synchronised queue. Requesting the next
 * item from it may block until an item becomes available, or until it gets
 * closed explicitly.
 */
public class SynchronizedQueue<T> {
	private final String name;
	private List<T> queue = null;
	private boolean active = true;

	public SynchronizedQueue() {
		this("");
	}

	public SynchronizedQueue(String name) {
		this.name = name;
		this.queue = new LinkedList<T>();
		this.active = true;
	}

	/**
	 * Add an item to the queue, and unblock all threads waiting on more data.
	 */
	public synchronized void enqueue(T item) {
		assert (active);

		// System.out.println(name + " << " + item);
		queue.add(item);

		if (active)
			notifyAll();
	}

	/**
	 * Close the queue, which basically says that there will no more incoming
	 * items. Any further requests for data which would otherwise block will now
	 * just receive <code>null</code>s.
	 */
	public synchronized void close() {
		// System.out.println(name + " closing queue with " + queue.size() +
		// " left");
		active = false;
		notifyAll();
	}

	/**
	 * Returns the next item in the queue. If no items are available yet the
	 * caller thread will get blocked until more data arrives or the queue gets
	 * closed.
	 */
	public synchronized T next() {
		while (active && queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (!queue.isEmpty()) {
			final T next = queue.remove(0);
			// System.out.println(name + " >> " + next);
			return next;

		} else {
			// System.out.println(name + " >> null");
			return null;
		}
	}

	public synchronized int size() {
		return queue.size();
	}

	public String toString() {
		return "Synchronized Queue '" + name + "'";
	}
}
