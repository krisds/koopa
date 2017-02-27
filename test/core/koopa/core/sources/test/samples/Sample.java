package koopa.core.sources.test.samples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Range;
import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.test.TokenValidator;
import koopa.core.util.FilenameFilters;

public class Sample {

	private final String input;
	private final List<Range> ranges;
	private final List<Annotation> annotations;

	public Sample(String input, List<Range> ranges,
			List<Annotation> annotations) {
		this.input = input;
		this.ranges = ranges;
		this.annotations = annotations;
	}

	public static FilenameFilter getFilenameFilter() {
		return FilenameFilters.forExtension("sample", true);
	}

	public static Sample from(File sampleFile) throws IOException {
		final List<Block> blocks = allBlocksFrom(sampleFile);

		final String input = getInputFrom(blocks);
		final List<Range> ranges = getRangesFrom(blocks);
		final List<Annotation> annotations = getAnnotationFrom(blocks);

		return new Sample(input, ranges, annotations);
	}

	private static List<Block> allBlocksFrom(File file) throws IOException {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);

			final Source source = new LineSplitter(fileReader);
			final List<Block> blocks = new ArrayList<Block>();

			while (true) {
				final Block block = Block.nextFrom(blocks.size() + 1, source);
				if (block == null)
					break;
				else
					blocks.add(block);
			}

			return blocks;

		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
			}
		}
	}

	private static String getInputFrom(List<Block> blocks) {
		final StringBuilder input = new StringBuilder();

		for (Block block : blocks)
			input.append(block.getInput());

		return input.toString();
	}

	private static List<Range> getRangesFrom(List<Block> blocks) {

		final List<Range> ranges = new ArrayList<Range>();
		Range incompleteRange = null;

		for (Block block : blocks) {
			final List<Range> blockRanges = block.getRanges();
			if (blockRanges == null)
				continue;

			for (Range range : blockRanges) {
				final boolean continuesARange = range.getStart() == null;
				final boolean rangeIsContinued = range.getEnd() == null;

				if (continuesARange) {
					if (incompleteRange == null)
						throw new IllegalStateException(
								"Unexpected continuation of a range.");

					incompleteRange = new Range(incompleteRange.getStart(),
							range.getEnd());

					if (!rangeIsContinued) {
						ranges.add(incompleteRange);
						incompleteRange = null;
					}

				} else if (rangeIsContinued) {
					if (incompleteRange != null)
						throw new IllegalStateException("Incomplete range.");

					incompleteRange = range;

				} else {
					ranges.add(range);
				}
			}
		}

		return ranges;
	}

	private static List<Annotation> getAnnotationFrom(List<Block> blocks) {
		final List<Annotation> annotations = new ArrayList<Annotation>();

		for (Block block : blocks)
			if (block.hasAnnotations())
				annotations.addAll(block.getAnnotations());
			else if (block.getRanges() != null)
				annotations.addAll(emptyAnnotations(block.getRanges().size()));

		return annotations;
	}

	private static List<Annotation> emptyAnnotations(int size) {
		List<Annotation> l = new ArrayList<Annotation>(size);
		for (int i = 0; i < size; i++)
			l.add(null);
		return l;
	}

	public Reader getReader() {
		return new StringReader(input);
	}

	/**
	 * Verifies that the tokens coming from the given source align with the
	 * expected output as defined in the sample.
	 */
	public void assertOutputIsAsExpected(Source source,
			TokenValidator validator) {

		int i = 0;
		while (true) {
			if (i >= ranges.size()) {
				assertNull("Was not expecting any more tokens.", source.next());
				break;
			}

			final Range range = ranges.get(i);

			String message = "Expected a token at line "
					+ range.getStart().getPositionInFile() + ", positions "
					+ range.getStart().getPositionInLine() + "--"
					+ range.getEnd().getPositionInLine();

			final Data d = source.next();
			assertNotNull(message, d);
			assertTrue(d instanceof Token);
			
			final Token token = (Token) d;
			if (token.isReplacement())
				continue;

			message += ". Found " + token + " instead.";

			assertEquals(message, range.getStart().getLinenumber(),
					token.getStart().getLinenumber());
			assertEquals(message, range.getStart().getPositionInLine(),
					token.getStart().getPositionInLine());

			assertEquals(message, range.getEnd().getLinenumber(),
					token.getEnd().getLinenumber());
			assertEquals(message, range.getEnd().getPositionInLine(),
					token.getEnd().getPositionInLine());

			final Annotation annotation = annotations.get(i);
			if (annotation != null) {
				final Set<String> required //
						= annotation.getRequired();
				if (required != null && !required.isEmpty())
					for (String category : required)
						validator.validate(token, category, true);

				final Set<String> forbidden //
						= annotation.getForbidden();
				if (forbidden != null && !forbidden.isEmpty())
					for (String category : forbidden)
						validator.validate(token, category, false);
			}

			i += 1;
		}
	}
}
