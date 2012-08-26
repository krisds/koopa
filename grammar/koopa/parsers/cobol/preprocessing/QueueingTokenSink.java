package koopa.parsers.cobol.preprocessing;

import java.util.LinkedList;
import java.util.List;

import koopa.tokens.Token;
import koopa.tokenstreams.TokenSink;

public class QueueingTokenSink implements TokenSink {

	private LinkedList<Token> tokens = null;

	public QueueingTokenSink() {
		this.tokens = new LinkedList<Token>();
	}

	public void addAll(List<Token> tokens) {
		// System.out.println("++++ " + tokens);
		synchronized (this.tokens) {
			this.tokens.addAll(tokens);
		}
	}

	public void setNextSink(TokenSink next) {
		// System.out.println("SINK NXT " + next);
		throw new UnsupportedOperationException();
	}

	public Token nextToken() {
		synchronized (this.tokens) {
			if (this.tokens.isEmpty()) {
				// System.out.println("---- EMPTY");
				return null;
			} else {
				Token head = this.tokens.removeFirst();
				// System.out.println("---- " + head);
				return head;
			}
		}
	}
}
