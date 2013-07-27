package koopa.tokenizers.generic;

import java.io.PrintStream;

import koopa.tokenizers.Tokenizer;
import koopa.tokens.Token;

public class PrintingTokenizer implements Tokenizer {
	private String marker = null;
	private Tokenizer tokenizer = null;
	private PrintStream out = null;

	public PrintingTokenizer(Tokenizer tokenizer) {
		this(null, tokenizer, System.out);
	}

	public PrintingTokenizer(String marker, Tokenizer tokenizer) {
		this(marker, tokenizer, System.out);
	}

	public PrintingTokenizer(String marker, Tokenizer tokenizer, PrintStream out) {
		assert (tokenizer != null);
		assert (out != null);

		this.marker = marker == null ? "" : marker;
		this.tokenizer = tokenizer;
		this.out = out;
	}

	public Token nextToken() {
		Token token = tokenizer.nextToken();

		if (token != null) {
			out.print(marker);
			out.print(token);
			for (Object tag : token.getTags()) {
				out.print(", " + tag.toString().toLowerCase());
			}
			out.println();
		}

		return token;
	}

	public void quit() {
		tokenizer.quit();
	}
}
