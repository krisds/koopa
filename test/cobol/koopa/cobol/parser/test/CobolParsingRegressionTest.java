package koopa.cobol.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import koopa.cobol.CobolProject;
import koopa.cobol.parser.CobolParser;
import koopa.cobol.parser.ParseResults;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

@RunWith(Files.class)
public abstract class CobolParsingRegressionTest implements FileBasedTest {

	private File file = null;

	// TODO This static stuff is not ideal yet. Why does Java not allow
	// overriding of class methods ?
	private static File targetResultsFile = null;
	private static File actualResultsFile = null;
	private static Map<String, TestResult> targetResults = null;
	private static Map<String, TestResult> actualResults = null;

	public CobolParsingRegressionTest() throws IOException {
		targetResultsFile = getTargetResultsFile();
		actualResultsFile = getActualResultsFile();
	}

	@Override
	public abstract File[] getFiles();

	protected File getTargetResultsFile() {
		return null;
	}

	protected File getActualResultsFile() {
		return null;
	}

	protected abstract CobolProject getConfiguredProject();

	@Override
	public void setFile(File file) {
		this.file = file;
	}

	@Test
	public void testParsing() throws IOException {
		final CobolProject project = getConfiguredProject();
		
		final CobolParser parser = new CobolParser();
		parser.setProject(project);
		parser.setKeepingTrackOfTokens(true);

		final TestResult target = getTargetResult(file);

		// Parse the file...
		final ParseResults result = parser.parse(file);
		final TestResult actual = TestResult.from(result);
		addActualResult(actual);

		if (target == null) {
			// Unknown test file. We will evaluate this on its overall
			// performance.
			assertTrue(result.isValidInput());
			// TODO Assert for no warnings ?

		} else {
			// We have previous test results, which we'll now compare...
			final List<String> messages = target.getComparison(actual);

			StringBuilder info = new StringBuilder();
			if (messages != null && messages.size() > 0) {
				for (String message : messages) {
					info.append(message);
					info.append("  ");
				}
			}

			assertFalse(info.toString(),
					messages != null && messages.size() > 0);
		}
	}

	private TestResult getTargetResult(File source) {
		if (targetResults != null)
			return targetResults.get(source.getName());
		else
			return null;
	}

	private void addActualResult(TestResult result) {
		if (actualResults != null)
			actualResults.put(result.getKey(), result);
	}

	public static void testRunStarted() throws IOException {
		if (targetResultsFile != null && targetResultsFile.exists())
			targetResults = TestResult.loadFromFile(targetResultsFile);
		else
			targetResults = null;

		if (actualResultsFile != null)
			actualResults = new HashMap<>();
		else
			actualResults = null;
	}

	public static void testRunFinished() {
		try {
			if (actualResultsFile != null)
				TestResult.saveToFile(actualResults, actualResultsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
