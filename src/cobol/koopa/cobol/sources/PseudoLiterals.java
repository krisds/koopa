package koopa.cobol.sources;

import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;
import static koopa.cobol.data.tags.SyntacticTag.PSEUDO_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

public class PseudoLiterals extends ThreadedSource<Token> implements
		Source<Token> {

	private Source<Token> source = null;

	public PseudoLiterals(Source<Token> source) {
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
				if (next.getText().equals("==")) {
					// We check that the very next thing is "whitespace".
					// Because "=====" is legal...

					Token oneMore = source.next();
					if (oneMore == null) {
						tokens.add(next);
						break;
					}

					// This isn't the greatest solution to the problem, I
					// think... :-)
					if (oneMore.hasTag(PROGRAM_TEXT_AREA)
							&& "=".equals(oneMore.getText())) {

						tokens.add(Tokens.subtoken(next, 0, 1));

						List<Token> endMarker = new ArrayList<Token>(2);
						endMarker.add(Tokens.subtoken(next, 1));
						endMarker.add(oneMore);

						tokens.add(Tokens.join(endMarker, PROGRAM_TEXT_AREA,
								SEPARATOR));
						break;

					} else {
						source.unshift(oneMore);
						tokens.add(next);
						break;
					}

				} else
					tokens.add(next);
			}

			next = source.next();
		}

		Token pseudoliteral = Tokens.join(tokens, PROGRAM_TEXT_AREA,
				CHARACTER_STRING, PSEUDO_LITERAL);

		enqueue(pseudoliteral);
	}

	@Override
	public void close() {
		super.close();
		source.close();
	}
}
