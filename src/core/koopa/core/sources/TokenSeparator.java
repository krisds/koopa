package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;

import java.util.LinkedList;

import koopa.core.data.Data;
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
public class TokenSeparator extends ChainingSource
		implements Source {

	private final LinkedList<Token> pendingTokens = new LinkedList<>();

	public TokenSeparator(Source source) {
		super(source);
	}

	@Override
	protected Data nxt1() {
		if (!pendingTokens.isEmpty())
			return pendingTokens.removeFirst();

		final Data d = source.next();
		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;
		if (t.hasTag(END_OF_LINE))
			return t.withTags(SEPARATOR);
		else if (!t.hasTag(PROGRAM_TEXT_AREA) || t.hasTag(COMMENT))
			return t;

		tokenizeProgramText(t);
		return pendingTokens.removeFirst();
	}

	protected void tokenizeProgramText(final Token token) {
		for (Token t : TokenSeparationLogic.apply(token))
			pendingTokens.add(t);
	}
}
