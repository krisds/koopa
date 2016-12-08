package koopa.core.streams;

import static koopa.core.util.Iterators.emptyIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import org.apache.log4j.Logger;

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

	private static final Logger LOGGER = Logger.getLogger("parse.stream");
	private static final Logger DELAYED_LOGGER = Logger
			.getLogger("parse.stream.delayed");

	/**
	 * The stream fetches {@linkplain Token}s from this {@linkplain Source}.
	 */
	private final Source<Token> source;

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
	 * Markers which have been inserted, but not yet pushed to the
	 * {@link #pendingData}.
	 * <p>
	 * See {@link #weShouldDelay(Marker)} for more.
	 */
	private LinkedList<Marker> delayedMarkers;

	/**
	 * Bookmarks in the {@link #pendingData} list for easy {@link #commit()}-ing
	 * and {@link #rewind()}-ing.
	 */
	private final Stack<Bookmark> bookmarks;

	/**
	 * The {@linkplain Parse} this stream is part of.
	 */
	private Parse parse = null;

	public BaseStream(Source<Token> source, Target<Data> target) {
		assert (source != null);
		assert (target != null);

		this.source = source;

		this.pendingData = new HoldingTarget(target);
		this.delayedMarkers = new LinkedList<Marker>();

		this.bookmarks = new Stack<Bookmark>();
	}

	/** {@inheritDoc} */
	public Token forward() {
		return forwardOne(false);
	}

	/** {@inheritDoc} */
	public Token skip() {
		return forwardOne(true);
	}

	private Token forwardOne(boolean skipped) {
		if (!skipped)
			insertDelayedMarkers();

		while (true) {
			Data packet = source.next();

			if (packet == null)
				return null;

			if (packet instanceof Marker)
				insert((Marker) packet);
			else if (skipped && packet instanceof Token) {
				Token token = (Token) packet;
				token.setSkipped(true);
				pendingData.push(token);
			} else
				pendingData.push(packet);

			if (packet instanceof Token) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace(">> " + packet);

				return (Token) packet;
			}
		}
	}

	/** {@inheritDoc} */
	public void insert(Marker marker) {
		if (weShouldDelay(marker)) {
			delay(marker);

		} else {
			insertDelayedMarkers();
			pendingData.push(marker);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("+> " + marker);
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
		delayedMarkers.addLast(marker);

		if (DELAYED_LOGGER.isTraceEnabled())
			DELAYED_LOGGER.trace("Delaying " + marker + ". Now "
					+ delayedMarkers.size() + " in total.");
	}

	/**
	 * Add all delayed markers to the {@linkplain #pendingData} list.
	 */
	private void insertDelayedMarkers() {
		while (!delayedMarkers.isEmpty()) {
			Marker delayedMarker = delayedMarkers.removeFirst();
			pendingData.push(delayedMarker);

			if (DELAYED_LOGGER.isTraceEnabled())
				DELAYED_LOGGER.trace("Inserting delayed " + delayedMarker + ". "
						+ delayedMarkers.size() + " remaining.");
		}
	}

	/** {@inheritDoc} */
	public void rewind(Token token) {
		while (true) {
			Data packet = pendingData.pop();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("<< " + packet);

			if (!(packet instanceof Token))
				continue;

			assert (packet == token);

			Token rewound = (Token) packet;
			rewound.setSkipped(false);
			source.unshift(rewound);

			break;
		}
	}

	/** {@inheritDoc} */
	public Token peek() {
		Token peeked = source.next();

		if (peeked == null)
			return null;

		source.unshift(peeked);
		return peeked;
	}

	/** {@inheritDoc} */
	public String peekMore() {
		Token[] peeked = new Token[5];
		int p = 0;

		while (p < peeked.length) {
			peeked[p] = source.next();

			if (peeked[p] == null)
				break;

			p += 1;
		}

		if (p == 0)
			return "[EOF]";

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < p; i++) {
			if (i == 0)
				builder.append("[" + peeked[i].getStart() + "|");
			builder.append(//
					peeked[i].getText() //
							.replaceAll("\n", "\\\\n")//
							.replaceAll("\r", "\\\\r"));
		}

		builder.append("]");

		for (int i = p - 1; i >= 0; i--)
			source.unshift(peeked[i]);

		return builder.toString();
	}

	/** {@inheritDoc} */
	public void bookmark() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("!+ " + pendingData.size());

		bookmarks.push(new Bookmark(this));
	}

	/** {@inheritDoc} */
	public void rewind() {
		final int position;

		if (bookmarks.empty()) {
			position = 0;
			delayedMarkers.clear();

			if (DELAYED_LOGGER.isTraceEnabled())
				DELAYED_LOGGER
						.trace("Rewound delayed markers, without bookmarks.");

		} else {
			Bookmark bookmark = bookmarks.pop();
			position = bookmark.position;

			if (bookmark.delayedMarkers == null)
				delayedMarkers.clear();
			else
				delayedMarkers = bookmark.delayedMarkers;

			if (DELAYED_LOGGER.isTraceEnabled()) {
				DELAYED_LOGGER
						.trace("Rewound delayed markers, through bookmarks:");
				for (Marker marker : delayedMarkers)
					DELAYED_LOGGER.trace(" * " + marker);
			}
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("!- " + position);

		while (pendingData.size() > position) {
			Data packet = pendingData.pop();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("<< " + packet);

			if (!(packet instanceof Token))
				continue;

			Token rewound = (Token) packet;
			rewound.setSkipped(false);
			source.unshift(rewound);
		}
	}

	/** {@inheritDoc} */
	public void commit() {
		if (bookmarks.isEmpty()) {
			pendingData.shiftAllToNextTarget();

		} else {
			Bookmark bookmark = bookmarks.pop();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("!! " + bookmark.position);
		}
	}

	/** {@inheritDoc} */
	public Parse getParse() {
		return parse;
	}

	/** {@inheritDoc} */
	public void setParse(Parse parse) {
		this.parse = parse;
	}

	public HoldingTarget getTarget() {
		return pendingData;
	}

	/** {@inheritDoc} */
	public Iterator<Data> backToBookmarkIterator() {
		if (bookmarks.isEmpty())
			return emptyIterator();

		final Bookmark bookmark = bookmarks.peek();
		final int numberOfDelayedMarkers = bookmark.delayedMarkers == null ? 0
				: bookmark.delayedMarkers.size();
		final int positionOfBookmark = bookmark.position
				+ numberOfDelayedMarkers;

		return new Iterator<Data>() {
			int currentPosition = pendingData.size();
			Iterator<Data> reverseIterator = null;

			public boolean hasNext() {
				return currentPosition > positionOfBookmark;
			}

			public Data next() {
				if (reverseIterator == null)
					reverseIterator = pendingData.descendingIterator();

				currentPosition -= 1;
				return reverseIterator.next();
			}

			public void remove() {
				if (reverseIterator != null)
					reverseIterator.remove();
			}
		};
	}

	/** {@inheritDoc} */
	public Iterator<Data> fromBookmarkIterator() {
		if (bookmarks.isEmpty())
			return emptyIterator();

		final Bookmark bookmark = bookmarks.peek();
		final int numberOfDelayedMarkers = bookmark.delayedMarkers == null ? 0
				: bookmark.delayedMarkers.size();
		final int positionOfBookmark = bookmark.position
				+ numberOfDelayedMarkers;

		return pendingData.listIterator(positionOfBookmark);
	}

	public BaseStream getBaseStream() {
		return this;
	}

	private final class Bookmark {
		private final int position;
		private final LinkedList<Marker> delayedMarkers;

		public Bookmark(BaseStream stream) {
			position = stream.pendingData.size();

			if (stream.delayedMarkers.isEmpty())
				delayedMarkers = null;
			else
				delayedMarkers = new LinkedList<Marker>(stream.delayedMarkers);
		}
	}
}
