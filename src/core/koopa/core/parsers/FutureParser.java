package koopa.core.parsers;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a parser combinator whose internal parser can be set at a later time.
 * This is needed by grammars which have parser definitions which refer to each
 * other (either directly or indirectly). To prevent infinite recursion in such
 * a case you can first create instances of this class, and then install the
 * definitions later.
 */
public class FutureParser extends ParserCombinator {

	protected ParserCombinator parser = null;
	private Set<String> allKeywords;

	public void setParser(ParserCombinator parser) {
		assert (this.parser == null);
		assert (parser != null);

		this.parser = parser;
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		parser.addAllKeywordsInScopeTo(keywords, scopesSeen);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		parser.addAllLeadingKeywordsTo(keywords, scopesSeen);
	}

	@Override
	public boolean allowsLookahead() {
		return parser.allowsLookahead();
	}

	@Override
	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}

	@Override
	public boolean isKeywordInScope(String word) {
		return getAllKeywordsInScope().contains(word);
	}

	private Set<String> getAllKeywordsInScope() {
		if (allKeywords == null) {
			allKeywords = new HashSet<>();
			parser.addAllKeywordsInScopeTo(allKeywords, new HashSet<>());
		}

		return allKeywords;
	}

	@Override
	protected boolean matches(Parse parse) {
		return parser.matches(parse);
	}

	@Override
	public String toString() {
		if (parser == null)
			return "&?";
		else
			return "&" + parser.toString();
	}
}
