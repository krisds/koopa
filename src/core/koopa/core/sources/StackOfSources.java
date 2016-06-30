package koopa.core.sources;

import java.util.Stack;

import koopa.core.data.Data;

/**
 * This can handle a stack of {@linkplain Source}s to act as one. Whenever a
 * source gets depleted it will get popped of the stack, and the next one in
 * line will be used.
 */
public class StackOfSources<T extends Data, S extends Source<T>> extends BasicSource<T> implements Source<T> {

	private Stack<S> sources = new Stack<S>();

	@Override
	protected T nxt1() {
		while (!sources.isEmpty()) {
			final T data = sources.peek().next();

			if (data != null)
				return data;

			sources.peek().close();
			sources.pop();
		}

		return null;
	}

	public void push(S source) {
		sources.push(source);
	}

	public void pop() {
		assert (!sources.isEmpty());
		sources.pop();
	}

	public S peek() {
		return sources.peek();
	}

	public boolean isEmpty() {
		return sources.isEmpty();
	}

	public void close() {
		while (!sources.isEmpty()) {
			sources.peek().close();
			sources.pop();
		}
	}

	public <U extends Source<? extends Data>> U getSource(Class<U> clazz) {
		// TODO Should reverse order ?
		for (S source : sources) {
			U instance = source.getSource(clazz);
			if (instance != null)
				return instance;
		}

		return null;
	}
}
