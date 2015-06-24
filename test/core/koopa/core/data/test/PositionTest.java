package koopa.core.data.test;

import junit.framework.TestCase;
import koopa.core.data.Position;

import org.junit.Test;

public class PositionTest extends TestCase {

	private final String resourceName = "koopa.core.data.test.PositionTest";

	@Test
	public void testPositionWithResourceName() {
		Position p = new Position(resourceName, 11, 2, 7);
		assertEquals(resourceName, p.getResourceName());
		assertEquals(11, p.getPositionInFile());
		assertEquals(2, p.getLinenumber());
		assertEquals(7, p.getPositionInLine());
	}

	@Test
	public void testPositionWithoutResourceName() {
		Position p = new Position(11, 2, 7);
		assertEquals(null, p.getResourceName());
		assertEquals(11, p.getPositionInFile());
		assertEquals(2, p.getLinenumber());
		assertEquals(7, p.getPositionInLine());
	}

	@Test
	public void testOffsetPositionWithResourceName() {
		Position p = new Position(resourceName, 11, 2, 7).offsetBy(17);

		assertEquals(resourceName, p.getResourceName());
		assertEquals(28, p.getPositionInFile());
		assertEquals(2, p.getLinenumber());
		assertEquals(24, p.getPositionInLine());
	}

	@Test
	public void testOffsetPositionWithoutResourceName() {
		Position p = new Position(11, 2, 7).offsetBy(17);

		assertEquals(null, p.getResourceName());
		assertEquals(28, p.getPositionInFile());
		assertEquals(2, p.getLinenumber());
		assertEquals(24, p.getPositionInLine());
	}
}
