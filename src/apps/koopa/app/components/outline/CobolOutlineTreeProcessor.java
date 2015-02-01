package koopa.app.components.outline;

import java.io.File;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import koopa.core.treeparsers.Tree;
import koopa.core.treeparsers.TreeParser;
import koopa.core.treeparsers.TreeStream;
import koopa.core.trees.TreeProcessor;

public class CobolOutlineTreeProcessor implements TreeProcessor {
	private List<DefaultMutableTreeNode> trees = null;

	public boolean processes(Tree tree, File file) {
		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		TreeStream stream = new TreeStream(tree);
		CobolOutlineTreeGrammar grammar = new CobolOutlineTreeGrammar();

		TreeParser parser = isCopybook ? grammar.copybook() : grammar
				.compilationGroup();

		boolean accepts = parser.accepts(stream);

		// TODO Slightly weird that I have to use grammar rather than parser
		// here...
		this.trees = grammar.getTrees();

		return accepts;
	}

	public boolean hasTrees() {
		return this.trees != null && !this.trees.isEmpty();
	}

	public List<DefaultMutableTreeNode> getTrees() {
		return this.trees;
	}
}
