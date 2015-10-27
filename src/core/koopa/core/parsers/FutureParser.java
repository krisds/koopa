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

	public FutureParser with(ParserCombinator parser) {
		setParser(parser);
		return this;
	}

	private Set<String> getAllKeywordsInScope() {
		if (allKeywords == null) {
			allKeywords = new HashSet<String>();
			parser.addAllKeywordsInScopeTo(allKeywords);
		}

		return allKeywords;
	}

	public boolean isKeyword(String word, Stack.Frame frame) {
		if (getAllKeywordsInScope().contains(word))
			return true;

		return frame.up().isKeyword(word);
	}

	@Override
	protected boolean matches(Parse parse) {
		return parser.matches(parse);
	}
}
