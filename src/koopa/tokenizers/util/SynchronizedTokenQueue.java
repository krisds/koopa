package koopa.tokenizers.util;

import java.util.LinkedList;
import java.util.List;

import koopa.tokens.Token;

public class SynchronizedTokenQueue {
	private final String name;
	private List<Token> queue = null;
	private boolean active = true;

	public SynchronizedTokenQueue() {
		this("");
	}

	public SynchronizedTokenQueue(String name) {
		this.name = name;
		this.queue = new LinkedList<Token>();
		this.active = true;
	}

	public synchronized void inactivate() {
		// System.out.println(name + " inactivating with " + queue.size() +
		// " left");
		active = false;
		notifyAll();
	}

	public synchronized void enqueue(Token token) {
		// System.out.println(name + " << " + token);
		queue.add(token);
		if (active) {
			notifyAll();
		}
	}

	public synchronized Token nextToken() {
		while (active && queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (!queue.isEmpty()) {
			final Token next = queue.remove(0);
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
		return "Synchronized Token Queue '" + name + "'";
	}
}
