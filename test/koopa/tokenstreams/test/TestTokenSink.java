package koopa.tokenstreams.test;

import java.util.List;

import junit.framework.Assert;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenSink;


public class TestTokenSink implements TokenSink {

	private int count = 0;

	private TokenSink next = null;

	public void addAll(List<Token> tokens) {
		Assert.assertNotNull(tokens);
		this.count += tokens.size();

		if (this.next != null) {
			this.next.addAll(tokens);
		}
	}

	public int getCount() {
		return this.count;
	}

	public void setNextSink(TokenSink next) {
		this.next = next;
	}
}
