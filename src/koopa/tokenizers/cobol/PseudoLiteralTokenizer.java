package koopa.tokenizers.cobol;

import java.io.IOException;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;

public class PseudoLiteralTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {
	private Tokenizer tokenizer = null;

	public PseudoLiteralTokenizer(Tokenizer tokenizer) {
		super("PseudoLiteralTokenizer");
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
	}

	protected void tokenize() throws IOException {
		while (!hasQuit()) {
			final Token token = this.tokenizer.nextToken();

			if (token == null) {
				break;
			}

			if (!token.hasTag(SyntacticTag.SEPARATOR)
					|| !token.getText().equals("==")) {
				enqueue(token);

			} else {
				tokenizePseudoLiteral(token);
			}
		}
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
