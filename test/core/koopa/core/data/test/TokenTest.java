package koopa.core.data.test;

import static koopa.core.util.test.Util.asListOfRanges;

import org.junit.Test;

import junit.framework.TestCase;
import koopa.core.data.Position;
import koopa.core.data.Replaced;
import koopa.core.data.Token;

/**
 * Tests basic {@linkplain Token} functionality.
 */
public class TokenTest extends TestCase {

	private static final String TEXT = "One accurate measurement is worth a thousand expert opinions.";
	private static final int LENGTH = TEXT.length();
	private static final Position START = new Position(0, 0, 0);
	private static final Position STOP = START.offsetBy(LENGTH - 1);

	@Test
	public void testCanCreateAToken() {
		final Token t = new Token(TEXT, START, STOP);

		assertEquals(LENGTH, t.getLength());
	}

	@Test
	public void testCanAddTags() {
		final Token t = new Token(TEXT, START, STOP, "Quote", "Grace Hopper");

		final Token mod = t.withTags("Cobol");

		assertTrue(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
		assertTrue(mod.hasTag("Cobol"));

		assertEquals(asListOfRanges(0, LENGTH - 1), t.getRanges());
		assertEquals(TEXT.length(), t.getRanges().get(0).getLength());
	}

	@Test
	public void testCanRemoveTags() {
		final Token t = new Token(TEXT, START, STOP, "Quote", "Grace Hopper");

		final Token mod = t.withoutTags("Quote");

		assertFalse(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));

		assertEquals(asListOfRanges(0, LENGTH - 1), t.getRanges());
		assertEquals(TEXT.length(), t.getRanges().get(0).getLength());
	}

	@Test
	public void testCanAddAndRemoveTags() {
		final Token t = new Token(TEXT, START, STOP, "Quote", "Grace Hopper");

		final Token mod = t.replacingTag("Quote", "Cobol");

		assertFalse(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
		assertTrue(mod.hasTag("Cobol"));

		assertEquals(asListOfRanges(0, LENGTH - 1), t.getRanges());
		assertEquals(TEXT.length(), t.getRanges().get(0).getLength());
	}

	@Test
	public void testNotReallyChangingATokenReturnsItself() {
		final Token t = new Token(TEXT, START, STOP, "Quote", "Grace Hopper");

		assertSame(t, t.withTags());
		assertSame(t, t.withoutTags());
	}

	@Test
	public void canBeReplacingAToken() {
		Replaced r = new Replaced(START, STOP, null);

		final String text = "It is often easier to ask for forgiveness " //
				+ "than to ask for permission.";
		final Position start = Position.ZERO;
		final Position end = start.offsetBy(text.length());
		final Token t = new Token(text, start, end);

		assertNull(t.getReplaced());
		assertSame(t, t.asReplacing(null));

		final Token s = t.asReplacing(r);

		assertEquals(text, s.getText());
		assertEquals(start, s.getStart());
		assertEquals(end, s.getEnd());
		assertSame(r, s.getReplaced());
	}
}
