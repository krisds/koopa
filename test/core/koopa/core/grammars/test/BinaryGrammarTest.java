package koopa.core.grammars.test;

import org.junit.BeforeClass;
import org.junit.Test;

import koopa.core.grammars.combinators.Scoped;
import koopa.core.parsers.ParserCombinator;
import koopa.core.util.test.TreeSample;

// TODO Redo with a fluent grammar ?
// TODO AST tests for every input.
public class BinaryGrammarTest extends GrammarTest {

	private static final String FOX = "The quick brown fox jumped over the lazy dog . ";
	private static final String LIPSUM = "Lorem ipsum dolor sit amet , ";

	private static ParserCombinator and = null;
	private static ParserCombinator or = null;

	private static Scoped cond = null;
	private static Scoped disj = null;
	private static Scoped conj = null;
	private static Scoped atom = null;

	private static Scoped nested = null;
	private static Scoped unknown = null;

	@BeforeClass
	public static void setup() {
		TestGrammar G = new TestGrammar();

		cond = (Scoped) G.scoped("cond");
		disj = (Scoped) G.scoped("disj");
		conj = (Scoped) G.scoped("conj");
		atom = (Scoped) G.scoped("atom");
		nested = (Scoped) G.scoped("nested");
		unknown = (Scoped) G.scoped("unknown");

		final ParserCombinator openParen = G.literal("(");
		final ParserCombinator closeParen = G.literal(")");

		and = G.notNested(G.token("AND"));
		or = G.notNested(G.token("OR"));

		// TODO G.eoi(), instead of G.eof() ?
		unknown.setParser(G.skipto(G.eof()));

		nested.setParser(G.sequence(//
				openParen, //
				G.balancing(openParen, closeParen, //
						G.upTo(cond, G.notNested(closeParen))), //
				closeParen));

		atom.setParser(G.choice(nested, unknown));

		conj.setParser(G.sequence( //
				G.upTo(atom, and), G.star(G.sequence(and, G.upTo(atom, and)))));

		disj.setParser(G.sequence( //
				G.upTo(conj, or), G.star(G.sequence(or, G.upTo(conj, or)))));

		cond.setParser(G.balancing( //
				openParen, closeParen, //
				disj));
	}

	@Test
	public void testUnknown() {
		// 'unknown' eats everything to the end of the file/input.
		shouldAccept(unknown,
				TreeSample.from( //
						"+ unknown", //
						"  > " + FOX //
				));
	}

	@Test
	public void testUnknownUpTo() {
		// We can limit what 'unknown' sees. Here it will consume until the next
		// 'AND'.
		ParserCombinator upToAnd = G.upTo(unknown, and);

		// '%match unkown %upto and' should still consume to the end of the
		// input as is though.
		shouldAccept(upToAnd,
				TreeSample.from( //
						"+ unknown", //
						"  > " + FOX //
				));

		// But when we expect that 'AND', it should still get matched correctly.
		ParserCombinator upToAndMore = G.sequence(upToAnd, and,
				G.token("more"));

		// This fails because there is no 'AND' following FOX.
		shouldReject(upToAndMore, spaced(FOX));
		// This fails because there is no 'more' after 'AND'.
		shouldReject(upToAndMore, spaced(FOX + " AND"));

		shouldAccept(upToAndMore,
				TreeSample.from( //
						"+ unknown", //
						"  > " + FOX, //
						"> AND more" //
				));

		shouldAccept(upToAndMore,
				TreeSample.from( //
						"+ unknown", //
						"  > " + LIPSUM, //
						"> AND more" //
				));
	}

	@Test
	public void testUnknownUpToNotNested() {
		// We can limit what 'unknown' sees. Here it will consume until the next
		// 'AND'. Note that that 'AND' must be a "not nested" 'AND'. An 'AND'
		// which is nested does not count towards the limit.
		ParserCombinator unknownUpToAnd = G.upTo(unknown, and);

		// So let's test that. We will be balancing parentheses while scanning
		// for the "not nested" 'AND'.
		ParserCombinator balanced = G.balancing( //
				G.literal("("), G.literal(")"), //
				G.sequence(unknownUpToAnd, and, G.token("more")) //
		);

		// This old example should still work.
		shouldAccept(balanced, spaced(FOX + " AND more"));
		// This one shouldn't, as the wrong thing is following the 'AND'.
		shouldReject(balanced, spaced(FOX + " AND hare"));
		// This one should match again, as the faulty 'AND' is now nested and
		// should therefore be ignored.
		shouldAccept(balanced, spaced(FOX + " ( AND hare ) AND more"));
	}

	@Test
	public void testUnknownConditions() {
		shouldAccept(cond,
				TreeSample.from( //
						"+ cond/disj/conj/atom/unknown", //
						"  > " + FOX //
				));

		shouldAccept(cond,
				TreeSample.from( //
						"+ cond/disj/conj/atom/unknown", //
						"  > " + LIPSUM //
				));
	}

	@Test
	public void testConjunction() {
		shouldAccept(cond,
				TreeSample.from(//
						"+ cond/disj/conj", //
						"  + atom/unknown", //
						"    > " + FOX, //
						"  > AND", //
						"  + atom/unknown", //
						"    > " + LIPSUM //
				));
	}

	@Test
	public void testDisjunction() {
		shouldAccept(cond,
				TreeSample.from(//
						"+ cond/disj", //
						"  + conj/atom/unknown", //
						"    > " + FOX, //
						"  > OR", //
						"  + conj/atom/unknown", //
						"    > " + LIPSUM //
				));
	}

	@Test
	public void testCombined() {
		shouldAccept(cond,
				TreeSample.from(//
						"+ cond/disj", //
						"  + conj", //
						"    + atom/unknown", //
						"      > " + FOX, //
						"    > AND", //
						"    + atom/unknown", //
						"      > " + LIPSUM, //
						"  > OR", //
						"  + conj", //
						"    + atom/unknown", //
						"      > " + LIPSUM, //
						"    > AND", //
						"    + atom/unknown", //
						"      > " + FOX //
				));
	}

	@Test
	public void testDisjunctionWithNesting() {
		shouldAccept(cond,
				TreeSample.from( //
						"+ cond/disj/conj/atom/nested", //
						"  > (", //
						"  + cond/disj/conj/atom/unknown", //
						"    > " + FOX, //
						"  > )" //
				));

		shouldAccept(cond, spaced("( " + LIPSUM + " )"));
		shouldAccept(cond, spaced("( " + FOX + " AND " + LIPSUM + " )"));
		shouldAccept(cond, spaced("( " + LIPSUM + " OR " + FOX + " )"));
		shouldAccept(cond, spaced("( " + FOX + " AND " + LIPSUM + " OR "
				+ LIPSUM + " AND " + FOX + " )"));

		// This uses parentheses to invert the order of precedence.
		shouldAccept(cond, spaced("( " + FOX + " OR " + LIPSUM + " ) AND ( "
				+ LIPSUM + " OR " + FOX + " )"));
	}

	@Test
	public void testDeepNesting() {
		shouldAccept(cond,
				TreeSample.from( //
						"+ cond/disj/conj/atom/nested", //
						"  > (", //
						"  + cond/disj/conj/atom/nested", //
						"    > (", //
						"    + cond/disj/conj/atom/unknown", //
						"      > A", //
						"    > )", //
						"  > )" //
				));

		// Going overboard on the parentheses.
		shouldAccept(cond, spaced(
				"( ( ( ( ( ( " + FOX + " ) ) ) ) OR " + LIPSUM + " ) )"));
	}

	@Test
	public void testIssue() {
		shouldAccept(cond,
				TreeSample.from( //
						"+ cond/disj/conj", //
						"  + atom/nested", //
						"    > (", //
						"    + cond/disj", //
						"      + conj/atom/unknown", //
						"        > A", //
						"      > OR", //
						"      + conj/atom/unknown", //
						"        > B", //
						"    > )", //
						"  > AND", //
						"  + atom/unknown", //
						"    > C" //
				));
	}
}
