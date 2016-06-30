package koopa.core.targets;

import java.util.LinkedList;

import koopa.core.data.Data;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

public class Pipe<T extends Data> extends BasicSource<T> implements Target<T>, Source<T> {

	private LinkedList<T> tokens = null;

	public Pipe() {
		this.tokens = new LinkedList<T>();
	}

	public void push(T data) {
		synchronized (this.tokens) {
			this.tokens.add(data);
		}
	}

	@Override
	protected T nxt1() {
		synchronized (this.tokens) {
			if (this.tokens.isEmpty()) {
				return null;

			} else {
				T head = this.tokens.removeFirst();
				return head;
			}
		}
	}

	public void done() {
	}

	public void close() {
	}
}
