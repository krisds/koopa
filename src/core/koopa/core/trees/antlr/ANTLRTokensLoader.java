package koopa.core.trees.antlr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Class for loading an {@linkplain ANTLRTokens} instance from an ANTLR
 * ".tokens" file.
 */
public final class ANTLRTokensLoader {

	private ANTLRTokensLoader() {
	}

	/**
	 * Load the specified tokens resource, and return a {@linkplain ANTLRTokens}
	 * object holding the equivalent information.
	 */
	public static ANTLRTokens loadResource(String resourceName)
			throws IOException {
		final InputStream resourceStream = ANTLRTokensLoader.class
				.getResourceAsStream(resourceName);

		assert (resourceStream != null) : "Expected a valid resourcename, "
				+ "but this one yields nothing: " + resourceName;

		InputStreamReader reader = new InputStreamReader(resourceStream);
		return load(reader, new ANTLRTokens());
	}

	public static ANTLRTokens loadFile(File file) throws IOException {
		return loadFile(file, new ANTLRTokens());
	}

	public static ANTLRTokens loadFile(File file, ANTLRTokens tt)
			throws IOException {
		FileReader reader = new FileReader(file);

		return load(reader, tt);
	}

	private static ANTLRTokens load(Reader reader, ANTLRTokens tt)
			throws IOException {

		BufferedReader br = new BufferedReader(reader);

		String line = br.readLine();
		while (line != null) {
			if (line.trim().length() == 0)
				continue;

			// Every line is of the form "key=integer". If the key is quoted
			// then it means it's a literal.

			int pos = 0;
			final int len = line.length();
			char c = line.charAt(pos);
			boolean literal = false;

			if (c == '\'') {
				pos++;
				while (pos < len) {
					c = line.charAt(pos);

					if (c == '\'')
						break;

					if (c == '\\')
						pos++;

					pos++;
				}
				literal = true;
			}

			if (pos == len) {
				// TODO Flag bad line ?
				continue;
			}

			while (pos < len) {
				c = line.charAt(pos);

				if (c == '=')
					break;

				pos++;
			}

			if (pos == len) {
				// TODO Flag bad line ?
				continue;
			}

			String key = line.substring(0, pos).trim();
			String value = line.substring(pos + 1).trim();
			tt.put(key, Integer.parseInt(value), literal);

			line = br.readLine();
		}

		return tt;
	}
}
