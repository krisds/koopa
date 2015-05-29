package koopa.core.parsers;

public class ParseStack {

	private Frame head;

	public ParseStack() {
		head = new Frame();
	}

	public boolean isEmpty() {
		return head.parser == null;
	}

	public void push(Parser parser) {
		head = head.push(parser);
	}

	public Parser peek() {
		return head.parser;
	}

	public Parser pop() {
		Parser p = head.parser;
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
		private Parser parser = null;

		/** "Up" = towards the root of the stack. */
		private Frame up = null;

		/** "Down" = away from the root of the stack. */
		private Frame down = null;

		private Frame push(Parser p) {
			// We try to reuse existing frames before creating new ones.
			if (down == null) {
				down = new Frame();
				down.up = this;
			}

			down.parser = p;
			return down;
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

			parser = null;
			return up;
		}

		public Frame up() {
			return up;
		}
	}
}
