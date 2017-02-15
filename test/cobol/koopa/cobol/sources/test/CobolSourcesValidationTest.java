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
import koopa.cobol.Copybooks;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationOfLines;
import koopa.cobol.sources.InlineComments;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.NarrowingSource;
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

	private static final HashMap<String, Class<? extends Source<? extends Data>>> CLASSES //
			= new HashMap<String, Class<? extends Source<? extends Data>>>();
	static {
		CLASSES.put("LineSplitter", LineSplitter.class);
		CLASSES.put("SourceFormatDirectives", CompilerDirectives.class);
		CLASSES.put("CompilerDirectives", CompilerDirectives.class);
		CLASSES.put("SourceListingDirectives", CompilerDirectives.class);
		CLASSES.put("ProgramArea", ProgramArea.class);
		CLASSES.put("TokenSeparator", TokenSeparator.class);
		CLASSES.put("InlineComments", InlineComments.class);
		CLASSES.put("ContinuationOfLines", ContinuationOfLines.class);
	}

	@Override
	protected File getFolder() {
		return new File("test/cobol/koopa/cobol/sources/test/");
	}

	@Override
	protected Source<Token> getSource(String resourceName, Sample sample) {
		final String fileName = file.getName();
		final String className = fileName.substring(0, fileName.indexOf('.'));

		final Class<? extends Source<? extends Data>> clazz;
		if ("All".equals(className))
			clazz = null;
		else {
			clazz = CLASSES.get(className);
			Assert.assertNotNull("Missing key: " + className, clazz);
		}

		final SourceFormat format = SourceFormat.FIXED;
		final CobolGrammar grammar = new CobolGrammar();
		// We set up a Copybooks instance (though empty) so that we force all
		// the stages to be present.
		final Copybooks copybooks = new Copybooks();

		final Source<Token> source = CobolTokens.getNewSource(file,
				sample.getReader(), grammar, format, copybooks);

		final Source<? extends Data> selectedSource;
		if (clazz == null)
			selectedSource = source;
		else
			selectedSource = source.getSource(clazz);

		Assert.assertNotNull("No such source: " + clazz, selectedSource);

		@SuppressWarnings("unchecked")
		final Source<Data> narrowed = (Source<Data>) selectedSource;

		return new NarrowingSource<Data, Token>(narrowed, Token.class);
	}

	@Before
	public void initialize() {
		super.initialize();

		final Object[] fixed = new Object[] { FIXED };
		addCategory("FIXED", fixed);
		addCategory("FXD", fixed);
		addCategory("F", fixed);

		final Object[] free = new Object[] { FREE };
		addCategory("FREE", free);
		addCategory("f", free);

		final Object[] variable = new Object[] { VARIABLE };
		addCategory("VARIABLE", variable);
		addCategory("VAR", variable);
		addCategory("V", variable);

		final Object[] seqnr = new Object[] { SEQUENCE_NUMBER_AREA };
		addCategory("SEQNR", seqnr);

		final Object[] indicator = new Object[] { INDICATOR_AREA };
		addCategory("INDIC", indicator);
		addCategory("I", indicator);

		final Object[] identification = new Object[] { IDENTIFICATION_AREA };
		addCategory("IDENT", identification);

		final Object[] sourceListingDirective = new Object[] {
				SOURCE_LISTING_DIRECTIVE, COMPILER_DIRECTIVE };
		addCategory("SOURCE_LISTING_DIRECTIVE", sourceListingDirective);
		addCategory("SOURCE_LISTING", sourceListingDirective);
		addCategory("LISTING", sourceListingDirective);

		final Object[] sourceFormatDirective = new Object[] {
				SOURCE_FORMAT_DIRECTIVE, COMPILER_DIRECTIVE };
		addCategory("SOURCE_FORMAT_DIRECTIVE", sourceFormatDirective);
		addCategory("SOURCE_FORMAT", sourceFormatDirective);
		addCategory("FORMAT", sourceFormatDirective);
	}
}
