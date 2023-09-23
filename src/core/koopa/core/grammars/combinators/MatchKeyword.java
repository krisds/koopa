package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Accepts {@linkplain Grammar#keyword()} if its match covers the given text.
 */
public class MatchKeyword extends TestProgramText {

	private final String word;

	public MatchKeyword(Grammar grammar, String text) {
		super(grammar, grammar.keyword());
		this.word = grammar.comparableText(text);
	}

	@Override
	protected boolean matchesProgramText(Parse parse, String text) {
		return grammar.comparableText(text).equals(word);
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		keywords.add(word);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		keywords.add(word);
	}
	
	@Override
	public boolean allowsLookahead() {
		return true;
	}

	@Override
	public String toString() {
		return "keyword " + word;
	}
}