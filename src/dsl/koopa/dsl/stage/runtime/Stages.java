package koopa.dsl.stage.runtime;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import koopa.core.trees.Tree;
import koopa.core.util.Files;
import koopa.dsl.stage.util.StageUtil;

import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class Stages extends Suite {

	public Stages(Class<?> clazz) throws InitializationError {
		super(clazz, getRunners(clazz));
		assert (SampleBasedTest.class.isAssignableFrom(clazz));
	}

	private static List<Runner> getRunners(Class<?> clazz)
			throws InitializationError {
		try {
			List<Runner> runners = new ArrayList<Runner>();

			final SampleBasedTest provider = (SampleBasedTest) clazz
					.newInstance();
			final File[] sources = provider.getFiles();

			if (sources == null) {
				System.out.println("[WARN] No stages found.");
				return runners;
			}

			for (File source : sources) {
				try {
					final Tree ast = StageUtil.getAST(source, true);

					final String grammarName = ast.getDescendant("grammar",
							"qualified_name").getAllText();
					final String testSourceName = ast.getDescendant(
							"tokenizer", "qualified_name").getAllText();

					for (Tree suite : ast.getChildren("suite")) {
						final String targetName = suite.getDescendant("target",
								"identifier").getAllText();

						int i = 0;
						for (Tree test : suite.getChildren("test")) {
							final boolean shouldAccept = test
									.getChild("accept") != null;

							String sample = test.getChild("sample")
									.getAllText();
							sample = sample.substring(1, sample.length() - 1);

							final SampleRunner runner = new SampleRunner(clazz,
									source, grammarName, testSourceName,
									targetName, i, shouldAccept, sample);

							runners.add(runner);
							i++;
						}
					}

				} catch (IOException e) {
					// TODO Fail the suite somehow ?
					e.printStackTrace();
				}
			}

			return runners;

		} catch (InstantiationException e) {
			throw new InitializationError(e);
		} catch (IllegalAccessException e) {
			throw new InitializationError(e);
		}
	}

	public static class SampleRunner extends BlockJUnit4ClassRunner {
		private final File file;
		private String grammarName;
		private String testSourceName;
		private String targetName;
		private int i;
		private boolean shouldAccept;
		private String sample;

		SampleRunner(Class<?> clazz, File file, String grammarName,
				String testSourceName, String targetName, int i,
				boolean shouldAccept, String sample) throws InitializationError {
			super(clazz);

			this.file = file;
			this.grammarName = grammarName;
			this.testSourceName = testSourceName;
			this.targetName = targetName;
			this.i = i;
			this.shouldAccept = shouldAccept;
			this.sample = sample;
		}

		@Override
		protected Object createTest() throws Exception {
			final Object object = super.createTest();
			if (object instanceof SampleBasedTest) {
				SampleBasedTest provider = (SampleBasedTest) object;
				provider.setData(grammarName, testSourceName, targetName,
						shouldAccept, sample);
			}
			return object;
		}

		@Override
		protected String getName() {
			return Files.getName(file) + ":" + targetName + ":" + i;
		}

		@Override
		protected String testName(final FrameworkMethod method) {
			return getName();
		}
	}
}