package koopa.cobol.sources.test;

import static koopa.cobol.data.tags.CobolAreaTag.IDENTIFICATION_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.INDICATOR_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.cobol.data.tags.CobolTag.PSEUDO_LITERAL;
import static koopa.cobol.data.tags.ContinuationsTag.CONTINUED;
import static koopa.cobol.data.tags.ContinuationsTag.CONTINUING;
import static koopa.cobol.data.tags.ContinuationsTag.LEADING_QUOTE;
import static koopa.cobol.data.tags.ContinuationsTag.SKIPPED;
import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.InlineComments;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Token;
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

	@Override
	protected File getFolder() {
		return new File("test/cobol/koopa/cobol/sources/test/");
	}

	@Override
	protected Source<Token> getSource(String resourceName, Sample sample) {
		SourceFormat format = SourceFormat.FIXED;

		Source<Token> source = null;

		source = new LineSplitter(resourceName, sample.getReader());

		source = new CompilerDirectives(source, format);
		if (file.getName().startsWith("CompilerDirectives"))
			return source;

		source = new ProgramArea(source);
		if (file.getName().startsWith("ProgramArea"))
			return source;

		source = new SourceFormattingDirectives(source);
		if (file.getName().startsWith("SourceFormattingDirectives"))
			return source;

		source = new LineContinuations(source);
		if (file.getName().startsWith("LineContinuations"))
			return source;

		source = new ContinuationWelding(source);
		if (file.getName().startsWith("ContinuationWelding"))
			return source;

		source = new TokenSeparator(source);
		if (file.getName().startsWith("TokenSeparator"))
			return source;

		source = new InlineComments(source);
		if (file.getName().startsWith("InlineComments"))
			return source;

		source = new PseudoLiterals(source);
		if (file.getName().startsWith("PseudoLiterals"))
			return source;

		if (file.getName().startsWith("Full"))
			return source;

		Assert.fail("Don't know how to setup source for " + file.getName());
		return null;
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

		addCategory("SEQNR", new Object[] { SEQUENCE_NUMBER_AREA });

		addCategory("I", new Object[] { INDICATOR_AREA });

		addCategory("IDENT", new Object[] { IDENTIFICATION_AREA });

		addCategory("PSEUDO", new Object[] { PSEUDO_LITERAL });

		addCategory("CTD__", new Object[] { CONTINUED });
		addCategory("_CTD_", new Object[] { CONTINUING, CONTINUED });
		addCategory("__CTD", new Object[] { CONTINUING });

		addCategory("LQ", new Object[] { LEADING_QUOTE });

		final Object[] skipped = new Object[] { SKIPPED };
		addCategory("SKIPPED", skipped);
		addCategory("SKP", skipped);
	}
}
