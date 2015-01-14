package koopa.core.parsers;

import java.util.LinkedList;
import java.util.Stack;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import koopa.core.data.Marker;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.targets.Target;

/**
 * This is not so much a stream, as a parse in progress. It holds on to all
 * {@linkplain Token}s it consumed from a {@linkplain Source}, and
 * {@linkplain Marker}s which were added by the grammar, until (that part of)
 * the parse has been completed. At that time it forwards the result to the
 * {@linkplain Target}.
 * <p>
 * When the parse is complete (either successfully or not) the
 * {@linkplain ParseStream} will no longer be holding on to any
 * {@linkplain Data} itself. In particular, any {@linkplain Token}s which were
 * consumed but did not match will have been returned to their
 * {@linkplain Source}.
 */
public class ParseStream {

	private static final Logger LOGGER = Logger.getLogger("parse.stream");

	private final Source<Token> source;
	private final Target<Data> target;

	// Tokens in either of these lists are always in reading order.
	private final LinkedList<Data> seen;

	// Bookmarks govern rewind/commit semantics.
	private final Stack<Integer> bookmarks;

	public ParseStream(Source<Token> source, Target<Data> target) {
		assert (source != null);
		assert (target != null);

		this.source = source;
		this.target = target;

		this.seen = new LinkedList<Data>();

		this.bookmarks = new Stack<Integer>();
	}

	/**
	 * Get the next token in the stream.
	 */
	public Token forward() {
		while (true) {
			Data packet = source.next();

			if (packet == null)
				return null;

			seen.addLast(packet);

			if (packet instanceof Token) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace(">> " + packet);

				return (Token) packet;
			}
		}
	}

	/**
	 * This inserts a given marker at the current position. When the stream gets
	 * committed the marker will be sent along to the target. When the stream
	 * gets rollbacked the marker will be removed instead.
	 */
	public void insert(Marker marker) {
		seen.addLast(marker);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("+> " + marker);
	}

	/**
	 * Move the stream back towards where we're just about to see this token.
	 * <p>
	 * We expect tokens to be rewound in the order in which they were given.
	 */
	public void rewind(Token token) {
		while (true) {
			Data packet = seen.removeLast();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("<< " + packet);

			if (!(packet instanceof Token))
				continue;

			assert (packet == token);

			// unseen.addFirst((Token) packet);
			source.unshift((Token) packet);
			break;
		}
	}

	/**
	 * Basically a {@linkplain #forward()}, followed by an immediate
	 * {@linkplain #rewind(Token)}.
	 */
	public Token peek() {
		Level level = LOGGER.getLevel();
		LOGGER.setLevel(Level.FATAL);

		Token t = forward();
		if (t != null)
			rewind(t);

		LOGGER.setLevel(level);
		return t;
	}

	/**
	 * This is for tracing purposes. Gives up to five tokens worth of text.
	 */
	public String peekMore() {
		Level level = LOGGER.getLevel();
		LOGGER.setLevel(Level.FATAL);

		bookmark();

		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			Token t = forward();
			if (t == null)
				break;
		
			builder.append("[");
			builder.append(t.getText());
			builder.append("]");
		}

		rewind();

		LOGGER.setLevel(level);
		return builder.toString();
	}

	/**
	 * Bookmark the current position in the stream. This will impact the
	 * behaviour of {@linkplain ParseStream#rewind()} and
	 * {@linkplain ParseStream#commit()}.
	 */
	public void bookmark() {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("!+ " + seen.size());

		bookmarks.push(seen.size());
	}

	/**
	 * Moves the stream back towards the last bookmark, or to the last commit.
	 * <p>
	 * Anything that's not a {@linkplain Token} will get removed again.
	 */
	public void rewind() {
		int bookmark = bookmarks.empty() ? 0 : bookmarks.pop();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("!- " + bookmark);

		while (seen.size() > bookmark) {
			Data packet = seen.removeLast();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("<< " + packet);

			if (!(packet instanceof Token))
				continue;

			// unseen.addFirst((Token) packet);
			source.unshift((Token) packet);
		}
	}

	/**
	 * Commit all {@linkplain Data}s the latest bookmark (in effect removing
	 * it). You won't be able to rewind beyond this point again.
	 * <p>
	 * If there was no bookmark then this will committing the entire stream so
	 * far, which means pushing all tokens to that given {@linkplain Target}.
	 */
	public void commit() {
		if (bookmarks.isEmpty()) {
			while (!seen.isEmpty()) {
				final Data data = seen.removeFirst();

				if (LOGGER.isTraceEnabled())
					LOGGER.trace("!< " + data);

				target.push(data);
			}

		} else {
			int bookmark = bookmarks.pop();

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("!! " + bookmark);
		}
	}
}
