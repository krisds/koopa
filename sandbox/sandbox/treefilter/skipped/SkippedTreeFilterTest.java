package sandbox.treefilter.skipped;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.parsers.ParseResults;
import koopa.parsers.cobol.CobolParser;
import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteredTreeNodeStream;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SkippedTreeFilterTest {

	private static final boolean EXIT_ON_FIRST_ERROR = false;

	public static void main(String[] args) throws IOException {
		Logger.getLogger("parser").setLevel(Level.TRACE);

		File folder = new File("testsuite/cobol85");
		// File folder = new File("testsuite/koopa");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toUpperCase();
				return name.endsWith(".CBL") || name.endsWith(".CPY");
			}
		});

		final CobolParser parser = new CobolParser();
		parser.setBuildTrees(true);

		int count = 0;
		List<File> erroneous = new LinkedList<File>();
		for (File file : sources) {
			System.out.println("Processing " + file);

			final ParseResults parseResults = parser.parse(file);
			if (parseResults.isValidInput()) {

				final boolean isCopybook = file.getName().toUpperCase()
						.endsWith(".CPY");

				if (acceptedByMyAdaptiveTreeParser(parseResults.getTree(),
						isCopybook)) {
					System.out
							.println("Adaptive match was successful as well.");
				} else {
					System.out
							.println("Adaptive match, however, was NOT successful.");
				}
				System.out.println();

				count += 1;

			} else {
				erroneous.add(file);
				if (EXIT_ON_FIRST_ERROR) {
					break;
				}
			}
		}

		System.out.println("Found " + sources.length + " sources.");
		System.out.println(count + " of these parsed successfully.");

		if (!erroneous.isEmpty()) {
			System.out
					.println("Following files were found not to parse correctly:");
			for (File file : erroneous) {
				System.out.println("  " + file);
			}
		}
	}

	private static boolean acceptedByMyAdaptiveTreeParser(CommonTree tree,
			boolean isCopybook) {
		// System.out.println(tree.toStringTree());

		Filter filter = null;
		if (isCopybook) {
			filter = new SkippedTreeParserFilter().copybook();
		} else {
			filter = new SkippedTreeParserFilter().compilationGroup();
		}

		FilteredTreeNodeStream filteredStream = new FilteredTreeNodeStream(
				tree, filter);
		SkippedTreeParser parser = new SkippedTreeParser(filteredStream);

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
