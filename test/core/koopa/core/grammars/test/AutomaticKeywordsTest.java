package koopa.core.grammars.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack;
import koopa.core.parsers.combinators.Opt;

import org.junit.Test;

/**
 * Koopa grammars support automatic and context-sensitive detection of keywords.
 * This makes it easy for you to test whether something word is reserved without
 * having to do your own bookkeeping, or coding an extra lookup table.
 * <p>
 * This test exercises the keyword behaviour while explaining how it works
 * logically.
 */
public class AutomaticKeywordsTest extends GrammarTest {

	public static final String SEPARATOR = "$SEP$";

	public AutomaticKeywordsTest() {
		super(SEPARATOR);
	}

	/**
	 * Tokens are scoped by the grammar rule they are in. Within that scope all
	 * these tokens are considered to be reserved as keywords.
	 * <p>
	 * E.g., given:
	 * 
	 * <pre>
	 * def hello =
	 *   HELLO ( WORLD | KOOPA )
	 * end
	 * </pre>
	 * 
	 * All words within the <code>hello</code> rule (i.e. <code>HELLO</code>,
	 * <code>WORLD</code> and <code>KOOPA</code>), are keywords. Any other word
	 * (e.g. <code>GOODBYE</code>) would not be.
	 */
	@Test
	public void testBasicScope() {
		// This is a pretty complete list of all possible parsers.
		ParserCombinator[] differentPossibleParsers = new ParserCombinator[] {
				G.choice(G.token("CHOICE_ONE"), G.token("CHOICE_TWO")),
				G.tagged("COBOL"),
				G.optional(G.token("OPTIONAL")),
				G.plus(G.token("PLUS")),
				G.star(G.token("STAR")),
				G.permuted(G.token("PERMUTED_ONE"), G.token("PERMUTED_TWO")),
				G.any(),
				G.as("name", G.token("AS")),
				G.dispatched(
						new String[] { "LEADING_ONE", "LEADING_TWO" },
						new ParserCombinator[] { G.token("LEADING_ONE"),
								G.token("LEADING_TWO") }), G.eof(),
				G.limited(G.token("LIMITED"), G.token("LIMITER")),
				G.not(G.token("NOT")), //
				G.opt(Opt.NOSKIP, G.token("OPT")), //
				G.skipto(G.token("SKIP_TO")) };

		// And these are all words appearing in those parsers.
		String[] words = new String[] { "CHOICE_ONE", "CHOICE_TWO", "OPTIONAL",
				"PLUS", "STAR", "PERMUTED_ONE", "PERMUTED_TWO", "AS",
				"LEADING_ONE", "LEADING_TWO", "LIMITED", "OPT" };

		// This combines all parsers into one sequence.
		ParserCombinator sequence = G.sequence(differentPossibleParsers);

		// And this gives them a well-defined scope.
		FutureParser scoped = G.scoped("name");
		scoped.setParser(sequence);

		// While matching anything in that scope, all words should be identified
		// as keywords. While any other word (here: "HELLO") should not.
		whileMatching(scoped).keywordsInclude(words).and
				.keywordsExclude("HELLO");
	}

	/**
	 * Tokens belonging to referenced rules should not be part of the scope,
	 * unless they are leading the referenced rule.
	 * <p>
	 * E.g., given:
	 * 
	 * <pre>
	 * def hello =
	 *   HELLO subject
	 * end
	 * 
	 * def subject =
	 *   (SWEET WORLD | KOOPA)
	 * end
	 * </pre>
	 * 
	 * The <code>hello</code> rule would have <code>HELLO</code> as a keyword,
	 * because this appears directly as a token in that rule. It would also have
	 * <code>SWEET</code> and <code>KOOPA</code> as keywords, because these are
	 * leading words in the referenced rule <code>subject</code>.
	 */
	@Test
	public void testReferencedScope() {
		FutureParser subject = G.scoped("subject");
		subject.setParser(G.choice(
				G.sequence(G.token("SWEET"), G.token("WORLD")),
				G.token("KOOPA")));

		FutureParser hello = G.scoped("hello");
		hello.setParser(G.sequence(G.token("HELLO"), subject));

		whileMatching(subject).keywordsInclude("SWEET", "WORLD", "KOOPA");
		whileMatching(hello).keywordsInclude("HELLO", "SWEET", "KOOPA").and
				.keywordsExclude("WORLD");
	}

	/**
	 * Literals are never considered possible keywords.
	 * <p>
	 * E.g., given:
	 * 
	 * <pre>
	 * def hello =
	 *   'HELLO' subject
	 * end
	 * 
	 * def subject =
	 *   ('SWEET' 'WORLD' | 'KOOPA')
	 * end
	 * </pre>
	 * 
	 * This time the <code>hello</code> rule will know no keywords.
	 */
	@Test
	public void testLiterals() {
		FutureParser subject = G.scoped("subject");
		subject.setParser(G.choice(
				G.sequence(G.literal("SWEET"), G.literal("WORLD")),
				G.literal("KOOPA")));

		FutureParser hello = G.scoped("hello");
		hello.setParser(G.sequence(G.literal("HELLO"), subject));

		whileMatching(subject).keywordsExclude("SWEET", "WORLD", "KOOPA");
		whileMatching(hello)
				.keywordsExclude("SWEET", "KOOPA", "HELLO", "WORLD");
	}

	/**
	 * Keywords are impacted by dynamic scope. That is, any executing scope will
	 * contribute its keywords to the full set of active keywords.
	 * <p>
	 * E.g., given:
	 * 
	 * <pre>
	 * def hello =
	 *   HELLO subject
	 * end
	 * 
	 * def subject =
	 *   BLUE WORLD
	 * end
	 * </pre>
	 * 
	 * While matching <code>hello</code> the active keywords are just
	 * <code>HELLO</code> and <code>BLUE</code>.
	 * <p>
	 * While matching <code>subject</code> within <code>hello</code> the active
	 * keywords will be <code>BLUE</code> and <code>WORLD</code>, as you'd
	 * expect, but <b>also</b> <code>HELLO</code> because the active
	 * <code>hello</code> rule will contribute its keywords as well.
	 */
	@Test
	public void testDynamicScope() {
		FutureParser subject = G.scoped("subject");
		subject.setParser(G.sequence(G.token("BLUE"), G.token("WORLD")));

		FutureParser hello = G.scoped("hello");
		hello.setParser(G.sequence(G.token("HELLO"), subject));

		whileMatching(hello).keywordsInclude("HELLO", "BLUE").and
				.keywordsExclude("WORLD");

		whileMatching(subject, hello).keywordsInclude("HELLO", "BLUE", "WORLD");
	}

	// ------------------------------------------

	private Stack stack(ParserCombinator... context) {
		Stack stack = new Stack();
		for (int i = context.length - 1; i >= 0; i--)
			stack.push(context[i]);
		return stack;
	}

	private StackAssertions whileMatching(ParserCombinator... context) {
		return new StackAssertions(stack(context));
	}

	private class StackAssertions {
		private Stack stack;

		public StackAssertions and = this;

		public StackAssertions(Stack stack) {
			this.stack = stack;
		}

		public StackAssertions keywordsInclude(String... words) {
			for (String word : words)
				assertTrue("'" + word + "' should be a keyword",
						stack.isKeyword(G.comparableText(word)));

			return this;
		}

		public StackAssertions keywordsExclude(String... words) {
			for (String word : words)
				assertFalse("'" + word + "' should not be a keyword",
						stack.isKeyword(G.comparableText(word)));

			return this;
		}
	}
}
