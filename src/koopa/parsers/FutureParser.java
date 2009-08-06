package koopa.parsers;

public abstract class FutureParser extends Parser {

	protected Parser parser = null;

	public void setParser(Parser parser) {
		assert (this.parser == null);
		assert (parser != null);
		this.parser = parser;
	}
}
