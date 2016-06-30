package koopa.cobol.parser.preprocessing.replacing;

import static koopa.core.trees.jaxen.Jaxen.getMatch;

import java.util.LinkedList;
import java.util.Stack;

import koopa.cobol.data.tags.SyntacticTag;
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

	public ReplacingPhrase(ReplacingPhraseOperand replacing, ReplacingPhraseOperand by) {
		this.replacing = replacing;
		this.by = by;
	}

	public ReplacingPhraseOperand getReplacing() {
		return replacing;
	}

	public ReplacingPhraseOperand getBy() {
		return by;
	}

	public abstract boolean appliedTo(Source<Data> source, LinkedList<Token> newTokens);

	protected Token nextTextWord(Source<Data> library, Stack<Token> seen) {
		while (true) {
			final Data data = library.next();

			if (data == null)
				return null;

			// TODO Non-tokens still need to be tracked.
			if (!(data instanceof Token)) {
				library.unshift(data);
				return null;
			}

			final Token textWord = (Token) data;

			seen.add(textWord);

			if (!textWord.hasTag(AreaTag.PROGRAM_TEXT_AREA))
				continue;

			final String text = textWord.getText();
			if ("\n".equals(text) || "\r\n".equals(text))
				continue;

			return textWord;
		}
	}

	protected void unshiftStack(Source<Data> library, Stack<Token> seen) {
		while (!seen.isEmpty())
			library.unshift(seen.pop());
	}

	public static boolean isConsideredSingleSpace(Token textWord) {
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

		if (Strings.isEmpty(text.trim()))
			return true;

		return false;
	}

	protected boolean isNewline(Token token) {
		final String text = token.getText();
		return "\n".equals(text) || "\r\n".equals(text);
	}

	@Override
	public String toString() {
		return replacing + " BY " + by;
	}
}
