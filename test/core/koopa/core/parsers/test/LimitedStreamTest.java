package koopa.core.parsers.test;

import org.junit.Test;

import koopa.core.data.Token;
import koopa.core.parsers.BaseStream;
import koopa.core.parsers.LimitedStream;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;
import koopa.core.sources.test.HardcodedSource;
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
			final Token t = parse.getStream().forward();
			return t != null && WORDS[n].equals(t.getText());
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
			final Stream stream = new LimitedStream(parse.getStream(),
					new NthWord(n));
			parse.setStream(stream);
			parse.getStack().push(new Dummy());

			assertCanStream(stream, WORDS, n, target);
		}
	}

	@Test
	public void testCanRewind() {
		for (int n = 0; n < WORDS.length; n++) {
			final HardcodedSource source = HardcodedSource.from(WORDS);
			final ListTarget target = new ListTarget();
			final Parse parse = Parse.of(source).to(target);
			final Stream stream = new LimitedStream(parse.getStream(),
					new NthWord(n));
			parse.setStream(stream);
			parse.getStack().push(new Dummy());

			assertCanRewind(stream, WORDS, n, target);
		}
	}

	@Test
	public void testCanBookmark() {
		for (int n = 0; n < WORDS.length; n++) {
			final HardcodedSource source = HardcodedSource.from(WORDS);
			final ListTarget target = new ListTarget();
			final Parse parse = Parse.of(source).to(target);
			final Stream stream = new LimitedStream(parse.getStream(),
					new NthWord(n));
			parse.setStream(stream);
			parse.getStack().push(new Dummy());

			assertCanBookmark(stream, WORDS, n, target);
		}
	}
}
