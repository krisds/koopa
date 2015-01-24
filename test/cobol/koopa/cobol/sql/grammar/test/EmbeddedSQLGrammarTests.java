package koopa.cobol.sql.grammar.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Triggers all grammar unit tests.
 * <p>
 * <b>When adding a new stage you must also include the compiled results in the
 * overall test suite defined here !</b>
 */
public class EmbeddedSQLGrammarTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Embedded SQL Grammar test suite.");

		suite.addTestSuite(IncludeStatementTest.class);
		suite.addTestSuite(DeclareSessionStatementTest.class);
		suite.addTestSuite(DeclareCursorStatementTest.class);
		suite.addTestSuite(OpenStatementTest.class);
		return suite;
	}
}
