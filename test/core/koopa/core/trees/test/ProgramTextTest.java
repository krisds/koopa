package koopa.core.trees.test;

import static koopa.core.util.test.Util.comment;
import static koopa.core.util.test.Util.text;
import static koopa.core.util.test.Util.tree;

import java.io.IOException;

import junit.framework.TestCase;
import koopa.core.trees.Tree;

import org.junit.Test;

public class ProgramTextTest extends TestCase {

	@Test
	public void testEmptyProgramText() throws IOException {
		Tree tree = tree("");

		String expected = "";

		assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testSingleToken() throws IOException {
		Tree tree = text("COBOL");

		String expected = "COBOL";

		assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testTreeOfTokens() throws IOException {
		Tree tree = tree("test", text("Stop", 0, 3), text("bashing", 5, 11),
				text("Cobol", 13, 17));

		String expected = "StopbashingCobol";

		assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testTreeOfTokensWithComments() throws IOException {
		Tree tree = tree("test", text("Stop", 0, 3),
				comment("-don't do it any more-"), text("bashing", 5, 11),
				comment("-or making jokes about-"), text("Cobol", 13, 17),
				comment("-seriously!-"));

		String expected = "StopbashingCobol";

		assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testTreeOfConsecutiveTokens() throws IOException {
		Tree tree = tree("test", text("Stop", 0, 3), text("bashing", 4, 10),
				text("Cobol", 11, 15));

		String expected = "StopbashingCobol";

		assertEquals(expected, tree.getProgramText());
	}
}
