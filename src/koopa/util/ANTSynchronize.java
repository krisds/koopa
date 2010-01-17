package koopa.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ANTSynchronize {
	private static Set<File> affectedFolders = new HashSet<File>();

	public static void main(String[] args) throws IOException {
		if (args == null || args.length < 2) {
			System.out.println("Need a source file and a path.");
			System.exit(-1);
		}

		File source = new File(args[0]);
		if (!source.exists() || !source.isFile()) {
			System.out.println("Need a valid source file and a path.");
			System.exit(-1);
		}

		source = source.getCanonicalFile();

		File path = new File(args[1]);
		if (!path.exists() || !path.isDirectory()) {
			System.out.println("Need a valid source file and a path.");
			System.exit(-1);
		}

		String name = source.getName();
		List<File> matches = new LinkedList<File>();

		process(path, name, matches);

		for (File matched : matches) {
			if (matched.getCanonicalFile().compareTo(source) == 0) {
				continue;
			}

			copy(source, matched);
		}

		for (File folder : affectedFolders) {
			touchGrammarsInFolder(folder);
		}
	}

	private static void process(File file, String name, List<File> matches) {
		if (!file.exists()) {
			return;

		} else if (file.isDirectory()) {
			if (file.getName().equals("build")) {
				return;
			}

			File[] files = file.listFiles();

			for (File stage : files) {
				process(stage, name, matches);
			}

		} else if (file.getName().equals(name)) {
			matches.add(file);
			affectedFolders.add(file.getParentFile());
		}
	}

	private static void copy(File source, File destination) throws IOException {
		System.out.println("Copying " + source + " to " + destination);

		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(destination);

		byte[] buf = new byte[1024];
		int len;

		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		out.close();
		in.close();

		System.out.println("  Done.");
	}

	private static void touchGrammarsInFolder(File folder) {
		if (folder == null) {
			return;
		}

		File[] grammars = folder.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().endsWith(".g");
			}
		});

		long now = System.currentTimeMillis();
		for (File grammar : grammars) {
			System.out.println("Touching grammar " + grammar);
			grammar.setLastModified(now);
		}
	}
}
