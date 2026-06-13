package koopa.core.grammars.test;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import koopa.core.grammars.combinators.Scoped;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.test.HardcodedSource;
import koopa.core.targets.ListTarget;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.util.test.TreeSample;

public abstract class GrammarTest {

	protected final TestGrammar G;

	protected GrammarTest(String... separators) {
		G = new TestGrammar(separators);
	}

	protected List<Object> spaced(String text) {
		final String[] split = text.split("\\s+");
		final Object[] taggedWords = new Object[split.length * 2];
		for (int i = 0; i < split.length; i++) {
			taggedWords[2 * i + 0] = PROGRAM_TEXT_AREA;
			taggedWords[2 * i + 1] = split[i];
		}
		return input(taggedWords);
	}

	protected List<Object> input(Object... taggedWords) {
		List<Object> r = new ArrayList<>(taggedWords.length);
		r.addAll(Arrays.asList(taggedWords));
		return r;
	}

	protected void shouldReject(ParserCombinator parser, List<Object> input) {
		Scoped rule = (Scoped) G.scoped("rule");
		rule.setParser(parser);

		HardcodedSource source = HardcodedSource.from(input);
		ListTarget target = new ListTarget();

		assertFalse(rule.accepts(Parse.of(source).to(target))
				&& source.next() == null);
	}

	protected void shouldAccept(ParserCombinator parser,
			List<Object> input) {
		Scoped rule = (Scoped) G.scoped("rule");
		rule.setParser(parser);

		HardcodedSource source = HardcodedSource.from(input);
		ListTarget target = new ListTarget();

		assertTrue(rule.accepts(Parse.of(source).to(target)));
		assertTrue(target.size() > 0);

		assertNull(source.next());
	}

	protected void shouldAccept(ParserCombinator parser, TreeSample sample) {
		Scoped rule = (Scoped) G.scoped("rule");
		rule.setParser(parser);

		HardcodedSource source = HardcodedSource.from(sample.getTaggedWords());
		KoopaTreeBuilder target = new KoopaTreeBuilder(G);

		assertTrue(rule.accepts(Parse.of(source).to(target)));
		assertNull(source.next());

		final Tree treeForRule = target.getTree();
		assertNotNull(treeForRule);

		assertEquals(sample.getTrees().size(),
				treeForRule.getChildCount());
		for (Tree e : sample.getTrees()) {
			final Tree actual = treeForRule.getChild(0);
			assertNotNull(treeForRule);

			treeForRule.removeChild(0);
			shouldBeEqual(e, actual);
		}
	}

	private void shouldBeEqual(Tree expected, Tree actual) {
		final String expectedPath = getPath(expected);
		final String actualPath = getPath(actual);

		if (expected.isNode()) {
			assertTrue(actual.isNode(),
					expectedPath + " == " + actualPath);

			assertEquals(expected.getName(), actual.getName(),
					expectedPath + " == " + actualPath);

			for (int i = 0; i < expected.getChildCount(); i++)
				shouldBeEqual(expected.getChild(i), actual.getChild(i));

			assertEquals(expected.getChildCount(), actual.getChildCount(),
					expectedPath + ": child count");

		} else {
			assertTrue(actual.isToken(),
					expectedPath + " == " + actualPath);

			assertEquals(expected.getText(), actual.getText());
		}
	}

	private String getPath(Tree tree) {
		if (tree == null)
			return "";

		if (tree.isNode()) {
			return getPath(tree.getParent()) + "/" + tree.getName() + "["
					+ tree.getChildIndex() + "]";

		} else {
			return getPath(tree.getParent()) + "/text(" + tree.getText() + ")"
					+ "[" + tree.getChildIndex() + "]";
		}
	}
}
