package koopa.cobol.parser.preprocessing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import koopa.cobol.data.tags.SyntacticTag;
import koopa.cobol.parser.preprocessing.ReplacingPhrase.Mode;
import koopa.cobol.sources.SeparationLogic;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.Source;
import koopa.core.treeparsers.Tree;

public class ReplacingPhraseOperand {
	private static final Logger LOGGER = Logger
			.getLogger("tokenising.preprocessing.replacing.operands");

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

	public boolean matches(Source<Token> library, Mode mode) {
		// TODO Support all the things !
		if (mode != Mode.MATCHING)
			return false;

		// LEADING and TRAILING implies PSEUDO having only one word.

		// TODO Support all the things !
		if (type == Type.LITERAL)
			return false;

		// "[...] the entire REPLACING phrase operand that precedes the reserved
		// word BY is compared to an equivalent number of contiguous library
		// text-words."

		boolean matchOccured = true;
		Stack<Token> seenWhileMatching = new Stack<Token>();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Trying " + this);

		Iterator<Token> it = textWords.iterator();
		while (it.hasNext()) {
			final Token libraryTextWord = nextTextWord(library,
					seenWhileMatching);

			if (libraryTextWord == null) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("  <EOF>");

				matchOccured = false;
				break;
			}

			// Newlines are not matched against.
			if (isNewline(libraryTextWord))
				continue;

			// Spaces are not matched against, as they are not considered text
			// words.
			if (isConsideredSingleSpace(libraryTextWord))
				continue;

			final Token textWord = it.next();
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("  TESTING " + textWord);
				LOGGER.trace("    AGAINST " + libraryTextWord);
			}

			final String text = textWord.getText();
			final String libraryText = libraryTextWord.getText();

			if (!text.equalsIgnoreCase(libraryText)) {
				matchOccured = false;
				break;
			}
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("  => " + (matchOccured ? "MATCH FOUND" : "NO MATCH"));

		// Restore the source when we failed to match.
		if (!matchOccured)
			while (!seenWhileMatching.isEmpty())
				library.unshift(seenWhileMatching.pop());

		return matchOccured;
	}

	private Token nextTextWord(Source<Token> library, Stack<Token> seen) {
		while (true) {
			final Token textWord = library.next();

			if (textWord == null)
				return null;

			seen.add(textWord);

			if (!textWord.hasTag(AreaTag.PROGRAM_TEXT_AREA))
				continue;

			final String text = textWord.getText();
			if ("\n".equals(text) || "\r\n".equals(text))
				continue;

			return textWord;
		}
	}

	private boolean isConsideredSingleSpace(Token textWord) {
		// "Each occurrence of a separator comma, semicolon, or space in
		// pseudo-text-1 or in the library text is considered to be a single
		// space."

		if (!textWord.hasTag(SyntacticTag.SEPARATOR))
			return false;

		final String text = textWord.getText();

		if (",".equals(text))
			return true;

		if (";".equals(text))
			return true;

		if (text.trim().isEmpty())
			return true;

		return false;
	}

	private boolean isNewline(Token token) {
		final String text = token.getText();
		return "\n".equals(text) || "\r\n".equals(text);
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