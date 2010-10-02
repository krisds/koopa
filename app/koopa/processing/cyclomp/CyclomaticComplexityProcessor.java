package koopa.processing.cyclomp;

import java.io.File;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import koopa.trees.antlr.CommonTreeProcessor;
import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteredTreeNodeStream;

public class CyclomaticComplexityProcessor implements CommonTreeProcessor {

	public boolean processes(CommonTree tree, File file) {
		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		Filter filter = null;
		if (isCopybook) {
			filter = new CyclomaticComplexityTreeParserFilter().copybook();
		} else {
			filter = new CyclomaticComplexityTreeParserFilter()
					.compilationGroup();
		}

		FilteredTreeNodeStream filteredStream = new FilteredTreeNodeStream(
				tree, filter);
		CyclomaticComplexityTreeParser parser = new CyclomaticComplexityTreeParser(
				filteredStream);

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
