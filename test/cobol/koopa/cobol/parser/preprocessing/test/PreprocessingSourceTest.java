package koopa.cobol.parser.preprocessing.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;

import koopa.cobol.CobolTokens;
import koopa.cobol.projects.StandardCobolProject;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Files.class)
public class PreprocessingSourceTest implements FileBasedTest {

	private static final String INPUT_PREFIX = "<";
	private static final String EXPECTED_PREFIX = ">";

	@Override
	public File[] getFiles() {
		File folder = new File(
				"test/cobol/koopa/cobol/parser/preprocessing/test/");

		File[] sources = folder.listFiles((FilenameFilter) (dir, name) -> {
			name = name.toLowerCase();
			return name.endsWith(".ppsample");
		});

		return sources;
	}

	private File file;

	@Override
	public void setFile(File file) {
		this.file = file;
	}

	@Test
	public void testSampleValidates() throws IOException {
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

		Assert.assertEquals(sample.expected.toString(), actual.toString());
	}

	private static class Sample {
		private StringBuilder input = new StringBuilder();
		private StringBuilder expected = new StringBuilder();

		public Sample(File file) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				String line = null;
				while ((line = br.readLine()) != null) {
					if (line.startsWith(INPUT_PREFIX)) {
						input.append(line.substring(INPUT_PREFIX.length()));
						input.append('\n');

					} else if (line.startsWith(EXPECTED_PREFIX)) {
						expected.append(line.substring(EXPECTED_PREFIX.length()));
						expected.append('\n');
					}
				}

			} finally {
				if (br != null)
					br.close();
			}
		}
	}
}
