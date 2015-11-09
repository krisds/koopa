package koopa.core.util;

public class Strings {

	/**
	 * Equivalent to String.isEmpty() from later Java versions.
	 */
	public static boolean isEmpty(String s) {
		return s != null && s.length() == 0;
	}

}
