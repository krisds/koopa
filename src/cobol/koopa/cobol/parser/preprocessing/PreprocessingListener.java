package koopa.cobol.parser.preprocessing;

import koopa.core.treeparsers.Tree;

public interface PreprocessingListener {

	void startCopying(Tree copyStatementAST);

	void stopCopying(Tree copyStatementAST);
}
