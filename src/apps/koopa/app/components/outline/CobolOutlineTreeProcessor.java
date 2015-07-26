package koopa.app.components.outline;

import java.io.File;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import koopa.cobol.CobolFiles;
import koopa.core.treeparsers.BasicTreeStream;
import koopa.core.treeparsers.TreeParser;
import koopa.core.treeparsers.TreeStream;
import koopa.core.trees.Tree;

public class CobolOutlineTreeProcessor {
	private List<DefaultMutableTreeNode> trees = null;

	public boolean processes(Tree tree, File file) {
		final boolean isCopybook = CobolFiles.isCopybook(file);

		TreeStream stream = new BasicTreeStream(tree);
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
