package koopa.tokenstreams.generic;

import java.util.Stack;

import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.tokenstreams.TokenStream;


public class SubordinateTokenStream implements TokenStream {

	private TokenStream parentStream = null;

	private Stack<Token> tokens = new Stack<Token>();

	public SubordinateTokenStream(TokenStream parentStream) {
		assert (parentStream != null);
		this.parentStream = parentStream;
	}

	public void commit() {
		// DON'T DO THIS: this.parentStream.commit();
		this.tokens.clear();
	}

	public void mark(Marker marker) {
		this.parentStream.mark(marker);
		this.tokens.add(marker);
	}

	public Token nextToken() {
		Token t = this.parentStream.nextToken();

		if (t != null) {
			this.tokens.add(t);
		}

		return t;
	}

	public void pushback(Token token) {
		assert (this.tokens.peek() == token);
		this.parentStream.pushback(token);
		this.tokens.pop();
	}

	public void restore() {
		while (!tokens.isEmpty()) {
			this.parentStream.pushback(this.tokens.pop());
		}
	}
}
