package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.Stream;

/**
 * Accepts a single token if its text matches the given text.
 * <p>
 * This will skip all intermediate separators, other than the text itself.
 */
public class MatchToken extends ParserCombinator {

	private final Grammar grammar;
	private final boolean isSeparator;
	private final String text;

	public MatchToken(Grammar grammar, String text) {
		this.grammar = grammar;
		this.isSeparator = grammar.isSeparator(text);
		this.text = text;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (!isSeparator)
			grammar.skipSeparators(parse);
		else
			grammar.skipOtherSeparators(parse, text);

		final Token token = stream.forward();

		if (token != null && matchesText(token)) {

			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " =~ " + text + " : yes");

			parse.getStack().getScope().setRValue(token);
			return true;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " =~ " + text + " : no");

			return false;
		}
	}

	private boolean matchesText(final Token token) {
		if (grammar.isCaseSensitive())
			return token.getText().equals(text);
		else
			return token.getText().equalsIgnoreCase(text);
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		keywords.add(text);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		keywords.add(text);
	}

	public boolean isKeyword(String word, Frame frame) {
		return frame.up().isKeyword(word);
	}

	public String toString() {
		return "'" + text + "'";
	}
}