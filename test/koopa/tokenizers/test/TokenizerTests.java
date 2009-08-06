package koopa.tokenizers.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import koopa.tokenizers.generic.test.FilteringTokenizerTest;
import koopa.tokenizers.generic.test.StackBasedPushbackTokenizerTest;

public class TokenizerTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tokenizer test suite.");

		suite.addTestSuite(StackBasedPushbackTokenizerTest.class);
		suite.addTestSuite(FilteringTokenizerTest.class);

		return suite;
	}
}
