package koopa.core.util.test;

import org.junit.Test;

import junit.framework.TestCase;
import koopa.core.util.TabStops;

public class TabStopsTest extends TestCase {

	@Test
	public void testNoTabStops() {
		final TabStops stops = new TabStops();
		assertTrue(stops.undefined());

		for (int pos = 1; pos < 10; pos++)
			assertEquals(-1, stops.tabStopAfter(pos));
	}

	@Test
	public void testTabStops() {
		final TabStops stops = new TabStops();
		stops.fromString("6,7,8,12,72");
		assertFalse(stops.undefined());

		final int[] expected = new int[] { //
				// 0 :
				-1,
				// 1--5:
				6, 6, 6, 6, 6,
				// 6:
				7,
				// 7:
				8,
				// 8--11 (AREA A)
				12, 12, 12, 12,
				// 12--71 (AREA B):
				72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72,
				72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72,
				72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72,
				72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72,
				// 72-- :
				-1 //
		};

		for (int pos = 1; pos < expected.length; pos++)
			assertEquals(expected[pos], stops.tabStopAfter(pos));
	}

	@Test
	public void testEmptyTabStops() {
		final TabStops stops = new TabStops().fromString("");
		assertTrue(stops.undefined());
	}

	@Test()
	public void testNonNumericTabStops() {
		boolean seenException = false;
		try {
			new TabStops().fromString("aa,bb,cc");
		} catch (IllegalArgumentException e) {
			seenException = true;
		}

		assertTrue(seenException);
	}

	@Test()
	public void testOutOfOrderTabStops() {
		boolean seenException = false;
		try {
			new TabStops().fromString("10,30,20");
		} catch (IllegalArgumentException e) {
			seenException = true;
		}

		assertTrue(seenException);
	}
}
