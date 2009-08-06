package koopa.parsers.test;

import static junit.framework.Assert.*;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class KoopaGrammarTest {

	private static TestGrammar grammar = new TestGrammar();

	@Test
	public void token_1() {
		Parser parser = grammar.scoped("test", grammar.token("TEXT"));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer("TEXT");
		assertTrue(parser.accepts(tokenizer));
	}

	@Test
	public void token_2() {
		Parser parser = grammar.scoped("test", grammar.token("TEXT"));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer("FUMBLE");
		assertFalse(parser.accepts(tokenizer));
	}

	@Test
	public void permuted_1() {
		Parser parser = grammar.scoped("test", grammar.sequence(grammar
				.permuted(grammar.token("A"), grammar.token("B"), grammar
						.token("C")), grammar.token(".")));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer("A", "B", "C", ".");
		assertTrue(parser.accepts(tokenizer));
	}

	@Test
	public void permuted_2() {
		Parser parser = grammar.scoped("test", grammar.sequence(grammar
				.permuted(grammar.token("A"), grammar.token("B"), grammar
						.token("C")), grammar.token(".")));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer("C", "B", "A", ".");
		assertTrue(parser.accepts(tokenizer));
	}

	@Test
	public void permuted_3() {
		Parser parser = grammar.scoped("test", grammar.sequence(grammar
				.permuted(grammar.token("A"), grammar.token("B"), grammar
						.token("C")), grammar.token(".")));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer("B", "C", ".");
		assertTrue(parser.accepts(tokenizer));
	}

	@Test
	public void permuted_4() {
		Parser parser = grammar.scoped("test", grammar.sequence(grammar
				.permuted(grammar.token("A"), grammar.token("B"), grammar
						.token("C")), grammar.token(".")));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer("A", "B", "A", ".");
		assertFalse(parser.accepts(tokenizer));
	}

	@Test
	public void permuted_5() {
		Parser parser = grammar.scoped("test", grammar.sequence(grammar
				.permuted(grammar.token("A"), grammar.token("B"), grammar
						.token("C")), grammar.token(".")));
		assertNotNull(parser);
		TestTokenizer tokenizer = new TestTokenizer(".");
		assertTrue(parser.accepts(tokenizer));
	}
}
