package koopa.tokenizers.cobol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;

/**
 * This class takes a {@link Reader} and spits out tokens. The tokens are either
 * "end of lines" which have an {@link AreaTag#END_OF_LINE} tag, or contain one
 * line of text (without tags).
 */
public class LineSplittingTokenizer implements Tokenizer {

	private static final int NO_CHARACTER = -2;

	private BufferedReader reader = null;

	private int linenumber = 1;
	private int positionInFile = 1;
	private int positionInLine = 1;

	private int character = NO_CHARACTER;

	private Position start = null;
	private Position end = null;
	private StringBuffer buffer = null;

	public LineSplittingTokenizer(Reader reader) {
		super();

		assert (reader != null);

		if (reader instanceof BufferedReader) {
			this.reader = (BufferedReader) reader;

		} else {
			this.reader = new BufferedReader(reader);
		}

		this.buffer = new StringBuffer();
	}

	public Token nextToken() {
		try {
			if (atEndOfFile()) {
				// EOF.
				return null;
			}

			if (!atEndOfLine()) {
				// Not already processing a newline.

				// Reset buffer.
				this.buffer.setLength(0);

				markStart();

				// Process left over character from last time (if any).
				if (this.character >= 0) {
					this.buffer.append((char) this.character);
					nextPosition();
				}

				// Read line.
				while (true) {
					this.character = this.reader.read();

					if (atEndOfFile() || atEndOfLine()) {
						break;
					}

					this.buffer.append((char) this.character);
					nextPosition();
				}

				// Produce the line, if we read one.
				if (this.buffer.length() > 0) {
					markEnd();
					return produceToken(this.buffer.toString());
				}
			}

			if (this.character == '\n') {
				// Processing an end of line.

				markStart();
				nextPosition();
				markEnd();

				final Token token = produceToken("\n", AreaTag.END_OF_LINE);

				newLine();

				this.character = NO_CHARACTER;

				return token;
			}

			if (this.character == '\r') {
				// Processing an end of line.

				markStart();
				nextPosition();

				// We need to know if this is followed by a '\n'. If so that is
				// part of the newline token.
				this.character = this.reader.read();

				if (this.character == '\n') {
					nextPosition();
					markEnd();

					final Token token = produceToken("\r\n",
							AreaTag.END_OF_LINE);

					newLine();

					this.character = NO_CHARACTER;

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
		return this.character == -1;
	}

	private boolean atEndOfLine() {
		return this.character == '\n' || this.character == '\r';
	}

	private Token produceToken(String text) {
		final Token token = new BasicToken(text, this.start, this.end);
		return token;
	}

	private Token produceToken(String text, Object tag) {
		final Token token = produceToken(text);
		token.addTag(tag);
		return token;
	}

	private void newLine() {
		this.linenumber += 1;
		this.positionInLine = 1;
	}

	private void nextPosition() {
		this.positionInLine += 1;
		this.positionInFile += 1;
	}

	private void markStart() {
		this.start = new Position(positionInFile, linenumber, positionInLine);
	}

	private void markEnd() {
		this.end = new Position(positionInFile - 1, linenumber,
				positionInLine - 1);
	}

	public void quit() {
		try {
			if (reader != null)
				reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
