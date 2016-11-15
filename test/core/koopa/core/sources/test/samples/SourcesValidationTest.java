package koopa.core.sources.test.samples;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TokenValidator;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

/**
 * This class provides the infrastructure for testing the different sources. It
 * looks for ".sample" files, and runs each one it finds through a JUnit test.
 */
@RunWith(Files.class)
public abstract class SourcesValidationTest
		implements FileBasedTest, TokenValidator {

	protected abstract File getFolder();

	public File[] getFiles() {
		File folder = getFolder();

		List<File> sources = koopa.core.util.Files.listFilesRecursively(folder,
				Sample.getFilenameFilter());

		return sources.toArray(new File[sources.size()]);
	}

	protected File file;

	public void setFile(File file) {
		this.file = file;
	}

	@Test
	public void testSampleValidates() throws IOException {
		Sample sample = Sample.from(file);

		Source<Token> source = getSource(file.getAbsolutePath(), sample);

		sample.assertOutputIsAsExpected(source, this);
	}

	protected abstract Source<Token> getSource(String resourceName,
			Sample sample);

	private Map<String, Object[]> CATEGORIES = new HashMap<String, Object[]>();

	protected void addCategory(String category, Object[] tags) {
		assert (!CATEGORIES.containsKey(category));
		CATEGORIES.put(category, tags);
	}

	public void validate(Token token, String category) {
		if ("_".equalsIgnoreCase(category)) {
			// A "don't care". For when you don't care.
			return;
		}

		if ("?".equalsIgnoreCase(category)) {
			// This one is used for debugging.
			System.out.println(token);
			return;
		}

		if (CATEGORIES.containsKey(category)) {
			Object[] expectedTags = CATEGORIES.get(category);
			for (Object tag : expectedTags) {
				assertTrue("Missing " + tag + " on " + token + ".",
						token.hasTag(tag));
			}

		} else {
			System.out.println("Warning! Unknown category: " + category);
		}
	}
}
