package koopa.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class Util {
	private Util() {
	}

	public static String contents(File file) {
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
}
