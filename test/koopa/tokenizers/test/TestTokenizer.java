package koopa.tokenizers.test;

import java.util.ArrayList;
import java.util.List;

import koopa.tokenizers.PushbackTokenizer;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;


public class TestTokenizer implements PushbackTokenizer {

	private List<Token> tokens = null;

	private int index = 0;

	private boolean quit = false;

	public TestTokenizer(String... parts) {
		this.tokens = new ArrayList<Token>();

		Position start = new Position(0, 0, 0);
		for (String part : parts) {
			Position end = start.offsetBy(part.length());
			Token token = new BasicToken(part, start, end);
			token.addTag(SyntacticTag.CHARACTER_STRING);

			if (part.startsWith("\"") && part.endsWith("\"")) {
				token.addTag(SyntacticTag.STRING_LITERAL);

			} else if (part.startsWith("==") && part.endsWith("==")) {
				token.addTag(SyntacticTag.PSEUDO_LITERAL);

			} else if (part.matches("^\\d+$")) {
				token.addTag(SyntacticTag.INTEGER_LITERAL);

			} else if (part.matches("^\\d+\\.\\d+$")) {
				token.addTag(SyntacticTag.DECIMAL_LITERAL);

			} else if (part.matches("^\\d+\\,\\d+$")) {
				token.addTag(SyntacticTag.DECIMAL_LITERAL);
			}

			this.tokens.add(token);
			start = end.offsetBy(1);
		}
	}

	public Token nextToken() {
		if (index == tokens.size())
			return null;

		return tokens.get(index++);
	}

	public void quit() {
		this.quit = true;
	}

	public void pushback(Token token) {
		if (token != null)
			index -= 1;
	}

	public void addTag(int index, Object tag) {
		tokens.get(index).addTag(tag);
	}

	public boolean hasQuit() {
		return quit;
	}

	public int getNumberOfProcessedTokens() {
		return index;
	}
}
