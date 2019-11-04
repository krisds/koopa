package koopa.core.util.test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class Files extends Suite {

	private Class<?> clazz = null;

	public Files(Class<?> clazz) throws InitializationError {
		super(clazz, getRunners(clazz));
		this.clazz = clazz;

		assert (FileBasedTest.class.isAssignableFrom(this.clazz));
	}

	private static List<Runner> getRunners(Class<?> clazz)
			throws InitializationError {
		try {
			List<Runner> runners = new ArrayList<>();

			FileBasedTest provider = (FileBasedTest) clazz.newInstance();

			File[] sources = provider.getFiles();
			for (File source : sources)
				runners.add(new FileRunner(clazz, source));

			return runners;

		} catch (InstantiationException e) {
			throw new InitializationError(e);
		} catch (IllegalAccessException e) {
			throw new InitializationError(e);
		}
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			Files.this.clazz.getMethod("testRunStarted").invoke(null);
		} catch (NoSuchMethodException e) {
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		} catch (SecurityException e) {
		}

		super.run(notifier);

		try {
			Files.this.clazz.getMethod("testRunFinished").invoke(null);
		} catch (NoSuchMethodException e) {
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		} catch (SecurityException e) {
		}
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
			return String.format("%s", this.file.getName());
		}

		@Override
		protected String testName(final FrameworkMethod method) {
			return String.format("%s [%s]", method.getName(),
					this.file.getName());
		}
	}
}