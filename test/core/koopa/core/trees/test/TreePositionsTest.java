package koopa.core.trees.test;

import static koopa.core.util.test.Util.comment;
import static koopa.core.util.test.Util.text;
import static koopa.core.util.test.Util.tree;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import koopa.core.trees.Tree;

public class TreePositionsTest  {

	@Test
	public void testEmptyTree()  {
		Tree tree = tree("test");

		assertEquals(null, tree.getStartPosition());
		assertEquals(null, tree.getEndPosition());
	}

	@Test
	public void testSingleToken()  {
		Tree tree = tree("test", text("Cobol", 1, 5));

		assertEquals(1, tree.getStartPosition().getPositionInFile());
		assertEquals(5, tree.getEndPosition().getPositionInFile());
	}

	@Test
	public void testSequenceOfTokens() {
		Tree tree = tree("test", text("Stop", 1, 4), text("bashing", 6, 12),
				text("Cobol", 14, 18));

		assertEquals(1, tree.getStartPosition().getPositionInFile());
		assertEquals(18, tree.getEndPosition().getPositionInFile());
	}

	@Test
	public void testSequenceOfTokensWithComments() {
		Tree tree = tree("test", comment("-please-"), text("Stop", 1, 4),
				comment("-don't do it any more-"), text("bashing", 6, 16),
				comment("-or making jokes about-"), text("Cobol", 14, 18),
				comment("-seriously!-"));

		assertEquals(1, tree.getStartPosition().getPositionInFile());
		assertEquals(18, tree.getEndPosition().getPositionInFile());
	}
}
