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
		int sep = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
		if (sep < 0)
			return path;

		return path.substring(sep + 1, path.length());
	}

	public static String getName(String filename) {
		int dot = filename.lastIndexOf(".");

		if (dot < 0)
			return filename;

		return filename.substring(0, dot);
	}

	public static String getName(File file) {
		return getName(file.getName());
	}

	public static String getExtension(String filename) {
		int dot = filename.lastIndexOf(".");

		if (dot < 0)
			return "";

		return filename.substring(dot);
	}

	public static String getExtension(File file) {
		return getExtension(file.getName());
	}

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

	public static List<File> offset(String relativePathName, List<File> paths) {
		if (paths == null || paths.size() == 0)
			return Collections.emptyList();

		if (relativePathName == null)
			return paths;

		List<File> offset = new ArrayList<File>();
		for (File path : paths)
			offset.add(new File(path, relativePathName));
		return offset;
	}

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

}
