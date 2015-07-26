package koopa.cobol.parser.preprocessing;

import koopa.core.trees.Tree;

public interface PreprocessingListener {

	void startCopying(Tree copyStatementAST);

	void stopCopying(Tree copyStatementAST);
}
