package koopa.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * Defines possible line endings to be used when parsing.
 * <p>
 * You can set these via the <code>koopa.lineEndings</code> system property.
 * Separate choices with a ','. Separate characters with a '-'. Encode
 * individual characters by their integer value. E.g.:
 * 
 * <pre>
 *   13-10,13,10
 * </pre>
 * 
 * Which corresponds to <code>\r\n</code>, <code>\r</code> and <code>\n</code>.
 * <p>
 * In addition you can also toggle whether line endings should be "sticky" or
 * not. By that we mean whether the first line ending encountered should be used
 * for the remainder of the parse ("sticky" mode), or whether we should try all
 * possible line endings always.
 * <p>
 * This can be toggled by setting the <code>koopa.lineEndings.sticky</code>
 * system property to true (default) or false.
 */
public class LineEndings {

	private LineEndings() {
	}

	private static final Logger LOGGER = Logger.getLogger("eoln");

	private static final List<List<Character>> DEFAULT_LINE_ENDINGS;
	static {
		List<List<Character>> defaultEndings = new LinkedList<>();
		defaultEndings.add(Arrays.asList('\r', '\n'));
		defaultEndings.add(Arrays.asList('\r'));
		defaultEndings.add(Arrays.asList('\n'));

		DEFAULT_LINE_ENDINGS = Collections.unmodifiableList(defaultEndings);
	}

	// ------------------------------------------------------------------------

	private static final String LINE_ENDINGS = "koopa.lineEndings";
	private static final String CHOICE_SEPARATOR = ",";
	private static final String BYTE_SEPARATOR = "-";
	private static final String REGEX = "\\d+(-\\d+)*(,\\d+(-\\d+)*)*";
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	private static List<List<Character>> lineEndings = null;

	static {
		final String definition = System.getProperty(LINE_ENDINGS);

		List<List<Character>> lineEndings = null;

		if (definition != null)
			lineEndings = decodeChoices(definition);

		setChoices(lineEndings);
	}

	/**
	 * These are <code>\r\n</code>, <code>\r</code> and <code>\n</code>, in that
	 * order.
	 */
	public static List<List<Character>> getDefaults() {
		return DEFAULT_LINE_ENDINGS;
	}

	public static void setChoices(String definition) {
		setChoices(decodeChoices(definition));
	}

	private static void setChoices(List<List<Character>> choices) {
		if (choices == null)
			lineEndings = DEFAULT_LINE_ENDINGS;
		else
			lineEndings = Collections.unmodifiableList(choices);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Line endings: " + encodeChoices(lineEndings));
	}

	/**
	 * Specify these via system property <code>koopa.lineEndings</code>.
	 * <p>
	 * Otherwise, this returns {@linkplain #getDefaults()}.
	 */
	public static List<List<Character>> getChoices() {
		return lineEndings;
	}

	/**
	 * Tells you whether an input is a valid definition for line endings.
	 */
	public static boolean isValidDefinition(String value) {
		return PATTERN.matcher(value).matches();
	}

	public static String encodeChoices(List<List<Character>> choices) {
		StringBuilder sb = new StringBuilder();

		for (List<Character> choice : choices) {
			if (sb.length() > 0)
				sb.append(CHOICE_SEPARATOR);

			sb.append(encodeLineEnding(choice));
		}

		return sb.toString();
	}

	public static String encodeLineEnding(List<Character> characters) {
		StringBuilder sb = new StringBuilder();

		for (Character character : characters) {
			if (sb.length() > 0)
				sb.append(BYTE_SEPARATOR);

			sb.append((int) character);
		}

		return sb.toString();
	}

	private static List<List<Character>> decodeChoices(final String definition) {
		if (definition == null || !isValidDefinition(definition))
			return null;

		final String[] choices = definition.split(CHOICE_SEPARATOR);

		List<List<Character>> decoded = new ArrayList<>(choices.length);

		for (String choice : choices) {
			final String[] bytes = choice.split(BYTE_SEPARATOR);
			final byte[] values = new byte[bytes.length];

			for (int i = 0; i < bytes.length; i++)
				values[i] = (byte) Long.parseLong(bytes[i]);

			final char[] cs = Encoding.getChars(values);

			List<Character> chars = new ArrayList<>();
			for (char c : cs)
				chars.add(c);

			decoded.add(chars);
		}

		return decoded;
	}

	// ------------------------------------------------------------------------

	private static final String STICKY_ENDINGS = LINE_ENDINGS + ".sticky";

	private static boolean sticky = true;
	static {
		setSticky("true".equalsIgnoreCase( //
				System.getProperty(STICKY_ENDINGS, "true")));
	}

	public static boolean areSticky() {
		return sticky;
	}

	public static void setSticky(boolean b) {
		sticky = b;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(sticky ? "Line endings are sticky."
					: "Line endings are re-evaluated every time.");

	}
}
