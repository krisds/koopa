package koopa.cobol.directives;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;

import java.util.regex.Pattern;

import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;

// References
// http://documentation.microfocus.com/help/index.jsp?topic=%2Fcom.microfocus.eclipse.infocenter.studee60ux%2FHHBUCHCOMP08.html
// https://supportline.microfocus.com/documentation/books/sx2011sp1/cyadir.htm
// http://documentation.microfocus.com/help/index.jsp?topic=%2FGUID-0E0191D8-C39A-44D1-BA4C-D67107BAF784%2FHRCDRHCDIR56.html
// http://documentation.microfocus.com/help/index.jsp?topic=%2FGUID-0E0191D8-C39A-44D1-BA4C-D67107BAF784%2FHRCDRHCDIR0W.html
/**
 * Micro Focus $SET statement.
 */
public class MFSetStatement {

	private static final String DIRECTIVE = "[a-zA-Z0-9-]+";
	private static final String PARAMETER = "(\"[^\"]+\"|\\([^\\)]+\\))";
	private static final String STATEMENT = "\\$SET(\\s+" + DIRECTIVE + "("
			+ PARAMETER + ")?)+";

	// Fixed vs. free formatting is not well documented. I'm basing this off a
	// comment found in an online discussion, which stated: "When in fixed
	// format mode, the $ should be in col 7. In freeformat, this should start
	// in col 1."
	//
	// I also found something on conditional compilation by Micro Focus:
	// "Conditional compilation statements are indicated by a dollar ($) in
	// column 7 in fixed-format source, or column 1 in free-format source of the
	// COBOL source line followed by one of the key words IF, DISPLAY, ELSE,
	// END."
	// Not sure if this also applies to "$SET".
	// https://supportline.microfocus.com/documentation/books/nx40/lrcomp.htm

	private static final Pattern STATEMENT_FREE = Pattern
			.compile("^" + STATEMENT + "\\s*$", CASE_INSENSITIVE);

	private static final Pattern STATEMENT_FIXED = Pattern
			.compile("^.{6}" + STATEMENT + "\\s*$", CASE_INSENSITIVE);

	public static boolean matches(SourceFormat format, Token token) {
		return matches(format, token.getText());
	}

	public static boolean matches(SourceFormat format, String text) {
		if (format == FREE)
			return STATEMENT_FREE.matcher(text).matches();
		else
			return STATEMENT_FIXED.matcher(text).matches();
	}

	public static SourceFormat getSourceFormat(final Token token) {
		return getSourceFormat(token.getText());
	}

	public static SourceFormat getSourceFormat(final String text) {
		int index = text.toUpperCase().indexOf("SOURCEFORMAT");

		if (index < 0)
			return null;

		index += "SOURCEFORMAT".length();

		final char opener = text.charAt(index);

		final int end;
		if (opener == '"')
			end = text.indexOf('"', index + 1);
		else if (opener == '(')
			end = text.indexOf(')', index + 1);
		else
			return null;

		final String format = text.substring(index + 1, end);

		if ("FREE".equalsIgnoreCase(format))
			return FREE;
		else if ("VARIABLE".equalsIgnoreCase(format))
			return VARIABLE;
		else
			return FIXED;
	}
}
