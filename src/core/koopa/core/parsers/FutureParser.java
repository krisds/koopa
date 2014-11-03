package koopa.core.parsers;

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

	public void setParser(Parser parser) {
		assert (this.parser == null);
		assert (parser != null);
		this.parser = parser;
	}
}
