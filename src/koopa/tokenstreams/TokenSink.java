package koopa.tokenstreams;

import java.util.List;

import koopa.tokens.Token;


public interface TokenSink {

	public void addAll(List<Token> tokens);

	public void setNextSink(TokenSink next);
}
