package sandbox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.CharacterStringTokenizer;
import koopa.tokenizers.cobol.ContinuationsTokenizer;
import koopa.tokenizers.cobol.ContinuedTokenizer;
import koopa.tokenizers.cobol.ProgramAreaTokenizer;
import koopa.tokenizers.cobol.SeparatorTokenizer;
import koopa.tokenizers.cobol.SourceFormattingDirectivesFilter;
import koopa.tokenizers.cobol.TokenCountVerifiyingTokenizer;
import koopa.tokenizers.cobol.TokenStateVerifiyingTokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokenizers.generic.PrintingTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

public class TokenizerTest {

	public static void main(String[] args) throws IOException {
		// FileReader reader = new FileReader("testsuite.cob");
		FileReader reader = new FileReader("testsuite/koopa/test.CBL");
		// FileReader reader = new FileReader("testsuite/cobol85/NC205A.CBL");

		// We will be building up our tokenizer in several stages. Each stage
		// takes the preceding tokenizer, and extends its abilities.
		Tokenizer tokenizer;

		// The tokenizers in this sequence should generate the expected tokens.
		tokenizer = new ProgramAreaTokenizer(new BufferedReader(reader));
		tokenizer = new SourceFormattingDirectivesFilter(tokenizer);
		tokenizer = new SeparatorTokenizer(tokenizer);
		tokenizer = new ContinuationsTokenizer(tokenizer);
		tokenizer = new ContinuedTokenizer(tokenizer);
		tokenizer = new CharacterStringTokenizer(tokenizer);

		// This tokenizer partly tests that assumption by comparing the number
		// of tokens in the program text area on each line with the expected
		// number. The number of expected tokens is encoded in the indicator
		// area of the test file. If it is missing (which is allowed) the line
		// is not tested in this way.
		TokenCountVerifiyingTokenizer countVerifier = null;
		tokenizer = countVerifier = new TokenCountVerifiyingTokenizer(tokenizer);

		TokenStateVerifiyingTokenizer stateVerifier = null;
		tokenizer = stateVerifier = new TokenStateVerifiyingTokenizer(tokenizer);

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

		// Finally, we pass the remaining tokens through a tokenizer which
		// prints them out to the terminal.
		tokenizer = new PrintingTokenizer(tokenizer, System.out);

		// Sofar, no tokenization will have occured. The file will only start
		// getting tokenized when we start asking for tokens. We do this in the
		// following loop, which also counts the number of tokens which are
		// returned at the end.
		int count = 0;
		while (tokenizer.nextToken() != null) {
			count += 1;
		}

		// Some of our tokenizers may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of tokenizers, giving each a chance
		// to stop running.
		tokenizer.quit();

		// Finally, some reporting on the results of the tokenizing.
		System.out.println();
		System.out.println("== Koopa Tokenizer report ======================");
		System.out.println("Processed " + count + " top level token(s).");

		if (countVerifier != null) {
			// TODO General logger/reporter ?
			for (String message : countVerifier.getErrorMessages()) {
				System.out.println(message);
			}
		}

		if (stateVerifier != null) {
			// TODO General logger/reporter ?
			for (String message : stateVerifier.getErrorMessages()) {
				System.out.println(message);
			}
		}
	}
}
