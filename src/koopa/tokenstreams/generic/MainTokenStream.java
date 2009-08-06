package koopa.tokenstreams.generic;

import java.util.LinkedList;

import koopa.tokenizers.PushbackTokenizer;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.generic.BasicPushbackTokenizer;
import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.tokenstreams.TokenSink;
import koopa.tokenstreams.TokenStream;


public class MainTokenStream implements TokenStream {

	private LinkedList<Token> seen = new LinkedList<Token>();

	private PushbackTokenizer tokenizer = null;

	private TokenSink sink = null;

	public MainTokenStream(Tokenizer tokenizer) {
		assert (tokenizer != null);
		if (tokenizer instanceof PushbackTokenizer) {
			this.tokenizer = (PushbackTokenizer) tokenizer;

		} else {
			this.tokenizer = new BasicPushbackTokenizer(tokenizer);
		}
	}

	public Token nextToken() {
		Token t = this.tokenizer.nextToken();

		if (t != null) {
			this.seen.add(t);
		}

		return t;
	}

	public void pushback(Token token) {
		assert (this.seen.getLast() == token);
		this.seen.removeLast();
		if (!(token instanceof Marker)) {
			this.tokenizer.pushback(token);
		}
	}

	public void commit() {
		if (this.sink != null) {
			this.sink.addAll(this.seen);
		}

		this.seen.clear();
	}

	public void mark(Marker marker) {
		this.seen.add(marker);
	}

	public void restore() {
		while (!this.seen.isEmpty()) {
			pushback(this.seen.getLast());
		}
	}

	public void setTokenSink(TokenSink sink) {
		this.sink = sink;
	}
}
