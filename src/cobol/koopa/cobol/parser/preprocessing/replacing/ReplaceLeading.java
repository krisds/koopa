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

public class ReplaceLeading extends ReplacingPhrase {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.replacing.leading");

	private final String pattern;
	private final int patternLength;
	private final LinkedList<Token> replacement;

	public ReplaceLeading(ReplacingPhraseOperand replacing,
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
			replacement.addAll(by.getTokens());
			replacement.add(null);
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
			if (text.startsWith(pattern)) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("  We have a match.");

				final Token tail = Tokens.subtoken(Tokens.join(next),
						patternLength);

				if (replacement == null) {
					if (LOGGER.isTraceEnabled())
						LOGGER.trace("  Replacing with: " + tail);

					newTokens.add(tail);
					return true;

				} else {
					replacement.removeLast();
					replacement.addLast(tail);

					final Token newToken = Tokens.join(replacement,
							AreaTag.PROGRAM_TEXT_AREA);

					if (LOGGER.isTraceEnabled())
						LOGGER.trace("  Replacing with: " + newToken);

					newTokens.add(newToken);
					return true;
				}
			}
		}

		// library.unshift(next);
		unshiftStack(library, seen);

		return false;
	}

	@Override
	public String toString() {
		return "REPLACING LEADING " + replacing + " BY " + by;
	}
}
