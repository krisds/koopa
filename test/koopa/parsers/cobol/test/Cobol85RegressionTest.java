package koopa.parsers.cobol.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Map;

import koopa.grammars.test.TargetResult;

// TODO Add to ANT run-tests target.
public class Cobol85RegressionTest extends CobolParsingRegressionTest {

	private static Map<String, TargetResult> targetResults = null;
	static {
		try {
			targetResults = TargetResult.loadFromFile(new File(
					"testsuite/cobol85.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TargetResult getTargetResult(File source) {
		return targetResults.get(source.getName());
	}

	@Override
	public File[] getFiles() {
		File folder = new File("testsuite/cobol85");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toUpperCase();
				return name.endsWith(".CBL") || name.endsWith(".CPY");
			}
		});

		return sources;
	}
}
