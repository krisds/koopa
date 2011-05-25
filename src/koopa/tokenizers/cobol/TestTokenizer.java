package koopa.tokenizers.cobol;

import java.io.StringReader;

import koopa.tokenizers.PushbackTokenizer;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.cobol.tags.TokenizerTag;
import koopa.tokenizers.generic.BasicPushbackTokenizer;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;

public class TestTokenizer implements PushbackTokenizer {

	public static final String MARKER_TEXT = "\u2022";

	private PushbackTokenizer tokenizer;
	private boolean quit = false;
	private Token markerToken = null;
	private Token lastToken = null;

	public TestTokenizer(String data) {
		this(SourceFormat.FREE, data);
	}

	public TestTokenizer(SourceFormat format, String data) {
		// The tokenizers in this sequence should generate the expected tokens.
		Tokenizer tokenizer = new LineSplittingTokenizer(new StringReader(data));
		tokenizer = new CompilerDirectivesTokenizer(tokenizer);
		tokenizer = new ProgramAreaTokenizer(tokenizer, format);
		tokenizer = new SourceFormattingDirectivesFilter(tokenizer);
		tokenizer = new SeparatorTokenizer(tokenizer);
		tokenizer = new PseudoLiteralTokenizer(tokenizer);

		// Here we filter out all tokens which are not part of the program text
		// area (comments are not considered part of this area). This leaves us
		// with the pure code, which should be perfect for processing by a
		// parser.
		tokenizer = new FilteringTokenizer(tokenizer, AreaTag.PROGRAM_TEXT_AREA);

		// Here we filter out all pure whitespace separators. This leaves us
		// with only the "structural" tokens which are of interest to a parser.
		// 
		// When we do this we need to tag tokens which were not separated by
		// whitespace. This is needed to correctly build picture strings while
		// parsing. It would be nicer if we could recognize picture strings
		// in the tokenizer stages, but I don't see how we can do that without
		// some form of parsing...
		// TODO Duplication of code in CobolParser. Should clean this up...
		tokenizer = new FilteringTokenizer(tokenizer, new TokenFilter() {
			boolean lastWasWhitespace = true;
			int lastLinenumber = -1;

			public boolean accepts(Token token) {
				final int currentLinenumber = token.getStart().getLinenumber();
				
				// A change of line is seen as whitespace.
				if (lastLinenumber != currentLinenumber) {
					lastWasWhitespace = true;
				}
				
				if (!token.hasTag(SyntacticTag.SEPARATOR)) {
					if (!lastWasWhitespace) {
						token.addTag(TokenizerTag.CHAINED);
					}
					lastWasWhitespace = false;
					lastLinenumber = currentLinenumber;
					return true;
				}

				final String text = token.getText().trim();
				if (text.equals("")) {
					lastWasWhitespace = true;
					lastLinenumber = currentLinenumber;
					return false;
				}

				if (!lastWasWhitespace) {
					token.addTag(TokenizerTag.CHAINED);
				}
				lastWasWhitespace = false;
				lastLinenumber = currentLinenumber;
				return !text.equals(",") && !text.equals(";");
			}
		});

		this.tokenizer = new BasicPushbackTokenizer(tokenizer);
	}

	public Token nextToken() {
		Token nextToken = this.tokenizer.nextToken();
		if (nextToken != null && nextToken.getText().equals(MARKER_TEXT)) {
			this.markerToken = nextToken;
			nextToken = this.tokenizer.nextToken();
		}

		return nextToken;
	}

	public void quit() {
		this.lastToken = this.tokenizer.nextToken();
		this.quit = true;
		this.tokenizer.quit();
	}

	public void pushback(Token token) {
		this.tokenizer.pushback(token);
		if (this.markerToken != null) {
			this.tokenizer.pushback(this.markerToken);
			this.markerToken = null;
		}
	}

	public boolean hasQuit() {
		return this.quit;
	}

	public boolean isWhereExpected() {
		return (this.lastToken == null && this.markerToken == null)
				|| this.lastToken.getText().equals(MARKER_TEXT);
	}
}
