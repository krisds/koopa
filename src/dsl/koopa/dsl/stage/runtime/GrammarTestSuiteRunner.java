package koopa.dsl.stage.runtime;

import java.util.Random;

/**
 * Utility class for grammar test configuration. Previously was a JUnit 4 runner,
 * now only provides static configuration for randomized testing.
 *
 * @deprecated This class is kept only for its static randomization fields.
 *             GrammarTestSuite now uses JUnit 5's @TestFactory instead of custom runners.
 */
@Deprecated
public class GrammarTestSuiteRunner {

	public static final boolean RANDOMIZE_TESTS;
	public static final Random RANDOMIZER;
	public static final int RANDOMIZER_LIMIT;

	static {
		RANDOMIZE_TESTS = "true".equalsIgnoreCase(System.getProperty(
				"koopa.tests.random", "false"));

		final String seed = System.getProperty("koopa.tests.random.seed");
		if (!RANDOMIZE_TESTS)
			RANDOMIZER = null;
		else if (seed == null)
			RANDOMIZER = new Random();
		else
			RANDOMIZER = new Random(seed.hashCode());

		final String limit = System.getProperty("koopa.tests.random.limit");
		if (!RANDOMIZE_TESTS)
			RANDOMIZER_LIMIT = 1;
		else if (limit == null)
			RANDOMIZER_LIMIT = 2;
		else
			RANDOMIZER_LIMIT = Integer.parseInt(limit);

		if (RANDOMIZE_TESTS) {
			System.out.println("Randomizing grammar tests, up to "
					+ RANDOMIZER_LIMIT + " per test definition.");
		}
	}

}