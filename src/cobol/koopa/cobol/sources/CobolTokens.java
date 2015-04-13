package koopa.cobol.sources;

import java.io.BufferedReader;
import java.io.Reader;

import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;

// TODO Make it so that CobolParser can reuse this. --> 
// We'll need support for intermediate tokenizers and copybook lookup.
public class CobolTokens {
	public Source<Token> getNewSource(Reader reader,
			SourceFormat format) {
		// We will be building up our tokenization stage in several steps. Each
		// step takes the preceding tokenizer, and extends its abilities.
		Source<Token> tokenizer;

		// Split the input into lines.
		tokenizer = new LineSplitter(new BufferedReader(reader));
		// Filter out some compiler directives.
		tokenizer = new CompilerDirectives(tokenizer, format);
		// Split up the different areas of each line (depending on the format).
		tokenizer = new ProgramArea(tokenizer, format);
		// Filter out some source formatting directives.
		tokenizer = new SourceFormattingDirectives(tokenizer);

		// In case of fixed format: take care of line continuations
		if (format == SourceFormat.FIXED) {
			tokenizer = new LineContinuations(tokenizer);
			tokenizer = new ContinuationWelding(tokenizer);
		}

		// Split up the lines into separators and non-separators.
		tokenizer = new Separators(tokenizer);
		// Find (and mark) pseudo literals.
		tokenizer = new PseudoLiterals(tokenizer);

		// tokenizer = new Printing(tokenizer, "%% ");
		return tokenizer;
	}
}
