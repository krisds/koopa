package koopa.sql.grammar;

import koopa.core.grammars.KoopaGrammar;

public class SQLBaseGrammar extends KoopaGrammar {

	@Override
	public String getNamespace() {
		return "sql";
	}

	@Override
	public boolean isCaseSensitive() {
		return false;
	}
}
