package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.tags.SyntacticTag;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Accepts a single token if it is tagged with {@linkplain SyntacticTag#NUMBER}
 * and its text matches the given text.
 */
public class MatchNumber extends GrammaticalCombinator {

	private final String comparableText;

	public MatchNumber(Grammar grammar, String text) {
		super(grammar);
		this.comparableText = grammar.comparableText(text);
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Data d = parse.getStream().forward();

		if (d == null || !(d instanceof Token)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, null");

			return false;

		}

		final Token t = (Token) d;

		if (!t.hasTag(SyntacticTag.NUMBER)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(
						toString() + " : no, not tagged as a NUMBER, " + t);

			return false;

		} else if (!comparableText.equals(t.getText())) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, " + t);

			return false;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : yes, " + t);

			return true;
		}
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		keywords.add(comparableText);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		keywords.add(comparableText);
	}
	
	@Override
	public boolean allowsLookahead() {
		return false;
	}

	@Override
	public String toString() {
		return "number " + comparableText;
	}
}