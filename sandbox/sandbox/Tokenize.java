package sandbox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.CompilerDirectivesTokenizer;
import koopa.tokenizers.cobol.ContinuationWeldingTokenizer;
import koopa.tokenizers.cobol.LineContinuationTokenizer;
import koopa.tokenizers.cobol.LineSplittingTokenizer;
import koopa.tokenizers.cobol.ProgramAreaTokenizer;
import koopa.tokenizers.cobol.PseudoLiteralTokenizer;
import koopa.tokenizers.cobol.SeparatorTokenizer;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.SourceFormattingDirectivesFilter;
import koopa.tokenizers.cobol.TokenCountVerifiyingTokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokenizers.generic.PrintingTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

public class Tokenize {

	public static void main(String[] args) throws IOException {
		process("testsuite/koopa/foo.cbl", SourceFormat.FIXED);
	}

	public static List<Token> process(String filename, SourceFormat format)
			throws IOException {
		System.out.println("Tokenizing " + filename);

		FileReader reader = new FileReader(filename);

		// We will be building up our tokenizer in several stages. Each stage
		// takes the preceding tokenizer, and extends its abilities.
		Tokenizer tokenizer;

		// The tokenizers in this sequence should generate the expected tokens.

		tokenizer = new LineSplittingTokenizer(new BufferedReader(reader));
		tokenizer = new CompilerDirectivesTokenizer(tokenizer, format);
		tokenizer = new ProgramAreaTokenizer(tokenizer, format);
		tokenizer = new SourceFormattingDirectivesFilter(tokenizer);

		if (format == SourceFormat.FIXED) {
			tokenizer = new LineContinuationTokenizer(tokenizer);
			tokenizer = new ContinuationWeldingTokenizer(tokenizer);
		}

		tokenizer = new SeparatorTokenizer(tokenizer);
		tokenizer = new PseudoLiteralTokenizer(tokenizer);

		// Here we filter out all tokens which are not part of the program text
		// area (comments are not considered part of this area). This leaves us
		// with the pure code, which should be perfect for processing by a
		// parser.
		tokenizer = new FilteringTokenizer(tokenizer, AreaTag.PROGRAM_TEXT_AREA);

		// Here we filter out all pure whitespace separators. This leaves us
		// with only the "structural" tokens which are of interest to a parser.
		tokenizer = new FilteringTokenizer(tokenizer, new TokenFilter() {
			public boolean accepts(Token token) {
				return !token.hasTag(SyntacticTag.SEPARATOR)
						|| !token.getText().trim().equals("");
			}
		});
		
		// The following is handy in debugging:
		tokenizer = new PrintingTokenizer("--> ", tokenizer);

		// So far, no tokenization will have occurred. The file will only start
		// getting tokenized when we start asking for tokens. We do this in the
		// following loop, which also counts the number of tokens which are
		// returned at the end.
		List<Token> tokens = new ArrayList<Token>();
		Token nextToken = null;
		while ((nextToken = tokenizer.nextToken()) != null) {
			tokens.add(nextToken);
			// System.out.println(nextToken);
		}

		// Some of our tokenizers may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of tokenizers, giving each a chance
		// to stop running.
		tokenizer.quit();

		// Finally, some reporting on the results of the tokenizing.
		System.out.println("Processed " + tokens.size()
				+ " top level token(s).");

		System.out.println();

		return tokens;
	}
}
