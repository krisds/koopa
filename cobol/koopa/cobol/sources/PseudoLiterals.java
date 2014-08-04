package koopa.cobol.sources;

import static koopa.cobol.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;
import static koopa.cobol.data.tags.SyntacticTag.PSEUDO_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

public class PseudoLiterals extends ThreadedSource<Token> implements
		Source<Token> {

	private Source<? extends Token> source = null;

	public PseudoLiterals(Source<? extends Token> source) {
		super("PseudoLiteralTokenizer");
		assert (source != null);
		this.source = source;
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			final Token token = this.source.next();

			if (token == null)
				break;

			if (!token.hasTag(SEPARATOR) || !token.getText().equals("==")) {
				enqueue(token);

			} else {
				tokenizePseudoLiteral(token);
			}
		}
	}

	private void tokenizePseudoLiteral(final Token openingToken) {
		List<Token> tokens = new ArrayList<Token>();

		tokens.add(openingToken);

		Token next = source.next();
		while (next != null) {
			if (next.hasTag(PROGRAM_TEXT_AREA)) {
				tokens.add(next);

				if (next.getText().equals("=="))
					break;
			}

			next = source.next();
		}

		Token pseudoliteral = new Token(tokens, PROGRAM_TEXT_AREA,
				CHARACTER_STRING, PSEUDO_LITERAL);

		enqueue(pseudoliteral);
	}

	@Override
	public void close() {
		super.close();
		source.close();
	}
}
