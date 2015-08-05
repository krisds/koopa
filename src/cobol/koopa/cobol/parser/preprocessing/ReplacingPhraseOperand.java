package koopa.cobol.parser.preprocessing;

import static koopa.cobol.parser.preprocessing.ReplacingPhrase.isConsideredSingleSpace;

import java.util.LinkedList;
import java.util.List;

import koopa.cobol.sources.SeparationLogic;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.trees.Tree;

public class ReplacingPhraseOperand {
	public static enum Type {
		PSEUDO, LITERAL, WORD;

		public static ReplacingPhraseOperand.Type from(Tree operand) {
			Tree child = operand.getChild(0);
			Start start = (Start) child.getData();
			final String name = start.getName();

			if ("pseudoLiteral".equals(name))
				return PSEUDO;
			else if ("literal".equals(name))
				return LITERAL;
			else if ("cobolWord".equals(name))
				return WORD;
			else
				return null;
		}
	}

	private final ReplacingPhraseOperand.Type type;
	private final LinkedList<Token> tokens;
	private final List<Token> textWords;

	public static ReplacingPhraseOperand from(Tree operand) {
		Type type = Type.from(operand);
		LinkedList<Token> tokens = new LinkedList<Token>();

		for (Token token : operand.getTokens())
			tokens.addAll(SeparationLogic.apply(token));

		return new ReplacingPhraseOperand(type, tokens);
	}

	public ReplacingPhraseOperand(Type type, List<Token> tokens) {
		this.type = type;
		this.tokens = new LinkedList<Token>(tokens);

		// Discard the pseudo text markers.
		if (type == Type.PSEUDO) {
			this.tokens.removeFirst();
			this.tokens.removeLast();
		}

		// Discard leading and trailing spaces.
		while (!this.tokens.isEmpty()
				&& isConsideredSingleSpace(this.tokens.peekFirst()))
			this.tokens.removeFirst();
		while (!this.tokens.isEmpty()
				&& isConsideredSingleSpace(this.tokens.peekLast()))
			this.tokens.removeLast();

		this.textWords = reduce(this.tokens);
	}

	private List<Token> reduce(List<Token> tokens) {
		final LinkedList<Token> words = new LinkedList<Token>();

		for (Token token : tokens) {
			// Discard newlines.
			if (isNewline(token))
				continue;

			// Discard spaces. They are not considered text words, and do not
			// participate in matching.
			if (isConsideredSingleSpace(token))
				continue;

			words.add(token);
		}

		return words;
	}

	private boolean isNewline(Token token) {
		final String text = token.getText();
		return "\n".equals(text) || "\r\n".equals(text);
	}

	public List<Token> getTextWords() {
		return textWords;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public ReplacingPhraseOperand.Type getType() {
		return type;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();

		b.append(type);
		b.append(":");
		for (Token word : textWords)
			b.append(word.getText());

		return b.toString();
	}
}