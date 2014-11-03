package koopa.cobol.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.cobol.ParsingCoordinator;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Files.class)
public abstract class CobolParsingRegressionTest implements FileBasedTest {

	private File file = null;

	@Override
	public abstract File[] getFiles();

	public TargetResult getTargetResult(File source) {
		return null;
	}

	public void configure(ParsingCoordinator coordinator) {
	}

	@Override
	public void setFile(File file) {
		this.file = file;
	}

	@Test
	public void testParsing() throws IOException {
		ParsingCoordinator coordinator = new ParsingCoordinator();
		configure(coordinator);
		coordinator.setKeepingTrackOfTokens(true);

		// Parse the file...
		final ParseResults result = coordinator.parse(file);

		final TargetResult target = getTargetResult(file);

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
}
