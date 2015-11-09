package koopa.core.util;

import org.apache.log4j.Logger;

public class Encoding {

	private static final Logger LOGGER = Logger.getLogger("config");

	private static final String LINE_SEPARATOR;

	static {
		if (System.getProperty("line.separator") == null) {
			LOGGER.warn("Line separator has not been correctly set in this environment. "
					+ "Defaulting to Unix style line endings.");
		}

		LINE_SEPARATOR = System.getProperty("line.separator", "\n");
	}

	/**
	 * Equivalent (I hope) to System.lineSeparator() in later Java versions.
	 */
	public static String lineSeparator() {
		return LINE_SEPARATOR;
	}

}
