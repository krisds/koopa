package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import koopa.core.data.Token;

/**
 * This looks for bash-style comments (starting with a hash '#' mark, up to the
 * end of the line) in the source and marks them as comment.
 */
public class BashStyleComments extends ChainingSource<Token, Token> implements
		Source<Token> {

	private boolean inComment = false;

	public BashStyleComments(Source<Token> source) {
		super(source);
	}

	@Override
	protected Token nxt1() {
		Token token = source.next();

		if (token == null)
			return null;

		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return token;

		if (inComment) {
			if (!token.hasTag(END_OF_LINE))
				return token.withTags(COMMENT);

			inComment = false;
			return token;

		} else {
			if (!"#".equals(token.getText()))
				return token;

			inComment = true;
			return token.withTags(COMMENT);
		}
	}

	public void close() {
		source.close();
	}
}
