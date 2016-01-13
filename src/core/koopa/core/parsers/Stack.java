package koopa.core.parsers;

import java.util.HashMap;
import java.util.Map;

import koopa.core.data.Token;
import koopa.core.grammars.combinators.Scoped;

public class Stack {

	private Frame head;

	public Stack() {
		head = new Frame(null, null);
		head.makeScoped();
	}

	public boolean isEmpty() {
		return head.parser == null;
	}

	public Frame getHead() {
		return head;
	}

	public Scope getScope() {
		return head.getScope();
	}

	public void push(ParserCombinator parser) {
		head = head.push(parser);
	}

	public ParserCombinator peek() {
		return head.parser;
	}

	public ParserCombinator pop() {
		ParserCombinator p = head.parser;
		head = head.pop();
		return p;
	}

	public boolean isKeyword(String word) {
		return head.isKeyword(word);
	}

	public boolean isMatching(String... ruleNames) {
		Frame f = head;

		for (int i = 0; i < ruleNames.length; i++) {
			String name = ruleNames[i];

			while (f.parser != null && !f.parser.isMatching(name))
				f = f.up;

			if (f.parser == null)
				return false;
		}

		return true;
	}

	public String toString() {
		if (isEmpty())
			return "___";

		StringBuilder b = new StringBuilder();
		Frame h = head;
		while (h.parser != null) {
			b.append(h.parser.toString());
			b.append(" < ");
			h = h.up;
		}

		b.append("___");
		return b.toString();
	}

	public class Frame {
		private final ParserCombinator parser;

		/** "Up" = towards the root of the stack. */
		private final Frame up;

		/** Each frame can establish an optional scope. */
		private Scope scope;

		public Frame(Frame up, ParserCombinator parser) {
			this.up = up;
			this.parser = parser;
			this.scope = null;
		}

		private Frame push(ParserCombinator p) {
			return new Frame(this, p);
		}

		public boolean isKeyword(String word) {
			if (parser == null)
				return false;
			else
				return parser.isKeyword(word, this);
		}

		public Frame pop() {
			if (up == null)
				return null;

			if (scope != null) {
				up.getScope().setRValue(scope.returnValue);
				scope = null;
			}

			return up;
		}

		public Frame up() {
			return up;
		}

		public void makeScoped() {
			if (this.scope == null)
				this.scope = new Scope();
		}

		public Scope getScope() {
			if (scope != null || up == null)
				return scope;
			else
				return up.getScope();
		}

		public String toTrace() {
			StringBuilder sb = new StringBuilder();

			Frame frame = this;
			do {
				if (frame.parser == null || !(frame.parser instanceof Scoped))
					continue;

				if (sb.length() > 0)
					sb.append(" < ");

				sb.append(((Scoped) frame.parser).getName());

			} while ((frame = frame.up()) != null);

			return sb.toString();
		}
	}

	/**
	 * This establishes a scope for variables defined in the grammar.
	 * <p>
	 * We also use it to resolve return values and "lvalues".
	 */
	public class Scope {
		private Map<String, Object> values = new HashMap<String, Object>();
		private Object returnValue = null;
		private String lvalue;

		public Object getValue(String name) {
			return values.get(name);
		}

		public void setReturnValue(Object returnValue) {
			this.returnValue = returnValue;
		}

		public void setLValue(String name) {
			this.lvalue = name;
		}

		public void setRValue(Object rvalue) {
			if (lvalue == null)
				return;

			values.put(lvalue, rvalue);
		}

		public void setValue(String name, Token value) {
			values.put(name, value);
		}
	}
}
