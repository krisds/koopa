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
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	@Override
	public boolean allowsLookahead() {
		if (parser == null) {
			System.out.println("Too Soon !");
			return false;
		}else
			return parser.allowsLookahead();
	}
	
	@Override
	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}

	@Override
	public boolean isKeyword(String word, Stack.Frame frame) {
		if (getAllKeywordsInScope().contains(word))
			return true;

		return parser.isKeyword(word, frame);
	}

	private Set<String> getAllKeywordsInScope() {
		if (allKeywords == null) {
			allKeywords = new HashSet<String>();
			parser.addAllKeywordsInScopeTo(allKeywords);
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
			return "&" + parser;
		else
			return "&" + parser.toString();
	}
}
