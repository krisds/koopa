package koopa.core.data;

import java.util.ArrayList;
import java.util.List;

public final class Tokens {

	private Tokens() {
	}

	/**
	 * Similar to String.substring(beginIndex), but then with Tokens.
	 * <p>
	 * Will return <code>token</code> if the begin index is zero.
	 * <p>
	 * Will copy all tags to the new token. Will also retain the ranges from the
	 * original token, except for those getting cut by the substring semantics.
	 * 
	 * @param token
	 *            The input token.
	 * @param beginIndex
	 *            Relative offset to start from.
	 * @return The requested subtoken.
	 */
	public static Token subtoken(final Token token, final int beginIndex) {
		final int lengthOfToken = token.getLength();

		// Check bounds.
		if (beginIndex < 0 || beginIndex > lengthOfToken)
			throw new IndexOutOfBoundsException("Start position (" + beginIndex
					+ ") falls outside the token's bounds [0, " + lengthOfToken
					+ "[.");

		// Full token ?
		if (beginIndex == 0)
			return token;

		// Empty token ?
		if (beginIndex == lengthOfToken) {
			List<Range> ranges = new ArrayList<>(1);
			Position end = token.getEnd();
			ranges.add(new Range(end, end));
			return new Token("", ranges, token.getTags(), token.getReplaced());
		}

		int index = beginIndex;
		String text = token.getText().substring(index);

		List<Range> ranges = new ArrayList<>();
		for (Range range : token.getRanges()) {
			if (index == 0) {
				// We have already made the cut. All further ranges get added
				// as-is.
				ranges.add(range);
				continue;
			}

			int length = range.getLength();
			if (index < length) {
				// We need to cut the current range.
				Position start = range.getStart().offsetBy(index);
				Position end = range.getEnd();
				ranges.add(new Range(start, end));
				// Once cut we zero the start index.
				index = 0;
				continue;
			}

			// And this case is for when we haven't yet reached the correct
			// range to cut.
			index -= length;
		}

		assert (!ranges.isEmpty());

		final Token sub = new Token(text, ranges,
				token.getTags(), token.getReplaced());

		return sub;
	}

	/**
	 * Similar to String.substring(beginIndex, endIndex), but then with Tokens.
	 * <p>
	 * Will return <code>token</code> if the begin index is zero and the end
	 * index is equal to this token's length.
	 * <p>
	 * Will copy all tags to the new token.
	 * 
	 * @param token
	 *            The input token.
	 * @param beginIndex
	 *            Relative offset to start from.
	 * @param endIndex
	 *            Relative offset to end at (not inclusive).
	 * @return The requested subtoken.
	 */
	public static Token subtoken(final Token token, final int beginIndex,
			final int endIndex) {
		String text = token.getText();

		if (beginIndex == 0 && endIndex == text.length())
			return token;

		int begin = beginIndex;
		int end = endIndex;

		text = text.substring(begin, end);

		List<Range> ranges = new ArrayList<>();
		for (Range range : token.getRanges()) {
			if (end < 0) {
				// We have gone past the end index. Which means we're done.
				break;
			}

			int length = range.getLength();
			if (begin > length) {
				// We have not yet reached the start of the cut.
				begin -= length;
				end -= length;
				continue;
			}

			// At this point we know we're doing a cut.

			if (begin <= 0 && end >= length) {
				// The current range fits inside the cut.
				ranges.add(range);
				begin -= length;
				end -= length;
				continue;
			}

			// And now we know we need to cut the current range.

			Position start = range.getStart();
			Position stop = range.getEnd();

			if (begin > 0)
				start = range.getStart().offsetBy(begin);
			if (end < length)
				stop = range.getStart().offsetBy(end - 1);

			ranges.add(new Range(start, stop));
			begin -= length;
			end -= length;
		}

		assert (!ranges.isEmpty());

		final Token sub = new Token(text, ranges,
				token.getTags(), token.getReplaced());

		return sub;
	}

	/**
	 * Split a token into two.
	 * <p>
	 * In case the cut happens at the start or at the end then one of the tokens
	 * will be <code>null</code> and the other will be <code>token</code>.
	 * <p>
	 * Will copy all tags to the new token.
	 * 
	 * @param token
	 *            The input token.
	 * @param cutIndex
	 *            Relative offset to cut at. The first token will go up to this
	 *            position, but not include it. The second token will start at
	 *            this position.
	 * @return Two tokens which are a split version of the given one.
	 */
	public static Token[] split(Token token, int cutIndex) {
		if (cutIndex <= 0)
			return new Token[] { null, token };

		if (cutIndex >= token.getText().length())
			return new Token[] { token, null };

		return new Token[] { subtoken(token, 0, cutIndex),
				subtoken(token, cutIndex) };
	}

	/**
	 * Creates a new token which is equivalent to the composition of the given
	 * ones, except for their tags.
	 * <p>
	 * <b>The tags of the original tokens are not aggregated.</b> Instead you
	 * can specify whatever tags the new token should have as extra parameters.
	 * <p>
	 * The {@linkplain Range}s of the original tokens, however, do get
	 * aggregated into the new one.
	 */
	public static Token join(List<Token> tokens, Object... tags) {
		if (tokens.size() == 1)
			return tokens.get(0).withTags(tags);
		else
			return new Token(tokens, tags);
	}
}
