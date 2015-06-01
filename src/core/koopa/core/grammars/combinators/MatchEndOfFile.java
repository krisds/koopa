package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * Accepts when the token stream is at the end of the input (ignoring
 * separators).
 * <p>
 * This will skip all intermediate separators.
 */
public class MatchEndOfFile extends ParserCombinator {

	private final Grammar grammar;

	public MatchEndOfFile(Grammar grammar) {
		this.grammar = grammar;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		grammar.skipSeparators(parse);

		final Token token = stream.forward();
		final boolean atEndOfFile = token == null;

		if (parse.getTrace().isEnabled())
			parse.getTrace().add(token + " == null : " + atEndOfFile);

		return atEndOfFile;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "end-of-file";
	}
}