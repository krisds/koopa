package koopa.core.sources.test;

import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class provides the infrastructure for testing the different sources. It
 * looks for ".sample" files, and runs each one it finds through a JUnit test.
 */
@RunWith(Files.class)
public class CoreSourcesValidationTest implements FileBasedTest, TokenValidator {

	public File[] getFiles() {
		File folder = new File("test/core/koopa/core/sources/test/");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return name.endsWith(".sample");
			}
		});

		return sources;
	}

	private File file;

	public void setFile(File file) {
		this.file = file;
	}

	@Test
	public void testSampleValidates() throws IOException {
		AnnotatedSourceSample sample = new AnnotatedSourceSample(
				new FileReader(file));

		Source<Token> source = getSource(file.getAbsolutePath(), sample);

		sample.assertOutputIsAsExpected(source, this);
	}

	private Source<Token> getSource(String resourceName,
			AnnotatedSourceSample sample) {
		Source<Token> source = null;

		source = new LineSplitter(resourceName, sample.getReader());
		if (file.getName().startsWith("LineSplitter"))
			return source;

		Assert.fail("Don't know how to setup source for " + file.getName());
		return null;
	}

	private static final Map<String, Object[]> TAG_VALIDATIONS;
	static {
		TAG_VALIDATIONS = new HashMap<String, Object[]>();

		TAG_VALIDATIONS.put("EOLN", new Object[] { END_OF_LINE });
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

		if (TAG_VALIDATIONS.containsKey(category)) {
			Object[] expectedTags = TAG_VALIDATIONS.get(category);
			for (Object tag : expectedTags) {
				assertTrue("Missing " + tag + " on " + token + ".",
						token.hasTag(tag));
			}

		} else {
			System.out.println("Warning! Unknown category: " + category);
		}
	}
}
