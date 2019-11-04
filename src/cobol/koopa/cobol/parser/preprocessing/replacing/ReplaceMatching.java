package koopa.cobol.parser.preprocessing.replacing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.Source;

public class ReplaceMatching extends ReplacingPhrase {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.replacing.matching");

	public ReplaceMatching(ReplacingPhraseOperand replacing,
			ReplacingPhraseOperand by) {
		super(replacing, by);
	}

	@Override
	public boolean appliedTo(Source library,
			LinkedList<Data> newTokens) {
		boolean matchOccurred = true;
		Stack<Token> seenWhileMatching = new Stack<>();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Trying " + this);

		Iterator<String> it = replacing.getTextWords().iterator();
		while (it.hasNext()) {
			final String libraryTextWord = text(
					nextTextWord(library, seenWhileMatching));

			if (libraryTextWord == null) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("  <EOF>");

				matchOccurred = false;
				break;
			}

			final String textWord = it.next();
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("  TESTING " + textWord);
				LOGGER.trace("    AGAINST " + libraryTextWord);
			}

			final String text = textWord;
			final String libraryText = libraryTextWord;

			if (!text.equalsIgnoreCase(libraryText)) {
				matchOccurred = false;
				break;
			}
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(
					"  => " + (matchOccurred ? "MATCH FOUND" : "NO MATCH"));

		if (matchOccurred) {
			// "When a match occurs between pseudo-text-1, text-1,
			// word-1, or literal-3 and the library text, the
			// corresponding pseudo-text-2, text-2, word-2, or
			// literal-4 is placed into the resultant text."

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Matched " + replacing);
				LOGGER.debug("  Replaced with " + by);
			}

			// The output should include any whitespace we skipped while
			// matching.
			if (!seenWhileMatching.isEmpty())
				for (Token token : seenWhileMatching)
					if (isNewline(token) || isConsideredSingleSpace(token))
						newTokens.add(token);
					else
						break;

			newTokens.addAll(by.getTokens());

		} else
			unshiftStack(library, seenWhileMatching);

		return matchOccurred;
	}

	@Override
	public String toString() {
		return "REPLACING MATCHING " + replacing + " BY " + by;
	}
}
