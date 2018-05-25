package koopa.core.sources.test;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.AreaTag.SKIPPED;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.INCOMPLETE;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.data.tags.SyntacticTag.WORD;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

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
		final Object[] notProgramText = new Object[] { //
				COMMENT, SKIPPED, COMPILER_DIRECTIVE };
		addTokenCategory("TEXT", programText, notProgramText);
		addTokenCategory("T", programText, notProgramText);

		final Object[] comment = new Object[] { COMMENT };
		final Object[] notComment = new Object[] { //
				PROGRAM_TEXT_AREA, SKIPPED, COMPILER_DIRECTIVE };
		addTokenCategory("COMMENT", comment, notComment);
		addTokenCategory("C", comment, notComment);

		final Object[] skipped = new Object[] { SKIPPED };
		final Object[] notSkipped = new Object[] { //
				PROGRAM_TEXT_AREA, COMMENT, COMPILER_DIRECTIVE };
		addTokenCategory("SKIPPED", skipped, notSkipped);
		addTokenCategory("SKIP", skipped, notSkipped);
		addTokenCategory("SKP", skipped, notSkipped);

		final Object[] compilerDirective = new Object[] { COMPILER_DIRECTIVE };
		final Object[] notCompilerDirective = new Object[] { //
				PROGRAM_TEXT_AREA, COMMENT, SKIPPED };
		addTokenCategory("COMPILER_DIRECTIVE", compilerDirective,
				notCompilerDirective);
		addTokenCategory("DIRECTIVE", compilerDirective, notCompilerDirective);
		addTokenCategory("DIR", compilerDirective, notCompilerDirective);
		addTokenCategory("D", compilerDirective, notCompilerDirective);

		final Object[] separator = new Object[] { SEPARATOR };
		addTokenCategory(":", separator);
		addTokenCategory("SEP", separator);

		final Object[] eoln = new Object[] { END_OF_LINE };
		addTokenCategory("EOLN", eoln);

		final Object[] whitespace = new Object[] { SEPARATOR, WHITESPACE };
		addTokenCategory(".", whitespace);
		addTokenCategory("WS", whitespace);

		final Object[] string = new Object[] { STRING };
		addTokenCategory("STRING", string);
		addTokenCategory("STR", string);
		addTokenCategory("S", string);

		final Object[] number = new Object[] { NUMBER };
		addTokenCategory("NUMBER", number);
		addTokenCategory("NUM", number);
		addTokenCategory("N", number);

		final Object[] word = new Object[] { WORD };
		addTokenCategory("WORD", word);
		addTokenCategory("W", word);

		final Object[] incomplete = new Object[] { INCOMPLETE };
		addTokenCategory("INCOMPLETE", incomplete);
	}

	@Override
	protected Source getSource(String resourceName, Sample sample) {
		final LineSplitter lineSplitter //
				= new LineSplitter(resourceName, sample.getReader());
		if (file.getName().startsWith("LineSplitter"))
			return lineSplitter;

		Assert.fail("Don't know how to setup source for " + file.getName());
		return null;
	}
}
