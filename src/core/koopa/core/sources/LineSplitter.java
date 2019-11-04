package koopa.core.sources;

import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.tags.SyntacticTag;
import koopa.core.util.LineEndings;

/**
 * This class takes a {@link Reader} and spits out tokens. The tokens are either
 * "end of lines" which have an {@link SyntacticTag#END_OF_LINE} tag, or contain
 * one line of text (without tags).
 * <p>
 * The client can specify which line endings to use by providing a list of
 * character lists. Each will tried in order.
 * <p>
 * If the client does not specify line endings, this will use
 * {@linkplain LineEndings#getDefaults()} instead.
 */
public class LineSplitter extends BasicSource implements Source {
	private static final Logger LOGGER = Logger
			.getLogger("source.linesplitter");

	private File file = null;
	private final String resourceName;
	private PushbackReader reader = null;
	private final char[] lookahead;

	private final List<List<Character>> lineEndings;
	private final boolean stickyEndings;
	private List<Character> detectedLineEnding;

	private int linenumber = 1;
	private int positionInFile = 1;
	private int positionInLine = 1;

	private Position start = null;
	private Position end = null;
	private StringBuffer buffer = null;

	public LineSplitter(Reader reader) {
		this((String) null, reader, LineEndings.getDefaults());
	}

	public LineSplitter(String resourceName, Reader reader) {
		this(resourceName, reader, LineEndings.getDefaults());
	}

	public LineSplitter(File file, Reader reader,
			List<List<Character>> lineEndings) {
		this(getResourceName(file), reader, lineEndings);
		this.file = file;
	}

	private static String getResourceName(File file) {
		if (file == null)
			return null;

		try {
			return file.getCanonicalPath();

		} catch (IOException e) {
			e.printStackTrace();
			return file.getName();
		}
	}

	public LineSplitter(String resourceName, Reader reader,
			List<List<Character>> lineEndings) {

		assert (reader != null);
		assert (lineEndings != null && !lineEndings.isEmpty());
		final int max = maxLengthOfLineEnding(lineEndings);
		assert (max > 0);

		this.resourceName = resourceName;

		final BufferedReader br;
		if (reader instanceof BufferedReader)
			br = (BufferedReader) reader;
		else
			br = new BufferedReader(reader);
		this.reader = new PushbackReader(br, max);

		this.lookahead = new char[max];

		this.stickyEndings = LineEndings.areSticky();
		this.lineEndings = lineEndings;

		this.buffer = new StringBuffer();
	}

	@Override
	public Data nxt1() {
		try {
			if (atEndOfFile())
				return null;

			buffer.setLength(0);

			final int len = atLineEnding();
			if (len > 0) {
				// Read line ending, whose length we know.

				markStart();
				reader.read(lookahead, 0, len);
				buffer.append(lookahead, 0, len);
				advance(len);
				markEnd();
				newLine();

				final Token lineEnding = produceToken(buffer.toString(),
						END_OF_LINE);
				return lineEnding;

			} else {
				// Read line of unknown length;

				markStart();
				while (!atEndOfFile() && atLineEnding() <= 0) {
					int c = reader.read();
					buffer.append((char) c);
					advance();
				}
				markEnd();

				final Token line = produceToken(buffer.toString());
				return line;
			}

		} catch (IOException e) {
			// How to handle this correctly ?
			e.printStackTrace();
			return null;
		}
	}

	private int atLineEnding() throws IOException {
		if (detectedLineEnding != null && stickyEndings) {
			if (atLineEnding(detectedLineEnding))
				return detectedLineEnding.size();
			else
				return -1;

		} else {
			for (List<Character> possibleLineEnding : lineEndings)
				if (atLineEnding(possibleLineEnding)) {
					if (stickyEndings) {
						detectedLineEnding = possibleLineEnding;

						if (LOGGER.isTraceEnabled())
							LOGGER.trace("Detected line ending: "
									+ LineEndings.encodeLineEnding(
											detectedLineEnding)
									+ ". Stickying.");
					}

					return possibleLineEnding.size();
				}

			return -1;
		}
	}

	private boolean atLineEnding(List<Character> list) throws IOException {
		int len = 0;

		for (char expected : list) {
			lookahead[len] = (char) reader.read();

			if (lookahead[len] == -1) {
				reader.unread(lookahead, 0, len);
				return false;
			}

			len += 1;

			if (lookahead[len - 1] != expected) {
				reader.unread(lookahead, 0, len);
				return false;
			}
		}

		reader.unread(lookahead, 0, len);
		return true;
	}

	private boolean atEndOfFile() throws IOException {
		final int c = reader.read();
		if (c == -1)
			return true;
		else {
			reader.unread(c);
			return false;
		}
	}

	private void newLine() {
		linenumber += 1;
		positionInLine = 1;
	}

	private void advance() {
		positionInLine += 1;
		positionInFile += 1;
	}

	private void advance(int len) {
		positionInLine += len;
		positionInFile += len;
	}

	private void markStart() {
		start = new Position(resourceName, positionInFile, linenumber,
				positionInLine);
	}

	private void markEnd() {
		end = new Position(resourceName, positionInFile - 1, linenumber,
				positionInLine - 1);
	}

	private Token produceToken(String text, Object... tags) {
		return new Token(text, start, end, tags);
	}

	@Override
	public void close() {
		try {
			if (reader != null)
				reader.close();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			reader = null;
		}
	}

	private static int maxLengthOfLineEnding(
			List<List<Character>> lineEndings) {
		int max = 0;

		for (List<Character> list : lineEndings)
			max = Math.max(max, list.size());

		return max;
	}

	public File getFile() {
		return file;
	}
}
