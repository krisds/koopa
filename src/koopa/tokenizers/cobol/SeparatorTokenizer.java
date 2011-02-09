package koopa.tokenizers.cobol;


import java.io.IOException;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;

public class SeparatorTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {

	private Tokenizer tokenizer = null;
	private boolean inContinuation = false;

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

			} else if (token.hasTag(AreaTag.INDICATOR_AREA)) {
				enqueue(token);

				final String indicator = token.getText();
				if (indicator.equals("*") || indicator.equals("/")) {
					this.inContinuation = false;
					comment();

				} else if (indicator.equals("-")) {
					this.inContinuation = true;
				}

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				separate(token);
				this.inContinuation = false;

			} else {
				enqueue(token);
				this.inContinuation = false;
			}
		}
	}

	private void separate(final Token token) {
		final String text = token.getText();
		final int length = text.length();

		int position = 0;
		int characterstringStart = -1;

		if (this.inContinuation) {
			// Skip all leading whitespace.
			while (position < length && text.charAt(position) == ' ') {
				position += 1;
			}

			// Grab leading quote, if any.
			if (position < length
					&& (text.charAt(position) == '"' || text.charAt(position) == '\'')) {
				Token quote = subToken(token, position, position + 1);
				quote.addTag(AreaTag.PROGRAM_TEXT_AREA);
				quote.addTag(SyntacticTag.SEPARATOR);
				enqueue(quote);
				position += 1;
			}
		}

		while (position < length) {
			final char c = text.charAt(position);

			if (c == ' ') {

				// The following code checks to see if there is a character
				// string waiting to be assembled. If so, we assemble it before
				// processing the separator. This code needs to appear in every
				// branch dealing with a new separator. If you update one, you
				// should update all others.
				if (characterstringStart >= 0) {
					Token characterstring = subToken(token,
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					enqueue(characterstring);
					characterstringStart = -1;
				}

				final int start = position;

				position += 1;
				while (position < length && text.charAt(position) == ' ') {
					position += 1;
				}

				Token separator = subToken(token, start, position);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
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
					Token characterstring = subToken(token,
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					enqueue(characterstring);
					characterstringStart = -1;
				}

				// I choose to split the separator into two parts. The first
				// part is the comma, semicolon or dot. The second part is the
				// following sequence of spaces. I do this so that punctuation
				// remains separate, which I hope will make further processing
				// easier.
				Token separator = subToken(token, position, position + 1);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
				enqueue(separator);

				final int start = position + 1;
				position += 1;

				if (position < length) {
					while (position < length && text.charAt(position) == ' ') {
						position += 1;
					}

					Token whitespace = subToken(token, start, position);
					whitespace.addTag(AreaTag.PROGRAM_TEXT_AREA);
					whitespace.addTag(SyntacticTag.SEPARATOR);
					enqueue(whitespace);
				}

			} else if (c == '(' || c == ')' || c == '"' || c == '\''
					|| c == ':') {

				// The following code checks to see if there is a character
				// string waiting to be assembled. If so, we assemble it before
				// processing the separator. This code needs to appear in every
				// branch dealing with a new separator. If you update one, you
				// should update all others.
				if (characterstringStart >= 0) {
					Token characterstring = subToken(token,
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					enqueue(characterstring);
					characterstringStart = -1;
				}

				Token separator = subToken(token, position, position + 1);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
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
					Token characterstring = subToken(token,
							characterstringStart, position);
					characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
					characterstring.addTag(SyntacticTag.CHARACTER_STRING);
					enqueue(characterstring);
					characterstringStart = -1;
				}

				Token separator = subToken(token, position, position + 2);
				separator.addTag(AreaTag.PROGRAM_TEXT_AREA);
				separator.addTag(SyntacticTag.SEPARATOR);
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
			Token characterstring = subToken(token, characterstringStart,
					position);
			characterstring.addTag(AreaTag.PROGRAM_TEXT_AREA);
			characterstring.addTag(SyntacticTag.CHARACTER_STRING);
			enqueue(characterstring);
			characterstringStart = -1;
		}
	}

	private void comment() {
		Token comment = tokenizer.nextToken();
		while (comment != null && comment.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {

			comment.removeTag(AreaTag.PROGRAM_TEXT_AREA);
			comment.addTag(AreaTag.COMMENT);
			enqueue(comment);

			comment = tokenizer.nextToken();
		}

		if (comment != null) {
			// End of line tag, or identification tag. This can be safely
			// passed on, as they are of no interest here.
			enqueue(comment);
		}
	}

	private Token subToken(Token token, int start, int end) {
		final String text = token.getText();
		final Position position = token.getStart();

		return new BasicToken(text.substring(start, end), position
				.offsetBy(start), position.offsetBy(end - 1));
	}

	public void quit() {
		quitMe();
		tokenizer.quit();
	}
}
