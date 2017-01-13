package koopa.sql.grammar;

import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.ParserCombinator;

public abstract class SQLBaseGrammar extends KoopaGrammar {

	@Override
	public String getNamespace() {
		return "sql";
	}

	@Override
	public boolean isCaseSensitive() {
		return false;
	}

	protected abstract ParserCombinator word();

	@Override
	public ParserCombinator keyword() {
		return word();
	}
}
