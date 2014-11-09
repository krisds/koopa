package koopa.core.data.test;

import static koopa.core.util.test.Util.asListOfRanges;
import junit.framework.TestCase;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.Tokens;

import org.junit.Test;

/**
 * Tests the different operations in {@linkplain Tokens}.
 */
public class TokensTest extends TestCase {

	private static final String TEXT = "One accurate measurement is worth a thousand expert opinions.";
	private static final int LENGTH = TEXT.length();

	private static final Position START = new Position(0, 0, 0);
	private static final Position STOP = START.offsetBy(LENGTH - 1);

	@Test
	public void testFullSubtokenIsSameAsOriginal() {
		final Token t = new Token(TEXT, START, STOP);

		Token sub = Tokens.subtoken(t, 0, LENGTH);
		assertSame(t, sub);
	}

	@Test
	public void testFullSubtokenToEndIsSameAsOriginal() {
		final Token t = new Token(TEXT, START, STOP);

		Token sub = Tokens.subtoken(t, 0);
		assertSame(t, sub);
	}

	@Test
	public void testCanHasSubtokenToEnd() {
		final Token t = new Token(TEXT, START, STOP);

		final int from = LENGTH / 4;
		Token sub = Tokens.subtoken(t, from);

		assertEquals(TEXT.substring(from), sub.getText());
		assertEquals(LENGTH - from, sub.getLength());

		assertEquals(asListOfRanges(from, LENGTH - 1), sub.getRanges());
	}

	@Test
	public void testCanHasSubtoken() {
		final Token t = new Token(TEXT, START, STOP);

		final int from = LENGTH / 4;
		final int to = from + LENGTH / 2;

		Token sub = Tokens.subtoken(t, from, to);

		assertEquals(TEXT.substring(from, to), sub.getText());
		assertEquals(to - from, sub.getLength());

		assertEquals(asListOfRanges(from, to - 1), sub.getRanges());
	}

	@Test
	public void testSubtokensInheritTags() {
		final Token t = new Token(TEXT, START, STOP, "Quote", "Grace Hopper");

		Token sub = Tokens.subtoken(t, LENGTH / 2);
		assertEquals(t.getTags(), sub.getTags());
	}

	@Test
	public void testSubtokenToEndSplitsRanges1() {
		final int mid = LENGTH / 2;
		final Token t = new Token(TEXT, asListOfRanges(0, mid - 1, mid,
				LENGTH - 1));

		final int from = mid / 2;

		Token sub = Tokens.subtoken(t, from);

		String substring = TEXT.substring(from);
		assertEquals(substring, sub.getText());
		assertEquals(substring.length(), sub.getLength());

		assertEquals(asListOfRanges(from, mid - 1, mid, LENGTH - 1),
				sub.getRanges());
	}

	@Test
	public void testSubtokenToEndSplitsRanges2() {
		final int mid = LENGTH / 2;
		final Token t = new Token(TEXT, asListOfRanges(0, mid - 1, mid,
				LENGTH - 1));

		final int from = mid + mid / 2;

		Token sub = Tokens.subtoken(t, from);

		String substring = TEXT.substring(from);
		assertEquals(substring, sub.getText());
		assertEquals(substring.length(), sub.getLength());

		assertEquals(asListOfRanges(from, LENGTH - 1), sub.getRanges());
	}

	@Test
	public void testSubtokenSplitsRanges() {
		final int mid = LENGTH / 2;
		final Token t = new Token(TEXT, asListOfRanges(0, mid - 1, mid,
				LENGTH - 1));

		final int from = mid / 2;
		final int to = mid + mid / 2;

		Token sub = Tokens.subtoken(t, from, to);

		String substring = TEXT.substring(from, to);
		assertEquals(substring, sub.getText());
		assertEquals(substring.length(), sub.getLength());

		assertEquals(asListOfRanges(from, mid - 1, mid, to - 1),
				sub.getRanges());
	}

	@Test
	public void testCanSplitToken() {
		final Token t = new Token(TEXT, asListOfRanges(0, LENGTH - 1));

		final int mid = LENGTH / 2;
		Token[] tokens = Tokens.split(t, mid);

		assertEquals(2, tokens.length);

		Token first = tokens[0];
		Token second = tokens[1];

		assertEquals(TEXT.substring(0, mid), first.getText());
		assertEquals(TEXT.substring(mid, LENGTH), second.getText());

		assertEquals(asListOfRanges(0, mid - 1), first.getRanges());
		assertEquals(asListOfRanges(mid, LENGTH - 1), second.getRanges());
	}

}
