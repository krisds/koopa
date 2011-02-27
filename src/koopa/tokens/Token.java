package koopa.tokens;

import java.util.Set;

public interface Token {

	/**
	 * May return null for "virtual" tokens.
	 */
	String getText();

	/**
	 * May return null for "virtual" tokens.
	 */
	Position getStart();

	/**
	 * May return null for "virtual" tokens.
	 */
	Position getEnd();

	void addTag(Object tag);

	boolean hasTag(Object tag);

	int getLength();

	void removeTag(Object tag);

	Set<Object> getTags();

	void setStart(Position start);

	void setEnd(Position end);

	int tagCount();

	/**
	 * Similar to String.substring(beginIndex), but then with Tokens.
	 * <p>
	 * Will return <code>this</code> if the begin index is zero.
	 * <p>
	 * Will copy all tags to the new token.
	 * 
	 * @param beginIndex
	 *            Relative offset to start from.
	 * @return The requested subtoken..
	 */
	Token subtoken(int beginIndex);

	/**
	 * Similar to String.substring(beginIndex, endIndex), but then with Tokens.
	 * <p>
	 * Will return <code>this</code> if the begin index is zero and the end
	 * index is equal to this token's length.
	 * <p>
	 * Will copy all tags to the new token.
	 * 
	 * @param beginIndex
	 *            Relative offset to start from.
	 * @param endIndex
	 *            Relative offset to end at (not inclusive).
	 * @return The requested subtoken.
	 */
	Token subtoken(int beginIndex, int endIndex);

	/**
	 * Split this token into two.
	 * <p>
	 * In case the cut happens at the start or at the end then one of the tokens
	 * will be <code>null</code> and the other will be <code>this</code>.
	 * <p>
	 * Will copy all tags to the new token.
	 * 
	 * @param cutIndex
	 *            Relative offset to cut at. The first token will go up to this
	 *            position, but not include it. The second token will start at
	 *            this position.
	 * @return Two tokens which are a split version of this one.
	 */
	Token[] split(int cutIndex);
}