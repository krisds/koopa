package koopa.cics.grammar;

import koopa.core.grammars.KoopaGrammar;

public class CICSBaseGrammar extends KoopaGrammar {

	@Override
	public String getNamespace() {
		return "cics";
	}

	@Override
	public boolean isCaseSensitive() {
		return false;
	}
}
