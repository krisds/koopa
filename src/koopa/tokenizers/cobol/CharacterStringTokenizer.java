package koopa.tokenizers.cobol;

import java.io.IOException;
import java.util.LinkedList;

import koopa.tokenizers.PushbackTokenizer;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.generic.BasicPushbackTokenizer;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;

public class CharacterStringTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {
	private PushbackTokenizer tokenizer = null;

	public CharacterStringTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = new BasicPushbackTokenizer(tokenizer);
	}

	protected void tokenize() throws IOException {
		tokenisation: while (!hasQuit()) {
			final Token token = this.tokenizer.nextToken();

			if (token == null) {
				break;

			} else if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					|| token.hasTag(AreaTag.COMMENT)) {
				enqueue(token);
				continue tokenisation;
			}

			final String text = token.getText();

			if (token.hasTag(SyntacticTag.SEPARATOR)
					&& (text.equals("\"") || text.equals("'"))) {

				tokenizeStringLiteral(token);
				continue tokenisation;
			}

			if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA) && text.equals("*>")) {
				tokenizeInlineComment(token);
				continue tokenisation;
			}

			if (token.hasTag(SyntacticTag.SEPARATOR) && (text.equals("=="))) {
				tokenizePseudoLiteral(token);
				continue tokenisation;
			}

			if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					&& text.equalsIgnoreCase("x")) {

				// Single 'X'. This may be the start of a hexadecimal literal.

				final Token openQuote = this.tokenizer.nextToken();
				final String openQuoteText = openQuote.getText();

				if (openQuote.hasTag(SyntacticTag.SEPARATOR)
						&& (openQuoteText.equals("\"") || openQuoteText
								.equals("'"))) {

					// Single 'X' followed by an opening quote.

					final LinkedList<Token> value = new LinkedList<Token>();

					hexadecimal: while (true) {
						final Token next = this.tokenizer.nextToken();
						final String nextText = openQuote.getText();

						if (next.hasTag(SyntacticTag.SEPARATOR)
								&& (nextText.equals("\"") || nextText
										.equals("'"))) {

							// We found the closing quote which completes the
							// hexadecimal literal.

							final CompositeToken hexadecimal = new CompositeToken();
							hexadecimal.addToken(token);
							hexadecimal.addToken(openQuote);
							for (Token v : value) {
								hexadecimal.addToken(v);
							}
							hexadecimal.addToken(next);
							hexadecimal.addTag(AreaTag.PROGRAM_TEXT_AREA);
							hexadecimal.addTag(SyntacticTag.CHARACTER_STRING);
							hexadecimal
									.addTag(SyntacticTag.HEXADECIMAL_LITERAL);

							enqueue(hexadecimal);
							continue tokenisation;

						} else if (next.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
							// Assuming this to be part of the hexadecimal
							// value.
							// TODO Should also check if value matches
							// [a-zA-Z0-9].
							value.push(next);

						} else {
							// Not part of a hexadecimal value. We undo the
							// lookahead and continue with other options.
							this.tokenizer.pushback(next);

							Token last = null;
							while ((last = value.pop()) != null) {
								this.tokenizer.pushback(last);
							}

							this.tokenizer.pushback(openQuote);

							break hexadecimal;
						}
					}

				} else {
					// Not a hexadecimal-alphanumeric. Push back lookahead.
					this.tokenizer.pushback(openQuote);
				}
			}

			if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA) && holdsInteger(text)) {
				if (isSigned(text)) {
					token.addTag(SyntacticTag.INTEGER_LITERAL);
					token.addTag(SyntacticTag.SIGNED);
				} else {
					token.addTag(SyntacticTag.INTEGER_LITERAL);
					token.addTag(SyntacticTag.UNSIGNED);
				}

				enqueue(token);
				continue tokenisation;
			}

			if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA) && holdsDecimal(text)) {
				if (isSigned(text)) {
					token.addTag(SyntacticTag.DECIMAL_LITERAL);
					token.addTag(SyntacticTag.SIGNED);
				} else {
					token.addTag(SyntacticTag.DECIMAL_LITERAL);
					token.addTag(SyntacticTag.UNSIGNED);
				}

				enqueue(token);
				continue tokenisation;
			}

			enqueue(token);
		}
	}

	private boolean holdsInteger(String text) {
		final int len = text.length();
		if (len == 0)
			return false;

		int start = isSigned(text) ? 1 : 0;

		for (int i = start; i < len; i++) {
			char c = text.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}

		return len > start;
	}

	private boolean holdsDecimal(String text) {
		final int len = text.length();
		if (len <= 1)
			return false;

		int start = isSigned(text) ? 1 : 0;

		boolean seenDecimalPoint = false;
		for (int i = start; i < len; i++) {
			char c = text.charAt(i);
			if (c == '.' || c == ',') {
				if (!seenDecimalPoint) {
					seenDecimalPoint = true;
					continue;

				} else {
					return false;
				}

			} else if (c < '0' || c > '9') {
				return false;
			}
		}

		return seenDecimalPoint && len > start + 1;
	}

	private boolean isSigned(String number) {
		return number.length() > 0
				&& (number.charAt(0) == '+' || number.charAt(0) == '-');
	}

	private void tokenizeStringLiteral(final Token openingToken) {
		String delimiter = openingToken.getText();

		CompositeToken stringliteral = new CompositeToken();
		stringliteral.addToken(openingToken);

		Token next = tokenizer.nextToken();
		while (next != null && next.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
			if (!next.getText().equals(delimiter)) {
				// End of string not reached. Continue.
				stringliteral.addToken(next);
				next = tokenizer.nextToken();

			} else {
				final Token peek = tokenizer.nextToken();
				if (peek != null && peek.getText().equals(delimiter)) {
					// Escaped quote. Add both, and continue with string.
					// TODO Keep the escaping in the literal, or resolve it ?
					stringliteral.addToken(next);
					stringliteral.addToken(peek);
					next = tokenizer.nextToken();

				} else {
					// End of string found. Undo peek, and break loop.
					if (peek != null) {
						tokenizer.pushback(peek);
					}
					break;
				}
			}
		}

		stringliteral.addTag(AreaTag.PROGRAM_TEXT_AREA);
		stringliteral.addTag(SyntacticTag.CHARACTER_STRING);
		stringliteral.addTag(SyntacticTag.STRING_LITERAL);

		if (next != null) {
			if (next.getText().equals(delimiter)) {
				stringliteral.addToken(next);

			} else {
				// TODO Assert/flag as error ?
				tokenizer.pushback(next);
			}
		}

		enqueue(stringliteral);
	}

	private void tokenizePseudoLiteral(final Token openingToken) {
		CompositeToken pseudoliteral = new CompositeToken();
		pseudoliteral.addToken(openingToken);

		Token next = tokenizer.nextToken();
		while (next != null) {
			if (next.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				pseudoliteral.addToken(next);

				if (next.getText().equals("==")) {
					break;
				}
			}

			next = tokenizer.nextToken();
		}

		pseudoliteral.addTag(AreaTag.PROGRAM_TEXT_AREA);
		pseudoliteral.addTag(SyntacticTag.CHARACTER_STRING);
		pseudoliteral.addTag(SyntacticTag.PSEUDO_LITERAL);

		enqueue(pseudoliteral);
	}

	private void tokenizeInlineComment(final Token token) {
		final CompositeToken inlineComment = new CompositeToken();
		inlineComment.addToken(token);

		Token next = this.tokenizer.nextToken();
		while (next != null && next.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
			inlineComment.addToken(next);
			next = this.tokenizer.nextToken();
		}

		if (next != null) {
			this.tokenizer.pushback(next);
		}

		inlineComment.addTag(AreaTag.COMMENT);
		enqueue(inlineComment);
	}

	public void quit() {
		quitMe();
		tokenizer.quit();
	}
}
