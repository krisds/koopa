package koopa.tokenizers.cobol;

import java.io.IOException;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;

public class ProgramAreaTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {

	private final SourceFormat format;

	private final Tokenizer tokenizer;

	public ProgramAreaTokenizer(Tokenizer tokenizer) {
		this(tokenizer, SourceFormat.FIXED);
	}

	public ProgramAreaTokenizer(Tokenizer tokenizer, SourceFormat format) {
		super();

		assert (tokenizer != null);
		assert (format != null);

		this.tokenizer = tokenizer;
		this.format = format;
	}

	public SourceFormat getFormat() {
		return format;
	}

	protected void tokenize() throws IOException {
		while (!hasQuit()) {
			final Token token = this.tokenizer.nextToken();

			if (token == null) {
				return;
			}

			if (token.hasTag(AreaTag.END_OF_LINE)) {
				enqueue(token);
				continue;
			}

			final String text = token.getText();

			final int length = text.length();
			if (length == 0) {
				// No text. Shouldn't really happen; but better safe than sorry.
				continue;
			}

			if (this.format == SourceFormat.FREE) {
				int c = text.charAt(0);

				if (c == 'D' || c == 'd') {
					// This is only an indicator if it gets followed by a space.
					// Otherwise it's program text.
					if (text.charAt(1) == ' ') {
						enqueue(tokenizeArea(token, 0, 1,
								AreaTag.INDICATOR_AREA));
						enqueue(tokenizeArea(token, 1, length, AreaTag.COMMENT));

					} else {
						// Program text.
						token.addTag(AreaTag.PROGRAM_TEXT_AREA);
						enqueue(token);
					}

				} else if (indicatesComment(c)) {
					// These are definitely indicators.
					//
					// Note: Keep this after the debug line check, as the
					// indicatesComment method accepts 'd' and 'D' as well.
					enqueue(tokenizeArea(token, 0, 1, AreaTag.INDICATOR_AREA));
					enqueue(tokenizeArea(token, 1, length, AreaTag.COMMENT));

				} else {
					// Program text.
					token.addTag(AreaTag.PROGRAM_TEXT_AREA);
					enqueue(token);
				}

			} else if (this.format == SourceFormat.FIXED) {
				// 1-6 (in Java: 0-5) = sequence number
				// 7 (in Java: 6) = indicator
				// 8-72 (in Java: 7-71) = program text
				// 73-... (in Java: 72-...) = identification

				final int endOfSequenceNumber = Math.min(6, length);
				enqueue(tokenizeArea(token, 0, endOfSequenceNumber,
						AreaTag.SEQUENCE_NUMBER_AREA));

				boolean comment = false;
				if (length > 7) {
					final int endOfIndicator = Math.min(7, length);
					enqueue(tokenizeArea(token, 6, endOfIndicator,
							AreaTag.INDICATOR_AREA));

					comment = indicatesComment(text.charAt(6));
				}

				if (length > 8) {
					final int endOfProgramText = Math.min(72, length);
					if (comment) {
						enqueue(tokenizeArea(token, 7, endOfProgramText,
								AreaTag.COMMENT));
					} else {
						enqueue(tokenizeArea(token, 7, endOfProgramText,
								AreaTag.PROGRAM_TEXT_AREA));
					}
				}

				if (length > 72) {
					enqueue(tokenizeArea(token, 72, length,
							AreaTag.IDENTIFICATION_AREA));
				}

			} else {
				// Unexpected format.
				System.err.println("Unexpected format: " + this.format);
				// TODO Should throw an exception instead. Exiting hard is not
				// nice.
				System.exit(1);
			}
		}
	}

	private boolean indicatesComment(int c) {
		return c == '*' || c == '/' || c == '$' || c == 'D' || c == 'd';
	}

	private Token tokenizeArea(Token token, int begin, int end, Object tag) {
		final String text = token.getText().substring(begin, end);

		final Position start = token.getStart();
		final BasicToken newToken = new BasicToken(text, start.offsetBy(begin),
				start.offsetBy(end - 1));

		newToken.addTag(tag);

		return newToken;
	}

	public void quit() {
		quitMe();
	}
}
