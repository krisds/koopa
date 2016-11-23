package koopa.cobol.directives.test;

import org.junit.Test;

import junit.framework.TestCase;
import koopa.cobol.directives.MFIncludeStatement;

public class MFIncludeStatementTest extends TestCase {

	@Test
	public void testMatches() {
		accepts("       ++INCLUDE textName and a comment");
		accepts("       ++INCLUDE textName");

		rejects("        ++INCLUDE textName");
		rejects("      ++INCLUDE textName");
		rejects("       ++INCLUDE");
		rejects("       ++include textName and a comment");
	}

	private static void accepts(String sample) {
		assertTrue(sample, MFIncludeStatement.matches(sample));
	}

	private static void rejects(String sample) {
		assertFalse(sample, MFIncludeStatement.matches(sample));
	}
}
