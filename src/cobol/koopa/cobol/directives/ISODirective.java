package koopa.cobol.directives;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;

/**
 * Based on ISO/IEC 1989:20xx FCD 1.0 (E), section 7.3 "Compiler directives".
 */
public class ISODirective {

	private static final String INDICATOR = ">>";
	private static final String COMMENT_START = "\\*\\>";

	private static final String COMMAND = "(" //
			+ "CALL-CONVENTION" + "|" //
			+ "DEFINE" + "|" //
			+ "EVALUATE" + "|" //
			+ "WHEN" + "|" //
			+ "END-EVALUATE" + "|" //
			+ "FLAG-02" + "|" //
			+ "FLAG-85" + "|"//
			+ "FLAG-NATIVE-ARITHMETIC" + "|" //
			+ "IF" + "|" //
			+ "ELSE" + "|" //
			+ "END-IF" + "|" //
			+ "LEAP-SECOND" + "|" //
			+ "LISTING" + "|" //
			+ "PAGE" + "|" //
			+ "PROPAGATE" + "|" //
			+ "SOURCE" + "|" //
			+ "TURN" //
			+ ")";

	private static final String INSTRUCTION = COMMAND + "((?!" + COMMENT_START
			+ ").)*";
	private static final String INLINE_COMMENT = COMMENT_START + ".*";

	// "A compiler directive is composed of the compiler directive indicator,
	// optionally followed by the COBOL character space, followed by
	// compiler-instruction. The compiler directive indicator shall be treated
	// as though it were followed by a space if no space is specified after the
	// indicator."

	private static final String DIRECTIVE = INDICATOR + "\\s*" + INSTRUCTION;

	// "A compiler directive shall be preceded only by zero, one, or more space
	// characters."

	// "When the reference format is fixed-form, a compiler directive shall be
	// written in the program-text area and may be followed only by space
	// characters and an optional inline comment."
	private static final Pattern FIXED_FORM = Pattern.compile(
			"^\\s{7,}" + DIRECTIVE + "\\s*(" + INLINE_COMMENT + ")?$",
			CASE_INSENSITIVE);

	// "When the reference format is free-form, a compiler directive may be
	// followed only by space characters and an optional inline comment."
	private static final Pattern FREE_FORM = Pattern.compile(
			"^\\s*" + DIRECTIVE + "\\s*(" + INLINE_COMMENT + ")?$",
			CASE_INSENSITIVE);

	// TODO Support VARIABLE as well ?
	private static final Pattern SOURCE_FORMAT = Pattern.compile(
			INDICATOR + "\\s*SOURCE\\s+(FORMAT\\s+)?(IS\\s+)?(FIXED|FREE)",
			CASE_INSENSITIVE);

	public static boolean matches(SourceFormat format, Token token) {
		return matches(format, token.getText());
	}

	public static boolean matches(SourceFormat format, String text) {
		if (format == FREE)
			return FREE_FORM.matcher(text).matches();
		else
			return FIXED_FORM.matcher(text).matches();
	}

	public static SourceFormat getSourceFormat(final Token token) {
		return getSourceFormat(token.getText());
	}

	public static SourceFormat getSourceFormat(final String text) {
		final Matcher matcher = SOURCE_FORMAT.matcher(text);

		if (!matcher.find())
			return null;

		final String format = matcher.group(3);
		if ("FREE".equalsIgnoreCase(format))
			return FREE;
		else if ("VARIABLE".equalsIgnoreCase(format))
			return VARIABLE;
		else
			return FIXED;
	}
}
