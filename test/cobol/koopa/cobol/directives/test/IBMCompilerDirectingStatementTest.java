package koopa.cobol.directives.test;

import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;

import org.junit.Test;

import junit.framework.TestCase;
import koopa.cobol.directives.IBMCompilerDirectingStatement;
import koopa.cobol.sources.SourceFormat;

public class IBMCompilerDirectingStatementTest extends TestCase {

	@Test
	public void testMatchesFixed() {
		accepts(FIXED, "       TITLE 'BOY.... OF DESSSTINY'.");
		accepts(FIXED, "       TITLE 'BOY.... OF DESSSTINY'");
		accepts(FIXED, "         TITLE   'BOY.... OF DESSSTINY'  .  ");

		rejects(FIXED, "     TITLE 'BOY.... OF DESSSTINY'.");

		accepts(FIXED, "CBL NSYMBOL(NATIONAL)");
		accepts(FIXED, "PROCESS NSYMBOL(NATIONAL)");

		accepts(FIXED, "1abc56 CBL NSYMBOL(NATIONAL)");
		accepts(FIXED, "1abc56 PROCESS NSYMBOL(NATIONAL)");

		rejects(FIXED, "1abc5 CBL NSYMBOL(NATIONAL)");
		rejects(FIXED, "abc456 CBL NSYMBOL(NATIONAL)");

		// Examples from MasterProgrammer in the forums.
		// https://sourceforge.net/p/koopa/discussion/989430/thread/1f9c6886/
		accepts(FIXED, "001470     TITLE 'PBO - PRODUCT BASIS OVERRIDE'");
		accepts(FIXED, "CBL NOADV XREF MAP OFFSET OPTIMIZE                                      00000010");
	}

	@Test
	public void testMatchesFree() {
		accepts(FREE, "TITLE 'BOY.... OF DESSSTINY'.");

		// Example from MasterProgrammer in the forums.
		// https://sourceforge.net/p/koopa/discussion/989430/thread/1f9c6886/
		accepts(FREE, "CBL NOADV XREF MAP OFFSET OPTIMIZE                                      00000010");
	}

	private static void accepts(SourceFormat format, String sample) {
		assertTrue(sample,
				IBMCompilerDirectingStatement.matches(format, sample));
		assertTrue(sample.toLowerCase(), IBMCompilerDirectingStatement
				.matches(format, sample.toLowerCase()));
		assertTrue(sample.toUpperCase(), IBMCompilerDirectingStatement
				.matches(format, sample.toUpperCase()));
	}

	private static void rejects(SourceFormat format, String sample) {
		assertFalse(sample,
				IBMCompilerDirectingStatement.matches(format, sample));
		assertFalse(sample.toLowerCase(), IBMCompilerDirectingStatement
				.matches(format, sample.toLowerCase()));
		assertFalse(sample.toUpperCase(), IBMCompilerDirectingStatement
				.matches(format, sample.toUpperCase()));
	}

}
