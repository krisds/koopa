package koopa.dsl.stage.runtime;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import koopa.core.util.Files;
import koopa.dsl.stage.runtime.model.Stage;
import koopa.dsl.stage.runtime.model.SuiteOfStages;
import koopa.dsl.stage.runtime.model.Target;

import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * Support class for {@linkplain GrammarTestSuite}, responsible for setting up
 * the actual test runners.
 */
public class GrammarTestSuiteRunner extends Suite {

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

	public GrammarTestSuiteRunner(Class<?> clazz) throws InitializationError {
		super(clazz, getRunners(clazz));
		assert (GrammarTestSuite.class.isAssignableFrom(clazz));
	}

	private static List<Runner> getRunners(Class<?> clazz)
			throws InitializationError {
		try {
			final List<Runner> runners = new ArrayList<>();

			final GrammarTestSuite provider = (GrammarTestSuite) clazz
					.newInstance();
			final File[] sources = provider.getStageFiles();

			if (sources == null || sources.length == 0)
				throw new InternalError("No stages.");

			final SuiteOfStages testsuite = new SuiteOfStages(sources);

			for (Stage stage : testsuite.getStages())
				for (Target target : stage.getTargets()) {
					int i = 0;
					for (GrammarTest sample : target.getTests())
						runners.add(new GrammarTestRunner(clazz, i++, sample));
				}

			return runners;

		} catch (IOException e) {
			throw new InitializationError(e);
		} catch (InstantiationException e) {
			throw new InitializationError(e);
		} catch (IllegalAccessException e) {
			throw new InitializationError(e);
		}
	}

	public static class GrammarTestRunner extends BlockJUnit4ClassRunner {
		private final GrammarTest test;
		private final int index;

		public GrammarTestRunner(Class<?> clazz, int index, GrammarTest test)
				throws InitializationError {
			super(clazz);

			this.index = index;
			this.test = test;
		}

		@Override
		protected Object createTest() throws Exception {
			final Object object = super.createTest();
			if (object instanceof GrammarTestSuite)
				((GrammarTestSuite) object).setTest(test);
			return object;
		}

		@Override
		protected String getName() {
			return Files.getName(test.getStage()) + ":" + test.getTarget()
					+ ":" + index;
		}

		@Override
		protected String testName(final FrameworkMethod method) {
			return getName();
		}
	}
}