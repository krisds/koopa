package koopa.core.data;

public final class Tokens {

	private Tokens() {
	}

	/**
	 * Similar to String.substring(beginIndex), but then with Tokens.
	 * <p>
	 * Will return <code>token</code> if the begin index is zero.
	 * <p>
	 * Will copy all tags to the new token.
	 * 
	 * @param token
	 *            The input token.
	 * @param beginIndex
	 *            Relative offset to start from.
	 * @return The requested subtoken.
	 */
	public static Token subtoken(Token token, int beginIndex) {
		if (beginIndex == 0)
			return token;

		String text = token.getText();
		Position start = token.getStart();
		Position end = token.getEnd();

		final Token sub = new Token(text.substring(beginIndex),
				start.offsetBy(beginIndex), end, token.getTags());

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
	public static Token subtoken(Token token, int beginIndex, int endIndex) {
		String text = token.getText();

		if (beginIndex == 0 && endIndex == text.length())
			return token;

		Position start = token.getStart();

		final Token sub = new Token(text.substring(beginIndex, endIndex),
				start.offsetBy(beginIndex), start.offsetBy(endIndex - 1),
				token.getTags());

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
}
