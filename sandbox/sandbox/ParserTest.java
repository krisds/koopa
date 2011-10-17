package sandbox;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.parsers.cobol.CobolParser;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ParserTest {

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

		final long start = System.currentTimeMillis();

		int count = 0;
		List<File> erroneous = new LinkedList<File>();
		for (File file : sources) {
			System.out.println("Processing " + file);
			if (parser.parse(file).isValidInput()) {
				count += 1;

			} else {
				erroneous.add(file);
			}

			System.out.println();
		}

		final long end = System.currentTimeMillis();

		System.out.println("Found " + sources.length + " sources.");
		System.out.println("Parsing took " + (end - start) + "ms.");
		System.out.println(count + " source files parsed successfully.");

		if (!erroneous.isEmpty()) {
			System.out.println("Following files failed to parse:");
			for (File file : erroneous) {
				System.out.println("  " + file);
			}
		}
	}
}
