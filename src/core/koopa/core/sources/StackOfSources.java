package koopa.core.sources;

import java.util.Stack;

import koopa.core.data.Data;

/**
 * This can handle a stack of {@linkplain Source}s to act as one. Whenever a
 * source gets depleted it will get popped of the stack, and the next one in
 * line will be used.
 */
public class StackOfSources extends BasicSource implements Source {

	private Stack<Source> sources = new Stack<>();

	@Override
	protected Data nxt1() {
		while (!sources.isEmpty()) {
			final Data d = sources.peek().next();

			if (d != null)
				return d;

			sources.peek().close();
			sources.pop();
		}

		return null;
	}

	public void push(Source source) {
		sources.push(source);
	}

	public void pop() {
		assert (!sources.isEmpty());
		sources.pop();
	}

	public Source peek() {
		return sources.peek();
	}

	public boolean isEmpty() {
		return sources.isEmpty();
	}

	@Override
	public void close() {
		while (!sources.isEmpty()) {
			sources.peek().close();
			sources.pop();
		}
	}

	@Override
	public <S extends Source> S getSource(Class<S> clazz) {
		// TODO Should reverse order ?
		for (Source source : sources) {
			S instance = source.getSource(clazz);
			if (instance != null)
				return instance;
		}

		return null;
	}
}
