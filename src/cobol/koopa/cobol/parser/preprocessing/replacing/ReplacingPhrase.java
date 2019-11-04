package koopa.cobol.parser.preprocessing.replacing;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.AreaTag.SKIPPED;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.trees.jaxen.Jaxen.getMatch;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.Source;
import koopa.core.trees.Tree;
import koopa.core.util.Strings;

public abstract class ReplacingPhrase {

	public static enum Mode {
		MATCHING, LEADING, TRAILING;

		public static Mode from(Tree instruction) {
			if (getMatch(instruction, "leading") != null)
				return LEADING;
			else if (getMatch(instruction, "trailing") != null)
				return TRAILING;
			else
				return MATCHING;
		}
	}

	protected final ReplacingPhraseOperand replacing;
	protected final ReplacingPhraseOperand by;

	public ReplacingPhrase(ReplacingPhraseOperand replacing,
			ReplacingPhraseOperand by) {
		this.replacing = replacing;
		this.by = by;
	}

	public ReplacingPhraseOperand getReplacing() {
		return replacing;
	}

	public ReplacingPhraseOperand getBy() {
		return by;
	}

	public abstract boolean appliedTo(Source source,
			LinkedList<Data> newTokens);

	protected List<Token> nextTextWord(Source library,
			Stack<Token> seen) {
		skipToNonBlankProgramText(library, seen);
		return nonBlankProgramText(library, seen);
	}

	private List<Token> nonBlankProgramText(Source library,
			Stack<Token> seen) {

		List<Token> textWord = null;
		boolean buildingDummyOperand = false;

		while (true) {
			final Data data = library.next();

			if (data == null)
				return textWord;

			// If we find non-Tokens in the data stream we assume they're there
			// for a good reason and let them indicate the end of the text word.
			if (!(data instanceof Token)) {
				library.unshift(data);
				return textWord;
			}

			final Token t = (Token) data;

			if (!isProgramText(t)) {
				seen.add(t);
				continue;
			}

			if (isBlank(t)) {
				library.unshift(t);
				return textWord;
			}

			if (t.hasTag(SEPARATOR)) {
				if (textWord == null || buildingDummyOperand) {

					seen.add(t);
					if (textWord == null) {
						textWord = new LinkedList<>();
					}

					//Check if we are looking at a dummy operand
					if (":".equals(t.getText())) {
						if (!buildingDummyOperand) {
							buildingDummyOperand = true;
							textWord.add(t);
							continue;
						}
					}
					// SEP while building a word => complete word and ignore
					// SEP.

					textWord.add(t);

					return textWord;

				} else {
					// SEP while not building a word => return SEP.
					library.unshift(t);
					return textWord;
				}

			} else {
				seen.add(t);

				if (textWord == null)
					textWord = new LinkedList<>();

				textWord.add(t);
			}
		}
	}

	private void skipToNonBlankProgramText(Source library,
			Stack<Token> seen) {
		while (true) {
			final Data d = library.next();

			if (d == null)
				return;

			if (!(d instanceof Token)) {
				library.unshift(d);
				return;
			}

			final Token t = (Token) d;

			if (isProgramText(t) && !isBlank(t)) {
				library.unshift(t);
				return;
			} else
				seen.add(t);
		}
	}

	private boolean isProgramText(Token t) {
		return t.hasAnyTag(PROGRAM_TEXT_AREA, SKIPPED) && !t.hasAnyTag(COMMENT);
	}

	private boolean isBlank(Token t) {
		return isProgramText(t)
				&& t.hasAnyTag(COMMENT, END_OF_LINE, WHITESPACE);
	}

	protected void unshiftStack(Source library, Stack<Token> seen) {
		while (!seen.isEmpty())
			library.unshift(seen.pop());
	}

	public static boolean isConsideredSingleSpace(Data tw) {
		if (!(tw instanceof Token))
			return false;
		
		final Token textWord = (Token) tw;
		
		// "Comments, if any, are treated as a single space."
		if (textWord.hasTag(AreaTag.COMMENT))
			return true;

		// "Each occurrence of a separator comma, semicolon, or space in
		// pseudo-text-1 or in the library text is considered to be a single
		// space."

		final String text = textWord.getText();

		if (",".equals(text))
			return true;

		if (";".equals(text))
			return true;

		if (Strings.isEmpty(text.trim()))
			return true;

		return false;
	}

	protected boolean isNewline(Token token) {
		final String text = token.getText();
		return "\n".equals(text) || "\r\n".equals(text);
	}

	protected String text(List<Token> words) {
		if (words == null || words.isEmpty())
			return null;

		String text = "";
		for (Token token : words)
			text += token.getText();

		return text;
	}

	@Override
	public String toString() {
		return replacing + " BY " + by;
	}
}