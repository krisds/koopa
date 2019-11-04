package koopa.cobol.parser.preprocessing.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import koopa.cobol.CobolProject;
import koopa.cobol.parser.test.CobolParsingRegressionTest;
import koopa.cobol.projects.StandardCobolProject;

public class Cobol85PreprocessingTest extends CobolParsingRegressionTest {

	public Cobol85PreprocessingTest() throws IOException {
	}

	@Override
	public File[] getFiles() {
		final File folder = new File("testsuite/cobol85");

		final File[] sources = folder
				.listFiles((FilenameFilter) (dir, name) -> {
					name = name.toUpperCase();
					return name.endsWith(".CBL");
				});

		return sources;
	}

	@Override
	public CobolProject getConfiguredProject() {
		final StandardCobolProject project = new StandardCobolProject();
		project.setDefaultPreprocessing(true);
		project.addCopybookPath(new File("testsuite/cobol85/"));

		return project;
	}

	@Override
	protected File getTargetResultsFile() {
		return new File("testsuite/cobol85_pp.csv");
	}

	@Override
	protected File getActualResultsFile() {
		return new File("testsuite/cobol85_pp-actuals.csv");
	}
}
