package koopa.tokenizers.cobol;

import java.util.LinkedList;
import java.util.List;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;

public class TokenStateVerifiyingTokenizer implements Tokenizer {
	private Tokenizer tokenizer = null;

	private List<String> errorMessages = null;

	public TokenStateVerifiyingTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
		this.errorMessages = new LinkedList<String>();
	}

	public Token nextToken() {
		Token token = tokenizer.nextToken();

		if (token != null) {
			checkAreaTags(token);
			checkCharacterStringTags(token);
			checkNumericalTags(token);
			checkLineBreaks(token);
		}

		return token;
	}

	private void checkLineBreaks(Token token) {
		if (token instanceof CompositeToken) {
			final CompositeToken composite = (CompositeToken) token;
			for (int i = 0; i < composite.size(); i++) {
				checkLineBreaks(composite.getToken(i));
			}

		} else {
			if (token.getStart().getLinenumber() != token.getEnd()
					.getLinenumber()) {
				errorMessages.add("Line " + token.getStart().getLinenumber()
						+ ": " + token + " crosses line boundary.");
			}
		}
	}

	private void checkNumericalTags(Token token) {
		if (token.hasTag(SyntacticTag.SIGNED)
				|| token.hasTag(SyntacticTag.UNSIGNED)) {
			if (!token.hasTag(SyntacticTag.DECIMAL_LITERAL)
					&& !token.hasTag(SyntacticTag.INTEGER_LITERAL)) {
				errorMessages.add("Line " + token.getStart().getLinenumber()
						+ ": " + token + " misses numeric identification.");
			}

		} else if (token.hasTag(SyntacticTag.DECIMAL_LITERAL)
				|| token.hasTag(SyntacticTag.INTEGER_LITERAL)) {
			if (!token.hasTag(SyntacticTag.SIGNED)
					&& !token.hasTag(SyntacticTag.UNSIGNED)) {
				errorMessages.add("Line " + token.getStart().getLinenumber()
						+ ": " + token + " misses sign information.");
			}
		}
	}

	private void checkCharacterStringTags(Token token) {
		if (token.hasTag(SyntacticTag.STRING_LITERAL)
				|| token.hasTag(SyntacticTag.INTEGER_LITERAL)
				|| token.hasTag(SyntacticTag.DECIMAL_LITERAL)
				|| token.hasTag(SyntacticTag.PICTURE)) {

			if (!token.hasTag(SyntacticTag.CHARACTER_STRING)) {
				errorMessages.add("Line " + token.getStart().getLinenumber()
						+ ": " + token + " misses character_string tag.");
			}

			if (token.hasTag(SyntacticTag.SEPARATOR)) {
				errorMessages.add("Line " + token.getStart().getLinenumber()
						+ ": " + token + " has a bad separator tag.");
			}
		}
	}

	private void checkAreaTags(Token token) {
		int count = 0;

		for (Object tag : token.getTags()) {
			if (tag instanceof AreaTag) {
				count += 1;
			}
		}

		if (count == 0) {
			errorMessages.add("Line " + token.getStart().getLinenumber() + ": "
					+ token + " misses area identification.");

		} else if (count > 1) {
			errorMessages.add("Line " + token.getStart().getLinenumber() + ": "
					+ token + " has conflicting area identification.");
		}
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void quit() {
		tokenizer.quit();
	}
}
