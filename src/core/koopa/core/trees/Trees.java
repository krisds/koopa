package koopa.core.trees;

import java.util.List;

import koopa.core.data.Data;
import koopa.core.grammars.Grammar;

public class Trees {
	public static Tree getTree(Grammar grammar, List<Data> data) {
		KoopaTreeBuilder builder = new KoopaTreeBuilder(grammar, true);

		for (Data d : data)
			builder.push(d);

		final List<Tree> trees = builder.getTrees();
		return trees == null || trees.size() != 1 ? null : trees.get(0);
	}
}
