package koopa.core.parsers;

import java.util.HashSet;
import java.util.Set;

import koopa.core.parsers.ParseStack.Frame;

/**
 * This is a parser combinator whose internal parser can be set at a later time.
 * This is needed by grammars which have parser definitions which refer to each
 * other (either directly or indirectly). To prevent infinite recursion in such
 * a case you can first create instances of this class, and then install the
 * definitions later.
 */
// TODO Rename to ScopedParser ?
public abstract class FutureParser extends Parser {

	protected Parser parser = null;
	private Set<String> allKeywords;

	public void setParser(Parser parser) {
		assert (this.parser == null);
		assert (parser != null);

		this.parser = parser;
	}

	private Set<String> getAllKeywordsInScope() {
		if (allKeywords == null) {
			allKeywords = new HashSet<String>();
			parser.addAllKeywordsInScopeTo(allKeywords);
		}

		return allKeywords;
	}

	public boolean isKeyword(String word, Frame frame) {
		if (getAllKeywordsInScope().contains(word))
			return true;

		return frame.up().isKeyword(word);
	}
}
