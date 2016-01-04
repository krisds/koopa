package koopa.core.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

	private static String getString(byte[] bytes) {
		try {
			return new String(bytes, charset.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	private static char[] getChars(byte[] bytes) {
		return getString(bytes).toCharArray();
	}

	// ------------------------------------------------------------------------

	private static final List<List<Character>> DEFAULT_LINE_ENDINGS;

	static {
		List<List<Character>> defaultEndings = new LinkedList<List<Character>>();
		defaultEndings.add(Arrays.asList('\r', '\n'));
		defaultEndings.add(Arrays.asList('\r'));
		defaultEndings.add(Arrays.asList('\n'));

		DEFAULT_LINE_ENDINGS = Collections.unmodifiableList(defaultEndings);
	}

	private static final String CHOICE_SEPARATOR = ",";
	private static final String BYTE_SEPARATOR = "-";
	private static List<List<Character>> lineEndings = null;

	static {
		final String definition = System.getProperty("koopa.lineEndings");

		if (definition != null) {
			final String[] choices = definition.split(CHOICE_SEPARATOR);
			lineEndings = new ArrayList<List<Character>>(choices.length);

			for (String choice : choices) {
				final String[] bytes = choice.split(BYTE_SEPARATOR);
				final byte[] values = new byte[bytes.length];

				for (int i = 0; i < bytes.length; i++)
					values[i] = (byte) Long.parseLong(bytes[i]);

				final char[] cs = Encoding.getChars(values);

				List<Character> chars = new ArrayList<Character>();
				for (char c : cs)
					chars.add(c);

				lineEndings.add(chars);
			}
		}

		if (lineEndings == null)
			lineEndings = DEFAULT_LINE_ENDINGS;

		lineEndings = Collections.unmodifiableList(lineEndings);

		if (LOGGER.isTraceEnabled()) {
			StringBuilder sb = new StringBuilder();
			for (List<Character> cs : lineEndings) {
				if (sb.length() > 0)
					sb.append(CHOICE_SEPARATOR);

				for (int i = 0; i < cs.size(); i++) {
					if (i > 0)
						sb.append(BYTE_SEPARATOR);
					sb.append((int) cs.get(i));
				}
			}
			LOGGER.trace("Line endings: " + sb.toString() + ".");
		}
	}

	/**
	 * These are <code>\r\n</code>, <code>\r</code> and <code>\n</code>, in that
	 * order.
	 */
	public static List<List<Character>> getDefaultLineEndings() {
		return DEFAULT_LINE_ENDINGS;
	}

	/**
	 * Specify these via system property <code>koopa.lineEndings</code>.
	 * <p>
	 * Otherwise, this returns {@linkplain Encoding#getDefaultLineEndings()}.
	 */
	public static List<List<Character>> getLineEndings() {
		return lineEndings;
	}
}
