package koopa.tokens.test;

import junit.framework.TestCase;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;
import koopa.tokens.Tokens;

import org.junit.Test;

public class TokensTest extends TestCase {

	@Test
	public void testCanCreateABasicToken() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new BasicToken(text, start, stop);

		assertEquals(text.length(), t.getLength());
	}

	@Test
	public void testCanHasSubtokenToEnd() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new BasicToken(text, start, stop);

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
		final Token t = new BasicToken(text, start, stop);

		Token sub = Tokens.subtoken(t, 0);
		assertEquals(t, sub);
	}

	@Test
	public void testCanHasSubtoken() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new BasicToken(text, start, stop);

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
		final Token t = new BasicToken(text, start, stop);

		t.addTag("Quote");
		t.addTag("Grace Hopper");

		Token sub = Tokens.subtoken(t, 1);
		assertEquals(t.getTags(), sub.getTags());
	}
}
