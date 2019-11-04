package koopa.cobol.parser.preprocessing.replacing;

import static koopa.cobol.parser.preprocessing.replacing.ReplacingPhrase.isConsideredSingleSpace;
import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;
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
	private final LinkedList<String> textWords;

	public static ReplacingPhraseOperand from(Tree operand) {
		final Type type = Type.from(operand);
		final LinkedList<Data> tokens //
				= new LinkedList<>(operand.getTokens());
		return new ReplacingPhraseOperand(type, tokens);
	}

	public ReplacingPhraseOperand(Type type, List<Data> data) {
		this.type = type;
		this.tokens = new LinkedList<>();
		for (Data d : data) 
			if (d instanceof Token)
				this.tokens.add((Token) d);

		// Discard the pseudo text markers.
		if (type == Type.PSEUDO) {
			// Two '=' at the start...
			this.tokens.removeFirst();
			this.tokens.removeFirst();
			// Two '=' at the end...
			this.tokens.removeLast();
			this.tokens.removeLast();
		}

		// Discard leading and trailing spaces.
		while (!this.tokens.isEmpty()
				&& isConsideredSingleSpace(this.tokens.getFirst()))
			this.tokens.removeFirst();
		while (!this.tokens.isEmpty()
				&& isConsideredSingleSpace(this.tokens.getLast()))
			this.tokens.removeLast();

		this.textWords = new LinkedList<>();
		prepareForMatching();
	}

	private void prepareForMatching() {
		boolean atSpace = true;
		for (Data d : tokens) {
			// Discard anything that's not program text.
			// TODO Ask grammar ?
			if (!(d instanceof Token))
				continue;
			
			final Token token = (Token) d;
			
			if (!token.hasTag(PROGRAM_TEXT_AREA) || token.hasTag(COMMENT))
				continue;

			// Discard newlines and spaces. They are not considered text words,
			// and do not participate in matching.
			if (isNewline(token) || isConsideredSingleSpace(token)) {
				atSpace = true;
				continue;
			}

			if (token.hasTag(SEPARATOR) && !isDummyOperand()) {
				textWords.add(token.getText());
				atSpace = true;
			} else if (atSpace)
				textWords.add(token.getText());
			else
				textWords.addLast(textWords.removeLast() + token.getText());

			atSpace = false;
		}
	}
	
	private boolean isDummyOperand() {
		if (tokens.size() >= 3) {
			if (":".equals(tokens.getFirst().getText()) && ":".equals(tokens.getLast().getText())) {
				return true;
			}
		}
		return false;
	}

	private boolean isNewline(Token token) {
		final String text = token.getText();
		return "\n".equals(text) || "\r\n".equals(text);
	}

	public List<String> getTextWords() {
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
		for (int i = 0; i < textWords.size(); i++) {
			if (i > 0)
				b.append(" ");
			b.append(textWords.get(i));
		}

		return b.toString();
	}
}