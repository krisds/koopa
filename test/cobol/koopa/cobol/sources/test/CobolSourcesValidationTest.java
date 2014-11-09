package koopa.cobol.sources.test;

import static koopa.cobol.data.tags.ContinuationsTag.CONTINUED;
import static koopa.cobol.data.tags.ContinuationsTag.CONTINUING;
import static koopa.cobol.data.tags.ContinuationsTag.LEADING_QUOTE;
import static koopa.cobol.data.tags.ContinuationsTag.SKIPPED;
import static koopa.cobol.data.tags.SyntacticTag.BOOLEAN_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.CHARACTER_STRING;
import static koopa.cobol.data.tags.SyntacticTag.HEXADECIMAL_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.INTEGER_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.PSEUDO_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.cobol.data.tags.SyntacticTag.SIGNED;
import static koopa.cobol.data.tags.SyntacticTag.STRING_LITERAL;
import static koopa.cobol.data.tags.SyntacticTag.UNSIGNED;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.END_OF_LINE;
import static koopa.core.data.tags.AreaTag.IDENTIFICATION_AREA;
import static koopa.core.data.tags.AreaTag.INDICATOR_AREA;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.AreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.core.data.tags.AreaTag.SOURCE_FORMATTING_DIRECTIVE;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.Separators;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.test.AnnotatedSourceSample;
import koopa.core.sources.test.TokenValidator;
import koopa.core.util.test.FileBasedTest;
import koopa.core.util.test.Files;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class provides the infrastructure for testing the different Cobol
 * tokenizer stages. It looks for ".sample" files, and runs each one it finds
 * through a JUnit test.
 */
@RunWith(Files.class)
public class CobolSourcesValidationTest implements FileBasedTest,
		TokenValidator {

	@Override
	public File[] getFiles() {
		File folder = new File("test/cobol/koopa/cobol/sources/test/");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return name.endsWith(".sample");
			}
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
		AnnotatedSourceSample sample = new AnnotatedSourceSample(
				new FileReader(file));

		Source<Token> source = getSource(sample, SourceFormat.FIXED);

		sample.assertOutputIsAsExpected(source, this);
	}

	private Source<Token> getSource(AnnotatedSourceSample sample,
			SourceFormat format) {
		Source<Token> source = null;

		source = new LineSplitter(sample.getReader());

		// TODO Get source format from file name as well, somehow.
		source = new CompilerDirectives(source, format);
		if (file.getName().startsWith("CompilerDirectives"))
			return source;

		source = new ProgramArea(source);
		if (file.getName().startsWith("ProgramArea"))
			return source;

		source = new SourceFormattingDirectives(source);
		if (file.getName().startsWith("SourceFormattingDirectives"))
			return source;

		if (format == SourceFormat.FIXED) {
			source = new LineContinuations(source);
			if (file.getName().startsWith("LineContinuations"))
				return source;

			source = new ContinuationWelding(source);
			if (file.getName().startsWith("ContinuationWelding"))
				return source;
		}

		source = new Separators(source);
		if (file.getName().startsWith("Separators"))
			return source;

		source = new PseudoLiterals(source);
		if (file.getName().startsWith("PseudoLiterals"))
			return source;

		if (file.getName().startsWith("Full"))
			return source;

		Assert.fail("Don't know how to setup source for " + file.getName());
		return null;
	}

	private static final Map<String, Object[]> TAG_VALIDATIONS;
	static {
		TAG_VALIDATIONS = new HashMap<String, Object[]>();

		TAG_VALIDATIONS.put(":", new Object[] { SEPARATOR });
		TAG_VALIDATIONS.put("EOLN", new Object[] { END_OF_LINE });
		TAG_VALIDATIONS.put("COMPILER_DIRECTIVE",
				new Object[] { COMPILER_DIRECTIVE });
		TAG_VALIDATIONS.put("SEQNR", new Object[] { SEQUENCE_NUMBER_AREA });
		TAG_VALIDATIONS.put("I", new Object[] { INDICATOR_AREA });
		TAG_VALIDATIONS.put("TEXT", new Object[] { PROGRAM_TEXT_AREA });
		TAG_VALIDATIONS.put("IDENT", new Object[] { IDENTIFICATION_AREA });
		TAG_VALIDATIONS.put("COMMENT", new Object[] { COMMENT });
		TAG_VALIDATIONS.put("FORMATTING",
				new Object[] { SOURCE_FORMATTING_DIRECTIVE });

		TAG_VALIDATIONS.put("CS", new Object[] { CHARACTER_STRING,
				PROGRAM_TEXT_AREA });
		TAG_VALIDATIONS.put("STRING", new Object[] { STRING_LITERAL,
				CHARACTER_STRING, PROGRAM_TEXT_AREA });
		TAG_VALIDATIONS.put("BOOL", new Object[] { BOOLEAN_LITERAL,
				CHARACTER_STRING, PROGRAM_TEXT_AREA });
		TAG_VALIDATIONS.put("HEX", new Object[] { HEXADECIMAL_LITERAL,
				CHARACTER_STRING, PROGRAM_TEXT_AREA });
		TAG_VALIDATIONS.put("UINT", new Object[] { INTEGER_LITERAL, UNSIGNED,
				CHARACTER_STRING, PROGRAM_TEXT_AREA });
		TAG_VALIDATIONS.put("SINT", new Object[] { INTEGER_LITERAL, SIGNED,
				CHARACTER_STRING, PROGRAM_TEXT_AREA });

		TAG_VALIDATIONS.put("PSEUDO", new Object[] { PSEUDO_LITERAL,
				CHARACTER_STRING, PROGRAM_TEXT_AREA });

		TAG_VALIDATIONS.put("CTD__", new Object[] { CONTINUED });
		TAG_VALIDATIONS.put("_CTD_", new Object[] { CONTINUING, CONTINUED });
		TAG_VALIDATIONS.put("__CTD", new Object[] { CONTINUING });

		TAG_VALIDATIONS.put("LQ", new Object[] { LEADING_QUOTE });

		TAG_VALIDATIONS.put("SKIPPED", new Object[] { SKIPPED });
	}

	@Override
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
