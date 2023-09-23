package koopa.core.parsers;

import java.io.PrintStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import koopa.core.grammars.Grammar;
import koopa.core.grammars.combinators.Scoped;

public class Stack {

	private Frame head;

	public Stack() {
		head = new Frame(null, null);
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

	public Scoped getScope() {
		Frame h = head;
		while (h.parser != null)
			if (h.parser instanceof Scoped)
				return (Scoped) h.parser;
			else
				h = h.up;
		
		return null;
	}
	
	/**
	 * Whether or not this stack can say that the given word is a keyword.
	 * <p>
	 * We assume that the given word has been passed through
	 * {@linkplain Grammar#comparableText(String)} already.
	 */
	public boolean isKeyword(String word) {
		Frame f = head;

		while (f != null) {
			ParserCombinator p = f.parser;

			if (p == null)
				return false;

			while (true) {
				if (!p.allowsKeywords())
					return false;

				if (p.isKeywordInScope(word))
					return true;

				if (p instanceof FutureParser)
					p = ((FutureParser) p).parser;
				else
					break;
			}

			f = f.up();
		}

		return false;
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

	@Override
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

		public Frame(Frame up, ParserCombinator parser) {
			this.up = up;
			this.parser = parser;
		}

		private Frame push(ParserCombinator p) {
			return new Frame(this, p);
		}

		public Frame pop() {
			return up;
		}

		public Frame up() {
			return up;
		}

		public ParserCombinator getParser() {
			return parser;
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

			Set<String> keywords = new HashSet<>();
			parser.addAllKeywordsInScopeTo(keywords, new HashSet<>());
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

		public int depth() {
			if (up == null)
				return 0;
			else
				return 1 + up.depth();
		}

		public Frame getFrameUpBy(int offset) {
			if (offset == 0)
				return this;
			else
				return up.getFrameUpBy(offset - 1);
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
