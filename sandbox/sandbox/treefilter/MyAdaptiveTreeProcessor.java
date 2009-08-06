package sandbox.treefilter;

import java.io.File;

import koopa.trees.antlr.CommonTreeProcessor;
import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteredTreeNodeStream;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;


public class MyAdaptiveTreeProcessor implements CommonTreeProcessor {
	public boolean processes(CommonTree tree, File file) {
		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		Filter filter = null;
		if (isCopybook) {
			filter = new MyAdaptiveTreeParserFilter().copybook();
		} else {
			filter = new MyAdaptiveTreeParserFilter().compilationGroup();
		}

		FilteredTreeNodeStream filteredStream = new FilteredTreeNodeStream(
				tree, filter);
		MyAdaptiveTreeParser parser = new MyAdaptiveTreeParser(filteredStream);

		try {
			if (isCopybook) {
				parser.copybook();
			} else {
				parser.compilationGroup();
			}

			return parser.getNumberOfSyntaxErrors() == 0;

		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
