package koopa.tokens.test;

import junit.framework.TestCase;
import koopa.tokens.BasicToken;
import koopa.tokens.ModifiedToken;
import koopa.tokens.Position;
import koopa.tokens.Token;

import org.junit.Test;

public class ModifiedTokenTest extends TestCase {

	@Test
	public void testCanAddTags() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new BasicToken(text, start, stop);

		t.addTag("Quote");
		t.addTag("Grace Hopper");

		final Token mod = new ModifiedToken(t);
		mod.addTag("Cobol");

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
		final Token t = new BasicToken(text, start, stop);

		t.addTag("Quote");
		t.addTag("Grace Hopper");

		final Token mod = new ModifiedToken(t);
		mod.removeTag("Quote");

		assertFalse(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
	}

	@Test
	public void testCanAddAndRemoveTags() {
		final String text = "One accurate measurement is worth a thousand expert opinions.";
		final int length = text.length();

		final Position start = new Position(0, 0, 0);
		final Position stop = start.offsetBy(length);
		final Token t = new BasicToken(text, start, stop);

		t.addTag("Quote");
		t.addTag("Grace Hopper");

		final Token mod = new ModifiedToken(t);
		mod.removeTag("Quote");
		mod.addTag("Cobol");

		assertFalse(mod.hasTag("Quote"));
		assertTrue(mod.hasTag("Grace Hopper"));
		assertTrue(mod.hasTag("Cobol"));
	}
}
