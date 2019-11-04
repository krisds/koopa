package koopa.core.parsers.combinators.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import koopa.core.grammars.test.GrammarTest;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.combinators.Balancing;
import koopa.core.parsers.combinators.NotNested;
import koopa.core.parsers.combinators.UnaryParserDecorator;

// TODO Redo with a fluent grammar ?
public class BalancingTest extends GrammarTest {

	private final ParserCombinator openParen = G.literal("(");
	private final ParserCombinator closeParen = G.literal(")");
	private final ParserCombinator openBrace = G.literal("{");
	private final ParserCombinator closeBrace = G.literal("}");
	private final ParserCombinator openBracket = G.literal("[");
	private final ParserCombinator closeBracket = G.literal("]");

	private final ParserCombinator any = G.notAKeyword(G.any());

	@Test
	public void testBalancing() {
		final BalancingTracker state = new BalancingTracker(any);
		final ParserCombinator balancing = G.balancing(//
				openParen, closeParen, //
				G.star(state));

		shouldAccept(balancing, spaced("one ( two three ) four"));

		final List<Boolean> expected = Arrays.asList(new Boolean[] { //
				true, false, false, false, false, true });
		Assert.assertEquals(expected.size(), state.actual.size());
		Assert.assertEquals(expected, state.actual);
	}

	@Test
	public void testBalancingAtStart() {
		final BalancingTracker state = new BalancingTracker(any);
		final ParserCombinator balancing = G.balancing(//
				openParen, closeParen, //
				G.star(state));

		shouldAccept(balancing, spaced("( one two three ) four"));

		final List<Boolean> expected = Arrays.asList(new Boolean[] { //
				false, false, false, false, false, true });
		Assert.assertEquals(expected.size(), state.actual.size());
		Assert.assertEquals(expected, state.actual);
	}

	@Test
	public void testMultiplePairs() {
		final ParserCombinator a = G.literal("A");
		final NotNested outside = new NotNested(a);

		final ParserCombinator sequence = G.sequence( //
				any, any, outside, any, any);

		final ParserCombinator balancing = G.balancing(openBrace, closeBrace, //
				openBracket, closeBracket, //
				sequence);

		shouldAccept(balancing, spaced("A A A A A"));
		shouldAccept(balancing, spaced("A ( A ) A"));

		shouldReject(balancing, spaced("A [ A ] A"));
		shouldReject(balancing, spaced("A { A } A"));
	}

	@Test
	public void testNotNested() {
		final ParserCombinator a = G.literal("A");
		final NotNested outside = new NotNested(a);

		final ParserCombinator sequence = G.sequence( //
				any, any, outside, any, any);

		final ParserCombinator balancing = G.balancing(//
				openParen, closeParen, //
				sequence);

		shouldAccept(balancing, spaced("A A A A A"));
		shouldAccept(balancing, spaced("( ) A ( )"));

		shouldReject(balancing, spaced("A ( A ) A"));
		shouldReject(balancing, spaced("( A A A )"));
		shouldReject(balancing, spaced("( ( A ) )"));

		shouldAccept(balancing, spaced("A [ A ] A"));
		shouldAccept(balancing, spaced("A { A } A"));
	}

	@Test
	public void testNested() {
		// This accepts anything, as long as it is nested.
		final ParserCombinator nested = G.balancing( //
				G.literal("("), G.literal(")"), //
				G.star(G.nested(G.any())) //
		);

		shouldAccept(nested, spaced("( ONE TWO THREE )"));
		shouldReject(nested, spaced("ONE TWO THREE"));

		// This tests that the matching of tested elements stops where we expect
		// it.
		final ParserCombinator nestedAndMore = G.sequence( //
				nested, //
				G.literal(")"), G.token("A"));

		shouldAccept(nestedAndMore, spaced("( ONE TWO THREE ) ) A"));
		shouldReject(nestedAndMore, spaced("ONE TWO THREE ) A"));
	}

	// ========================================================================

	private class BalancingTracker extends UnaryParserDecorator {
		public final List<Boolean> actual = new LinkedList<>();

		public BalancingTracker(ParserCombinator parser) {
			super(parser);
		}

		@Override
		protected boolean matches(Parse parse) {
			final Frame frame = parse.getStack().find(Balancing.Balancer.class);

			final Balancing.Balancer balancing = (Balancing.Balancer) frame
					.getParser();

			final boolean balanced = balancing == null
					|| balancing.isBalanced();

			final boolean accepts = parser.accepts(parse);

			if (accepts)
				actual.add(balanced);

			return accepts;
		}
	}
}
