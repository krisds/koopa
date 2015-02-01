package koopa.core.trees.jaxen.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import koopa.core.treeparsers.Tree;
import koopa.core.trees.jaxen.Jaxen;

import org.junit.Test;

// TODO Internalize features shown in JaxenSample.
public class JaxenTest extends TestCase {

	@Test
	public void testMatchesRoot() throws IOException {
		Tree leaf = token("leaf");
		Tree branch = tree("branch", leaf);
		Tree root = tree("branch", branch);
		Tree document = tree("koopa", root);

		// TODO Is it always List<Tree> ?
		List<?> matches = Jaxen.evaluate(document, "/branch");

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
		Tree text = token("Hopper");
		Tree pp = tree("preprocessingStatement",
				tree("textName", tree("cobolWord", text)));

		List<?> matches = Jaxen.evaluate(pp, "//textName//text()");

		Assert.assertEquals(1, matches.size());
		Assert.assertSame(text, matches.get(0));
	}
}
