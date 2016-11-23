package koopa.cobol.directives.test;

import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;

import org.junit.Test;

import junit.framework.TestCase;
import koopa.cobol.directives.MFSetStatement;
import koopa.cobol.sources.SourceFormat;

public class MFSetStatementTest extends TestCase {

	@Test
	public void testMatchesFixed() {
		accepts(FIXED, "      $set dialect\"MF\"");
		accepts(FIXED,
				"      $set SOURCEFORMAT\"VARIABLE\" OUTDD\"SYSOUT 121 R\"");
		accepts(FIXED, "      $SET SOURCEFORMAT\"VARIABLE\"");
		accepts(FIXED, "      $set intlevel(6)");
		accepts(FIXED, "      $set nsymbol(national)");

		// http://www.microfocus.co.jp/manuals/ED21/html/BKDIDIXMLES007.html
		accepts(FIXED, "0010  $set preprocess(prexml) warn endp");
		accepts(FIXED, "0020  $set sourceformat(free) case");
		
		rejects(FIXED, "       $set dialect\"MF\"");
		rejects(FIXED, "     $set dialect\"MF\"");
	}

	@Test
	public void testMatchesFree() {
		accepts(FREE, "$set dialect\"MF\"");
		accepts(FREE, "$set SOURCEFORMAT\"VARIABLE\" OUTDD\"SYSOUT 121 R\"");
		accepts(FREE, "$set intlevel(6)");
		accepts(FREE, "$set nsymbol(national)");

		accepts(FREE, "$set preprocess(prexml) warn endp");
		accepts(FREE, "$set sourceformat(free) case");
		
		rejects(FREE, " $set dialect\"MF\"");
	}

	@Test
	public void testSourceFormatParameter() {
		sourceFormatIs("      $set SOURCEFORMAT\"FREE\"", FREE);
		sourceFormatIs("      $set sourceformat\"VARIABLE\"  ", VARIABLE);
		sourceFormatIs("      $set sourceformat\"fixed\"  ", FIXED);
		sourceFormatIs("      $set $set intlevel(6)  ", null);
	}

	private static void accepts(SourceFormat format, String sample) {
		assertTrue(sample, MFSetStatement.matches(format, sample));
		assertTrue(sample.toLowerCase(),
				MFSetStatement.matches(format, sample.toLowerCase()));
		assertTrue(sample.toUpperCase(),
				MFSetStatement.matches(format, sample.toUpperCase()));
	}

	private static void rejects(SourceFormat format, String sample) {
		assertFalse(sample, MFSetStatement.matches(format, sample));
		assertFalse(sample.toLowerCase(),
				MFSetStatement.matches(format, sample.toLowerCase()));
		assertFalse(sample.toUpperCase(),
				MFSetStatement.matches(format, sample.toUpperCase()));
	}

	private static void sourceFormatIs(String sample, SourceFormat format) {
		assertSame(sample, format,
				MFSetStatement.getSourceFormat(sample));
		assertSame(sample.toLowerCase(), format,
				MFSetStatement.getSourceFormat(sample.toLowerCase()));
		assertSame(sample.toUpperCase(), format,
				MFSetStatement.getSourceFormat(sample.toUpperCase()));
	}
}
