package koopa.cobol.parser.preprocessing.replacing;

import java.util.LinkedList;
import java.util.List;

import koopa.cobol.data.tags.SyntacticTag;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

public class ReplacingSource extends ChainingSource<Data, Data> implements Source<Data> {

	/**
	 * The list of all active {@linkplain ReplacingPhrase}s. It is sorted in
	 * order of precedence, with the highest precedence appearing first.
	 */
	private LinkedList<List<ReplacingPhrase>> replacements = new LinkedList<List<ReplacingPhrase>>();

	/**
	 * This is a list of {@link Token}s which have been substituted in for a
	 * match.
	 */
	private LinkedList<Token> replacementTokens = new LinkedList<Token>();

	/**
	 * We don't want to match against the internals of already parsed
	 * structures. To that end we'll need to keep track of where we are in such
	 * structures.
	 */
	private int openStartTags = 0;

	public ReplacingSource() {
		super(null);
	}

	public ReplacingSource(Source<Data> source) {
		super(source);
	}

	/**
	 * Removes all {@linkplain Replacing}.
	 */
	public void clearAllReplacements() {
		replacements.clear();
	}

	public void popReplacements() {
		if (!replacements.isEmpty())
			replacements.removeFirst();
	}

	/**
	 * Adds and activates the given {@linkplain Replacement}. The new one will
	 * take precedence over all others.
	 */
	public void pushReplacements(List<ReplacingPhrase> r) {
		replacements.addFirst(r);
	}

	@Override
	protected Data nxt1() {
		replacing: while (true) {
			// If there is an active replacement, we process that first before
			// looking for more.
			if (!replacementTokens.isEmpty())
				return replacementTokens.removeFirst();

			final Data data = source.next();

			if (data == null)
				return null;

			// Anything which is bracketed by a Start and matching End will be
			// forwarded as is. To be able to do that we must track the number
			// of open Start tags, and act accordingly.
			if (data instanceof Start)
				openStartTags += 1;
			else if (data instanceof End)
				openStartTags -= 1;

			// So if we are within the reach of a Start tag we just pass the
			// data on as is.
			// Note that this won't apply to the final End tag, but that one
			// will get covered by the next check.
			if (openStartTags > 0)
				return data;

			// Anything that's not a Token will get passed on as is.
			// Most of that should have been covered by the logic for the
			// balanced Start/End tags, but the final End tag, for instance,
			// won't be.
			if (!(data instanceof Token))
				return data;

			// Now we get into the actual replacement logic, as described by the
			// spec. All of that seems to hinge around the leftmost text word,
			// which is what we're trying to identify first.
			final Token leftmost = (Token) data;

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

			// There may be multiple sets of replacement directives which are
			// active, thanks to the complexity of the REPLACE statement. We try
			// them all in order of precedence.
			for (List<ReplacingPhrase> r : replacements) {

				// "Starting with the first text-word for comparison and first
				// pseudo-text-1, text-1, word-1, literal-3, or
				// partial-word-1 that was specified in the REPLACING phrase,
				// the entire REPLACING phrase operand that precedes the
				// reserved word BY is compared to an equivalent number of
				// contiguous library text-words."
				for (ReplacingPhrase replacingPhrase : r) {
					if (replacingPhrase.appliedTo(source, replacementTokens)) {
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
					// next successive pseudo-text-1, text-1, word-1, literal-3,
					// or partial-word-1, if any, in the REPLACING phrase until
					// either a match is found or there is no next successive
					// REPLACING operand."
				}
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

	@Override
	public String toString() {
		return "REPLACING " + replacements;
	}
}
