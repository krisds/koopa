package koopa.core.treegrammars;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This is basically a parsing equivalent to a call stack.
 */
public class ParsingContext {

	// The dictionary will have to get pushed and popped as we enter/leave
	// certain parsers. Otherwise, recursion will screw up the lexical scopes.
	final Stack<Frame> callStack = new Stack<Frame>();

	public ParsingContext() {
		callStack.push(new Frame(null));
	}

	private class Frame {
		private final String name;
		private final Map<String, Object> values;

		public Object returnValue = null;
		public String lvalue = null;

		public Frame(String name) {
			this.name = name;
			this.values = new HashMap<String, Object>();
		}

		public void set(String key, Object value) {
			if (key != null)
				values.put(key, value);
		}

		public Object get(String key) {
			return values.get(key);
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public void enter(String name) {
		callStack.push(new Frame(name));
	}

	public void leave(String name) {
		Frame callee = callStack.pop();
		assert (callee.name == name);

		Frame caller = callStack.peek();
		caller.set(caller.lvalue, callee.returnValue);
	}

	public void assignLValue(Object value) {
		Frame frame = callStack.peek();
		frame.set(frame.lvalue, value);
	}

	public void setLValueReceiver(String name) {
		Frame frame = callStack.peek();
		frame.lvalue = name;
	}

	public void setReturnValueFrom(String name) {
		Frame frame = callStack.peek();
		frame.returnValue = frame.get(name);
	}

	public void setReturnValue(Object value) {
		Frame frame = callStack.peek();
		frame.returnValue = value;
	}

	public Object get(String name) {
		return callStack.peek().get(name);
	}

	public void set(String key, Object value) {
		callStack.peek().set(key, value);
	}

	public int getDepth() {
		return callStack.size();
	}
}
