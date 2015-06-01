package koopa.core.parsers.test;

import junit.framework.TestCase;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.BaseStream;
import koopa.core.parsers.Stream;
import koopa.core.sources.test.HardcodedSource;
import koopa.core.targets.ListTarget;

import org.junit.Test;

/**
 * Tests the core operations which make up a {@linkplain Stream}.
 */
public class ParseStreamTest extends TestCase {

	private static final Object[] WORDS = "The quick brown fox jumped over the lazy dog"
			.split("\\s+");

	@Test
	public void testCanStream() {
		HardcodedSource source = HardcodedSource.from(WORDS);
		ListTarget target = new ListTarget();

		Stream stream = new BaseStream(source, target);

		// We just step through all words, until there are no more.
		for (int i = 0; i < WORDS.length; i++)
			assertNextTokenMatchesWord(stream, WORDS[i]);

		assertNoMoreTokens(stream);

		// At this point the target should still be empty.
		assertTrue(target.isEmpty());

		// When committing the stream all words should end up in the target.
		stream.commit();
		assertTargetHasAllWords(target, WORDS);
	}

	@Test
	public void testCanRewind() {
		HardcodedSource source = HardcodedSource.from(WORDS);
		ListTarget target = new ListTarget();

		Stream stream = new BaseStream(source, target);

		// Each loop we step through all words and rewind all of them. But
		// before the next loop we push one token to the target, so each
		// iteration will have one less token to work with.
		for (int w = 0; w < WORDS.length; w++) {
			for (int i = w; i < WORDS.length; i++)
				assertNextTokenMatchesWord(stream, WORDS[i]);

			// At the end of each iteration there should be no more tokens
			// coming available.
			assertNoMoreTokens(stream);

			// We then rewind all tokens.
			stream.rewind();

			// And here we "eat" one of them.
			stream.forward();
			stream.commit();

			assertEquals(w + 1, target.size());
		}

		assertNoMoreTokens(stream);

		assertTargetHasAllWords(target, WORDS);
	}

	@Test
	public void testCanBookmark() {
		HardcodedSource source = HardcodedSource.from(WORDS);
		ListTarget target = new ListTarget();

		Stream stream = new BaseStream(source, target);

		// Each loop we step through all words and rewind all of them. But
		// before the next loop we push one token to the target, so each
		// iteration will have one less token to work with.
		for (int w = 0; w < WORDS.length; w++) {
			for (int i = w; i < WORDS.length; i++)
				assertNextTokenMatchesWord(stream, WORDS[i]);

			// At the end of each iteration there should be no more tokens
			// coming available.
			assertNoMoreTokens(stream);

			// We then rewind all tokens.
			stream.rewind();

			// And here we "eat" one of them.
			stream.forward();
			stream.bookmark();

			// Note that because we're using bookmarks the target won't have
			// received any tokens yet.
			assertEquals(0, target.size());
		}

		assertNoMoreTokens(stream);

		// Because we bookmarked at the end of each loop there is still one
		// outstanding bookmark left.
		stream.commit();
		assertEquals(0, target.size());

		// This time there are no bookmarks left, and committing will push all
		// tokens to the target.
		stream.commit();
		assertTargetHasAllWords(target, WORDS);
	}

	// =========================================================================

	private Token assertNextTokenMatchesWord(Stream stream, Object text) {
		Token token = stream.forward();
		assertNotNull(token);
		token.getText().equals(text);
		return token;
	}

	private void assertNoMoreTokens(Stream stream) {
		assertNull(stream.forward());
	}

	private void assertTargetHasAllWords(ListTarget target, Object[] words) {
		assertEquals(words.length, target.size());

		for (int i = 0; i < words.length; i++) {
			Data packet = target.get(i);
			assertTrue(packet instanceof Token);
			final Token token = (Token) packet;
			assertEquals(words[i], token.getText());
		}
	}
}
