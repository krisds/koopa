package koopa.core.data.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import koopa.core.data.Position;

public class PositionTest {

	private static final String RESOURCE_NAME = "koopa.core.data.test.PositionTest";

	@Test
	public void testPositionWithResourceName() {
		Position p = new Position(RESOURCE_NAME, 11, 2, 7);
		assertEquals(RESOURCE_NAME, p.getResourceName());
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
		Position p = new Position(RESOURCE_NAME, 11, 2, 7).offsetBy(17);

		assertEquals(RESOURCE_NAME, p.getResourceName());
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
