package koopa.core.treegrammars.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Block;
import koopa.core.treegrammars.TreeGrammar;
import koopa.core.treeparsers.FutureTreeParser;
import koopa.core.treeparsers.TreeParser;
import koopa.core.treeparsers.TreeStream;
import koopa.core.trees.antlr.ANTLRNaming;
import koopa.core.trees.antlr.CommonKoopaToken;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Assert;
import org.junit.Test;

public class TreeGrammarTest {

	private static TreeGrammar G = new TreeGrammar();

	@Test
	public void canMatchSingleToken() {
		CommonTree tree = token("Cobol");

		shouldAccept(G.token("COBOL"), tree);
		shouldAccept(G.token("cobol"), tree);
		shouldReject(G.token("Flowmatic"), tree);
	}

	@Test
	public void willSkipToMatchSingleToken() {
		CommonTree tree = tree("quote", "One", "accurate", "measurement", "is",
				"worth", "a", "thousand", "expert", "opinions", ".");

		shouldAccept(G.token("one"), tree);
		shouldAccept(G.token("thousand"), tree);
		shouldReject(G.token("Flowmatic"), tree);
	}

	@Test
	public void canMatchGrammarRule() {
		FutureTreeParser parser = G.scoped("quote");
		parser.setParser(G.token("verily"));

		shouldAccept(parser, tree("quote", "Verily"));
		shouldReject(parser, tree("quote", "Merrily"));
		shouldReject(parser, tree("citation", "Verily"));
	}

	@Test
	public void willSkipToMatchGrammarRule() {
		FutureTreeParser parser = G.scoped("quote");
		parser.setParser(G.token("thousand"));

		shouldAccept(
				parser,
				tree("quote", "One", "accurate", "measurement", "is", "worth",
						"a", "thousand", "expert", "opinions", "."));
		shouldAccept(
				parser,
				tree("Hopper",
						tree("quote", "One", "accurate", "measurement", "is",
								"worth", "a", "thousand", "expert", "opinions",
								".")));
	}

	@Test
	public void canMatchASequence() {
		CommonTree tree = tree("quote", "One", "accurate", "measurement", "is",
				"worth", "a", "thousand", "expert", "opinions", ".");

		shouldAccept(
				G.sequence(G.token("one"), G.token("measurement"),
						G.token("thousand"), G.token("opinions")), tree);

		shouldReject(
				G.sequence(G.token("thousand"), G.token("opinions"),
						G.token("one"), G.token("measurement")), tree);
	}

	@Test
	public void scopingSkipsSubtreeAfterASuccessfulMatch() {
		CommonTree tree = tree("quote", "One", "accurate", "measurement", "is",
				"worth", "a", "thousand", "expert", "opinions", ".");

		FutureTreeParser one = G.scoped("quote");
		one.setParser(G.token("one"));

		FutureTreeParser thousand = G.scoped("quote");
		thousand.setParser(G.token("thousand"));

		shouldAccept(one, tree);
		shouldAccept(thousand, tree);

		// Even though "one" and "thousand" appear in the correct order, because
		// each is scoped to "quote" they each need to be in their own unique
		// subtree. Which is not the case for the sample.
		shouldReject(G.sequence(one, thousand), tree);

		// But here they do each have their own subtree.
		shouldAccept(
				G.sequence(one, thousand),
				tree("Hopper",
						tree,
						tree("quote", "One", "accurate", "measurement", "is",
								"worth", "a", "thousand", "expert", "opinions",
								".")));
	}

	@Test
	public void canMatchChoice() {
		CommonTree tree = tree("quote", "One", "accurate", "measurement", "is",
				"worth", "a", "thousand", "expert", "opinions", ".");

		shouldAccept(G.choice(G.token("one"), G.token("Flowmatic")), tree);
		shouldAccept(G.choice(G.token("Flowmatic"), G.token("thousand")), tree);
		shouldReject(G.choice(G.token("Flowmatic"), G.token("PL/I")), tree);
	}

	@Test
	public void canMatchOptionalRepitition() {
		final TreeParser quotes = G.star(G.scoped("quote"));

		shouldAccept(quotes, token("quote"));

		shouldAccept(
				quotes,
				tree("quote", "One", "accurate", "measurement", "is", "worth",
						"a", "thousand", "expert", "opinions", "."));
		shouldAccept(
				quotes,
				tree("Hopper",
						tree("quote", "One", "accurate", "measurement", "is",
								"worth", "a", "thousand", "expert", "opinions",
								"."),
						tree("quote", "Life", "was", "simple", "before",
								"World War II", ".", "After", "that", ",",
								"we", "had", "systems", ".")));
	}

	@Test
	public void canMatchRepitition() {
		final TreeParser quotes = G.plus(G.scoped("quote"));

		shouldReject(quotes, token("quote"));

		shouldAccept(
				quotes,
				tree("quote", "One", "accurate", "measurement", "is", "worth",
						"a", "thousand", "expert", "opinions", "."));
		shouldAccept(
				quotes,
				tree("Hopper",
						tree("quote", "One", "accurate", "measurement", "is",
								"worth", "a", "thousand", "expert", "opinions",
								"."),
						tree("quote", "Life", "was", "simple", "before",
								"World War II", ".", "After", "that", ",",
								"we", "had", "systems", ".")));
	}

	@Test
	public void canMatchNegation() {
		CommonTree tree = tree("quote", "One", "accurate", "measurement", "is",
				"worth", "a", "thousand", "expert", "opinions", ".");

		shouldReject(G.not(G.token("one")), tree);
		shouldAccept(G.not(G.token("Flowmatic")), tree);
	}

	@Test
	public void canMatchAny() {
		TreeParser any = G.any();

		shouldReject(any, null);
		shouldAccept(any, token("Cobol"));
		shouldAccept(any, tree("language", "Cobol"));
	}

	@Test
	public void canMatchPermutation() {
		FutureTreeParser parser = G.scoped("series");
		parser.setParser(G.sequence(
				G.permuted(G.token("1"), G.token("2"), G.token("3")),
				G.not(G.any())));

		shouldAccept(parser, tree("series"));

		shouldAccept(parser, tree("series", "1"));
		shouldAccept(parser, tree("series", "2"));
		shouldAccept(parser, tree("series", "3"));

		shouldAccept(parser, tree("series", "1", "2"));
		shouldAccept(parser, tree("series", "1", "3"));
		shouldAccept(parser, tree("series", "2", "1"));
		shouldAccept(parser, tree("series", "2", "3"));
		shouldAccept(parser, tree("series", "3", "1"));
		shouldAccept(parser, tree("series", "3", "2"));

		shouldAccept(parser, tree("series", "1", "2", "3"));
		shouldAccept(parser, tree("series", "1", "3", "2"));
		shouldAccept(parser, tree("series", "2", "1", "3"));
		shouldAccept(parser, tree("series", "2", "3", "1"));
		shouldAccept(parser, tree("series", "3", "1", "2"));
		shouldAccept(parser, tree("series", "3", "2", "1"));

		shouldReject(parser, tree("series", "1", "2", "3", "1"));
		shouldReject(parser, tree("series", "1", "2", "3", "2"));
		shouldReject(parser, tree("series", "1", "2", "3", "3"));
	}

	@Test
	public void runsNativeCode() {
		final List<String> list = new ArrayList<String>();

		TreeParser application = G.apply(new Block() {
			public void apply() {
				list.add("Stop bashing Cobol");
			}
		});

		shouldAccept(application, null);
		assertEquals(1, list.size());

		shouldAccept(application, token("Cobol"));
		assertEquals(2, list.size());

		shouldAccept(application, tree("language", "Cobol"));
		assertEquals(3, list.size());
	}

	// ------------------------------------------------------------------------

	private CommonTree tree(String name, Object... parts) {
		ensureNode(name);

		Start start = Start.on("test", name);

		CommonToken antlrToken = new CommonKoopaToken(start);
		CommonTree antlrTree = new CommonTree(antlrToken);

		for (Object part : parts) {
			if (part instanceof CommonTree)
				antlrTree.addChild((CommonTree) part);
			else if (part instanceof String)
				antlrTree.addChild(token((String) part));
			else
				throw new IllegalArgumentException(
						"This is neither a CommonTree or a String: " + part);
		}

		return antlrTree;
	}

	private CommonTree token(String text) {
		ensureToken(text);

		Position start = new Position(0, 0, 0);
		Token token = new Token(text, start, start.offsetBy(text.length()));

		CommonToken antlrToken = new CommonKoopaToken(token);
		CommonTree antlrTree = new CommonTree(antlrToken);

		return antlrTree;
	}

	private void ensureNode(String name) {
		name = ANTLRNaming.forNode(name);
	}

	private void ensureToken(String text) {
		text = ANTLRNaming.forLiteral(text);
	}

	private void shouldAccept(TreeParser parser, CommonTree tree) {
		TreeStream stream = new TreeStream(tree);
		Assert.assertTrue(parser.accepts(stream));
	}

	private void shouldReject(TreeParser parser, CommonTree tree) {
		TreeStream stream = new TreeStream(tree);
		Assert.assertFalse(parser.accepts(stream));
	}
}
