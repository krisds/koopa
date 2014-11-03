package koopa.app.cc;

import java.io.File;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import koopa.core.trees.antlr.CommonTreeProcessor;
import koopa.core.trees.antlr.filter.Filter;
import koopa.core.trees.antlr.filter.FilteredTreeNodeStream;

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
