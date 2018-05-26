package koopa.core.sources.test;

import koopa.core.data.Token;
import koopa.core.trees.Tree;

public interface DataValidator {

	void validate(Token token, String category, boolean required);

	void validate(Tree tree, String category, boolean required);
}
