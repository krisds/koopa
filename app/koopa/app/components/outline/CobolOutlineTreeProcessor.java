package koopa.app.components.outline;

import java.io.File;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import koopa.trees.antlr.CommonTreeProcessor;
import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteredTreeNodeStream;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;


public class CobolOutlineTreeProcessor implements CommonTreeProcessor {
	private List<DefaultMutableTreeNode> trees = null;

	public boolean processes(CommonTree tree, File file) {
		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		Filter filter = null;
		if (isCopybook) {
			filter = new CobolOutlineTreeParserFilter().copybook();
		} else {
			filter = new CobolOutlineTreeParserFilter().compilationGroup();
		}

		FilteredTreeNodeStream filteredStream = new FilteredTreeNodeStream(
				tree, filter);
		CobolOutlineTreeParser parser = new CobolOutlineTreeParser(
				filteredStream);

		try {
			if (isCopybook) {
				parser.copybook();
			} else {
				parser.compilationGroup();
			}

			this.trees = parser.getTrees();

			return parser.getNumberOfSyntaxErrors() == 0;

		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean hasTrees() {
		return this.trees != null && !this.trees.isEmpty();
	}

	public List<DefaultMutableTreeNode> getTrees() {
		return this.trees;
	}
}
