package koopa.cobol.parser.preprocessing.replacing;

import static koopa.cobol.parser.preprocessing.replacing.ReplacingPhraseOperand.Type.PSEUDO;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.Tokens;
import koopa.core.data.tags.AreaTag;
import koopa.core.sources.Source;

public class ReplaceTrailing extends ReplacingPhrase {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.replacing.trailing");

	private final String pattern;
	private final int patternLength;
	private final LinkedList<Token> replacement;

	public ReplaceTrailing(ReplacingPhraseOperand replacing,
			ReplacingPhraseOperand by) {
		super(replacing, by);

		final List<String> replacingWords = replacing.getTextWords();
		final List<String> byWords = by.getTextWords();

		assert (replacing.getType() == PSEUDO && replacingWords.size() == 1);
		assert (by.getType() == PSEUDO && byWords.size() <= 1);

		final String leading = replacingWords.get(0);
		pattern = leading.toUpperCase();
		patternLength = pattern.length();

		if (byWords.size() == 0)
			replacement = null;
		else {
			replacement = new LinkedList<>();
			replacement.add(null);
			replacement.addAll(by.getTokens());
		}
	}

	@Override
	public boolean appliedTo(Source library,
			LinkedList<Data> newTokens) {

		final Stack<Token> seen = new Stack<>();
		final List<Token> next = nextTextWord(library, seen);

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Trying " + this);
			LOGGER.trace("  On " + next);
		}

		if (next != null) {
			final String text = text(next).toUpperCase();
			if (text.endsWith(pattern)) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("  We have a match.");

				final Token head = Tokens.subtoken(Tokens.join(next), 0,
						text.length() - patternLength);

				if (replacement == null) {
					if (LOGGER.isTraceEnabled())
						LOGGER.trace("  Replacing with: " + head);

					newTokens.add(head);
					return true;

				} else {
					replacement.removeFirst();
					replacement.addFirst(head);
					final Token newToken = Tokens.join(replacement,
							AreaTag.PROGRAM_TEXT_AREA);

					if (LOGGER.isTraceEnabled())
						LOGGER.trace("  Replacing with: " + newToken);

					newTokens.add(newToken);
					return true;
				}
			}
		}

		unshiftStack(library, seen);

		return false;
	}

	@Override
	public String toString() {
		return "REPLACING TRAILING " + replacing + " BY " + by;
	}
}
