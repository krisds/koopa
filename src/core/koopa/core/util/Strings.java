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
	
	/**
	 * Not all characters take up a single column. This is only true for
	 * "half-width" characters. "Full width" characters require two columns.
	 * This method will tell you how many columns a single character requires.
	 */
	public static int getWidthInColumns(char c) {
		
		// Based on an answer from StackOverflow (https://stackoverflow.com/a/13505508):
		if ('\u0000' <= c && c <= '\u00FF' || '\uFF61' <= c && c <= '\uFFDC'
				|| '\uFFE8' <= c && c <= '\uFFEE')
			return 1;
		else
			return 2;
	}

	/**
	 * Given that some characters require two columns (cfr.
	 * {@linkplain #getWidthInColumns(char)}) we can't just take a string's
	 * length as-is. Instead we have to check every character. This method does
	 * that for you.
	 */
	public static int getWidthInColumns(String text) {
		int length = 0;
		for (int i = 0; i < text.length(); i++)
			length += getWidthInColumns(text.charAt(i));
		return length;
	}

	/**
	 * Given a column number, what character position in the string matches with
	 * that ? A one-to-one match is not certain, as some characters take up two
	 * columns (cfr. {@linkplain #getWidthInColumns(char)}).
	 */
	public static int getCharIndexForColumn(String text, int column) {
		int c = 0;
		
		for (int i = 0; i < text.length(); i++) {
			c += getWidthInColumns(text.charAt(i));
			if (c >= column)
				return i + 1;
		}

		return text.length();
	}
}
