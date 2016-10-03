package koopa.core.parsers;

import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
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

	public void setHead(Frame head) {
		this.head = head;
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

	/**
	 * Whether or not this stack can say that the given word is a keyword.
	 * <p>
	 * We assume that the given word has been passed through
	 * {@linkplain Grammar#comparableText(String)} already.
	 * <p>
	 * By default this forwards the question to the {@link #head} frame. (via
	 * {@linkplain Frame#isKeyword(String)}).
	 */
	public boolean isKeyword(String word) {
		return head.isKeyword(word);
	}

	/**
	 * Whether or not this stack is matching the given rules in the given order.
	 * Earlier rules names should appear closer to the head of the stack.
	 */
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

	/**
	 * Walk the {@link #up()} chain of {@linkplain Frame}s, starting at the
	 * {@link #head}, to find the first one which has a {@link #parser} of the
	 * given type.
	 */
	public Frame find(Class<?> clazz) {
		return head.find(clazz);
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

		/**
		 * Whether or not this frame can say that the given word is a keyword.
		 * <p>
		 * We assume that the given word has been passed through
		 * {@linkplain Grammar#comparableText(String)} already.
		 * <p>
		 * By default this forwards the question to the parser linked to this
		 * frame (via {@linkplain ParserCombinator#isKeyword(String, Frame)}).
		 */
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

		public ParserCombinator getParser() {
			return parser;
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

		@Override
		public String toString() {
			if (parser == null)
				return "<base>";
			else
				return parser.toString();
		}

		private Set<String> getAllKeywords() {
			if (parser == null)
				return Collections.emptySet();

			Set<String> keywords = new HashSet<String>();
			parser.addAllKeywordsInScopeTo(keywords);
			return keywords;
		}

		/**
		 * Walk the {@link #up()} chain of {@linkplain Frame}s to find the first
		 * one which has a {@link #parser} of the given type.
		 */
		public Frame find(Class<?> clazz) {
			Frame next = this;

			while (next != null) {
				if (next.parser != null && clazz.isInstance(next.parser))
					return next;

				next = next.up();
			}

			return null;
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

	/**
	 * This is just a debugging utility for printing the current frames in the
	 * stack and their associated keywords.
	 */
	public void traceKeywords(PrintStream out) {
		Frame f = head;
		while (f != null) {
			Set<String> keywords = f.getAllKeywords();
			if (f == head)
				out.println(f + " -- " + keywords);
			else
				out.println("at " + f + " -- " + keywords);
			f = f.up();
		}
	}
}
