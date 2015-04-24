package koopa.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
}
