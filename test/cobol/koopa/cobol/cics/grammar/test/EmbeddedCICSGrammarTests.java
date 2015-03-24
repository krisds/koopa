package koopa.cobol.cics.grammar.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Triggers all grammar unit tests.
 * <p>
 * <b>When adding a new stage you must also include the compiled results in the
 * overall test suite defined here !</b>
 */
public class EmbeddedCICSGrammarTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Embedded CICS Grammar test suite.");

		suite.addTestSuite(ReadFileTest.class);
		suite.addTestSuite(ReadQTest.class);
		suite.addTestSuite(ReceiveMapTest.class);
		suite.addTestSuite(SendMapTest.class);
		return suite;
	}
}
