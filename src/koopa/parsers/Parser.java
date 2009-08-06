package koopa.parsers;

import koopa.tokenizers.Tokenizer;
import koopa.tokenstreams.TokenSink;
import koopa.tokenstreams.TokenStream;
import koopa.tokenstreams.generic.MainTokenStream;

public abstract class Parser {
	public final boolean accepts(Tokenizer tokenizer) {
		return accepts(tokenizer, null);
	}

	public final boolean accepts(Tokenizer tokenizer, TokenSink sink) {
		MainTokenStream stream = new MainTokenStream(tokenizer);
		stream.setTokenSink(sink);
		boolean accepted = accepts(stream);
		stream.commit();
		return accepted;
	}

	protected abstract boolean accepts(TokenStream stream);
}
