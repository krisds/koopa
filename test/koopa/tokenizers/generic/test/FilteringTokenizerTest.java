package koopa.tokenizers.generic.test;

import junit.framework.TestCase;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.TestTokenizer;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

import org.junit.Test;

public class FilteringTokenizerTest extends TestCase {

	private static final Object TAG = "TAG";

	@Test
	public void testTokenizer_1() {
		TestTokenizer test = new TestTokenizer("");
		FilteringTokenizer filter = new FilteringTokenizer(test, TAG);

		assertNoNextToken(filter);

		assertFalse(test.hasQuit());
		filter.quit();
		assertTrue(test.hasQuit());
	}

	@Test
	public void testTokenizer_2() {
		TestTokenizer test = new TestTokenizer("ZERO");
		FilteringTokenizer filter = new FilteringTokenizer(test, TAG);

		assertNoNextToken(filter);

		assertFalse(test.hasQuit());
		filter.quit();
		assertTrue(test.hasQuit());
	}

//	@Test
//	public void testTokenizer_3() {
//		TestTokenizer test = new TestTokenizer("ZERO");
//		test.addTag(0, TAG);
//
//		FilteringTokenizer filter = new FilteringTokenizer(test, TAG);
//
//		assertNextToken(filter, "ZERO");
//		assertNoNextToken(filter);
//
//		assertFalse(test.hasQuit());
//		filter.quit();
//		assertTrue(test.hasQuit());
//	}

	@Test
	public void testTokenizer_4() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");
		FilteringTokenizer filter = new FilteringTokenizer(test, TAG);

		assertNoNextToken(filter);

		assertFalse(test.hasQuit());
		filter.quit();
		assertTrue(test.hasQuit());
	}

//	@Test
//	public void testTokenizer_5() {
//		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");
//		test.addTag(0, TAG);
//		test.addTag(3, TAG);
//		test.addTag(7, TAG);
//
//		FilteringTokenizer filter = new FilteringTokenizer(test, TAG);
//
//		assertNextToken(filter, "ZERO");
//		assertNextToken(filter, "THREE");
//		assertNextToken(filter, "SEVEN");
//		assertNoNextToken(filter);
//
//		assertFalse(test.hasQuit());
//		filter.quit();
//		assertTrue(test.hasQuit());
//	}

	@Test
	public void testTokenizer_6() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");

		FilteringTokenizer filter = new FilteringTokenizer(test,
				new TokenFilter() {
					public boolean accepts(Token token) {
						return token.getText().startsWith("T");
					}
				});

		assertNextToken(filter, "TWO");
		assertNextToken(filter, "THREE");
		assertNoNextToken(filter);

		assertFalse(test.hasQuit());
		filter.quit();
		assertTrue(test.hasQuit());
	}

	@Test
	public void testTokenizer_7() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");

		FilteringTokenizer filter = new FilteringTokenizer(test,
				new TokenFilter() {
					public boolean accepts(Token token) {
						return token.getText().length() <= 3;
					}
				});

		assertNextToken(filter, "ONE");
		assertNextToken(filter, "TWO");
		assertNextToken(filter, "SIX");
		assertNoNextToken(filter);

		assertFalse(test.hasQuit());
		filter.quit();
		assertTrue(test.hasQuit());
	}

	// =========================================================================

	private Token assertNextToken(Tokenizer tokenizer, String text) {
		Token token = tokenizer.nextToken();
		assertNotNull(token);
		token.getText().equals(text);
		return token;
	}

	private void assertNoNextToken(Tokenizer tokenizer) {
		assertNull(tokenizer.nextToken());
	}
}
