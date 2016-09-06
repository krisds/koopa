package koopa.core.grammars.fluent.test;

import koopa.core.data.Token;
import koopa.core.grammars.fluent.FluentGrammar;
import koopa.core.parsers.Parse;

class FluentTestGrammar extends FluentGrammar {

	@Override
	public boolean canBeSkipped(Token token, Parse parse) {
		return false;
	}

	@Override
	public boolean isProgramText(Token token) {
		return false;
	}

	@Override
	public boolean isCaseSensitive() {
		return false;
	}

	@Override
	public String getNamespace() {
		return null;
	}

	@Override
	public NamedDefinition define(String name) {
		return super.define(name);
	}

	@Override
	public DelayedDefinition defineHelper(String name) {
		return super.defineHelper(name);
	}

	@Override
	public Definition definitionOf(String name) {
		return super.definitionOf(name);
	}
}