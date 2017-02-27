package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

public class InlineComments extends ChainingSource
		implements Source {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.inline_comments");

	private boolean inComment = false;

	public InlineComments(Source source) {
		super(source);
	}

	@Override
	public Data nxt1() {

		final Data data = source.next();

		if (data == null || !(data instanceof Token))
			return data;

		final Token token = (Token) data;

		// Comments only apply to program text.
		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return token;

		// Inline comments end at the end of the line.
		if (token.hasTag(END_OF_LINE)) {
			inComment = false;
			return token;
		}

		if (inComment)
			return token.withTags(COMMENT).withoutTags(PROGRAM_TEXT_AREA);

		// Inline comments start with "*>".
		if (token.hasTag(SEPARATOR) && "*".equals(token.getText())) {
			// Found "*"; checking for ">".
			final Data b = source.next();
			if (b != null && b instanceof Token) {
				final Token t = (Token) b;
				inComment = (t.hasTags(PROGRAM_TEXT_AREA, SEPARATOR)
						&& ">".equals(t.getText()));
			}

			source.unshift(b);
		}

		if (inComment) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Inline comment starts with " + token);
			return token.withTags(COMMENT).withoutTags(PROGRAM_TEXT_AREA);
		} else
			return token;
	}
}
