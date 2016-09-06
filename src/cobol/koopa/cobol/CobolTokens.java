package koopa.cobol;

import java.io.File;
import java.io.Reader;
import java.util.List;

import koopa.cobol.parser.preprocessing.PreprocessingSource;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.InlineComments;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.TokenSeparator;
import koopa.core.util.LineEndings;

public class CobolTokens {

	public static Source<Token> getNewSource(String resourceName,
			Reader reader, Grammar grammar, SourceFormat format, File file,
			Copybooks copybooks) {

		// We will be building up our source in several steps. Each
		// step takes the preceding source, and extends its abilities.
		Source<Token> source;

		// Split the input into lines.
		final List<List<Character>> lineEndings = LineEndings.getChoices();
		source = new LineSplitter(resourceName, reader, lineEndings);

		// Filter out some compiler directives.
		source = new CompilerDirectives(source, format);

		// Split up the different areas of each line.
		source = new ProgramArea(source);

		// Filter out some source formatting directives.
		source = new SourceFormattingDirectives(source);

		// Take care of line continuations.
		source = new LineContinuations(source);
		source = new ContinuationWelding(source);

		// Split up the lines into separators and non-separators.
		source = new TokenSeparator(source);

		// Find (and mark) inline comments.
		source = new InlineComments(source);

		// Find (and mark) pseudo literals.
		source = new PseudoLiterals(source);

		// source = new Printing(source, "%% ");

		// Apply preprocessing, when we know how to resolve copybooks.
		if (copybooks != null)
			source = new PreprocessingSource(source, grammar, format, file,
					copybooks);

		return source;
	}

	public static Source<Token> getNewSource(Reader reader, Grammar grammar,
			SourceFormat format) {
		return getNewSource(null, reader, grammar, format, null, null);
	}
}
