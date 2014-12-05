package koopa.cobol.parser.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import koopa.cobol.parser.cobol.ParsingCoordinator;

public class Cobol85PreprocessingTest extends CobolParsingRegressionTest {

	// Following files can be parsed when activating preprocessing, but fail
	// otherwise.
	// testsuite/cobol85/SM101A.CBL
	// testsuite/cobol85/SM103A.CBL
	// testsuite/cobol85/SM206A.CBL

	public Cobol85PreprocessingTest() throws IOException {
		super();
	}

	@Override
	public File[] getFiles() {
		File folder = new File("testsuite/cobol85");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toUpperCase();
				return name.endsWith(".CBL");
			}
		});

		return sources;
	}

	@Override
	public void configure(ParsingCoordinator coordinator) {
		coordinator.setPreprocessing(true);
		coordinator.addCopybookPath(new File("testsuite/cobol85/"));
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
