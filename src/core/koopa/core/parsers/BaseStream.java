package koopa.core.parsers;

import static koopa.core.util.Iterators.descendingIterator;
import static koopa.core.util.Iterators.emptyIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.sources.Source;
import koopa.core.targets.Target;

import org.apache.log4j.Logger;

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

	private final Source<Token> source;
	private final Target<Data> target;

	// Tokens this list are always in reading order.
	private final LinkedList<Data> seen;

	// Markers which are waiting to get pushed.
	private LinkedList<Marker> delayedMarkers;

	// Bookmarks govern rewind/commit semantics.
	private final Stack<Bookmark> bookmarks;

	// The active parse.
	private Parse parse = null;

	public BaseStream(Source<Token> source, Target<Data> target) {
		assert (source != null);
		assert (target != null);

		this.source = source;
		this.target = target;

		this.seen = new LinkedList<Data>();
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
			else
				seen.addLast(packet);

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
			seen.addLast(marker);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("+> " + marker);
		}
	}

	/**
	 * Should we delay a certain marker before inserting it into the
	 * {@linkplain #seen} list ? Delaying it makes it possible for "skipped"
	 * tokens to move in front of these markers.
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
	}

	/**
	 * Add all delayed markers to the {@linkplain #seen} list.
	 */
	private void insertDelayedMarkers() {
		while (!delayedMarkers.isEmpty()) {
			Marker delayedMarker = delayedMarkers.removeFirst();
			seen.addLast(delayedMarker);

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("+D " + delayedMarker);
		}
	}

	/** {@inheritDoc} */
	public void rewind(Token token) {
		while (true) {
			Data packet = seen.removeLast();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("<< " + packet);

			if (!(packet instanceof Token))
				continue;

			assert (packet == token);

			source.unshift((Token) packet);
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
			LOGGER.trace("!+ " + seen.size());

		bookmarks.push(new Bookmark(this));
	}

	/** {@inheritDoc} */
	public void rewind() {
		final int position;

		if (bookmarks.empty()) {
			position = 0;
			delayedMarkers.clear();

		} else {
			Bookmark bookmark = bookmarks.pop();
			position = bookmark.position;

			if (bookmark.delayedMarkers == null)
				delayedMarkers.clear();
			else
				delayedMarkers = bookmark.delayedMarkers;
		}

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("!- " + position);

		while (seen.size() > position) {
			Data packet = seen.removeLast();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("<< " + packet);

			if (!(packet instanceof Token))
				continue;

			// unseen.addFirst((Token) packet);
			source.unshift((Token) packet);
		}
	}

	/** {@inheritDoc} */
	public void commit() {
		if (bookmarks.isEmpty()) {
			while (!seen.isEmpty()) {
				final Data data = seen.removeFirst();

				if (LOGGER.isTraceEnabled())
					LOGGER.trace("!< " + data);

				target.push(data);
			}

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
			int currentPosition = seen.size();
			Iterator<Data> reverseIterator = null;

			public boolean hasNext() {
				return currentPosition > positionOfBookmark;
			}

			public Data next() {
				if (reverseIterator == null)
					reverseIterator = descendingIterator(seen);

				currentPosition -= 1;
				return reverseIterator.next();
			}

			public void remove() {
				if (reverseIterator != null)
					reverseIterator.remove();
			}
		};
	}

	private final class Bookmark {
		private final int position;
		private final LinkedList<Marker> delayedMarkers;

		public Bookmark(BaseStream stream) {
			position = stream.seen.size();

			if (stream.delayedMarkers.isEmpty())
				delayedMarkers = null;
			else
				delayedMarkers = new LinkedList<Marker>(stream.delayedMarkers);
		}
	}
}
