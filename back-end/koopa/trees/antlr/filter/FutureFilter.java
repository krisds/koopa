package koopa.trees.antlr.filter;

public class FutureFilter implements Filter {

	protected Filter filter = null;

	public void setFilter(Filter filter) {
		assert (this.filter == null);
		this.filter = filter;
	}

	public boolean filter(FilteringTokenizer tokenizer) {
		return this.filter != null ? this.filter.filter(tokenizer) : false;
	}
	
	public String toString() {
		return this.filter == null ? "<<future>>" : this.filter.toString();
	}
}
