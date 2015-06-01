package koopa.core.treegrammars.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import koopa.core.grammars.combinators.Opt;
import koopa.core.parsers.Parse;
import koopa.core.parsers.combinators.Block;
import koopa.core.treegrammars.TreeGrammar;
import koopa.core.treeparsers.BasicTreeStream;
import koopa.core.treeparsers.FutureTreeParser;
import koopa.core.treeparsers.Tree;
import koopa.core.treeparsers.TreeParser;
import koopa.core.treeparsers.TreeStream;

import org.junit.Assert;
import org.junit.Test;

public class TreeGrammarTest {

	private static TreeGrammar G = new TreeGrammar();

	@Test
	public void canMatchSingleToken() {
		Tree tree = token("Cobol");

		shouldAccept(G.token("COBOL"), tree);
		shouldAccept(G.token("cobol"), tree);
		shouldReject(G.token("Flowmatic"), tree);
	}

	@Test
	public void willSkipToMatchSingleToken() {
		Tree tree = tree("quote", "One", "accurate", "measurement", "is",
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
		Tree tree = tree("quote", "One", "accurate", "measurement", "is",
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
		Tree tree = tree("quote", "One", "accurate", "measurement", "is",
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
						tree("quote", "A", "thousand", "expert", "opinions",
								"are", "not", "worth", "one", "accurate",
								"measurement", ".")));
	}

	@Test
	public void canMatchChoice() {
		Tree tree = tree("quote", "One", "accurate", "measurement", "is",
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
	public void canMatchOptional() {
		final TreeParser quotes = G.sequence(G.optional(G.scoped("quote")),
				G.scoped("author"));

		shouldAccept(quotes, tree("quotes", tree("quote"), tree("author")));
		shouldAccept(quotes, tree("quotes", tree("author")));
		shouldReject(quotes, tree("quotes", tree("quote")));
	}

	@Test
	public void canMatchEmptyTree() {
		final TreeParser empty = G.scoped("empty");

		shouldAccept(empty, tree("empty"));
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
		Tree tree = tree("quote", "One", "accurate", "measurement", "is",
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
			public void apply(Parse parse) {
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

	@Test
	public void willUseScopeCorrectly() {
		final int[] count = new int[] { 0 };

		FutureTreeParser list = G.scoped("list");

		TreeParser cobolCounter = G.star(G.sequence(G.token("Cobol"),
				G.apply(new Block() {
					public void apply(Parse parse) {
						// System.out.println("FOUND ONE");
						count[0]++;
					}
				})));

		list.setParser(cobolCounter);

		TreeParser lists = G.star(list);

		count[0] = 0;
		shouldAccept(lists, null);
		assertEquals(0, count[0]);

		count[0] = 0;
		shouldAccept(lists, token("Cobol"));
		assertEquals(0, count[0]);

		count[0] = 0;
		shouldAccept(lists, tree("list", "Cobol"));
		assertEquals(1, count[0]);

		count[0] = 0;
		shouldAccept(lists, tree("list", "PL/I"));
		assertEquals(0, count[0]);

		count[0] = 0;
		shouldAccept(lists, tree("list", "PL/I", "Cobol", "FlowMatic", "Cobol"));
		assertEquals(2, count[0]);

		count[0] = 0;
		shouldAccept(
				lists,
				tree("inventory",
						tree("list", "PL/I", "Cobol", "FlowMatic", "Cobol")));
		assertEquals(2, count[0]);

		count[0] = 0;
		shouldAccept(
				lists,
				tree("inventory", tree("list", "PL/I", "Cobol"), "FlowMatic",
						"Cobol"));
		assertEquals(1, count[0]);

		count[0] = 0;
		shouldAccept(
				lists,
				tree("inventory", tree("list", "PL/I", "Cobol"), "FlowMatic",
						"Cobol", tree("list", "PL/I", "Cobol"), "FlowMatic",
						"Cobol"));
		assertEquals(2, count[0]);
	}

	@Test
	public void canMatchWithLimit() {
		FutureTreeParser limiter = G.scoped("list");
		limiter.setParser(G.any());

		final int[] count = new int[] { 0 };

		TreeParser cobolCounter = G.star(G.sequence(G.token("Cobol"),
				G.apply(new Block() {
					public void apply(Parse parse) {
						// System.out.println("FOUND ONE");
						count[0]++;
					}
				})));

		TreeParser limitedCobolCounter = G.limited(cobolCounter,
				G.opt(Opt.NOSKIP, limiter));

		count[0] = 0;
		shouldAccept(
				limitedCobolCounter,
				tree("inventory", tree("list", "PL/I", "Cobol"),
						tree("list", "PL/I", "Cobol")));
		assertEquals(0, count[0]);

		count[0] = 0;
		shouldAccept(
				limitedCobolCounter,
				tree("inventory", tree("list", "PL/I", "Cobol"), "FlowMatic",
						"Cobol", tree("list", "PL/I", "Cobol"), "FlowMatic",
						"Cobol"));
		assertEquals(0, count[0]);

		count[0] = 0;
		shouldAccept(
				limitedCobolCounter,
				tree("inventory", "Cobol", "FlowMatic", "Cobol", "PL/I",
						tree("list", "PL/I", "Cobol"), "FlowMatic", "Cobol",
						tree("list", "PL/I", "Cobol"), "FlowMatic", "Cobol"));
		assertEquals(2, count[0]);
	}

	private void shouldAccept(TreeParser parser, Tree tree) {
		TreeStream stream = new BasicTreeStream(tree);
		Assert.assertTrue(parser.accepts(stream));
	}

	private void shouldReject(TreeParser parser, Tree tree) {
		TreeStream stream = new BasicTreeStream(tree);
		Assert.assertFalse(parser.accepts(stream));
	}
}
