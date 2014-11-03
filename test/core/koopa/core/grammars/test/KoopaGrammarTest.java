package koopa.core.grammars.test;

import static koopa.core.grammars.test.TestTag.CHARACTER_STRING;
import static koopa.core.data.tags.IslandTag.LAND;

import java.util.List;

import koopa.core.grammars.KoopaGrammar;
import koopa.core.grammars.Opt;
import koopa.core.parsers.Parser;

import org.junit.Test;

/**
 * Tries to put the basic parser combinators offered in a
 * {@linkplain KoopaGrammar} to the test.
 */
public class KoopaGrammarTest extends GrammarTest {

	public static final String SEPARATOR = "$SEP$";

	public KoopaGrammarTest() {
		super(SEPARATOR);
	}

	@Test
	public void testCanMatchASingleToken() {
		Parser parser = G.token("COBOL");
		List<Object> input = input("COBOL");

		shouldAccept(parser, input);
	}

	@Test
	public void testTokenMustMatch() {
		Parser parser = G.token("COBOL");

		List<Object> input = input("PL/I");
		shouldReject(parser, input);
	}

	@Test
	public void testCanSkipSeparators() {
		Parser parser = G.token("COBOL");

		List<Object> input = input(SEPARATOR, SEPARATOR, "COBOL");
		shouldAccept(parser, input);
	}

	@Test
	public void testCanMatchSeparators() {
		Parser parser = G.token(SEPARATOR);

		List<Object> input = input(SEPARATOR);
		shouldAccept(parser, input);
	}

	@Test
	public void testCanPreventSkippingSeparators() {
		Parser parser = G.opt(Opt.NOSKIP, G.token("COBOL"));

		shouldAccept(parser, input("COBOL"));
		shouldReject(parser, input(SEPARATOR, "COBOL"));
		shouldReject(parser, input(SEPARATOR, SEPARATOR, "COBOL"));
	}

	@Test
	public void testCanStillMatchSeparatorsWhenNotSkippingThem() {
		Parser parser = G.opt(Opt.NOSKIP,
				G.sequence(G.token(SEPARATOR), G.token("COBOL")));

		shouldReject(parser, input("COBOL"));
		shouldAccept(parser, input(SEPARATOR, "COBOL"));
		shouldReject(parser, input(SEPARATOR, SEPARATOR, "COBOL"));
	}

	@Test
	public void testCanMatchAnyToken() {
		Parser parser = G.any();

		// Any token will do.
		shouldAccept(parser, input("COBOL"));
		shouldAccept(parser, input("PL/I"));

		// They can be preceded by separators.
		shouldAccept(parser, input(SEPARATOR, SEPARATOR, "COBOL"));

		// But there must be one though.
		shouldReject(parser, input());
	}

	@Test
	public void testCanMatchASequenceOfTokens() {
		Parser parser = G.sequence(G.token("COmmon"), G.token("Business"),
				G.token("Oriented"), G.token("Language"));

		List<Object> input = input("COmmon", "Business", "Oriented", "Language");

		shouldAccept(parser, input);
	}

	@Test
	public void testSequenceOfTokensMustBeInOrder() {
		Parser parser = G.sequence(G.token("COmmon"), G.token("Business"),
				G.token("Oriented"), G.token("Language"));

		List<Object> input = input("Oriented", "Language", "COmmon", "Business");

		shouldReject(parser, input);
	}

	@Test
	public void testCanMatchPermutationsOfTokens() {
		Parser parser = G.permuted(G.token("COmmon"), G.token("Business"),
				G.token("Oriented"), G.token("Language"));

		// Any order of tokens will do.
		shouldAccept(parser,
				input("COmmon", "Business", "Oriented", "Language"));
		shouldAccept(parser,
				input("Language", "Oriented", "COmmon", "Business"));

		// Any number of tokens will do.
		shouldAccept(parser, input("COmmon", "Language"));
		shouldAccept(parser, input("Business", "Language"));
		shouldAccept(parser, input("Language"));
	}

	@Test
	public void testPermutationsMatchEachItemAtMostOnce() {
		Parser parser = G.permuted(G.token("COmmon"), G.token("Business"),
				G.token("Oriented"), G.token("Language"));

		shouldReject(parser, input("COmmon", "Business", "COmmon", "Language"));
	}

	@Test
	public void testCanMatchOneOf() {
		Parser parser = G.choice(G.token("COmmon"), G.token("Business"),
				G.token("Oriented"), G.token("Language"));

		shouldAccept(parser, input("COmmon"));
		shouldAccept(parser, input("Business"));
		shouldAccept(parser, input("Oriented"));
		shouldAccept(parser, input("Language"));

		shouldReject(parser, input("PL/I"));
	}

	@Test
	public void testCanMatchZeroOrMore() {
		Parser parser = G.star(G.token("Developers!"));

		shouldAccept(parser, input());
		shouldAccept(parser, input("Developers!"));
		shouldAccept(parser, input("Developers!", "Developers!"));
		shouldAccept(parser, input("Developers!", "Developers!", "Developers!"));
	}

	@Test
	public void testCanMatchOneOrMore() {
		Parser parser = G.plus(G.token("Developers!"));

		shouldAccept(parser, input("Developers!"));
		shouldAccept(parser, input("Developers!", "Developers!"));
		shouldAccept(parser, input("Developers!", "Developers!", "Developers!"));

		shouldReject(parser, input());
	}

	@Test
	public void testCanMatchOptional() {
		Parser parser = G.optional(G.token("Grace"));

		shouldAccept(parser, input("Grace"));
		shouldAccept(parser, input());
	}

	@Test
	public void testCanHandleNegation() {
		Parser parser = G.sequence(G.token("Grace"), G.not(G.token("Kelly")),
				G.any());

		shouldAccept(parser, input("Grace", "Hopper"));
		shouldAccept(parser, input("Grace", "Murray"));

		shouldReject(parser, input("Grace", "Kelly"));
	}

	@Test
	public void testCanSkipTokens() {
		Parser parser = G.sequence(G.token("COmmon"),
				G.skipto(G.token("Language")), G.token("Language"));

		shouldAccept(parser, input("COmmon", "Language"));
		shouldAccept(parser, input("COmmon", "Business", "Language"));
		shouldAccept(parser,
				input("COmmon", "Business", "Oriented", "Language"));

		shouldReject(parser, input("COmmon", "Something", "Or", "Other"));
	}

	@Test
	public void testCanMatchOneTag() {
		Parser parser = G.sequence(G.tagged(CHARACTER_STRING), G.any());

		shouldAccept(parser, input(CHARACTER_STRING, "COBOL"));
		shouldAccept(parser, input(CHARACTER_STRING, "PL/I"));

		shouldReject(parser, input("Java"));
	}

	@Test
	public void testCanMatchMultipleTags() {
		Parser parser = G.sequence(G.tagged(CHARACTER_STRING), G.tagged(LAND),
				G.any());

		shouldAccept(parser, input(CHARACTER_STRING, LAND, "COBOL"));
		shouldAccept(parser, input(CHARACTER_STRING, LAND, "PL/I"));
		shouldAccept(parser, input(LAND, CHARACTER_STRING, "COBOL"));

		shouldReject(parser, input(CHARACTER_STRING, "COBOL"));
		shouldReject(parser, input(LAND, "COBOL"));
		shouldReject(parser, input("Cobol"));
	}

	// TODO Add some recursive tests.
}
