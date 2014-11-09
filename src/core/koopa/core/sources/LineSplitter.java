package koopa.core.sources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;

/**
 * This class takes a {@link Reader} and spits out tokens. The tokens are either
 * "end of lines" which have an {@link AreaTag#END_OF_LINE} tag, or contain one
 * line of text (without tags).
 */
public class LineSplitter extends BasicSource<Token> implements Source<Token> {

	private static final int NO_CHARACTER = -2;

	private BufferedReader reader = null;

	private int linenumber = 1;
	private int positionInFile = 1;
	private int positionInLine = 1;

	private int character = NO_CHARACTER;

	private Position start = null;
	private Position end = null;
	private StringBuffer buffer = null;

	public LineSplitter(Reader reader) {
		assert (reader != null);

		if (reader instanceof BufferedReader)
			this.reader = (BufferedReader) reader;
		else
			this.reader = new BufferedReader(reader);

		this.buffer = new StringBuffer();
	}

	@Override
	public Token nxt1() {
		try {
			if (atEndOfFile())
				return null;

			if (!atEndOfLine()) {
				// Not already processing a newline.

				// Reset buffer.
				buffer.setLength(0);

				markStart();

				// Process left over character from last time (if any).
				if (character >= 0) {
					buffer.append((char) character);
					nextPosition();
				}

				// Read line.
				while (true) {
					character = reader.read();

					if (atEndOfFile() || atEndOfLine()) {
						break;
					}

					buffer.append((char) character);
					nextPosition();
				}

				// Produce the line, if we read one.
				if (buffer.length() > 0) {
					markEnd();
					return produceToken(buffer.toString());
				}
			}

			if (character == '\n') {
				// Processing an end of line.

				markStart();
				nextPosition();
				markEnd();

				final Token token = produceToken("\n", AreaTag.END_OF_LINE);

				newLine();

				character = NO_CHARACTER;

				return token;
			}

			if (character == '\r') {
				// Processing an end of line.

				markStart();
				nextPosition();

				// We need to know if this is followed by a '\n'. If so that is
				// part of the newline token.
				character = reader.read();

				if (character == '\n') {
					nextPosition();
					markEnd();

					final Token token = produceToken("\r\n",
							AreaTag.END_OF_LINE);

					newLine();

					character = NO_CHARACTER;

					return token;

				} else {
					markEnd();

					final Token token = produceToken("\r", AreaTag.END_OF_LINE);

					newLine();

					return token;
				}
			}

			return null;

		} catch (IOException e) {
			// How to handle this correctly ?
			e.printStackTrace();
			return null;
		}
	}

	private boolean atEndOfFile() {
		return character == -1;
	}

	private boolean atEndOfLine() {
		return character == '\n' || character == '\r';
	}

	private Token produceToken(String text, Object... tags) {
		return new Token(text, start, end, tags);
	}

	private void newLine() {
		linenumber += 1;
		positionInLine = 1;
	}

	private void nextPosition() {
		positionInLine += 1;
		positionInFile += 1;
	}

	private void markStart() {
		start = new Position(positionInFile, linenumber, positionInLine);
	}

	private void markEnd() {
		end = new Position(positionInFile - 1, linenumber, positionInLine - 1);
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
			character = -1;
		}
	}
}
