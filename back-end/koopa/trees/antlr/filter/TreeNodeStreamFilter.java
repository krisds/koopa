package koopa.trees.antlr.filter;

import koopa.trees.antlr.filter.filters.DisjunctiveFilter;
import koopa.trees.antlr.filter.filters.LiteralFilter;
import koopa.trees.antlr.filter.filters.NodeFilter;
import koopa.trees.antlr.filter.filters.OptionalFilter;
import koopa.trees.antlr.filter.filters.RepeatedFilter;
import koopa.trees.antlr.filter.filters.SequentialFilter;
import koopa.trees.antlr.filter.filters.SubtreeFilter;

public class TreeNodeStreamFilter {

	protected Filter node(int type) {
		return new NodeFilter(type);
	}

	protected Filter star(Filter filter) {
		return new RepeatedFilter(filter);
	}

	protected Filter opt(Filter filter) {
		return new OptionalFilter(filter);
	}

	protected Filter or(Filter... filters) {
		return new DisjunctiveFilter(filters);
	}

	protected Filter seq(Filter... filters) {
		return new SequentialFilter(filters);
	}

	protected Filter tree(int type, Filter filter) {
		return new SubtreeFilter(type, filter);
	}

	protected Filter literal(String value) {
		return new LiteralFilter(value);
	}
}
