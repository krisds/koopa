package koopa.util.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class Files extends Suite {

	public Files(Class<?> clazz) throws InitializationError {
		super(clazz, getRunners(clazz));
	}

	private static List<Runner> getRunners(Class<?> clazz)
			throws InitializationError {
		List<Runner> runners = new ArrayList<Runner>();

		try {
			Object o = clazz.newInstance();
			if (o instanceof FileBasedTest) {
				FileBasedTest provider = (FileBasedTest) o;

				File[] sources = provider.getFiles();
				for (File source : sources) {
					runners.add(new FileRunner(clazz, source));
				}
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return runners;
	}

	public static class FileRunner extends BlockJUnit4ClassRunner {
		private final File file;

		FileRunner(Class<?> clazz, File file) throws InitializationError {
			super(clazz);
			this.file = file;
		}

		@Override
		protected Object createTest() throws Exception {
			final Object object = super.createTest();
			if (object instanceof FileBasedTest) {
				FileBasedTest provider = (FileBasedTest) object;
				provider.setFile(file);
			}
			return object;
		}

		@Override
		protected Statement methodBlock(final FrameworkMethod method) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					try {
						FileRunner.super.methodBlock(method).evaluate();
					} finally {
					}
				}
			};
		}

		@Override
		protected String getName() {
			return String.format("%s [%s]", super.getName(),
					this.file.getName());
		}

		@Override
		protected String testName(final FrameworkMethod method) {
			return String.format("%s [%s]", method.getName(),
					this.file.getName());
		}
	}
}