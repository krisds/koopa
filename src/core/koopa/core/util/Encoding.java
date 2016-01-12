package koopa.core.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

public final class Encoding {

	private Encoding() {
	}

	private static final Logger LOGGER = Logger.getLogger("encoding");

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

	// ------------------------------------------------------------------------

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

	public static Charset getCharset() {
		return charset;
	}

	public static String getString(byte[] bytes) {
		try {
			return new String(bytes, charset.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static char[] getChars(byte[] bytes) {
		return getString(bytes).toCharArray();
	}
}
