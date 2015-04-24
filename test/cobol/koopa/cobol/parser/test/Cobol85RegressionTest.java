package koopa.cobol.parser.test;

import java.io.File;
import java.io.IOException;

import koopa.cobol.CobolFiles;

public class Cobol85RegressionTest extends CobolParsingRegressionTest {

	public Cobol85RegressionTest() throws IOException {
		super();
	}

	@Override
	public File[] getFiles() {
		File folder = new File("testsuite/cobol85/");
		File[] sources = folder.listFiles(CobolFiles.getFilenameFilter());
		return sources;
	}

	@Override
	protected File getTargetResultsFile() {
		return new File("testsuite/cobol85.csv");
	}

	@Override
	protected File getActualResultsFile() {
		return new File("testsuite/cobol85-actuals.csv");
	}
}
