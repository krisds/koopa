package koopa.examples.treegrammars;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.cobol.CobolParser;
import koopa.core.treeparsers.Tree;
import koopa.core.treeparsers.TreeParser;
import koopa.core.treeparsers.TreeStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CobolStructureSample {

	private static final boolean EXIT_ON_FIRST_ERROR = true;

	public static void main(String[] args) throws IOException {
		Logger.getLogger("parser").setLevel(Level.TRACE);

		File folder = new File("testsuite/cobol85");
		// File folder = new File("testsuite/koopa");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toUpperCase().endsWith(".CBL");
			}
		});

		final CobolParser parser = new CobolParser();
		parser.setBuildTrees(true);

		int acceptedByCobolParser = 0;
		int acceptedByTreeParser = 0;
		List<File> erroneous = new LinkedList<File>();

		for (File file : sources) {
			final boolean isCopybook = file.getName().toUpperCase()
					.endsWith(".CPY");

			if (isCopybook)
				continue;

			System.out.println("Processing " + file);

			final ParseResults parseResults = parser.parse(file);
			if (parseResults.isValidInput()) {

				if (acceptedByCobolStructureTreeParser(parseResults.getTree())) {
					System.out
							.println("Tree parser match was successful as well.");
					acceptedByTreeParser += 1;

				} else {
					System.out
							.println("Tree parser match, however, was NOT successful.");

					erroneous.add(file);
					if (EXIT_ON_FIRST_ERROR)
						break;
				}

				System.out.println();
				acceptedByCobolParser += 1;

			} else {
				erroneous.add(file);
			}
		}

		System.out.println("Found " + sources.length + " sources.");
		System.out.println(acceptedByCobolParser
				+ " of these parsed successfully.");
		System.out.println(acceptedByTreeParser
				+ " of those were accepted by the tree parser.");

		if (!erroneous.isEmpty()) {
			System.out.println("Following files had problems:");
			for (File file : erroneous)
				System.out.println("  " + file);
		}
	}

	private static boolean acceptedByCobolStructureTreeParser(Tree tree) {
		// System.out.println(tree.toStringTree());

		TreeStream stream = new TreeStream(tree);

		CobolStructureTreeGrammar grammar = new CobolStructureTreeGrammar();
		TreeParser parser = grammar.compilationGroup();

		return parser.accepts(stream);
	}
}
