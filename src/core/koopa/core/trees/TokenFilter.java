package koopa.core.trees;

import koopa.core.data.Token;

public interface TokenFilter {
	boolean include(Token token);
}
