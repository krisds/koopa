package koopa.core.parsers;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.sources.Source;
import koopa.core.streams.BaseStream;
import koopa.core.targets.Target;

/**
 * This is not so much a stream, as a parse in progress. It holds on to all
 * {@linkplain Token}s it consumed from a {@linkplain Source}, and
 * {@linkplain Marker}s which were added by the grammar, until (that part of)
 * the parse has been completed. At that time it forwards the result to the
 * {@linkplain Target}.
 * <p>
 * When the parse is complete (either successfully or not) the
 * {@linkplain Stream} will no longer be holding on to any {@linkplain Data}
 * itself. In particular, any {@linkplain Token}s which were consumed but did
 * not match will have been returned to their {@linkplain Source}.
 */
public interface Stream {

	/**
	 * Get the next data in the stream.
	 * <p>
	 * This will force any delayed markers. Cfr. {@linkplain #insert(Marker)}.
	 */
	Data forward();

	/**
	 * Get the next data in the stream.
	 * <p>
	 * This will <b>not</b> force any delayed markers. Cfr.
	 * {@linkplain #insert(Marker)}.
	 */
	Data skip();

	/**
	 * This inserts a given marker at the current position. When the stream gets
	 * committed the marker will be sent along to the target. When the stream
	 * gets rollbacked the marker will be removed instead.
	 * <p>
	 * Certain markers may get "delayed". This means they don't get pushed to
	 * the target until something else comes along which forces it to.
	 * <p>
	 * Right now all {@linkplain Start} markers may be delayed. This way any
	 * skipped tokens which come right after a {@linkplain Start} marker end up
	 * before it, which means they won't become part of the subtree being
	 * marked.
	 */
	void insert(Marker marker);

	/**
	 * Move the stream back towards where we're just about to see this token.
	 * <p>
	 * We expect data to be rewound in the order in which they were given.
	 */
	void rewind(Data d);

	/**
	 * Get a look at the next upcoming {@linkplain Data} without it actually
	 * getting consumed.
	 */
	Data peek();

	/**
	 * This is for tracing purposes. Gives a textual representation of up to
	 * five upcoming tokens.
	 */
	String peekMore();

	/**
	 * Bookmark the current position in the stream. This will impact the
	 * behaviour of {@linkplain BaseStream#rewind()} and
	 * {@linkplain BaseStream#commit()}.
	 */
	void bookmark();

	/**
	 * Moves the stream back towards the last bookmark, or to the last commit.
	 * <p>
	 * Anything that's not a {@linkplain Token} will get removed again.
	 */
	void rewind();

	/**
	 * Commit all {@linkplain Data}s the latest bookmark (in effect removing
	 * it). You won't be able to rewind beyond this point again.
	 * <p>
	 * If there was no bookmark then this will commit the entire stream so far,
	 * which means pushing all tokens to that given {@linkplain Target}.
	 */
	void commit();

	/**
	 * The currently active {@linkplain Parse}.
	 */
	Parse getParse();

	/**
	 * Set the active {@linkplain Parse}.
	 */
	void setParse(Parse parse);

	/**
	 * Get an iterator which walks the stream in reverse up to the latest
	 * bookmark.
	 */
	Iterator<Data> backToBookmarkIterator();

	/**
	 * Get an iterator which walks the stream from the latest bookmark.
	 */
	Iterator<Data> fromBookmarkIterator();

	/**
	 * What {@linkplain Stream} is at the root of this one ?
	 */
	BaseStream getBaseStream();
}
