package koopa.parsers.cobol.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.grammars.test.TargetResult;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.util.test.FileBasedTest;
import koopa.util.test.Files;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Files.class)
public abstract class CobolParsingRegressionTest implements FileBasedTest {

	private File source = null;

	@Override
	public abstract File[] getFiles();

	public TargetResult getTargetResult(File source) {
		return null;
	}

	public void configure(ParsingCoordinator coordinator) {
	}

	@Override
	public void setFile(File source) {
		this.source = source;
	}

	@Test
	public void testParsing() throws IOException {
		ParsingCoordinator coordinator = new ParsingCoordinator();
		configure(coordinator);
		coordinator.setKeepingTrackOfTokens(true);

		// Parse the file...
		final ParseResults result = coordinator.parse(source);

		final TargetResult target = getTargetResult(source);

		if (target == null) {
			// Unknown test file. We will evaluate this on its overall
			// performance.
			assertTrue(result.isValidInput());
			// TODO Assert for no warnings ?

		} else {
			// We have previous test results, which we'll now compare...
			final List<String> messages = target.getComparison(result);

			assertFalse(messages != null && messages.size() > 0);
			if (messages != null && messages.size() > 0) {
				for (String message : messages) {
					System.out.println(message);
				}
			}
		}
	}
}
