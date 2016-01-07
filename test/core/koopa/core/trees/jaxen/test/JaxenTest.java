package koopa.core.trees.jaxen.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import koopa.core.data.tags.AreaTag;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.Jaxen;

import org.junit.Test;

// TODO Internalize features shown in JaxenSample.
public class JaxenTest extends TestCase {

	@Test
	public void testMatchesRootName() throws IOException {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("root", branch);
		Tree document = tree("koopa", root);

		// TODO Is it always List<Tree> ?
		List<?> matches = Jaxen.evaluate(document, "/*[local-name()='root']");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(root, matches.get(0));
	}

	@Test
	public void testMatchesRoot() throws IOException {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("root", branch);
		Tree document = tree("koopa", root);

		// TODO Is it always List<Tree> ?
		List<?> matches = Jaxen.evaluate(document, "/root");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(root, matches.get(0));
	}

	@Test
	public void testMatchesNodes() throws IOException {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//branch");

		Assert.assertEquals(2, matches.size());
		Assert.assertTrue(matches.contains(branch));
		Assert.assertTrue(matches.contains(root));
	}

	@Test
	public void testMatchesNodesWithConditions() throws IOException {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//branch[branch]");

		Assert.assertEquals(1, matches.size());
		Assert.assertFalse(matches.contains(branch));
		Assert.assertTrue(matches.contains(root));
	}

	@Test
	public void testSelectAllNodes() throws IOException {
		Tree branch = tree("branch", "Grace", "Murray", "Hopper");
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//node()");

		Assert.assertEquals(5, matches.size());
	}

	@Test
	public void testSelectAllText() throws IOException {
		Tree branch = tree("branch", "Grace", "Murray", "Hopper");
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//text()");

		Assert.assertEquals(3, matches.size());
	}

	/**
	 * Support for this case is required by the Cobol Preprocessor.
	 */
	@Test
	public void testCanSelectText() throws IOException {
		Tree comment = token("Rear Admiral", AreaTag.COMMENT);
		Tree text = token("Hopper");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", comment, text)));

		List<?> matches = Jaxen.evaluate(pp, "//textName//text()");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(text, matches.get(0));
	}

	@Test
	public void testCanSelectComments() throws IOException {
		Tree comment = token("Rear Admiral", AreaTag.COMMENT);
		Tree text = token("Hopper");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", comment, text)));

		List<?> matches = Jaxen.evaluate(pp, "//comment()");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(comment, matches.get(0));
	}

	@Test
	public void testCanSelectByTag() throws IOException {
		Tree title = token("Rear Admiral", "TITLE");
		Tree name = token("Hopper", "NAME");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", title, name)));

		List<?> matches = Jaxen.evaluate(pp, "//node()[@tag=\"TITLE\"]");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(title, matches.get(0));

		matches = Jaxen.evaluate(pp, "//node()[@tag=\"NAME\"]");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(name, matches.get(0));
	}

	@Test
	public void testCanSelectByPosition() throws IOException {
		Tree[] branches = new Tree[] { tree("branch", "0"),
				tree("branch", "1"), tree("branch", "2"), tree("branch", "3") };

		Tree tree = tree("root", branches[0], branches[1], branches[2],
				branches[3]);

		List<?> matches = null;

		matches = Jaxen.evaluate(tree, "//branch[1]");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(branches[0], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch[position()=1]");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(branches[0], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch[position()<=2]");
		Assert.assertEquals(2, matches.size());
		Assert.assertTrue(matches.contains(branches[0]));
		Assert.assertTrue(matches.contains(branches[1]));

		matches = Jaxen.evaluate(tree, "//branch[position()>2]");
		Assert.assertEquals(2, matches.size());
		Assert.assertTrue(matches.contains(branches[2]));
		Assert.assertTrue(matches.contains(branches[3]));

		matches = Jaxen.evaluate(tree, "//branch[last()]");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(branches[3], matches.get(0));
	}

	@Test
	public void testCanSelectFollowingSibling() throws IOException {
		Tree[] branches = new Tree[] { tree("branch", "0"),
				tree("branch", "1"), tree("branch", "2"),
				tree("bird", "woodpecker"), tree("branch", "3") };

		Tree tree = tree("root", branches[0], branches[1], branches[2],
				branches[3], branches[4]);

		List<?> matches = null;

		matches = Jaxen.evaluate(tree, "//branch[2]");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(branches[1], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch[2]/following-sibling::*");
		Assert.assertEquals(3, matches.size());
		Assert.assertTrue(matches.contains(branches[2]));
		Assert.assertTrue(matches.contains(branches[3]));
		Assert.assertTrue(matches.contains(branches[4]));

		matches = Jaxen.evaluate(tree, "//branch[2]/following-sibling::branch");
		Assert.assertEquals(2, matches.size());
		Assert.assertTrue(matches.contains(branches[2]));
		Assert.assertTrue(matches.contains(branches[4]));
	}

	@Test
	public void testCanSelectParent() throws IOException {
		Tree[] leaves = new Tree[] { tree("leaf"), tree("leaf") };

		Tree[] branches = new Tree[] { tree("branch", "0"),
				tree("branch", "1"), tree("branch", leaves[0], leaves[1]),
				tree("branch", "3") };

		Tree tree = tree("root", branches[0], branches[1], branches[2],
				branches[3]);

		List<?> matches = null;

		matches = Jaxen.evaluate(tree, "//leaf[2]");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(leaves[1], matches.get(0));

		matches = Jaxen.evaluate(tree, "//branch/..");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(tree, matches.get(0));

		matches = Jaxen.evaluate(tree, "//leaf/../..");
		Assert.assertEquals(1, matches.size());
		Assert.assertSame(tree, matches.get(0));
	}

	@Test
	public void testMatchesNSAttribute() throws IOException {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("root", branch);
		Tree document = tree("koopa", root);

		List<?> matches = Jaxen.evaluate(document, "//*[@ns='test']");

		// Two, because it never matches the document.
		Assert.assertEquals(2, matches.size());
		Assert.assertSame(root, matches.get(0));
		Assert.assertTrue(matches.contains(branch));
		Assert.assertTrue(matches.contains(root));
		Assert.assertFalse(matches.contains(leaf));
		Assert.assertFalse(matches.contains(document));
	}

}
