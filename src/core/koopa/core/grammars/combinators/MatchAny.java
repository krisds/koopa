package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * Accepts any and all tokens. Will only fail when there are no more tokens on
 * the token stream.
 * <p>
 * This will skip all intermediate separators.
 */
public class MatchAny extends ParserCombinator {

	private final Grammar grammar;

	public MatchAny(Grammar grammar) {
		this.grammar = grammar;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		grammar.skipSeparators(parse);

		final Token token = stream.forward();

		if (token != null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " != null : yes");

			parse.getStack().getScope().setRValue(token);
			return true;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " != null : no");

			return false;
		}
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public String toString() {
		return "_";
	}
}