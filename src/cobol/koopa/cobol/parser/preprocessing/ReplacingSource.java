package koopa.cobol.parser.preprocessing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.data.tags.SyntacticTag;
import koopa.core.data.Token;
import koopa.core.sources.ChainableSource;
import koopa.core.sources.Source;
import koopa.core.treeparsers.Tree;

import org.apache.log4j.Logger;

public class ReplacingSource extends ChainableSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.preprocessing.replacing");

	private List<ReplacingPhrase> replacingPhrases;
	private LinkedList<Token> replacementTokens = new LinkedList<Token>();

	public ReplacingSource(List<Tree> replacements) {
		replacingPhrases = new ArrayList<ReplacingPhrase>(replacements.size());

		for (Tree replacement : replacements) {
			ReplacingPhrase replacingPhrase = new ReplacingPhrase(replacement);

			if (LOGGER.isDebugEnabled())
				LOGGER.debug("* " + replacingPhrase);
			replacingPhrases.add(replacingPhrase);
		}
	}

	@Override
	protected Token nxt1() {
		replacing: while (true) {
			if (!replacementTokens.isEmpty())
				return replacementTokens.removeFirst();

			final Token leftmost = source.next();
			if (leftmost == null)
				return null;

			// "The leftmost library text-word that is not a separator comma or
			// a separator semicolon is the first text-word used for
			// comparison."

			if (leftmost.hasTag(SyntacticTag.SEPARATOR)) {
				final String text = leftmost.getText();
				if (",".equals(text) || ";".equals(text))
					return leftmost;
			}

			// Repositioning the token stream to start with the leftmost token.
			source.unshift(leftmost);

			// "Starting with the first text-word for comparison and first
			// pseudo-text-1, text-1, word-1, literal-3, or
			// partial-word-1 that was specified in the REPLACING phrase, the
			// entire REPLACING phrase operand that precedes the reserved word
			// BY is compared to an equivalent number of contiguous library
			// text-words."

			for (ReplacingPhrase replacingPhrase : replacingPhrases) {
				if (replacingPhrase.matches(source)) {
					if (LOGGER.isTraceEnabled()) {
						LOGGER.trace("Matched " + replacingPhrase.getOperand());
						LOGGER.trace("   From " + leftmost);
					}

					// "When a match occurs between pseudo-text-1, text-1,
					// word-1, or literal-3 and the library text, the
					// corresponding pseudo-text-2, text-2, word-2, or
					// literal-4 is placed into the resultant text."

					replacementTokens.addAll(replacingPhrase
							.getCorrespondingTokens());

					if (LOGGER.isTraceEnabled())
						LOGGER.trace("  Replaced with "
								+ replacingPhrase.getCorrespondingOperand());

					// TODO This:
					// "When a match occurs between partial-word-1 and the
					// library text-word, the library text-word is placed
					// into the resultant text with the matched characters
					// either replaced by partial-word-2 or deleted when
					// partial-word-2 consists of zero text-words."

					// "The library text-word immediately following the
					// rightmost text-word that participated in the match is
					// then considered as the leftmost text-word. The
					// comparison cycle starts again with the first
					// pseudo-text-1, text-1, word-1, literal-3, or
					// partial-word-1 specified in the REPLACING phrase."

					continue replacing;
				}

				// "If no match occurs, the comparison is repeated with each
				// next successive pseudo-text-1, text-1, word-1, literal-3, or
				// partial-word-1, if any, in the REPLACING phrase until either
				// a match is found or there is no next successive REPLACING
				// operand."
			}

			// "When all the REPLACING phrase operands have been compared and no
			// match has occurred, the leftmost library text-word is copied into
			// the resultant text. The next successive library text-word is then
			// considered as the leftmost library text-word, and the comparison
			// cycle starts again with the first pseudo-text-1, text-1, word-1,
			// literal-3, or partial-word-1 specified in the REPLACING phrase."

			return source.next();
		}
	}
}
