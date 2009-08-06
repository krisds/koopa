package koopa.tokenstreams;

import koopa.tokens.Token;

public interface TokenStream {

	public Token nextToken();

	public void mark(Marker marker);

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
