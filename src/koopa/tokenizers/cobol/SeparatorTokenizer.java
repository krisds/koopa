package koopa.tokenizers.cobol;

import java.io.IOException;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.Token;

import org.apache.log4j.Logger;

public class SeparatorTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.separators");

	private Tokenizer tokenizer = null;

	public SeparatorTokenizer(Tokenizer tokenizer) {
		super();

		assert (tokenizer != null);
		this.tokenizer = tokenizer;
	}

	protected void tokenize() throws IOException {
		while (!hasQuit()) {
			final Token token = tokenizer.nextToken();

			if (token == null) {
				break;

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					&& !token.hasTag(AreaTag.COMMENT)) {
				separate(token);

			} else {
				enqueue(token);
			}
		}
	}

	private void separate(final Token token) {
		final String text = token.getText();
		final int length = text.length();

		int position = 0;
		int characterstringStart = -1;

		while (position < length) {
			final char c = text.charAt(position);

			if (c == ' ') {

				// The following code checks to see if there is a character
				// string waiting to be assembled. If so, we assemble it before
				// processing the separator. This code needs to appear in every
				// branch dealing with a new separator. If you update one, you
				// should update all others.
				if (characterstringStart >= 0) {
					final Token characterstring = token.subtoken(
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Character string: " + characterstring);
					}
					enqueue(characterstring);
					characterstringStart = -1;
				}

				final int start = position;

				position += 1;
				while (position < length && text.charAt(position) == ' ') {
					position += 1;
				}

				final Token separator = token.subtoken(start, position);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Separator: " + separator);
				}
				enqueue(separator);

			} else if ((c == ',' || c == ';' || c == '.')
					&& (position + 1 == length || text.charAt(position + 1) == ' ')) {
				// Based on following definition:
				// "Commas and semicolons can only be used as separators when
				// they are immediately followed by a space."
				// "A period can only be used as a separator when immediately
				// followed by a space."
				//
				// Source: fujcob2k-cob2_bs.pdf, section 2.4.2 (p. 55)
				// Also confirmed in the Yellow Books by Ebbinkhuijsen.
				//
				// Note: I consider end-of-line as a space here, so that periods
				// may be the last character in the line.

				// The following code checks to see if there is a character
				// string waiting to be assembled. If so, we assemble it before
				// processing the separator. This code needs to appear in every
				// branch dealing with a new separator. If you update one, you
				// should update all others.
				if (characterstringStart >= 0) {
					final Token characterstring = token.subtoken(
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Character string: " + characterstring);
					}
					enqueue(characterstring);
					characterstringStart = -1;
				}

				// I choose to split the separator into two parts. The first
				// part is the comma, semicolon or dot. The second part is the
				// following sequence of spaces. I do this so that punctuation
				// remains separate, which I hope will make further processing
				// easier.
				final Token separator = token.subtoken(position, position + 1);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Separator: " + separator);
				}
				enqueue(separator);

				final int start = position + 1;
				position += 1;

				if (position < length) {
					while (position < length && text.charAt(position) == ' ') {
						position += 1;
					}

					final Token whitespace = token.subtoken(start, position);
					whitespace.addTag(AreaTag.PROGRAM_TEXT_AREA);
					whitespace.addTag(SyntacticTag.SEPARATOR);
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Separator: " + whitespace);
					}
					enqueue(whitespace);
				}

			} else if (c == '(' || c == ')' || c == '"' || c == '\''
					|| c == ':') {
				// TODO Treat quotation marks separately, and immediately build
				// up string literals here ?

				// The following code checks to see if there is a character
				// string waiting to be assembled. If so, we assemble it before
				// processing the separator. This code needs to appear in every
				// branch dealing with a new separator. If you update one, you
				// should update all others.
				if (characterstringStart >= 0) {
					final Token characterstring = token.subtoken(
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Character string: " + characterstring);
					}
					enqueue(characterstring);
					characterstringStart = -1;
				}

				final Token separator = token.subtoken(position, position + 1);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Separator: " + separator);
				}
				enqueue(separator);

				position += 1;

			} else if (c == '=' && position + 1 < length
					&& text.charAt(position + 1) == '=') {

				// The following code checks to see if there is a character
				// string waiting to be assembled. If so, we assemble it before
				// processing the separator. This code needs to appear in every
				// branch dealing with a new separator. If you update one, you
				// should update all others.
				if (characterstringStart >= 0) {
					final Token characterstring = token.subtoken(
							characterstringStart, position);
					// characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Character string: " + characterstring);
					}
					enqueue(characterstring);
					characterstringStart = -1;
				}

				final Token separator = token.subtoken(position, position + 2);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Separator: " + separator);
				}
				enqueue(separator);

				position += 2;

			} else {
				// Non-separator.
				if (characterstringStart < 0) {
					characterstringStart = position;
				}
				position += 1;
			}
		}

		// We have reached the end of the token. We check if there is still an
		// outstanding character string to be assembled. If so, we assemble it.
		if (characterstringStart >= 0) {
			final Token characterstring = token.subtoken(characterstringStart,
					position);
			characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
			characterstring.addTag(SyntacticTag.CHARACTER_STRING);
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("Character string: " + characterstring);
			}
			enqueue(characterstring);
			characterstringStart = -1;
		}
	}

	public void quit() {
		quitMe();
		tokenizer.quit();
	}
}
