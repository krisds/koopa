package koopa.cobol.parser.cobol.preprocessing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import koopa.cobol.data.tags.SyntacticTag;
import koopa.cobol.parser.cobol.preprocessing.ReplacingPhrase.Mode;
import koopa.cobol.sources.SeparationLogic;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.Source;
import koopa.core.treeparsers.Tree;

// TODO Unit tests !
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

	public ReplacingPhraseOperand(Tree operand) {
		this.type = Type.from(operand);

		this.tokens = new LinkedList<Token>();

		for (Token token : operand.getTokens())
			this.tokens.addAll(SeparationLogic.apply(token));

		// Discard the pseudo text markers.
		if (type == Type.PSEUDO) {
			this.tokens.removeFirst();
			this.tokens.removeLast();

			// "Beginning and ending spaces are not included in the text
			// comparison process, and multiple embedded spaces are considered
			// to be a single space."
			// IBM - ILE COBOL Reference
			// http://publib.boulder.ibm.com/iseries/v5r1/ic2924/books/c0925392609.htm#SPTCPY1PT
			//
			// My guess (based on samples) is that this is also true for the
			// replacement text.
			while (!tokens.isEmpty()
					&& isConsideredSingleSpace(tokens.peekFirst()))
				tokens.removeFirst();
			while (!tokens.isEmpty()
					&& isConsideredSingleSpace(tokens.peekLast()))
				tokens.removeLast();
		}

		this.textWords = reduce(tokens);
	}

	private List<Token> reduce(List<Token> tokens) {
		final LinkedList<Token> words = new LinkedList<Token>();

		boolean sawSpace = false;
		for (Token token : tokens) {
			// Discard newlines.
			if (isNewline(token))
				continue;

			// Discard consecutive spaces.
			if (sawSpace && isConsideredSingleSpace(token))
				continue;

			// Everything else we want.
			sawSpace = isConsideredSingleSpace(token);
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
		boolean sawSpace = false;

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

			if (isNewline(libraryTextWord))
				continue;

			// "Each sequence of one or more space separators is considered to
			// be a single space."
			if (sawSpace && isConsideredSingleSpace(libraryTextWord))
				continue;

			final Token textWord = it.next();
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("  TESTING " + textWord);
				LOGGER.trace("    AGAINST " + libraryTextWord);
			}

			sawSpace = isConsideredSingleSpace(textWord);
			if (sawSpace) {
				if (!isConsideredSingleSpace(libraryTextWord)) {
					matchOccured = false;
					break;
				}

			} else {
				final String text = textWord.getText();
				final String libraryText = libraryTextWord.getText();

				if (!text.equalsIgnoreCase(libraryText)) {
					matchOccured = false;
					break;
				}
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