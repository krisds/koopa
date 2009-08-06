package koopa.tokenizers.util;


import java.util.LinkedList;
import java.util.List;

import koopa.tokens.Token;

public class SynchronizedTokenQueue {
	private List<Token> queue = null;
	private boolean active = true;

	public SynchronizedTokenQueue() {
		this.queue = new LinkedList<Token>();
		this.active = true;
	}

	public synchronized void inactivate() {
		active = false;
		notifyAll();
	}

	public synchronized void enqueue(Token token) {
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

		if (!queue.isEmpty())
			return queue.remove(0);
		else
			return null;
	}

	public int size() {
		return queue.size();
	}
}
