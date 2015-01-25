package koopa.cobol.sql.grammar;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingBaseGrammar;

public class SQLBaseGrammar extends CobolPreprocessingBaseGrammar {

	@Override
	protected String getNamespace() {
		return "sql";
	}
}
