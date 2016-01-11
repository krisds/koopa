package koopa.cobol;

public class CobolWords {

	private CobolWords() {
	}

	private static final int DEFAULT_MAX_LENGTH = 31;
	private static int MAX_LENGTH;

	static {
		String maxCobolWordLengthSetting = System.getProperty(
				"koopa.maxCobolWordLength", "" + DEFAULT_MAX_LENGTH);

		int maxCobolWordLengthValue;
		try {
			maxCobolWordLengthValue = Integer
					.parseInt(maxCobolWordLengthSetting);

		} catch (NumberFormatException e) {
			System.err
					.println("Warning: value for koopa.maxCobolWordLength is not a number: "
							+ maxCobolWordLengthSetting);
			maxCobolWordLengthValue = DEFAULT_MAX_LENGTH;
		}

		if (maxCobolWordLengthValue == 0)
			maxCobolWordLengthValue = DEFAULT_MAX_LENGTH;

		MAX_LENGTH = maxCobolWordLengthValue;
	}

	public static int getMaxLength() {
		return MAX_LENGTH;
	}

	public static void setMaxLength(int length) {
		MAX_LENGTH = length;
	}

	public static boolean accepts(String text) {
		final int len = text.length();
		if (len < 1 || (MAX_LENGTH > 0 && len > MAX_LENGTH))
			return false;

		if (text.charAt(0) == '-')
			return false;

		if (text.charAt(len - 1) == '-')
			return false;

		for (int i = 0; i < len; i++) {
			final char c = text.charAt(i);

			if (c < '0' || c > '9')
				return true;
		}

		return false;
	}

	// ------------------------------------------------------------------------

	private static boolean useExtendedCharactersInCopybooks = false;
	static {
		if ("extended".equalsIgnoreCase(System
				.getProperty("koopa.cobolWord.inCopybooks")))
			useExtendedCharactersInCopybooks = true;
	}

	private static String extendedCobolWordCharacters = ":";
	static {
		final String characters = System
				.getProperty("koopa.cobolWord.extendedCharacters");
		if (characters != null)
			extendedCobolWordCharacters = characters;
	}

	public static boolean useExtendedCharactersInCopybooks() {
		return useExtendedCharactersInCopybooks;
	}

	public static void setUseExtendedCharactersInCopybooks(boolean setting) {
		useExtendedCharactersInCopybooks = setting;
	}

	public static String getExtendedCharactersInCopybooks() {
		return extendedCobolWordCharacters;
	}

	public static void setExtendedCharactersInCopybooks(String characters) {
		extendedCobolWordCharacters = characters;
	}

	public static boolean isExtendedPart(String text) {
		final int len = text.length();

		for (int i = 0; i < len; i++)
			if (extendedCobolWordCharacters.indexOf(text.charAt(i)) < 0)
				return false;

		return true;
	}
}
