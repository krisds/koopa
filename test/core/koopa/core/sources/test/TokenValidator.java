package koopa.core.sources.test;

import koopa.core.data.Token;

public interface TokenValidator {

	void validate(Token token, String category, boolean required);
}
