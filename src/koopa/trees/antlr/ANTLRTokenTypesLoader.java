package koopa.trees.antlr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ANTLRTokenTypesLoader {

	public TokenTypes load(String filename) throws IOException {
		TokenTypes tt = new TokenTypes();

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
			boolean literal = false;

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
				literal = true;
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

			tt.put(key, Integer.parseInt(value), literal);

			line = br.readLine();
		}

		return tt;
	}
}
