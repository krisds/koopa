package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

import org.apache.log4j.Logger;

public class InlineComments extends ChainingSource<Token, Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.inline_comments");

	private boolean inComment = false;

	public InlineComments(Source<Token> source) {
		super(source);

		assert (source != null);
	}

	@Override
	public Token nxt1() {

		final Token token = source.next();

		if (token == null)
			return null;

		// Comments only apply to program text.
		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return token;

		// Inline comments end at the end of the line.
		if (token.hasTag(END_OF_LINE)) {
			inComment = false;
			return token;
		}

		if (inComment)
			return token.withTags(COMMENT);

		// Inline comments start with "*>".
		if (token.hasTag(SEPARATOR) && "*".equals(token.getText())) {
			// Found "*"; checking for ">".
			final Token b = source.next();

			inComment = (b != null && b.hasTags(PROGRAM_TEXT_AREA, SEPARATOR) && ">"
					.equals(b.getText()));

			source.unshift(b);
		}

		if (inComment) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Inline comment starts with " + token);
			return token.withTags(COMMENT);
		} else
			return token;
	}

	public void close() {
		source.close();
	}
}
