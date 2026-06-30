package koopa.core.trees.jaxen.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import koopa.core.data.tags.AreaTag;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.Jaxen;

// TODO Internalize features shown in JaxenSample.
public class JaxenTest  {

	@Test
	public void testMatchesRootName() {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("root", branch);
		Tree document = tree("koopa", root);

		// TODO Is it always List<Tree> ?
		List<?> matches = Jaxen.evaluate(document, "/*[local-name()='root']");

		assertEquals(1, matches.size());
		assertSame(root, matches.get(0));
	}

	@Test
	public void testMatchesRoot() {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("root", branch);
		Tree document = tree("koopa", root);

		// TODO Is it always List<Tree> ?
		List<?> matches = Jaxen.evaluate(document, "/root");

		assertEquals(1, matches.size());
		assertSame(root, matches.get(0));
	}

	@Test
	public void testMatchesNodes() {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//branch");

		assertEquals(2, matches.size());
		assertTrue(matches.contains(branch));
		assertTrue(matches.contains(root));
	}

	@Test
	public void testMatchesNodesWithConditions() {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//branch[branch]");

		assertEquals(1, matches.size());
		assertFalse(matches.contains(branch));
		assertTrue(matches.contains(root));
	}

	@Test
	public void testSelectAllNodes() {
		Tree branch = tree("branch", "Grace", "Murray", "Hopper");
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//node()");

		assertEquals(5, matches.size());
	}

	@Test
	public void testSelectAllText() {
		Tree branch = tree("branch", "Grace", "Murray", "Hopper");
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//text()");

		assertEquals(3, matches.size());
	}

	/**
	 * Support for this case is required by the Cobol Preprocessor.
	 */
	@Test
	public void testCanSelectText() {
		Tree comment = token("Rear Admiral", AreaTag.COMMENT);
		Tree text = token("Hopper");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", comment, text)));

		List<?> matches = Jaxen.evaluate(pp, "//textName//text()");

		assertEquals(1, matches.size());
		assertSame(text, matches.get(0));
	}

	@Test
	public void testCanSelectComments() {
		Tree comment = token("Rear Admiral", AreaTag.COMMENT);
		Tree text = token("Hopper");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", comment, text)));

		List<?> matches = Jaxen.evaluate(pp, "//comment()");

		assertEquals(1, matches.size());
		assertSame(comment, matches.get(0));
	}

	@Test
	public void testCanSelectByTag() {
		Tree title = token("Rear Admiral", "TITLE");
		Tree name = token("Hopper", "NAME");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", title, name)));

		List<?> matches = Jaxen.evaluate(pp, "//node()[@tag=\"TITLE\"]");

		assertEquals(1, matches.size());
		assertSame(title, matches.get(0));

		matches = Jaxen.evaluate(pp, "//node()[@tag=\"NAME\"]");

		assertEquals(1, matches.size());
		assertSame(name, matches.get(0));
	}

	@Test
	public void testCanSelectByPosition() {
		Tree[] branches = new Tree[] { tree("branch", "0"),
				tree("branch", "1"), tree("branch", "2"), tree("branch", "3") };

		Tree tree = tree("root", branches[0], branches[1], branches[2],
				branches[3]);

		List<?> matches = null;

		matches = Jaxen.evaluate(tree, "//branch[1]");
		assertEquals(1, matches.size());
		assertSame(branches[0], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch[position()=1]");
		assertEquals(1, matches.size());
		assertSame(branches[0], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch[position()<=2]");
		assertEquals(2, matches.size());
		assertTrue(matches.contains(branches[0]));
		assertTrue(matches.contains(branches[1]));

		matches = Jaxen.evaluate(tree, "//branch[position()>2]");
		assertEquals(2, matches.size());
		assertTrue(matches.contains(branches[2]));
		assertTrue(matches.contains(branches[3]));

		matches = Jaxen.evaluate(tree, "//branch[last()]");
		assertEquals(1, matches.size());
		assertSame(branches[3], matches.get(0));
	}

	@Test
	public void testCanSelectFollowingSibling() {
		Tree[] branches = new Tree[] { tree("branch", "0"),
				tree("branch", "1"), tree("branch", "2"),
				tree("bird", "woodpecker"), tree("branch", "3") };

		Tree tree = tree("root", branches[0], branches[1], branches[2],
				branches[3], branches[4]);

		List<?> matches = null;

		matches = Jaxen.evaluate(tree, "//branch[2]");
		assertEquals(1, matches.size());
		assertSame(branches[1], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch[2]/following-sibling::*");
		assertEquals(3, matches.size());
		assertTrue(matches.contains(branches[2]));
		assertTrue(matches.contains(branches[3]));
		assertTrue(matches.contains(branches[4]));

		matches = Jaxen.evaluate(tree, "//branch[2]/following-sibling::branch");
		assertEquals(2, matches.size());
		assertTrue(matches.contains(branches[2]));
		assertTrue(matches.contains(branches[4]));
	}

	@Test
	public void testCanSelectParent() {
		Tree[] leaves = new Tree[] { tree("leaf"), tree("leaf") };

		Tree[] branches = new Tree[] { tree("branch", "0"),
				tree("branch", "1"), tree("branch", leaves[0], leaves[1]),
				tree("branch", "3") };

		Tree tree = tree("root", branches[0], branches[1], branches[2],
				branches[3]);

		List<?> matches = null;

		matches = Jaxen.evaluate(tree, "//leaf[2]");
		assertEquals(1, matches.size());
		assertSame(leaves[1], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch/..");
		assertEquals(1, matches.size());
		assertSame(tree, matches.get(0));

		matches = Jaxen.evaluate(tree, "//leaf/../..");
		assertEquals(1, matches.size());
		assertSame(tree, matches.get(0));
	}

	@Test
	public void testMatchesNSAttribute() {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("root", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//*[@ns='test']");

		// Two, because it never matches the document.
		assertEquals(2, matches.size());
		assertSame(root, matches.get(0));
		assertTrue(matches.contains(branch));
		assertTrue(matches.contains(root));
		assertFalse(matches.contains(leaf));
		assertFalse(matches.contains(document));
	}

}
