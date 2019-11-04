package koopa.dsl.kg.grammar.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import koopa.core.trees.Tree;
import koopa.core.util.Files;
import koopa.dsl.kg.grammar.KGGrammar;
import koopa.dsl.kg.util.KGUtil;

/**
 * This test comes in handy when tweaking {@linkplain KGGrammar}, as it can
 * quickly be run from within the IDE without having to recompile everything.
 * <p>
 * In the full build you don't really need it as all grammar files will get
 * parsed and processed anyway.
 */
@RunWith(ParseIncludedGrammarsTest.KGRunner.class)
public class ParseIncludedGrammarsTest {

	public static List<File> getKGFiles() {
		return Files.listFilesRecursively(new File("src"),
				KGUtil.getFilenameFilter());
	}

	private File source = null;

	public void setSource(File source) {
		this.source = source;
	}

	@Test
	public void kgShouldParse() throws IOException {
		Assert.assertNotNull(source);

		final Tree ast = KGUtil.getAST(source);
		Assert.assertNotNull(ast);
	}

	public static class KGRunner extends Suite {
		public KGRunner(Class<?> clazz) throws InitializationError {
			super(clazz, getRunners(clazz));
			assert (ParseIncludedGrammarsTest.class.isAssignableFrom(clazz));
		}

		private static List<Runner> getRunners(Class<?> clazz)
				throws InitializationError {
			final List<Runner> runners = new ArrayList<>();

			final List<File> sources = getKGFiles();

			if (sources == null || sources.isEmpty())
				throw new InternalError("No grammar files.");

			for (File file : sources)
				runners.add(new GrammarTestRunner(clazz, file));

			return runners;
		}

		public static class GrammarTestRunner extends BlockJUnit4ClassRunner {
			private final File source;

			public GrammarTestRunner(Class<?> clazz, File source)
					throws InitializationError {
				super(clazz);

				this.source = source;
			}

			@Override
			protected Object createTest() throws Exception {
				final Object object = super.createTest();
				if (object instanceof ParseIncludedGrammarsTest)
					((ParseIncludedGrammarsTest) object).setSource(source);
				return object;
			}

			@Override
			protected String getName() {
				return source.getPath();
			}

			@Override
			protected String testName(final FrameworkMethod method) {
				return getName();
			}
		}
	}
}
