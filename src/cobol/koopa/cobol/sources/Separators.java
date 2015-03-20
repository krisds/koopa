package koopa.cobol.sources;

import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.END_OF_LINE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.io.IOException;

import koopa.cobol.sources.SeparationLogic.Feedback;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.ThreadedSource;

public class Separators extends ThreadedSource<Token> implements Source<Token> {

	private Source<? extends Token> source = null;
	private final Feedback feedback = new Feedback() {
		public void add(Token token) {
			enqueue(token);
		}
	};

	public Separators(Source<? extends Token> tokenizer) {
		super();

		assert (tokenizer != null);
		this.source = tokenizer;
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			final Token token = source.next();

			if (token == null) {
				break;
			} else if (token.hasTag(END_OF_LINE)) {
				enqueue(token.withTags(SEPARATOR));

			} else if (token.hasTag(PROGRAM_TEXT_AREA)
					&& !token.hasTag(COMMENT)
					&& !token.hasTag(COMPILER_DIRECTIVE)) {
				SeparationLogic.apply(token, feedback);

			} else {
				enqueue(token);
			}
		}
	}

	@Override
	public void close() {
		super.close();
		source.close();
	}
}
