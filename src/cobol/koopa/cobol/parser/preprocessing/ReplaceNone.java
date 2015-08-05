package koopa.cobol.parser.preprocessing;

import java.util.LinkedList;

import koopa.core.data.Token;
import koopa.core.sources.Source;

/**
 * This class is an implementation of {@linkplain ReplacingPhrase} which will
 * never replace anything. It's used as a dummy implementation for replacing
 * phrases which are not supported yet.
 */
public class ReplaceNone extends ReplacingPhrase {
	public ReplaceNone() {
		super(null, null);
	}

	public boolean appliedTo(Source<Token> source, LinkedList<Token> newTokens) {
		return false;
	}
}
