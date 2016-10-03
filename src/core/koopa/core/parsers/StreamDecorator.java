package koopa.core.parsers;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;

public abstract class StreamDecorator implements Stream {

	protected final Stream stream;

	public StreamDecorator(Stream stream) {
		assert (stream != null);

		this.stream = stream;
	}

	/** {@inheritDoc} */
	public Token forward() {
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

	/** {@inheritDoc} */
	public BaseStream getBaseStream() {
		return stream.getBaseStream();
	}
}
