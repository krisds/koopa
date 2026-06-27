package koopa.cobol.parser.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.opencsv.exceptions.CsvValidationException;

import koopa.cobol.CobolProject;
import koopa.cobol.parser.CobolParser;
import koopa.cobol.parser.ParseResults;
import koopa.core.util.test.FileBasedTest;

@TestInstance(Lifecycle.PER_CLASS)
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

	@TestFactory
	public Stream<DynamicTest> generateRegressionTests() {
		return Arrays.stream(getFiles())
			.map(file -> DynamicTest.dynamicTest(
				file.getName(),
				() -> testFile(file)
			));
	}

	private void testFile(File file) throws IOException {
		setFile(file);
		testParsing();
	}

	private void testParsing() throws IOException {
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
			if (messages != null && !messages.isEmpty()) {
				for (String message : messages) {
					info.append(message);
					info.append("  ");
				}
			}

			assertFalse(messages != null && !messages.isEmpty(),
					info.toString());
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

	@BeforeAll
	public static void testRunStarted() throws IOException, CsvValidationException {
		if (targetResultsFile != null && targetResultsFile.exists())
			targetResults = TestResult.loadFromFile(targetResultsFile);
		else
			targetResults = null;

		if (actualResultsFile != null)
			actualResults = new HashMap<>();
		else
			actualResults = null;
	}

	@AfterAll
	public static void testRunFinished() {
		try {
			if (actualResultsFile != null)
				TestResult.saveToFile(actualResults, actualResultsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
