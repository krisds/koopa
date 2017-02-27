package koopa.core.streams.test;

import junit.framework.TestCase;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Stream;
import koopa.core.targets.ListTarget;

/**
 * Base for testing the core operations which make up a {@linkplain Stream}.
 */
public abstract class ParseStreamTest extends TestCase {

	protected void assertCanStream(Stream stream, Object[] words,
			ListTarget target) {
		assertCanStream(stream, words, words.length, target);
	}

	protected void assertCanStream(Stream stream, Object[] words, int endIndex,
			ListTarget target) {

		// We just step through all words, until there are no more.
		for (int i = 0; i < endIndex; i++) {
			assertPeekMatchesWord(stream, words[i]);
			assertNextTokenMatchesWord(stream, words[i]);
		}

		// We expect the stream to be at its end now.
		assertNoMoreTokens(stream);

		// At this point the target should still be empty.
		assertTrue(target.isEmpty());

		// When committing the stream all words should end up in the target.
		stream.commit();
		assertTargetHasAllWords(target, words, endIndex);
	}

	protected void assertCanRewind(Stream stream, Object[] words,
			ListTarget target) {
		assertCanRewind(stream, words, words.length, target);
	}

	protected void assertCanRewind(Stream stream, Object[] words, int endIndex,
			ListTarget target) {

		// Each loop we step through all words and rewind all of them. But
		// before the next loop we push one token to the target, so each
		// iteration will have one less token to work with.
		for (int w = 0; w < endIndex; w++) {
			for (int i = w; i < endIndex; i++) {
				assertPeekMatchesWord(stream, words[i]);
				assertNextTokenMatchesWord(stream, words[i]);
			}

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

		// We expect the stream to be at its end now.
		assertNoMoreTokens(stream);

		// And all words should have ended up in the target.
		assertTargetHasAllWords(target, words, endIndex);
	}

	protected void assertCanBookmark(Stream stream, Object[] words,
			ListTarget target) {
		assertCanBookmark(stream, words, words.length, target);
	}

	protected void assertCanBookmark(Stream stream, Object[] words,
			int endIndex, ListTarget target) {
		// Each loop we step through all words and rewind all of them. But
		// before the next loop we push one token to the target, so each
		// iteration will have one less token to work with.
		for (int w = 0; w < endIndex; w++) {
			for (int i = w; i < endIndex; i++) {
				assertPeekMatchesWord(stream, words[i]);
				assertNextTokenMatchesWord(stream, words[i]);
			}

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

		// We expect the stream to be at its end now.
		assertNoMoreTokens(stream);

		// Because we bookmarked at the end of each loop there is still one
		// outstanding bookmark left.
		stream.commit();
		assertEquals(0, target.size());

		// This time there are no bookmarks left, and committing will push all
		// tokens to the target.
		stream.commit();
		assertTargetHasAllWords(target, words, endIndex);
	}

	// =========================================================================

	private void assertPeekMatchesWord(Stream stream, Object text) {
		final Data d = stream.peek();
		if (text == null)
			assertNull(d);
		else {
			assertNotNull(d);
			assertTrue(d instanceof Token);
			assertTrue(((Token) d).getText().equals(text));
		}
	}

	private void assertNextTokenMatchesWord(Stream stream, Object text) {
		final Data d = stream.forward();
		if (text == null)
			assertNull(d);
		else {
			assertNotNull(d);
			assertTrue(d instanceof Token);
			assertTrue(((Token) d).getText().equals(text));
		}
	}

	private void assertNoMoreTokens(Stream stream) {
		assertNull(stream.peek());
		assertNull(stream.forward());
	}

	private void assertTargetHasAllWords(ListTarget target, Object[] words,
			int endIndex) {
		assertEquals(endIndex, target.size());

		for (int i = 0; i < endIndex; i++) {
			Data packet = target.get(i);
			assertTrue(packet instanceof Token);
			final Token token = (Token) packet;
			assertEquals(words[i], token.getText());
		}
	}
}
