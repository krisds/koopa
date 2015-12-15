package koopa.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

public final class Files {

	private static final Logger LOGGER = Logger.getLogger("files");

	private static Charset charset;
	static {
		final String encoding = System.getProperty("koopa.encoding");

		if (encoding == null) {
			charset = Charset.defaultCharset();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Using default charset: " + charset + ".");

		} else if (!Charset.isSupported(encoding)) {
			charset = Charset.defaultCharset();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Encoding not supported: '" + encoding
						+ "'. Using default charset instead: " + charset + ".");

		} else {
			charset = Charset.forName(encoding);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Using specified charset: " + charset + ".");
		}
	}

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
		return new InputStreamReader(stream, charset);
	}
}
