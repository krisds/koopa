package koopa.core.sources.test;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.AreaTag.SOURCE_FORMATTING_DIRECTIVE;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.data.tags.SyntacticTag.WORD;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.test.samples.Sample;
import koopa.core.sources.test.samples.SourcesValidationTest;
import koopa.core.util.test.Files;

/**
 * This class provides the infrastructure for testing the different sources. It
 * looks for ".sample" files, and runs each one it finds through a JUnit test.
 */
@RunWith(Files.class)
public class CoreSourcesValidationTest extends SourcesValidationTest {

	@Override
	protected File getFolder() {
		return new File("test/core/koopa/core/sources/test/");
	}

	@Before
	public void initialize() {
		final Object[] programText = new Object[] { PROGRAM_TEXT_AREA };
		addCategory("T", programText);
		addCategory("TEXT", programText);

		final Object[] comment = new Object[] { COMMENT };
		addCategory("C", comment);
		addCategory("COMMENT", comment);

		final Object[] compilerDirective = new Object[] { COMPILER_DIRECTIVE };
		addCategory("COMPILER_DIRECTIVE", compilerDirective);
		addCategory("DIRECTIVE", compilerDirective);
		addCategory("DIR", compilerDirective);
		addCategory("D", compilerDirective);

		addCategory("FORMATTING", new Object[] { SOURCE_FORMATTING_DIRECTIVE });

		final Object[] separator = new Object[] { SEPARATOR };
		addCategory(":", separator);
		addCategory("SEP", separator);

		addCategory("EOLN", new Object[] { END_OF_LINE });

		final Object[] whitespace = new Object[] { SEPARATOR, WHITESPACE };
		addCategory(".", whitespace);
		addCategory("WS", whitespace);

		addCategory("STRING", new Object[] { STRING });

		final Object[] number = new Object[] { NUMBER };
		addCategory("N", number);
		addCategory("NUM", number);
		addCategory("NUMBER", number);

		final Object[] word = new Object[] { WORD };
		addCategory("W", word);
		addCategory("WORD", word);
	}

	@Override
	protected Source<Token> getSource(String resourceName, Sample sample) {
		Source<Token> source = null;

		source = new LineSplitter(resourceName, sample.getReader());
		if (file.getName().startsWith("LineSplitter"))
			return source;

		Assert.fail("Don't know how to setup source for " + file.getName());
		return null;
	}
}
