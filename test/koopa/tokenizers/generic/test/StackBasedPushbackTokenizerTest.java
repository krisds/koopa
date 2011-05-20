package koopa.tokenizers.generic.test;

import junit.framework.TestCase;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.TestTokenizer;
import koopa.tokenizers.generic.BasicPushbackTokenizer;
import koopa.tokens.Token;

import org.junit.Test;

public class StackBasedPushbackTokenizerTest extends TestCase {

	@Test
	public void testTokenizer_1() {
		TestTokenizer test = new TestTokenizer("");
		BasicPushbackTokenizer stack = new BasicPushbackTokenizer(test);

		assertNoNextToken(stack);

		assertFalse(test.hasQuit());
		stack.quit();
		assertTrue(test.hasQuit());
	}

	@Test
	public void testTokenizer_2() {
		TestTokenizer test = new TestTokenizer("ZERO");
		BasicPushbackTokenizer stack = new BasicPushbackTokenizer(test);

		assertNextToken(stack, "ZERO");
		assertNoNextToken(stack);

		assertFalse(test.hasQuit());
		stack.quit();
		assertTrue(test.hasQuit());
	}

	@Test
	public void testTokenizer_3() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");
		BasicPushbackTokenizer stack = new BasicPushbackTokenizer(test);

		assertNextToken(stack, "ZERO");
		assertNextToken(stack, "ONE");
		assertNextToken(stack, "TWO");
		assertNextToken(stack, "THREE");
		assertNextToken(stack, "FOUR");
		assertNextToken(stack, "FIVE");
		assertNextToken(stack, "SIX");
		assertNextToken(stack, "SEVEN");
		assertNextToken(stack, "EIGHT");
		assertNextToken(stack, "NINE");
		assertNoNextToken(stack);

		assertFalse(test.hasQuit());
		stack.quit();
		assertTrue(test.hasQuit());
	}

	@Test
	public void testTokenizer_4() {
		TestTokenizer test = new TestTokenizer("ZERO");
		BasicPushbackTokenizer stack = new BasicPushbackTokenizer(test);

		Token token = assertNextToken(stack, "ZERO");
		assertNoNextToken(stack);

		stack.pushback(token);
		assertNextToken(stack, "ZERO");
		assertNoNextToken(stack);

		stack.pushback(token);
		assertNextToken(stack, "ZERO");
		assertNoNextToken(stack);

		assertFalse(test.hasQuit());
		stack.quit();
		assertTrue(test.hasQuit());
	}

	// =========================================================================

	private Token assertNextToken(Tokenizer stack, String text) {
		Token token = stack.nextToken();
		assertNotNull(token);
		token.getText().equals(text);
		return token;
	}

	private void assertNoNextToken(Tokenizer stack) {
		assertNull(stack.nextToken());
	}
}
