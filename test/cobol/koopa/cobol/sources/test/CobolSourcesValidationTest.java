package koopa.cobol.sources.test;

import static koopa.cobol.data.tags.CobolAreaTag.IDENTIFICATION_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.INDICATOR_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.cobol.data.tags.CobolTag.SOURCE_FORMAT_DIRECTIVE;
import static koopa.cobol.data.tags.CobolTag.SOURCE_LISTING_DIRECTIVE;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;

import java.io.File;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import koopa.cobol.CobolTokens;
import koopa.cobol.projects.StandardCobolProject;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationOfLines;
import koopa.cobol.sources.InlineComments;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.Replace;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.TokenSeparator;
import koopa.core.sources.test.CoreSourcesValidationTest;
import koopa.core.sources.test.samples.Sample;
import koopa.core.util.test.Files;

/**
 * This class provides the infrastructure for testing the different Cobol
 * sources. It looks for ".sample" files, and runs each one it finds through a
 * JUnit test.
 */
@RunWith(Files.class)
public class CobolSourcesValidationTest extends CoreSourcesValidationTest {

	private static final HashMap<String, Class<? extends Source>> CLASSES = new HashMap<>();
	static {
		CLASSES.put("LineSplitter", LineSplitter.class);
		CLASSES.put("SourceFormatDirectives", CompilerDirectives.class);
		CLASSES.put("CompilerDirectives", CompilerDirectives.class);
		CLASSES.put("SourceListingDirectives", CompilerDirectives.class);
		CLASSES.put("ProgramArea", ProgramArea.class);
		CLASSES.put("TokenSeparator", TokenSeparator.class);
		CLASSES.put("InlineComments", InlineComments.class);
		CLASSES.put("ContinuationOfLines", ContinuationOfLines.class);
		CLASSES.put("Replace", Replace.class);
	}

	@Override
	protected File getFolder() {
		return new File("test/cobol/koopa/cobol/sources/test/");
	}

	@Override
	protected Source getSource(String resourceName, Sample sample) {
		final String fileName = file.getName();
		final String className = fileName.substring(0, fileName.indexOf('.'));

		final Class<? extends Source> clazz;
		if ("All".equals(className))
			clazz = null;
		else {
			clazz = CLASSES.get(className);
			Assert.assertNotNull("Missing key: " + className, clazz);
		}

		final StandardCobolProject project = new StandardCobolProject();
		project.setDefaultFormat(FIXED);
		project.setDefaultPreprocessing(true);

		final Source source = CobolTokens.getNewSource(file,
				sample.getReader(), project);

		final Source selectedSource;
		if (clazz == null)
			selectedSource = source;
		else
			selectedSource = source.getSource(clazz);

		Assert.assertNotNull("No such source: " + clazz, selectedSource);

		return selectedSource;
	}

	@Override
	@Before
	public void initialize() {
		super.initialize();

		final Object[] fixed = new Object[] { FIXED };
		addTokenCategory("FIXED", fixed);
		addTokenCategory("FXD", fixed);
		addTokenCategory("F", fixed);

		final Object[] free = new Object[] { FREE };
		addTokenCategory("FREE", free);
		addTokenCategory("f", free);

		final Object[] variable = new Object[] { VARIABLE };
		addTokenCategory("VARIABLE", variable);
		addTokenCategory("VAR", variable);
		addTokenCategory("V", variable);

		final Object[] seqnr = new Object[] { SEQUENCE_NUMBER_AREA };
		addTokenCategory("SEQNR", seqnr);

		final Object[] indicator = new Object[] { INDICATOR_AREA };
		addTokenCategory("INDIC", indicator);
		addTokenCategory("I", indicator);

		final Object[] identification = new Object[] { IDENTIFICATION_AREA };
		addTokenCategory("IDENT", identification);

		final Object[] sourceListingDirective = new Object[] {
				SOURCE_LISTING_DIRECTIVE, COMPILER_DIRECTIVE };
		addTokenCategory("SOURCE_LISTING_DIRECTIVE", sourceListingDirective);
		addTokenCategory("SOURCE_LISTING", sourceListingDirective);
		addTokenCategory("LISTING", sourceListingDirective);

		final Object[] sourceFormatDirective = new Object[] {
				SOURCE_FORMAT_DIRECTIVE, COMPILER_DIRECTIVE };
		addTokenCategory("SOURCE_FORMAT_DIRECTIVE", sourceFormatDirective);
		addTokenCategory("SOURCE_FORMAT", sourceFormatDirective);
		addTokenCategory("FORMAT", sourceFormatDirective);

		addNodeCategory("copy", "cobol", "copyStatement");
		addNodeCategory("replace", "cobol", "replaceStatement");
	}
}
