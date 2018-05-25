package koopa.core.sources.test;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import koopa.core.data.Data;
import koopa.core.data.Token;

public class TestTokenizerTest {

	private final String input = "A B C ^ X Y Z";

	private final List<Object> objects = Arrays.asList(new Object[] {
			PROGRAM_TEXT_AREA, "A", //
			PROGRAM_TEXT_AREA, " ", //
			PROGRAM_TEXT_AREA, "B", //
			PROGRAM_TEXT_AREA, " ", //
			PROGRAM_TEXT_AREA, "C", //
			PROGRAM_TEXT_AREA, " ", //
			PROGRAM_TEXT_AREA, "^", //
			PROGRAM_TEXT_AREA, " ", //
			PROGRAM_TEXT_AREA, "X", //
			PROGRAM_TEXT_AREA, " ", //
			PROGRAM_TEXT_AREA, "Y", //
			PROGRAM_TEXT_AREA, " ", //
			PROGRAM_TEXT_AREA, "Z" });

	private final static String[] expected = new String[] { //
	"A", " ", "B", " ", "C", " ", " ", "X", " ", "Y", " ", "Z" };

	private final int C = input.indexOf('C');
	private final int X = input.indexOf('X') - 1;

	@Test
	public void beforeC() {
		for (int i = 0; i < C; i++)
			assertState("" + i, i, false);
	}

	@Test
	public void cUpToX() {
		for (int i = C; i < X; i++)
			assertState(i + ": '" + expected[i] + "'", i, true);
	}

	@Test
	public void xAndBeyond() {
		for (int i = X; i < input.length() - 1; i++)
			assertState("" + i, i, false);
	}

	private void assertState(String message, int count, boolean atMark) {
		HardcodedSource source = HardcodedSource.from(objects);
		TestTokenizer tokenizer = new TestTokenizer(source);

		for (int i = 0; i <= count; i++) {
			final Data d = tokenizer.next();
			assertTrue(expected[i], d instanceof Token);
			final Token t = (Token) d;
			assertEquals(t.toString(), expected[i], t.getText());
		}

		if (atMark)
			assertTrue(message, tokenizer.isWhereExpected());
		else
			assertFalse(message, tokenizer.isWhereExpected());
	}
}
