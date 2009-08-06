package koopa.tokenstreams.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TokenStreamTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Token stream test suite.");

		suite.addTestSuite(MainTokenStreamTest.class);
		suite.addTestSuite(SubordinateTokenStreamTest.class);
		suite.addTestSuite(TokenSinkTest.class);

		return suite;
	}
}
