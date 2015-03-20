package koopa.cobol.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.ParsingCoordinator;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Files.class)
public abstract class CobolParsingRegressionTest implements FileBasedTest {

	private File file = null;

	// TODO This static stuff is not ideal yet. Why does Java not allow
	// overriding of class methods ?
	private static File targetResultsFile = null;
	private static File actualResultsFile = null;
	private static Map<String, TargetResult> targetResults = null;
	private static Map<String, ParseResults> actualResults = null;

	public CobolParsingRegressionTest() throws IOException {
		targetResultsFile = getTargetResultsFile();
		actualResultsFile = getActualResultsFile();
	}

	public abstract File[] getFiles();

	protected File getTargetResultsFile() {
		return null;
	}

	protected File getActualResultsFile() {
		return null;
	}

	protected void configure(ParsingCoordinator coordinator) {
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Test
	public void testParsing() throws IOException {
		ParsingCoordinator coordinator = new ParsingCoordinator();
		configure(coordinator);
		coordinator.setKeepingTrackOfTokens(true);

		final TargetResult target = getTargetResult(file);

		// Parse the file...
		final ParseResults result = coordinator.parse(file);
		addActualResult(result);

		if (target == null) {
			// Unknown test file. We will evaluate this on its overall
			// performance.
			assertTrue(result.isValidInput());
			// TODO Assert for no warnings ?

		} else {
			// We have previous test results, which we'll now compare...
			final List<String> messages = target.getComparison(result);

			StringBuilder info = new StringBuilder();
			if (messages != null && messages.size() > 0) {
				for (String message : messages) {
					info.append(message);
					info.append("  ");
				}
			}

			assertFalse(info.toString(), messages != null
					&& messages.size() > 0);
		}
	}

	private TargetResult getTargetResult(File source) {
		if (targetResults != null)
			return targetResults.get(source.getName());
		else
			return null;
	}

	private void addActualResult(ParseResults result) {
		if (actualResults != null)
			actualResults.put(result.getFile().getName(), result);
	}

	public static void testRunStarted() throws IOException {
		if (targetResultsFile != null && targetResultsFile.exists())
			targetResults = TargetResult.loadFromFile(targetResultsFile);
		else
			targetResults = null;

		if (actualResultsFile != null)
			actualResults = new HashMap<String, ParseResults>();
		else
			actualResults = null;
	}

	public static void testRunFinished() {
		try {
			if (actualResultsFile != null)
				TargetResult.saveToFile(actualResults, actualResultsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
