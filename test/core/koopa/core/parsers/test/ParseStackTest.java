package koopa.core.parsers.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import koopa.core.parsers.ParseStack;
import koopa.core.parsers.ParseStream;
import koopa.core.parsers.Parser;

import org.junit.Test;

public class ParseStackTest {

	private static final class Named extends Parser {
		private final String name;

		public Named(String name) {
			this.name = name;
		}

		public boolean matches(ParseStream stream) {
			return false;
		}

		public boolean isMatching(String name) {
			return this.name.equals(name);
		}
	}

	private static final Parser X = new Named("X");
	private static final Parser Y = new Named("Y");
	private static final Parser Z = new Named("Z");

	@Test
	public void testBasicStackOperations() {
		ParseStack stack = new ParseStack();

		assertTrue(stack.isEmpty());
		assertNull(stack.peek());

		stack.push(X);

		assertFalse(stack.isEmpty());
		assertSame(X, stack.peek());

		assertSame(X, stack.pop());

		assertTrue(stack.isEmpty());
		assertNull(stack.peek());
	}

	@Test
	public void testIsMatching() {
		ParseStack stack = new ParseStack();

		stack.push(X);
		assertTrue(stack.isMatching("X"));

		stack.push(Y);
		assertTrue(stack.isMatching("X"));
		assertTrue(stack.isMatching("Y"));
		assertTrue(stack.isMatching("Y", "X"));
		assertFalse(stack.isMatching("X", "Y"));

		stack.push(Z);
		assertTrue(stack.isMatching("X"));
		assertTrue(stack.isMatching("Y"));
		assertTrue(stack.isMatching("Z"));
		assertTrue(stack.isMatching("Z", "Y", "X"));
		assertTrue(stack.isMatching("Z", "Y"));
		assertTrue(stack.isMatching("Y", "X"));
		assertTrue(stack.isMatching("Z", "X"));

		assertFalse(stack.isMatching("X", "Y"));
		assertFalse(stack.isMatching("X", "Z"));
		assertFalse(stack.isMatching("Y", "Z"));
	}
}
