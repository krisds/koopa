package koopa.cobol.directives;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static koopa.cobol.sources.SourceFormat.FREE;

import java.util.regex.Pattern;

import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;

/**
 * IBM Enterprise Cobol Compiler-Directing Statements.
 * <p>
 * References:
 * <ul>
 * <li>Chapter 8, Section 1, "<a href=
 * "http://publibz.boulder.ibm.com/cgi-bin/bookmgr_OS390/handheld/Connected/BOOKS/igy3lr40/8.1?SHELF=&DT=20071214160555&CASE=">
 * Compiler-directing statements</a>" in <a href="
 * http://publibz.boulder.ibm.com/cgi-bin/bookmgr_OS390/handheld/Connected/BOOKS/igy3lr40/CCONTENTS?SHELF=&CASE=&DT=20071214160555">
 * Enterprise COBOL for z/OS V4.1 Language Reference</a></li>
 * <li>Chapter 23, "Compiler-directing statements" in
 * "Enterprise COBOL for z/OS, Language Reference, Version 4 Release 2"</li>
 * </ul>
 */
public class IBMCompilerDirectingStatement {

	public static boolean matches(SourceFormat format, Token token) {
		return matches(format, token.getText());
	}

	public static boolean matches(SourceFormat format, String text) {
		if (isTitleStatement(format, text))
			return true;

		if (isCblProcessStatement(text))
			return true;

		return false;
	}

	// ------------------------------------------------------------------------

	// "The word TITLE can begin in either Area A or Area B."
	// "No other statement can appear on the same line as the TITLE statement."
	// I can't find any clear comment on FREE vs FIXED source code, so the
	// following patterns are educated guesses.
	private static final String TITLE = "TITLE\\s+.*";
	private static final Pattern TITLE_FREE = Pattern
			.compile("^\\s*" + TITLE + "$", CASE_INSENSITIVE);
	private static final Pattern TITLE_FIXED = Pattern
			.compile("^.{7}\\s*" + TITLE + "$", CASE_INSENSITIVE);

	/**
	 * "The TITLE statement specifies a title to be printed at the top of each
	 * page of the source listing produced during compilation."
	 */
	private static boolean isTitleStatement(SourceFormat format, String text) {
		if (format == FREE)
			return TITLE_FREE.matcher(text).matches();
		else
			return TITLE_FIXED.matcher(text).matches();
	}

	// ------------------------------------------------------------------------

	private static final String CBL_PROCESS = "(CBL|PROCESS)\\s.*";

	// "The CBL (PROCESS) statement can be preceded by a sequence number in
	// columns 1 through 6. The first character of the sequence number must be
	// numeric, and CBL or PROCESS can begin in column 8 or after; if a sequence
	// number is not specified, CBL or PROCESS can begin in column 1 or after."
	// "The CBL (PROCESS) statement must end before or at column 72, and options
	// cannot be continued across multiple CBL (PROCESS) statements. However,
	// you can use more than one CBL (PROCESS) statement. Multiple CBL (PROCESS)
	// statements must follow one another with no intervening statements of any
	// other type."
	// "The CBL (PROCESS) statement must be placed before any comment lines or
	// other compiler-directing statements."
	private static final Pattern CBL_PROCESS_STATEMENT = Pattern
			.compile("^(\\d.{5}\\s)?" + CBL_PROCESS + "$", CASE_INSENSITIVE);

	/**
	 * "With the CBL (PROCESS) statement, you can specify compiler options to be
	 * used in the compilation of the program."
	 */
	private static boolean isCblProcessStatement(final String text) {
		// "The CBL (PROCESS) statement is placed before the identification
		// division header of an outermost program."
		// But given that we don't have parser information in the lexer stages,
		// this is hard to verify.
		return CBL_PROCESS_STATEMENT.matcher(text).matches();
	}
}
