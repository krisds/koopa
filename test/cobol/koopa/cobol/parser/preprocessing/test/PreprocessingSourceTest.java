package koopa.cobol.parser.preprocessing.test;

import static koopa.core.util.test.Util.testFilesCharset;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import koopa.cobol.CobolTokens;
import koopa.cobol.projects.StandardCobolProject;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.util.test.FileBasedTest;

public class PreprocessingSourceTest implements FileBasedTest {

	private static final Charset TEST_FILES_CHARSET = testFilesCharset();

	private static final String INPUT_PREFIX = "<";
	private static final String EXPECTED_PREFIX = ">";
	private static final String LINE_SEPARATOR = System.lineSeparator();

	private static final FilenameFilter FILTER = (dir, name) -> name.toLowerCase().endsWith(".ppsample");

	@Override
	public File[] getFiles() {
		File folder = new File(
				"test/cobol/koopa/cobol/parser/preprocessing/test/");

		return folder.listFiles(FILTER);
	}

	private File file;

	@Override
	public void setFile(File file) {
		this.file = file;
	}

	@TestFactory
	public Stream<DynamicTest> generateFileTests() {
		return Arrays.stream(getFiles())
			.map(file -> DynamicTest.dynamicTest(
				file.getName(),
				() -> testFile(file)
			));
	}

	private void testFile(File file) throws IOException {
		setFile(file);
		testSampleValidates();
	}

	private void testSampleValidates() throws IOException {
		Sample sample = new Sample(file);

		final StandardCobolProject project = new StandardCobolProject();
		project.setDefaultFormat(SourceFormat.FREE);
		project.setDefaultPreprocessing(true);

		Source source = CobolTokens.getNewSource( //
				file, //
				new StringReader(sample.input.toString()), //
				project);

		StringBuilder actual = new StringBuilder();
		Data d = null;
		while ((d = source.next()) != null)
			if (d instanceof Token)
				actual.append(((Token) d).getText());

		assertEquals(sample.expected.toString(), actual.toString());
	}

	private static class Sample {
		private StringBuilder input = new StringBuilder();
		private StringBuilder expected = new StringBuilder();

		public Sample(File file) throws IOException {
			try(final BufferedReader br = new BufferedReader(new FileReader(file, TEST_FILES_CHARSET))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					if (line.startsWith(INPUT_PREFIX)) {
						input.append(line.substring(INPUT_PREFIX.length()));
						input.append(LINE_SEPARATOR);

					} else if (line.startsWith(EXPECTED_PREFIX)) {
						expected.append(line.substring(EXPECTED_PREFIX.length()));
						expected.append(LINE_SEPARATOR);
					}
				}

			}
		}
	}
}
