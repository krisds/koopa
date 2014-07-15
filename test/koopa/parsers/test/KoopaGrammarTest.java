package koopa.parsers.test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static koopa.tokenizers.cobol.tags.SyntacticTag.CHARACTER_STRING;
import koopa.parsers.Parser;
import koopa.tokenizers.Tokenizer;

import org.junit.Test;

public class KoopaGrammarTest {

	// TODO Hide the complexity of the noisy end-of-input marker token.

	private static final TestGrammar G = new TestGrammar();

	@Test
	public void testCanMatchASingleToken() {
		Parser parser = G.token("COBOL");

		assertTrue(parser.accepts(input_of("COBOL")));
	}

	@Test
	public void testTokenMustMatch() {
		Parser parser = G.token("COBOL");

		assertFalse(parser.accepts(input_of("PL/I")));
	}

	@Test
	public void testCanMatchAnyToken() {
		Parser parser = G.any();

		// Any token will do.
		assertTrue(parser.accepts(input_of("COBOL")));
		assertTrue(parser.accepts(input_of("PL/I")));

		// But there must be one though.
		assertFalse(parser.accepts(input_of()));
	}

	@Test
	public void testCanMatchASequenceOfTokens() {
		Parser parser = G.sequence(G.token("COmmon"), G.token("Business"),
				G.token("Oriented"), G.token("Language"));

		assertTrue(parser.accepts(input_of("COmmon", "Business", "Oriented",
				"Language")));
	}

	@Test
	public void testCanMatchPermutationsOfTokens() {
		Parser parser = G.sequence(
				G.permuted(G.token("COmmon"), G.token("Business"),
						G.token("Oriented")), G.token("Language"));

		// Any order of tokens will do.
		assertTrue(parser.accepts(input_of("COmmon", "Business", "Oriented",
				"Language")));
		assertTrue(parser.accepts(input_of("Business", "Oriented", "COmmon",
				"Language")));

		// Any number of tokens will do.
		assertTrue(parser.accepts(input_of("COmmon", "Language")));
		assertTrue(parser.accepts(input_of("Business", "Language")));
		assertTrue(parser.accepts(input_of("Language")));
	}

	@Test
	public void testPerumtationsMatchEachItemAtMostOnce() {
		Parser parser = G.sequence(
				G.permuted(G.token("COmmon"), G.token("Business"),
						G.token("Oriented")), G.token("Language"));

		assertFalse(parser.accepts(input_of("COmmon", "Business", "COmmon",
				"Language")));
	}

	@Test
	public void testCanMatchOneOf() {
		Parser parser = G.sequence(
				G.choice(G.token("COmmon"), G.token("Business"),
						G.token("Oriented")), G.token("Language"));

		assertTrue(parser.accepts(input_of("COmmon", "Language")));
		assertTrue(parser.accepts(input_of("Business", "Language")));
		assertTrue(parser.accepts(input_of("Oriented", "Language")));

		assertFalse(parser.accepts(input_of("Language")));
	}

	@Test
	public void testCanMatchZeroOrMore() {
		Parser parser = G.sequence(G.star(G.token("Developers!")),
				G.token("..."));

		assertTrue(parser.accepts(input_of("...")));
		assertTrue(parser.accepts(input_of("Developers!", "...")));
		assertTrue(parser
				.accepts(input_of("Developers!", "Developers!", "...")));
		assertTrue(parser.accepts(input_of("Developers!", "Developers!",
				"Developers!", "...")));
	}

	@Test
	public void testCanMatchOneOrMore() {
		Parser parser = G.sequence(G.plus(G.token("Developers!")),
				G.token("..."));

		assertTrue(parser.accepts(input_of("Developers!", "...")));
		assertTrue(parser
				.accepts(input_of("Developers!", "Developers!", "...")));
		assertTrue(parser.accepts(input_of("Developers!", "Developers!",
				"Developers!", "...")));

		assertFalse(parser.accepts(input_of("...")));
	}

	@Test
	public void testCanMatchOptional() {
		Parser parser = G.sequence(G.optional(G.token("Grace")),
				G.token("Hopper"));

		assertTrue(parser.accepts(input_of("Grace", "Hopper")));
		assertTrue(parser.accepts(input_of("Hopper")));
	}

	@Test
	public void testCanHandleNegation() {
		Parser parser = G.sequence(G.token("Grace"), G.not(G.token("Kelly")));

		assertTrue(parser.accepts(input_of("Grace", "Hopper")));
		assertFalse(parser.accepts(input_of("Grace", "Kelly")));
	}

	@Test
	public void testCanSkipTokens() {
		Parser parser = G.sequence(G.token("COmmon"),
				G.skipto(G.token("Language")), G.token("Language"));

		assertTrue(parser.accepts(input_of("COmmon", "Language")));
		assertTrue(parser.accepts(input_of("COmmon", "Business", "Language")));
		assertTrue(parser.accepts(input_of("COmmon", "Business", "Oriented",
				"Language")));

		assertFalse(parser.accepts(input_of("COmmon", "Something", "Or",
				"Other")));
	}

	@Test
	public void testCanMatchTags() {
		Parser parser = G.sequence(G.tagged(CHARACTER_STRING), G.any());

		// TODO Test tagged !
		assertTrue(parser
				.accepts(input_of(CHARACTER_STRING, "A character string.")));
		assertTrue(parser
				.accepts(input_of(CHARACTER_STRING, "Something else.")));
		assertFalse(parser.accepts(input_of("Whatever")));
	}

	private Tokenizer input_of(Object... tokens) {
		return new VerbatimTestTokenizer(tokens);
	}
}
