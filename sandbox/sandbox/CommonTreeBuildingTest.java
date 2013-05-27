package sandbox;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.app.ApplicationSupport;
import koopa.parsers.cobol.CobolParser;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CommonTreeBuildingTest {

	private static final boolean EXIT_ON_FIRST_ERROR = false;

	public static void main(String[] args) throws IOException {
		Logger.getLogger("parser").setLevel(Level.TRACE);

		File folder = new File("testsuite/cobol85");
		// File folder = new File("testsuite/koopa");

		File[] sources = folder.listFiles(ApplicationSupport
				.getFilenameFilter());

		final CobolParser parser = new CobolParser();
		parser.setBuildTrees(true);

		int count = 0;
		List<File> erroneous = new LinkedList<File>();
		for (File file : sources) {
			System.out.println("Processing " + file);
			if (parser.parse(file).isValidInput()) {
				count += 1;

			} else {
				erroneous.add(file);
				if (EXIT_ON_FIRST_ERROR) {
					break;
				}
			}

			System.out.println();
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
}
