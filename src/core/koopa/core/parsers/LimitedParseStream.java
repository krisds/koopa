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

	@Override
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

	@Override
	public void insert(Marker marker) {
		stream.insert(marker);
	}

	@Override
	public void rewind(Token token) {
		stream.rewind(token);
	}

	@Override
	public Token peek() {
		return stream.peek();
	}

	@Override
	public String peekMore() {
		return stream.peekMore();
	}

	@Override
	public void bookmark() {
		stream.bookmark();
	}

	@Override
	public void rewind() {
		stream.rewind();
	}

	@Override
	public void commit() {
		stream.commit();
	}
}
