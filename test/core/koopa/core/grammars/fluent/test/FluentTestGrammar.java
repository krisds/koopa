package koopa.core.grammars.fluent.test;

import koopa.core.data.Token;
import koopa.core.grammars.fluent.FluentGrammar;

class FluentTestGrammar extends FluentGrammar {

	@Override
	public boolean isSeparator(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProgramText(Token token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComment(Token token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCaseSensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
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