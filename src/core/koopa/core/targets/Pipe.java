package koopa.core.targets;

import java.util.LinkedList;

import koopa.core.data.Data;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

// TODO Synchronization primitives still needed ? (No more threading sources.)
public class Pipe extends BasicSource implements Target, Source {

	private LinkedList<Data> tokens = null;

	public Pipe() {
		this.tokens = new LinkedList<>();
	}

	@Override
	public void push(Data data) {
		synchronized (tokens) {
			tokens.add(data);
		}
	}

	@Override
	protected Data nxt1() {
		synchronized (tokens) {
			if (tokens.isEmpty()) 
				return null;
			else 
				return tokens.removeFirst();
		}
	}

	@Override
	public void done() {
	}

	@Override
	public void close() {
	}
}
