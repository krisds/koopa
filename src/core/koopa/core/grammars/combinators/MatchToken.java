package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Accepts a single token if its text matches the given text.
 */
public class MatchToken extends GrammaticalCombinator {

	private final String comparableText;

	public MatchToken(Grammar grammar, String text) {
		super(grammar);
		this.comparableText = grammar.comparableText(text);
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Token token = parse.getStream().forward();

		if (token == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, null");

			return false;

		} else if (!comparableText.equals(grammar.comparableText(token
				.getText()))) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, " + token);

			return false;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : yes, " + token);

			return true;
		}
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		keywords.add(comparableText);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		keywords.add(comparableText);
	}

	@Override
	public String toString() {
		return "token " + comparableText;
	}
}