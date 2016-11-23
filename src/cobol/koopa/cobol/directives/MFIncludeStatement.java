package koopa.cobol.directives;

import java.util.regex.Pattern;

import koopa.core.data.Token;

/**
 * Micro Focus ++INCLUDE statement.
 * <p>
 * Cfr. <a href=
 * "https://supportline.microfocus.com/documentation/books/sx40/lrcomp.htm">The
 * ++INCLUDE Statement</a>.
 */
public class MFIncludeStatement {

	// "++INCLUDE must begin in column 8, must be in upper case and must be
	// followed by one or more spaces."
	private static final String INCLUDE = "\\+\\+INCLUDE";

	// "Text-name defines a unique external file-name which conforms to the
	// rules for user-defined words."
	private static final String TEXT_NAME = "[a-zA-Z0-9_-]+";

	// "Any other text appearing on the line is treated as a comment."
	// "It must, in its entirety, be contained on a single line and must be in
	// upper case."
	private static final Pattern STATEMENT = Pattern
			.compile("^\\s{7}" + INCLUDE + "\\s+" + TEXT_NAME + ".*$");

	public static boolean matches(Token token) {
		return matches(token.getText());
	}

	public static boolean matches(String text) {
		return STATEMENT.matcher(text).matches();
	}
}
