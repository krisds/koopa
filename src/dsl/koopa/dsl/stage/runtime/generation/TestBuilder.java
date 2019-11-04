package koopa.dsl.stage.runtime.generation;

import java.util.Stack;

public abstract class TestBuilder {

	private Stack<String> stack = new Stack<>();

	public void push(String fragment) {
		stack.push(fragment);
	}

	public void pop() {
		stack.pop();
	}

	public void commit() {
		StringBuilder builder = new StringBuilder();

		for (String fragment : stack)
			builder.append(fragment);

		ready(builder.toString());
	}

	protected abstract void ready(String text);
}
