package koopa.core.treeparsers;

/**
 * This is a tree parser combinator whose internal parser can be set at a later
 * time. This is needed by grammars which have parser definitions which refer to
 * each other (either directly or indirectly). To prevent infinite recursion in
 * such a case you can first create instances of this class, and then install
 * the definitions later.
 */
// TODO Rename to ScopedTreeParser ?
public abstract class FutureTreeParser extends TreeParser {

	protected TreeParser parser = null;

	public void setParser(TreeParser parser) {
		assert (this.parser == null);
		assert (parser != null);
		this.parser = parser;
	}
}
