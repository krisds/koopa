package koopa.core.data.test;

import junit.framework.TestCase;
import koopa.core.data.Position;
import koopa.core.data.Token;

import org.junit.Test;

/**
 * Tests basic {@linkplain Token} functionality.
 */
public class TokenTest extends TestCase {

	@Test
	public void testCanAddTags() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop, "Quote", "Grace Hopper");

		final Token mod = t.withTags("Cobol");

		assertTrue(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
		assertTrue(mod.hasTag("Cobol"));
	}

	@Test
	public void testCanRemoveTags() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop, "Quote", "Grace Hopper");

		final Token mod = t.withoutTags("Quote");

		assertFalse(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
	}

	@Test
	public void testCanAddAndRemoveTags() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop, "Quote", "Grace Hopper");

		final Token mod = t.replacingTag("Quote", "Cobol");

		assertFalse(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
		assertTrue(mod.hasTag("Cobol"));
	}

	@Test
	public void testNotReallyChangingATokenReturnsItself() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop, "Quote", "Grace Hopper");

		assertSame(t, t.withTags());
		// assertSame(t, t.withTags("Quote"));

		assertSame(t, t.withoutTags());
		// assertSame(t, t.withoutTags("Murray"));
	}
}
