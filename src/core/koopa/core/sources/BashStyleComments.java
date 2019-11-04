package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import koopa.core.data.Data;
import koopa.core.data.Token;

/**
 * This looks for bash-style comments (starting with a hash '#' mark, up to the
 * end of the line) in the source and marks them as comment.
 */
public class BashStyleComments extends ChainingSource implements Source {

	private boolean inComment = false;

	public BashStyleComments(Source source) {
		super(source);
	}

	@Override
	protected Data nxt1() {
		final Data d = source.next();

		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;

		if (!t.hasTag(PROGRAM_TEXT_AREA))
			return t;

		if (inComment) {
			if (!t.hasTag(END_OF_LINE))
				return t.withTags(COMMENT).withoutTags(PROGRAM_TEXT_AREA);

			inComment = false;
			return t;

		} else {
			if (!"#".equals(t.getText()))
				return t;

			inComment = true;
			return t.withTags(COMMENT).withoutTags(PROGRAM_TEXT_AREA);
		}
	}
}
