package koopa.cobol.grammar.directives;

import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;

import koopa.core.data.Token;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.Parse;

public abstract class DirectivesBaseGrammar extends KoopaGrammar {

	public String getNamespace() {
		return "cobol-directives";
	}

	public boolean isCaseSensitive() {
		return false;
	}

	@Override
	public boolean canBeSkipped(Token token, Parse parse) {
		return token.hasAnyTag(WHITESPACE, END_OF_LINE);
	}
}