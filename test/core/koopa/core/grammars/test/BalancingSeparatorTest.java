package koopa.core.grammars.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import koopa.core.grammars.combinators.Scoped;
import koopa.core.parsers.ParserCombinator;


public class BalancingSeparatorTest extends GrammarTest {

	public static final String SEP = "$SEP$";

	private ParserCombinator wall;

	public BalancingSeparatorTest() {
		super(SEP);
	}

	@BeforeEach
	public void setup() {
		final ParserCombinator open = G.literal("(");
		final ParserCombinator close = G.literal(")");

		// An explicitly matched parenthesised group: ( word ).
		final Scoped group = (Scoped) G.scoped("group");
		group.setParser(G.sequence(open, G.any(), close));

		// The body is a run of groups and bare words - like a select list
		// of items, some of them parenthesised.
		final Scoped item = (Scoped) G.scoped("item");
		item.setParser(G.choice(group, G.any()));
		final ParserCombinator body = G.plus(item);

		// The wall: ( %balancing ( body %upto { %notnested ) } ) ) - the
		// subquery production in miniature.
		final Scoped w = (Scoped) G.scoped("wall");
		w.setParser(G.sequence( //
				open, //
				G.balancing(open, close, //
						G.upTo(body, G.notNested(close))), //
				close));
		this.wall = w;
	}

	@Test
	public void testNestedCloseWithoutSeparator() {
		// ( ( x ) ) - the inner close is adjacent to its content.
		shouldAccept(wall, input("(", "(", "x", ")", ")"));
	}

	@Test
	public void testNestedCloseAfterSeparator() {
		// ( ( x $SEP$ ) ) - a separator precedes the inner close. This is
		// the regression: it must parse exactly like the adjacent form.
		shouldAccept(wall, input("(", "(", "x", SEP, ")", ")"));
	}

	@Test
	public void testNestedCloseAfterSeparatorDeeper() {
		// ( ( ( y $SEP$ ) $SEP$ ) ) - separators before two nested closes.
		shouldAccept(wall,
				input("(", "(", "(", "y", SEP, ")", SEP, ")", ")"));
	}
}
