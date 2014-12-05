package koopa.cobol.parser.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Cobol85RegressionTest extends CobolParsingRegressionTest {

	public Cobol85RegressionTest() throws IOException {
		super();
	}

	@Override
	public File[] getFiles() {
		File folder = new File("testsuite/cobol85/");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toUpperCase();
				return name.endsWith(".CBL") || name.endsWith(".CPY");
			}
		});

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
