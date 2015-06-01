package koopa.core.parsers;

import koopa.core.data.Marker;
import koopa.core.data.Token;

import org.apache.log4j.Logger;

public class LimitedStream implements Stream {

	private static final Logger LOGGER = Logger.getLogger("parse.stream");

	private final Stream stream;
	private final ParserCombinator limiter;

	public LimitedStream(Stream stream, ParserCombinator limiter) {
		assert (stream != null);
		assert (limiter != null);

		this.stream = stream;
		this.limiter = limiter;
	}

	public Token forward() {
		stream.bookmark();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("%limited ?");

		// TODO This twiddling ain't great...
		Parse parse = stream.getParse();
		parse.setStream(stream);
		boolean hitLimit = limiter.accepts(parse);
		parse.setStream(this);

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

	public Parse getParse() {
		return stream.getParse();
	}

	public void setParse(Parse parse) {
		stream.setParse(parse);
	}
}
