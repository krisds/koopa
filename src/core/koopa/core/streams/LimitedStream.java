package koopa.core.streams;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import koopa.core.data.Data;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This stream will only return tokens from its parent stream up to a certain
 * point, as defined by its {@link #limiters}.
 */
public class LimitedStream extends StreamDecorator implements Stream {

	/**
	 * The matching of limiters can introduce a lot of noise in the logging, so
	 * I disable it by default. Toggle this to get the output.
	 */
	private final static boolean SILENCE = true;

	/**
	 * Limiters are additive. Whenever any limiter matches the
	 * {@link #forward()} method should return <code>null</code>.
	 */
	private Map<ParserCombinator, Integer> limiters = new LinkedHashMap<>();

	/**
	 * This lists the limiters in the order or Most-Recently-Used. This is the
	 * order in which they will be matched.
	 */
	private LinkedList<ParserCombinator> mru = new LinkedList<>();

	public LimitedStream(Stream stream) {
		super(stream);
	}

	public void addLimiter(ParserCombinator limiter) {
		final int count;
		if (limiters.containsKey(limiter))
			count = limiters.get(limiter);
		else
			count = 0;

		limiters.put(limiter, count + 1);
		if (count == 0)
			mru.addFirst(limiter);
	}

	public void removeLimiter(ParserCombinator limiter) {
		final int count = limiters.get(limiter) - 1;
		assert (count >= 0);
		if (count > 0)
			limiters.put(limiter, count);
		else {
			limiters.remove(limiter);
			mru.remove(limiter);
		}
	}

	public boolean hasLimiters() {
		return !limiters.isEmpty();
	}

	/** {@inheritDoc} */
	@Override
	public Data forward() {
		return forward(false);
	}

	public Data forward(boolean skip) {
		if (limiters.isEmpty())
			return skip ? stream.skip() : stream.forward();

		if (SILENCE)
			stream.getParse().getTrace().silence(true);

		final boolean atLimit = streamIsAtALimiter();

		if (SILENCE)
			stream.getParse().getTrace().silence(false);

		if (atLimit)
			return null;
		else
			return skip ? stream.skip() : stream.forward();
	}

	private boolean streamIsAtALimiter() {
		final Parse parse = getParse();

		// TODO Ignore skippables ?

		// Limits should not apply to limiters themselves.
		parse.getFlow().setLimitsEnabled(false);

		boolean atLimit = false;

		final Iterator<ParserCombinator> it = mru.iterator();
		while (it.hasNext()) {
			final ParserCombinator limiter = it.next();

			if (limitsStream(parse, limiter)) {
				atLimit = true;
				it.remove();
				mru.addFirst(limiter);
				break;
			}
		}

		// Here we restore the original stream.
		parse.getFlow().setLimitsEnabled(true);

		return atLimit;
	}

	private boolean limitsStream(Parse parse, ParserCombinator limiter) {
		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("%limited ?");

		// We can assume that the parse is using our parent stream. See
		// forwardUpToLimiter.

		stream.bookmark();
		final boolean hitLimit = limiter.accepts(parse);
		stream.rewind();

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("%limited : " + (hitLimit ? "yes" : "no"));

		return hitLimit;
	}

	/** {@inheritDoc} */
	@Override
	public Data peek() {
		bookmark();
		final Data d = forward(true);
		rewind();
		return d;
	}

	/** {@inheritDoc} */
	// TODO This doesn't respect the limiter. OK or not ?
	@Override
	public String peekMore() {
		return super.peekMore();
	}
}
