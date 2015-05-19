package koopa.core.trees.test;

import static koopa.core.util.test.Util.comment;
import static koopa.core.util.test.Util.text;
import static koopa.core.util.test.Util.tree;

import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;
import koopa.core.treeparsers.Tree;

import org.junit.Test;

public class ProgramTextTest extends TestCase {

	@Test
	public void testEmptyProgramText() throws IOException {
		Tree tree = tree("");

		String expected = "";

		Assert.assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testSingleToken() throws IOException {
		Tree tree = text("COBOL");

		String expected = "COBOL";

		Assert.assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testTreeOfTokens() throws IOException {
		Tree tree = tree("quote", text("Stop"), text("bashing"), text("Cobol"));

		String expected = "Stop bashing Cobol";

		Assert.assertEquals(expected, tree.getProgramText());
	}

	@Test
	public void testTreeOfTokensWithComments() throws IOException {
		Tree tree = tree("quote", text("Stop"),
				comment("-don't do it any more-"), text("bashing"),
				comment("-or making jokes about-"), text("Cobol"),
				comment("-seriously!-"));

		String expected = "Stop bashing Cobol";

		Assert.assertEquals(expected, tree.getProgramText());
	}
}
