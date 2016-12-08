package koopa.core.streams.test;

import org.junit.Test;

import koopa.core.parsers.Stream;
import koopa.core.sources.test.HardcodedSource;
import koopa.core.streams.BaseStream;
import koopa.core.targets.ListTarget;

/**
 * Tests the core operations which make up a {@linkplain BaseStream}.
 */
public class BaseStreamTest extends ParseStreamTest {

	private static final Object[] WORDS = "The quick brown fox jumped over the lazy dog"
			.split("\\s+");

	@Test
	public void testCanStream() {
		final HardcodedSource source = HardcodedSource.from(WORDS);
		final ListTarget target = new ListTarget();
		final Stream stream = new BaseStream(source, target);
		assertCanStream(stream, WORDS, target);
	}

	@Test
	public void testCanRewind() {
		final HardcodedSource source = HardcodedSource.from(WORDS);
		final ListTarget target = new ListTarget();
		final Stream stream = new BaseStream(source, target);
		assertCanRewind(stream, WORDS, target);
	}

	@Test
	public void testCanBookmark() {
		final HardcodedSource source = HardcodedSource.from(WORDS);
		final ListTarget target = new ListTarget();
		final Stream stream = new BaseStream(source, target);
		assertCanBookmark(stream, WORDS, target);
	}
}
