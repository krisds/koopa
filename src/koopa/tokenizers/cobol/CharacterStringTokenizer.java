package koopa.tokenizers.cobol;


import java.io.IOException;

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
		while (!hasQuit()) {
			final Token token = tokenizer.nextToken();

			if (token == null) {
				break;

			} else if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					|| token.hasTag(AreaTag.COMMENT)) {
				enqueue(token);
				continue;
			}

			final String text = token.getText();

			if (token.hasTag(SyntacticTag.SEPARATOR)
					&& (text.equals("\"") || text.equals("'"))) {

				tokenizeStringLiteral(token);

			} else if (token.hasTag(SyntacticTag.SEPARATOR)
					&& (text.equals("=="))) {

				tokenizePseudoLiteral(token);

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					&& holdsInteger(text)) {

				if (isSigned(text)) {
					token.addTag(SyntacticTag.INTEGER_LITERAL);
					token.addTag(SyntacticTag.SIGNED);
				} else {
					token.addTag(SyntacticTag.INTEGER_LITERAL);
					token.addTag(SyntacticTag.UNSIGNED);
				}
				enqueue(token);

			} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
					&& holdsDecimal(text)) {

				if (isSigned(text)) {
					token.addTag(SyntacticTag.DECIMAL_LITERAL);
					token.addTag(SyntacticTag.SIGNED);
				} else {
					token.addTag(SyntacticTag.DECIMAL_LITERAL);
					token.addTag(SyntacticTag.UNSIGNED);
				}
				enqueue(token);

			} else {
				enqueue(token);
			}
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

	public void quit() {
		quitMe();
		tokenizer.quit();
	}
}
