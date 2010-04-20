package koopa.app.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import koopa.grammars.cobol.CobolGrammar;
import koopa.grammars.cobol.CobolVerifier;
import koopa.parsers.Parser;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.CharacterStringTokenizer;
import koopa.tokenizers.cobol.ContinuationsTokenizer;
import koopa.tokenizers.cobol.ContinuedTokenizer;
import koopa.tokenizers.cobol.ProgramAreaTokenizer;
import koopa.tokenizers.cobol.SeparatorTokenizer;
import koopa.tokenizers.cobol.SourceFormattingDirectivesFilter;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;
import koopa.util.Tuple;

import org.apache.log4j.Logger;

public class BasicParserConfiguration implements ParserConfiguration {

	private static final Logger LOGGER = Logger.getLogger("parser.basic");

	public ParseResults parse(File file) throws IOException {
		LOGGER.info("Parsing " + file);

		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		FileReader reader = new FileReader(file);

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
						|| (!token.getText().trim().equals("")
								&& !token.getText().equals(",") && !token
								.getText().equals(";"));
			}
		});

		ParseResults results = new ParseResults(file);

		// This object holds all grammar productions. It is not thread-safe,
		// meaning that you can only ask it to parse one thing at a time.
		CobolGrammar grammar = new CobolGrammar();

		// This object does some extra verification on the output of the
		// grammar.
		CobolVerifier verifier = new CobolVerifier();

		// Depending on the type of file we ask the grammar for the right
		// parser.
		Parser parser = null;
		if (isCopybook) {
			parser = grammar.copybook();
		} else {
			parser = grammar.compilationGroup();
		}

		// We then ask the parser to parse the input.
		boolean accepts = parser.accepts(tokenizer, verifier);

		if (accepts) {
			LOGGER.info("Valid file: " + file);
			results.setValidInput(true);

		} else {
			LOGGER.info("Invalid file: " + file);
			results.setValidInput(false);
		}

		if (grammar.hasWarnings()) {
			LOGGER.info("There were warnings from the grammar:");

			final List<Tuple<Token, String>> warnings = grammar.getWarnings();

			for (Tuple<Token, String> warning : warnings) {
				LOGGER.info("  " + warning.getFirst() + ": "
						+ warning.getSecond());

				results.addWarning(warning.getFirst(), warning.getSecond());
			}
		}

		if (verifier.hasWarnings()) {
			LOGGER.info("There were warnings from the verifier:");

			final List<Tuple<Token, String>> warnings = verifier.getWarnings();

			for (Tuple<Token, String> warning : warnings) {
				LOGGER.info("  " + warning.getFirst() + ": "
						+ warning.getSecond());

				results.addWarning(warning.getFirst(), warning.getSecond());
			}
		}

		if (verifier.hasErrors()) {
			LOGGER.info("There were errors from the verifier:");

			final List<Tuple<Token, String>> errors = verifier.getErrors();

			for (Tuple<Token, String> error : errors) {
				LOGGER.info("  " + error.getFirst() + ": " + error.getSecond());

				results.addError(error.getFirst(), error.getSecond());
			}

			results.setValidInput(false);
		}

		Token t = tokenizer.nextToken();
		if (t != null) {
			LOGGER.info("Not all input was consumed.");

			results.setValidInput(false);
			results.addError(t, "Not all input was consumed.");

			int count = 0;
			do {
				LOGGER.info("-> " + t);
				count++;
			} while (count < 5 && (t = tokenizer.nextToken()) != null);

			if (t != null) {
				LOGGER.info("-> ...");
			}
		}

		// Some of our tokenizers may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of tokenizers, giving each a chance
		// to stop running.
		tokenizer.quit();

		return results;
	}
}
