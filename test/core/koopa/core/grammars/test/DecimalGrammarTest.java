package koopa.core.grammars.test;

import static koopa.core.grammars.test.TestTag.INTEGER_LITERAL;
import static koopa.core.grammars.test.TestTag.SIGNED;
import static koopa.core.grammars.test.TestTag.UNSIGNED;

import java.util.List;

import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Opt;

import org.junit.Test;

/**
 * This class tests a possible fix for issue #48
 * "Delay categorization of decimals". It let's the parser define decimals based
 * on {@linkplain TestTag#INTEGER_LITERAL} and separators.
 */
public class DecimalGrammarTest extends GrammarTest {

	public DecimalGrammarTest() {
		super(",");
	}

	/**
	 * This basically implements:
	 * 
	 * <pre>
	 *  integer %noskip ((','|'.') unsignedInteger)
	 * </pre>
	 */
	private ParserCombinator decimal() {
		final ParserCombinator integer = G.sequence(G.tagged(INTEGER_LITERAL),
				G.any());

		final ParserCombinator comma = G.choice(G.token(","), G.token("."));

		final ParserCombinator unsignedInteger = G.sequence(
				G.tagged(INTEGER_LITERAL), G.tagged(UNSIGNED), G.any());

		return G.sequence(integer,
				G.opt(Opt.NOSKIP, G.sequence(comma, unsignedInteger)));
	}

	/**
	 * This basically implements:
	 * 
	 * <pre>
	 *  integer+
	 * </pre>
	 */
	private ParserCombinator list() {
		return G.plus(G.sequence(G.tagged(INTEGER_LITERAL), G.any()));
	}

	@Test
	public void testCommaDecimal() {
		// 3,14
		List<Object> sample = input(UNSIGNED, INTEGER_LITERAL, "3");
		sample.addAll(input(","));
		sample.addAll(input(UNSIGNED, INTEGER_LITERAL, "14"));

		// This sample can be both a decimal and a list, so both should match.
		shouldAccept(decimal(), sample);
		shouldAccept(list(), sample);
	}

	@Test
	public void testDotDecimal() {
		// 3.14
		List<Object> sample = input(UNSIGNED, INTEGER_LITERAL, "3");
		sample.addAll(input("."));
		sample.addAll(input(UNSIGNED, INTEGER_LITERAL, "14"));

		shouldAccept(decimal(), sample);
		shouldReject(list(), sample);
	}

	@Test
	public void testSignedCommaDecimal() {
		// +3,14
		List<Object> sample = input(SIGNED, INTEGER_LITERAL, "+3");
		sample.addAll(input(","));
		sample.addAll(input(UNSIGNED, INTEGER_LITERAL, "14"));

		// This sample can be both a decimal and a list, so both should match.
		shouldAccept(decimal(), sample);
		shouldAccept(list(), sample);
	}

	@Test
	public void testSignedDotDecimal() {
		// +3.14
		List<Object> sample = input(SIGNED, INTEGER_LITERAL, "+3");
		sample.addAll(input("."));
		sample.addAll(input(UNSIGNED, INTEGER_LITERAL, "14"));

		shouldAccept(decimal(), sample);
		shouldReject(list(), sample);
	}

	@Test
	public void testSignedList() {
		// +3,+14
		List<Object> sample = input(SIGNED, INTEGER_LITERAL, "+3");
		sample.addAll(input(","));
		sample.addAll(input(SIGNED, INTEGER_LITERAL, "+14"));

		shouldReject(decimal(), sample);
		shouldAccept(list(), sample);
	}
}
