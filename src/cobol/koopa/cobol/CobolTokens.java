package koopa.cobol;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;

import koopa.cobol.parser.preprocessing.PreprocessingSource;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.Separators;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Token;
import koopa.core.sources.ChainableSource;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;

// TODO Make it so that CobolParser can reuse this. --> 
// We'll need support for intermediate tokenizers and copybook lookup.
public class CobolTokens {
	public static Source<Token> getNewSource(Reader reader,
			SourceFormat format,
			List<ChainableSource<Token>> intermediateSources,
			Copybooks copybooks) {

		// We will be building up our tokenization stage in several steps. Each
		// step takes the preceding tokenizer, and extends its abilities.
		Source<Token> tokenizer;

		// Split the input into lines.
		tokenizer = new LineSplitter(new BufferedReader(reader));
		// Filter out some compiler directives.
		tokenizer = new CompilerDirectives(tokenizer, format);
		// Split up the different areas of each line.
		tokenizer = new ProgramArea(tokenizer);
		// Filter out some source formatting directives.
		tokenizer = new SourceFormattingDirectives(tokenizer);

		// In case of fixed format: take care of line continuations.
		tokenizer = new LineContinuations(tokenizer);
		tokenizer = new ContinuationWelding(tokenizer);

		// Split up the lines into separators and non-separators.
		tokenizer = new Separators(tokenizer);
		// Find (and mark) pseudo literals.
		tokenizer = new PseudoLiterals(tokenizer);

		if (intermediateSources != null) {
			// This allows external tools to see all tokens before further
			// processing. At the moment it is not guaranteed that all tokens
			// will make it to the token sinks.
			for (ChainableSource<Token> intermediate : intermediateSources) {
				intermediate.setSource(tokenizer);
				tokenizer = intermediate;
			}
		}

		// tokenizer = new Printing(tokenizer, "%% ");

		// EXPERIMENTAL: optional preprocessing stage.
		// TODO Work on this stage.
		if (copybooks != null)
			tokenizer = new PreprocessingSource(tokenizer, format, copybooks);

		return tokenizer;
	}

	public static Source<Token> getNewSource(Reader reader,
			SourceFormat format, Copybooks copybooks) {
		return getNewSource(reader, format, null, copybooks);
	}

	public static Source<Token> getNewSource(Reader reader, SourceFormat format) {
		return getNewSource(reader, format, null, null);
	}
}
