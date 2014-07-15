package koopa.tokenstreams;

import koopa.tokens.Token;

/**
 * A TokenStream forms the basic input for a grammar. It iterates over the input
 * in the form of {@linkplain Token}s, which are then consumed by the grammar
 * and collated into the final parse tree.
 */
public interface TokenStream {

	/**
	 * Quite obviously returns the next token in the stream. Or
	 * <code>null</code> when there are no more tokens to be had.
	 * 
	 * @return The next token in the stream.
	 */
	public Token nextToken();

	/**
	 * Add the given marker to the stream. Markers are used to annotate the
	 * token stream and define the structure of the parse tree.
	 * 
	 * @param marker
	 *            The marker to be added.
	 */
	public void mark(Marker marker);

	/**
	 * Add a token which was consumed earlier back into the stream. The tokens
	 * should be pushed back in reverse order from how they were originally
	 * generated.
	 * 
	 * @param token
	 *            The token to be returned to the stream.
	 */
	public void pushback(Token token);

	/**
	 * Restore up to the last commit point.
	 */
	public void restore();

	/**
	 * Clean out the history. This basically marks the point up to where you
	 * want the possibility of restoring the token stream.
	 */
	public void commit();
}
