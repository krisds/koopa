package koopa.core.parsers;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;

import org.apache.log4j.Logger;

/**
 * This stream will only return tokens from another stream up to a certain
 * point, as defined by a {@linkplain ParserCombinator}.
 */
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

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
	public Token skip() {
		return stream.skip();
	}

	/** {@inheritDoc} */
	public void insert(Marker marker) {
		stream.insert(marker);
	}

	/** {@inheritDoc} */
	public void rewind(Token token) {
		stream.rewind(token);
	}

	/** {@inheritDoc} */
	public Token peek() {
		return stream.peek();
	}

	/** {@inheritDoc} */
	public String peekMore() {
		return stream.peekMore();
	}

	/** {@inheritDoc} */
	public void bookmark() {
		stream.bookmark();
	}

	/** {@inheritDoc} */
	public void rewind() {
		stream.rewind();
	}

	/** {@inheritDoc} */
	public void commit() {
		stream.commit();
	}

	/** {@inheritDoc} */
	public Parse getParse() {
		return stream.getParse();
	}

	/** {@inheritDoc} */
	public void setParse(Parse parse) {
		stream.setParse(parse);
	}

	/** {@inheritDoc} */
	public Iterator<Data> backToBookmarkIterator() {
		return stream.backToBookmarkIterator();
	}

	/** {@inheritDoc} */
	public Iterator<Data> fromBookmarkIterator() {
		return stream.fromBookmarkIterator();
	}
}
