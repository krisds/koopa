package koopa.tokenstreams.test;

import junit.framework.TestCase;
import koopa.tokenizers.cobol.TestTokenizer;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenStream;
import koopa.tokenstreams.generic.MainTokenStream;
import koopa.tokenstreams.generic.SubordinateTokenStream;

import org.junit.Test;

public class SubordinateTokenStreamTest extends TestCase {

	@Test
	public void test_1() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");

		MainTokenStream main = new MainTokenStream(test);
		SubordinateTokenStream stream = new SubordinateTokenStream(main);

		assertNextToken(stream, "ZERO");
		assertNextToken(stream, "ONE");
		assertNextToken(stream, "TWO");
		assertNextToken(stream, "THREE");
		assertNextToken(stream, "FOUR");
		assertNextToken(stream, "FIVE");
		assertNextToken(stream, "SIX");
		assertNextToken(stream, "SEVEN");
		assertNextToken(stream, "EIGHT");
		assertNextToken(stream, "NINE");
		assertNoNextToken(stream);
	}

	@Test
	public void test_2() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");

		MainTokenStream main = new MainTokenStream(test);
		SubordinateTokenStream stream = new SubordinateTokenStream(main);

		Token t = assertNextToken(stream, "ZERO");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "ONE");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "TWO");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "THREE");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "FOUR");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "FIVE");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "SIX");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "EIGHT");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "SEVEN");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		t = assertNextToken(stream, "NINE");
		stream.pushback(t);
		assertSame(t, stream.nextToken());

		assertNoNextToken(stream);
	}

	@Test
	public void test_3() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");

		MainTokenStream main = new MainTokenStream(test);
		SubordinateTokenStream stream = new SubordinateTokenStream(main);

		int count = 0;
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "ZERO");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "ONE");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "TWO");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "THREE");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "FOUR");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "FIVE");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "SIX");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "SEVEN");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "EIGHT");
		stream.mark(new TestMarker(count++));
		assertNextToken(stream, "NINE");
		stream.mark(new TestMarker(count++));
		assertNoNextToken(stream);
	}

	@Test
	public void test_4() {
		TestTokenizer test = new TestTokenizer("ZERO ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE");

		MainTokenStream main = new MainTokenStream(test);
		SubordinateTokenStream stream = new SubordinateTokenStream(main);

		assertNextToken(stream, "ZERO");
		stream.restore();

		assertNextToken(stream, "ZERO");
		assertNextToken(stream, "ONE");
		stream.restore();

		assertNextToken(stream, "ZERO");
		assertNextToken(stream, "ONE");
		assertNextToken(stream, "TWO");
		stream.restore();

		assertNextToken(stream, "ZERO");
		assertNextToken(stream, "ONE");
		assertNextToken(stream, "TWO");
		assertNextToken(stream, "THREE");
		stream.commit();

		assertNextToken(stream, "FOUR");
		stream.restore();

		assertNextToken(stream, "FOUR");
		assertNextToken(stream, "FIVE");
		stream.restore();

		assertNextToken(stream, "FOUR");
		assertNextToken(stream, "FIVE");
		assertNextToken(stream, "SIX");
		stream.restore();

		assertNextToken(stream, "FOUR");
		assertNextToken(stream, "FIVE");
		stream.mark(new TestMarker(0));
		assertNextToken(stream, "SIX");
		assertNextToken(stream, "SEVEN");
		stream.mark(new TestMarker(1));
		assertNextToken(stream, "EIGHT");
		assertNextToken(stream, "NINE");
		stream.restore();

		assertNextToken(stream, "FOUR");
		assertNextToken(stream, "FIVE");
		assertNextToken(stream, "SIX");
		assertNextToken(stream, "SEVEN");
		assertNextToken(stream, "EIGHT");
		assertNextToken(stream, "NINE");

		assertNoNextToken(stream);
	}

	// =========================================================================

	private Token assertNextToken(TokenStream stream, String text) {
		Token token = stream.nextToken();
		assertNotNull(token);
		token.getText().equals(text);
		return token;
	}

	private void assertNoNextToken(TokenStream stream) {
		assertNull(stream.nextToken());
	}
}
