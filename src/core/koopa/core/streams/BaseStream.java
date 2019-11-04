package koopa.core.streams;

import static koopa.core.util.Iterators.emptyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;
import koopa.core.sources.Source;
import koopa.core.targets.HoldingTarget;
import koopa.core.targets.Target;

/**
 * This is not so much a stream, as a parse in progress. It holds on to all
 * {@linkplain Token}s it consumed from a {@linkplain Source}, and
 * {@linkplain Marker}s which were added by the grammar, until (that part of)
 * the parse has been completed. At that time it forwards the result to the
 * {@linkplain Target}.
 * <p>
 * When the parse is complete (either successfully or not) the
 * {@linkplain BaseStream} will no longer be holding on to any {@linkplain Data}
 * itself. In particular, any {@linkplain Token}s which were consumed but did
 * not match will have been returned to their {@linkplain Source}.
 */
public class BaseStream implements Stream {

	/**
	 * The stream fetches {@linkplain Token}s from this {@linkplain Source}.
	 */
	private final Source source;

	/**
	 * Everything the parser has processed, but which has not been committed yet
	 * in full.
	 * <p>
	 * This {@linkplain Target} is basically a buffer leading up to the real
	 * target, but for which we can control the release of its data, and even
	 * take data back.
	 */
	private final HoldingTarget pendingData;

	/**
	 * A list of {@linkplain Marker}s which are yet to be passed to the
	 * {@link #pendingData}.
	 */
	private final List<Marker> delayed;

	/**
	 * A list of all {@linkplain Bookmark} ever made for this
	 * {@linkplain BaseStream}. We want to recycle these as a lot of bookmarks
	 * will get set and rewound, causing the cost of instantiation to quickly
	 * add up.
	 */
	private final List<Bookmark> allBookmarks;

	/**
	 * This points into the {@link #allBookmarks} list, identifying the next
	 * {@linkplain Bookmark} to be used, or where to insert a new one.
	 */
	private int nextActiveBookmark;

	/**
	 * The {@linkplain Parse} this stream is part of.
	 */
	private Parse parse = null;

	public BaseStream(Source source, Target target) {
		assert (source != null);
		assert (target != null);

		this.source = source;

		this.pendingData = new HoldingTarget(target);

		this.delayed = new ArrayList<>();

		this.allBookmarks = new ArrayList<>();
		this.nextActiveBookmark = 0;
	}

	/** {@inheritDoc} */
	@Override
	public Data forward() {
		insertDelayedMarkers();

		while (true) {
			final Data d = source.next();

			if (d == null)
				return null;

			if (d instanceof Marker) {
				insert((Marker) d);
				continue;
			}

			pendingData.push(d);
			return d;
		}
	}

	/** {@inheritDoc} */
	@Override
	public Data skip() {
		while (true) {
			final Data d = source.next();

			if (d == null)
				return null;

			if (d instanceof Marker) {
				insert((Marker) d);
				continue;
			}

			if (d instanceof Token)
				((Token) d).setSkipped(true);

			pendingData.push(d);
			return d;
		}
	}

	/** {@inheritDoc} */
	@Override
	public void insert(Marker marker) {
		if (weShouldDelay(marker))
			delay(marker);

		else {
			insertDelayedMarkers();
			pendingData.push(marker);
		}
	}

	/**
	 * Should we delay a certain marker before inserting it into the
	 * {@linkplain #pendingData} list ? Delaying it makes it possible for
	 * "skipped" tokens to move in front of these markers.
	 * <p>
	 * Right now all {@linkplain Start} markers may be delayed. This way any
	 * skipped tokens which come right after a {@linkplain Start} marker end up
	 * before it, which means they won't become part of the subtree being
	 * marked.
	 */
	private boolean weShouldDelay(Marker marker) {
		return marker instanceof Start;
	}

	/**
	 * Delay the given marker.
	 * <p>
	 * It is assumed the given marker has passed the tests in
	 * {@linkplain #weShouldDelay(Marker)}.
	 */
	private void delay(Marker marker) {
		delayed.add(marker);
	}

	/**
	 * Add all delayed markers to the {@linkplain #pendingData} list.
	 */
	private void insertDelayedMarkers() {
		for (Marker marker : delayed)
			pendingData.push(marker);

		delayed.clear();
	}

	/** {@inheritDoc} */
	@Override
	public void rewind(Data data) {
		while (true) {
			final Data d = pendingData.pop();

			if (d == null)
				return;

			assert (!(d instanceof Marker));

			// TODO We're dropping everything up to the mentioned item. Ok ?
			if (d != data)
				continue;

			if (d instanceof Token)
				((Token) d).setSkipped(false);

			if (!(d instanceof Marker))
				source.unshift(d);

			break;
		}
	}

	/** {@inheritDoc} */
	@Override
	public Data peek() {
		final Data peeked = source.next();

		if (peeked != null)
			source.unshift(peeked);

		return peeked;
	}

	/** {@inheritDoc} */
	@Override
	public String peekMore() {
		final Data[] peeked = new Data[5];
		int p = 0;

		while (p < peeked.length) {
			peeked[p] = source.next();

			if (peeked[p] == null)
				break;

			p += 1;
		}

		if (p == 0)
			return "[EOF]";

		final StringBuilder builder = new StringBuilder();

		for (int i = 0; i < p; i++) {
			final Data d = peeked[i];

			if (d instanceof Token)
				builder.append(((Token) d).getText() //
						.replaceAll("\n", "\\\\n") //
						.replaceAll("\r", "\\\\r"));
			else
				builder.append(d.toString());
		}

		for (int i = p - 1; i >= 0; i--)
			source.unshift(peeked[i]);

		return builder.toString();
	}

	/** {@inheritDoc} */
	@Override
	public void bookmark() {
		pushBookmark();
	}

	/** {@inheritDoc} */
	@Override
	public void rewind() {
		if (hasActiveBookmarks()) {
			final Bookmark rewound = popBookmark();
			delayed.clear();
			delayed.addAll(rewound.markers);
			rewindTo(rewound.position);

		} else {
			delayed.clear();
			rewindTo(0);
		}
	}

	private void rewindTo(int position) {
		while (pendingData.size() > position) {
			final Data d = pendingData.pop();

			// Dropping all markers.
			if (d instanceof Marker)
				continue;

			if (d instanceof Token)
				((Token) d).setSkipped(false);

			source.unshift(d);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void commit() {
		if (hasActiveBookmarks())
			popBookmark();

		else {
			assert (delayed.isEmpty());
			pendingData.shiftAllToNextTarget();
		}
	}

	/** {@inheritDoc} */
	@Override
	public Parse getParse() {
		return parse;
	}

	/** {@inheritDoc} */
	@Override
	public void setParse(Parse parse) {
		this.parse = parse;
	}

	public HoldingTarget getTarget() {
		return pendingData;
	}

	/** {@inheritDoc} */
	@Override
	public Iterator<Data> backToBookmarkIterator() {
		if (!hasActiveBookmarks())
			return emptyIterator();

		final Bookmark bookmark = peekBookmark();
		final int numberOfDelayedMarkers = bookmark.markers == null ? 0
				: bookmark.markers.size();
		final int positionOfBookmark = bookmark.position
				+ numberOfDelayedMarkers;

		return new Iterator<Data>() {
			int currentPosition = pendingData.size();
			Iterator<Data> reverseIterator = null;

			@Override
			public boolean hasNext() {
				return currentPosition > positionOfBookmark;
			}

			@Override
			public Data next() {
				if (reverseIterator == null)
					reverseIterator = pendingData.descendingIterator();

				currentPosition -= 1;
				return reverseIterator.next();
			}

			@Override
			public void remove() {
				if (reverseIterator != null)
					reverseIterator.remove();
			}
		};
	}

	/** {@inheritDoc} */
	@Override
	public Iterator<Data> fromBookmarkIterator() {
		if (!hasActiveBookmarks())
			return emptyIterator();

		final Bookmark bookmark = peekBookmark();
		final int numberOfDelayedMarkers = bookmark.markers == null ? 0
				: bookmark.markers.size();
		final int positionOfBookmark = bookmark.position
				+ numberOfDelayedMarkers;

		return pendingData.listIterator(positionOfBookmark);
	}

	@Override
	public BaseStream getBaseStream() {
		return this;
	}

	// ========================================================================

	private boolean hasActiveBookmarks() {
		return nextActiveBookmark > 0;
	}

	private void pushBookmark() {
		final Bookmark bookmark;

		if (nextActiveBookmark < allBookmarks.size())
			bookmark = allBookmarks.get(nextActiveBookmark);

		else {
			bookmark = new Bookmark();
			allBookmarks.add(bookmark);
		}

		nextActiveBookmark += 1;

		bookmark.latchCurrentState();
	}

	private Bookmark popBookmark() {
		nextActiveBookmark -= 1;
		return allBookmarks.get(nextActiveBookmark);
	}

	private Bookmark peekBookmark() {
		return allBookmarks.get(nextActiveBookmark - 1);
	}

	private final class Bookmark {
		private int position = 0;
		private List<Marker> markers = new ArrayList<>();

		public void latchCurrentState() {
			position = pendingData.size();
			markers.clear();
			markers.addAll(delayed);
		}

		@Override
		public String toString() {
			return "{ pos: " + position + " | markers: " + markers + "}";
		}
	}
}
