package koopa.core.parsers;

import org.apache.log4j.Logger;

import koopa.core.data.Marker;
import koopa.core.data.Token;

public class LimitedParseStream implements ParseStream {

	private static final Logger LOGGER = Logger.getLogger("parse.stream");

	private final ParseStream stream;
	private final Parser limiter;

	public LimitedParseStream(ParseStream stream, Parser limiter) {
		assert (stream != null);
		assert (limiter != null);

		this.stream = stream;
		this.limiter = limiter;
	}

	public Token forward() {
		stream.bookmark();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("%limited ?");

		boolean hitLimit = limiter.accepts(stream);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("%limited ? " + hitLimit);

		stream.rewind();

		if (hitLimit)
			return null;
		else
			return stream.forward();
	}

	public void insert(Marker marker) {
		stream.insert(marker);
	}

	public void rewind(Token token) {
		stream.rewind(token);
	}

	public Token peek() {
		return stream.peek();
	}

	public String peekMore() {
		return stream.peekMore();
	}

	public void bookmark() {
		stream.bookmark();
	}

	public void rewind() {
		stream.rewind();
	}

	public void commit() {
		stream.commit();
	}

	public ParseStack getStack() {
		return stream.getStack();
	}
}
