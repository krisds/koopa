package koopa.core.streams.test;

import org.junit.Test;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.test.HardcodedSource;
import koopa.core.streams.BaseStream;
import koopa.core.streams.LimitedStream;
import koopa.core.targets.ListTarget;

/**
 * Tests the core operations which make up a {@linkplain BaseStream}.
 */
public class LimitedStreamTest extends ParseStreamTest {

	// This is so I can set up a root parser on the parse stack. Without it the
	// LimitedStream would commit the stream too soon.
	private static final class Dummy extends ParserCombinator {
		@Override
		public boolean matches(Parse parse) {
			return false;
		}
	}

	private static final class NthWord extends ParserCombinator {
		private final int n;

		public NthWord(int n) {
			this.n = n;
		}

		@Override
		public boolean matches(Parse parse) {
			final Data d = parse.getStream().forward();
			return d != null && d instanceof Token && WORDS[n].equals(((Token) d).getText());
		}
	}

	private static final Object[] WORDS = "The quick brown fox jumped over the lazy dog"
			.split("\\s+");

	@Test
	public void testCanStream() {
		for (int n = 0; n < WORDS.length; n++) {
			final HardcodedSource source = HardcodedSource.from(WORDS);
			final ListTarget target = new ListTarget();
			final Parse parse = Parse.of(source).to(target);

			final LimitedStream limitedStream = parse.getFlow().getLimitedStream();
			final NthWord limiter = new NthWord(n);
			limitedStream.addLimiter(limiter);

			parse.getStack().push(new Dummy());

			assertCanStream(limitedStream, WORDS, n, target);
			limitedStream.removeLimiter(limiter);
		}
	}

	@Test
	public void testCanRewind() {
		for (int n = 0; n < WORDS.length; n++) {
			final HardcodedSource source = HardcodedSource.from(WORDS);
			final ListTarget target = new ListTarget();
			final Parse parse = Parse.of(source).to(target);

			final LimitedStream limitedStream = parse.getFlow().getLimitedStream();
			final NthWord limiter = new NthWord(n);
			limitedStream.addLimiter(limiter);

			parse.getStack().push(new Dummy());

			assertCanRewind(limitedStream, WORDS, n, target);
			limitedStream.removeLimiter(limiter);
		}
	}

	@Test
	public void testCanBookmark() {
		for (int n = 0; n < WORDS.length; n++) {
			final HardcodedSource source = HardcodedSource.from(WORDS);
			final ListTarget target = new ListTarget();
			final Parse parse = Parse.of(source).to(target);

			final LimitedStream limitedStream = parse.getFlow().getLimitedStream();
			final NthWord limiter = new NthWord(n);
			limitedStream.addLimiter(limiter);

			parse.getStack().push(new Dummy());

			assertCanBookmark(limitedStream, WORDS, n, target);
			limitedStream.removeLimiter(limiter);
		}
	}
}
