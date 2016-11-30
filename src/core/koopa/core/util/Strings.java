package koopa.core.util;

import java.util.Collection;

public class Strings {

	/**
	 * Equivalent to String.isEmpty() from later Java versions.
	 */
	public static boolean isEmpty(String s) {
		return s != null && s.length() == 0;
	}

	/**
	 * Similar to String.join(...) from later Java versions.
	 */
	public static String join(String delimiter, Collection<String> elements) {
		if (delimiter == null)
			throw new NullPointerException("No delimiter given.");
		if (elements == null)
			throw new NullPointerException("No elements given.");

		boolean first = true;
		StringBuilder builder = new StringBuilder();

		for (String element : elements) {
			if (!first)
				builder.append(delimiter);
			builder.append(element);
			first = false;
		}

		return builder.toString();
	}

	/**
	 * Similar to String.join(...) from later Java versions.
	 */
	public static String join(String delimiter, String... elements) {
		if (delimiter == null)
			throw new NullPointerException("No delimiter given.");
		if (elements == null)
			throw new NullPointerException("No elements given.");

		boolean first = true;
		StringBuilder builder = new StringBuilder();

		for (String element : elements) {
			if (!first)
				builder.append(delimiter);
			builder.append(element);
			first = false;
		}

		return builder.toString();
	}

	/**
	 * Splits the given string into words, capitalizes each one, and joins them
	 * back together.
	 */
	public static String titleCase(String s) {
		final String[] words = s.split("\\s+");
		final StringBuilder builder = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			builder.append(words[i].substring(0, 1).toUpperCase());
			builder.append(words[i].substring(1).toLowerCase());
			builder.append(" ");
		}

		return builder.toString();
	}
}
