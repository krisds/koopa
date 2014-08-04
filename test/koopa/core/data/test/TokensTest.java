package koopa.core.data.test;

import junit.framework.TestCase;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.Tokens;

import org.junit.Test;

/**
 * Tests the different operations in {@linkplain Tokens}.
 */
public class TokensTest extends TestCase {

	@Test
	public void testCanCreateAToken() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop);

		assertEquals(text.length(), t.getLength());
	}

	@Test
	public void testCanHasSubtokenToEnd() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop);

		final int from = "One accurate measurement ".length();
		Token sub = Tokens.subtoken(t, from);
		assertEquals(text.length() - from, sub.getLength());
		assertEquals("is worth a thousand expert opinions.", sub.getText());
	}

	@Test
	public void testFullSubtokenEqualsOriginal() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop);

		Token sub = Tokens.subtoken(t, 0);
		assertEquals(t, sub);
	}

	@Test
	public void testCanHasSubtoken() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop);

		final int from = "One accurate measurement ".length();
		final int to = from + "is worth".length();
		Token sub = Tokens.subtoken(t, from, to);
		assertEquals(to - from, sub.getLength());
		assertEquals("is worth", sub.getText());
	}

	@Test
	public void testSubtokensInheritTags() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new Token(text, start, stop, "Quote", "Grace Hopper");

		Token sub = Tokens.subtoken(t, 1);
		assertEquals(t.getTags(), sub.getTags());
	}
}
