package koopa.core.parsers;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;

/**
 * This stream will only return tokens from another stream up to a certain
 * point, as defined by a {@linkplain ParserCombinator}.
 */
public class LimitedStream implements Stream {

	private final Stream stream;
	private final ParserCombinator limiter;

	/** We keep track of where the last limiter test ran. */
	private Token lastTestAtToken = null;
	/** So that we can reuse the result from the last test. */
	private boolean lastTestHitLimit = false;

	public LimitedStream(Stream stream, ParserCombinator limiter) {
		assert (stream != null);
		assert (limiter != null);

		this.stream = stream;
		this.limiter = limiter;
	}

	/** {@inheritDoc} */
	public Token forward() {
		final Parse parse = stream.getParse();

		// Let's check if we have been here before. If so we can reuse the
		// result from last time.
		final Token peek = stream.peek();
		if (peek == lastTestAtToken) {
			if (lastTestHitLimit) {
				if (parse.getTrace().isEnabled())
					parse.getTrace().add("%limited : yes (memoized)");

				return null;

			} else {
				if (parse.getTrace().isEnabled())
					parse.getTrace().add("%limited : no (memoized)");

				return stream.forward();
			}
		}

		stream.bookmark();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("%limited ?");

		// TODO This twiddling ain't great...
		parse.setStream(stream);
		boolean hitLimit = limiter.accepts(parse);
		parse.setStream(this);

		lastTestAtToken = peek;
		lastTestHitLimit = hitLimit;

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("%limited : " + (hitLimit ? "yes" : "no"));

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
		bookmark();
		final Token t = forward();
		rewind();

		return t;
	}

	/** {@inheritDoc} */
	// TODO This doesn't respect the limiter.
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
