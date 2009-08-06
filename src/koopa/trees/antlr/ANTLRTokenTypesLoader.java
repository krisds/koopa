package koopa.trees.antlr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ANTLRTokenTypesLoader {

	public Properties load(String filename) throws IOException {
		Properties properties = new Properties();

		InputStreamReader ir = new InputStreamReader(
				ANTLRTokenTypesLoader.class.getResourceAsStream(filename));
		BufferedReader br = new BufferedReader(ir);

		String line = br.readLine();
		while (line != null) {
			// System.err.println(line);

			if (line.trim().length() == 0) {
				continue;
			}

			int pos = 0;
			final int len = line.length();
			char c = line.charAt(pos);

			if (c == '\'') {
				pos++;
				while (pos < len) {
					c = line.charAt(pos);

					if (c == '\'') {
						break;
					}

					if (c == '\\') {
						pos++;
					}

					pos++;
				}
			}

			if (pos == len) {
				// TODO Flag bad line ?
				continue;
			}

			while (pos < len) {
				c = line.charAt(pos);

				if (c == '=') {
					break;
				}

				pos++;
			}

			if (pos == len) {
				// TODO Flag bad line ?
				continue;
			}

			String key = line.substring(0, pos).trim();
			String value = line.substring(pos + 1).trim();

			properties.put(key, value);

			line = br.readLine();
		}

		return properties;
	}

}
