package koopa.cobol.directives.test;

import org.junit.Test;

import junit.framework.TestCase;
import koopa.cobol.directives.MFIncStatement;

public class MFIncStatementTest extends TestCase {

	@Test
	public void testMatches() {
		accepts("-INC textName and a comment");
		accepts("-INC textName");

		rejects(" -INC textName");
		rejects("-INC");
		rejects("-inc textName and a comment");
	}

	private static void accepts(String sample) {
		assertTrue(sample, MFIncStatement.matches(sample));
	}

	private static void rejects(String sample) {
		assertFalse(sample, MFIncStatement.matches(sample));
	}
}
