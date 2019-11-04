package koopa.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class Files {

	private Files() {
	}

	public static String getText(File file) {
		if (file == null)
			return null;

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			StringBuffer buffer = new StringBuffer();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				buffer.append(line);
				buffer.append('\n');
			}

			return buffer.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			try {
				if (fileReader != null)
					fileReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getFilename(String path) {
		if (path == null)
			return null;
		int sep = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
		if (sep < 0)
			return path;

		return path.substring(sep + 1, path.length());
	}

	/**
	 * Return the "name" part of a filename. That is, everything up to the final
	 * dot, if there is one.
	 */
	public static String getName(String filename) {
		int dot = filename.lastIndexOf(".");

		if (dot < 0)
			return filename;

		return filename.substring(0, dot);
	}

	/**
	 * Return the "name" part of a filename. That is, everything up to the final
	 * dot, if there is one.
	 */
	public static String getName(File file) {
		return getName(file.getName());
	}

	/**
	 * Return the extension of a given filename. That is, everything from the
	 * final dot, if there is one.
	 */
	public static String getExtension(String filename) {
		int dot = filename.lastIndexOf(".");

		if (dot < 0)
			return "";

		return filename.substring(dot + 1);
	}

	/**
	 * Return the extension of a given filename. That is, everything from the
	 * final dot, if there is one.
	 */
	public static String getExtension(File file) {
		return getExtension(file.getName());
	}

	/**
	 * Returns a {@linkplain Reader} for the given file, using the character set
	 * returned by {@linkplain Encoding#getCharset()}.
	 */
	public static Reader getReader(File file) throws FileNotFoundException {
		final FileInputStream stream = new FileInputStream(file);
		return new InputStreamReader(stream, Encoding.getCharset());
	}

	public static List<File> offset(String relativePathName, File path) {
		if (path == null)
			return Collections.emptyList();

		if (relativePathName == null)
			return Collections.singletonList(path);

		return Collections.singletonList(new File(path, relativePathName));
	}

	/**
	 * Given a list of paths, return a new list of paths which have been offset
	 * by the given relative path name.
	 * <p>
	 * If the given path name is <code>null</null> returns the paths as they
	 * were given.
	 */
	public static List<File> offset(String relativePathName, List<File> paths) {
		if (paths == null || paths.size() == 0)
			return Collections.emptyList();

		if (relativePathName == null)
			return paths;

		List<File> offset = new ArrayList<>();
		for (File path : paths)
			offset.add(new File(path, relativePathName));
		return offset;
	}

	/**
	 * Look in each of the given paths for files matching the given filter. When
	 * you find some ask the given selector which you should return, and return
	 * that one.
	 */
	public static File find(List<File> pathsInOrder, FilenameFilter filter,
			Select<File> selector) {

		if (pathsInOrder == null || pathsInOrder.size() == 0)
			return null;
		if (selector == null)
			return null;

		for (File path : pathsInOrder) {
			File[] matches = path.listFiles(filter);

			if (matches == null || matches.length == 0)
				continue;

			File match = selector.select(matches);
			if (match != null)
				return match;
		}

		return null;
	}

	public static List<File> listFilesRecursively(File root,
			FilenameFilter filenameFilter) {

		LinkedList<File> matchingFiles = new LinkedList<>();

		LinkedList<File> queuedFolders = new LinkedList<>();
		queuedFolders.addLast(root);

		while (!queuedFolders.isEmpty()) {
			final File folder = queuedFolders.removeFirst();

			for (File file : folder.listFiles()) {
				if (file.isDirectory())
					queuedFolders.addLast(file);
				else if (file.isFile()
						&& filenameFilter.accept(folder, file.getName()))
					matchingFiles.add(file);
			}
		}

		return matchingFiles;
	}
}
