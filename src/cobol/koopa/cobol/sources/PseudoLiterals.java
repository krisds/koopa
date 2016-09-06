package koopa.cobol.sources;

import static koopa.cobol.data.tags.CobolTag.PSEUDO_LITERAL;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

public class PseudoLiterals extends ThreadedSource<Token, Token> implements
		Source<Token> {

	public PseudoLiterals(Source<Token> source) {
		super("PseudoLiteralTokenizer", source);
		assert (source != null);
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			if (atEnd())
				break;

			if (!atStartMarker()) {
				enqueue(source.next());

			} else {
				tokenizePseudoLiteral();
			}
		}
	}

	private boolean atEnd() {
		final Token t = source.next();

		if (t == null)
			return true;

		source.unshift(t);
		return false;
	}

	private boolean atStartMarker() {
		boolean match = false;
		final Token a = source.next();

		if (a != null && a.getText().equals("=")) {
			final Token b = source.next();

			if (b != null && b.getText().equals("="))
				match = true;

			source.unshift(b);
		}

		source.unshift(a);
		return match;
	}

	private boolean atEndMarker() {
		boolean match = false;
		final Token a = source.next();

		if (a != null && a.getText().equals("=")) {
			final Token b = source.next();

			if (b != null && b.getText().equals("=")) {
				final Token c = source.next();

				if (c == null || !c.getText().equals("=")) {
					match = true;
				}

				source.unshift(c);
			}

			source.unshift(b);
		}

		source.unshift(a);
		return match;
	}

	private void tokenizePseudoLiteral() {
		List<Token> tokens = new ArrayList<Token>();

		tokens.add(source.next());
		tokens.add(source.next());

		while (!atEnd()) {
			if (atEndMarker()) {
				tokens.add(source.next());
				tokens.add(source.next());
				break;
			}

			Token next = source.next();
			if (next.hasTag(PROGRAM_TEXT_AREA) && !next.hasTag(END_OF_LINE))
				tokens.add(next);
			// else ignore...
		}

		Token pseudoliteral = Tokens.join(tokens, PROGRAM_TEXT_AREA,
				PSEUDO_LITERAL);

		enqueue(pseudoliteral);
	}

	@Override
	public void close() {
		super.close();
		source.close();
	}
}
