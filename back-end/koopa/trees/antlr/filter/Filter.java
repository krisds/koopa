package koopa.trees.antlr.filter;

public interface Filter {
	public static final boolean DEBUG = false;

	public boolean filter(FilteringTokenizer tokenizer);
}
