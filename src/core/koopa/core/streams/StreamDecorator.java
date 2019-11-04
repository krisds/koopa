package koopa.core.streams;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;

public abstract class StreamDecorator implements Stream {

	protected final Stream stream;

	public StreamDecorator(Stream stream) {
		assert (stream != null);

		this.stream = stream;
	}

	/** {@inheritDoc} */
	@Override
	public Data forward() {
		return stream.forward();
	}

	/** {@inheritDoc} */
	@Override
	public Data skip() {
		return stream.skip();
	}

	/** {@inheritDoc} */
	@Override
	public void insert(Marker marker) {
		stream.insert(marker);
	}

	/** {@inheritDoc} */
	@Override
	public void rewind(Data d) {
		stream.rewind(d);
	}

	/** {@inheritDoc} */
	@Override
	public Data peek() {
		return stream.peek();
	}

	/** {@inheritDoc} */
	@Override
	public String peekMore() {
		return stream.peekMore();
	}

	/** {@inheritDoc} */
	@Override
	public void bookmark() {
		stream.bookmark();
	}

	/** {@inheritDoc} */
	@Override
	public void rewind() {
		stream.rewind();
	}

	/** {@inheritDoc} */
	@Override
	public void commit() {
		stream.commit();
	}

	/** {@inheritDoc} */
	@Override
	public Parse getParse() {
		return stream.getParse();
	}

	/** {@inheritDoc} */
	@Override
	public void setParse(Parse parse) {
		stream.setParse(parse);
	}

	/** {@inheritDoc} */
	@Override
	public Iterator<Data> backToBookmarkIterator() {
		return stream.backToBookmarkIterator();
	}

	/** {@inheritDoc} */
	@Override
	public Iterator<Data> fromBookmarkIterator() {
		return stream.fromBookmarkIterator();
	}

	/** {@inheritDoc} */
	@Override
	public BaseStream getBaseStream() {
		return stream.getBaseStream();
	}
}
