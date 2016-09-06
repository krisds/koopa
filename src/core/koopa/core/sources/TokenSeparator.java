package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;

import java.io.IOException;

import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;

/**
 * This {@linkplain Source} splits up incoming {@linkplain Token}s using the
 * {@linkplain TokenSeparationLogic}.
 * <p>
 * Note: this will only separate tokens in the
 * {@linkplain AreaTag#PROGRAM_TEXT_AREA}, which are not
 * {@linkplain AreaTag#COMMENT}s or {@linkplain AreaTag#COMPILER_DIRECTIVE}s.
 */
public class TokenSeparator extends ThreadedSource<Token, Token> implements
		Source<Token> {

	public TokenSeparator(Source<Token> source) {
		super(source);

		assert (source != null);
	}

	protected void tokenize() throws IOException {
		while (!hasClosed()) {
			final Token token = source.next();

			if (token == null) {
				break;

			} else if (token.hasTag(END_OF_LINE)) {
				enqueue(token.withTags(SEPARATOR));

			} else if (token.hasTag(PROGRAM_TEXT_AREA) //
					&& !token.hasTag(COMMENT) //
					&& !token.hasTag(COMPILER_DIRECTIVE)) {

				for (Token t : TokenSeparationLogic.apply(token))
					enqueue(t);

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
