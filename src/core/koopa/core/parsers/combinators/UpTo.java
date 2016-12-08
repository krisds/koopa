package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;
import koopa.core.streams.LimitedStream;

/**
 * This {@linkplain ParserCombinator} will attempt to match a given
 * {@linkplain ParserCombinator}, while restricting the stream for that one to
 * never pass a positive match for a limiting {@linkplain ParserCombinator}. The
 * overall match will only succeed if the given parser matches, and we have hit
 * the limiter at that point.
 * <p>
 * The limited will be put inside a {@linkplain Closure} when this parser starts
 * matching.
 */
// TODO Extract common base class with LimitedTo ?
public class UpTo extends UnaryParserDecorator {

	private final ParserCombinator limiter;

	public UpTo(ParserCombinator target, ParserCombinator limiter) {
		super(target);
		this.limiter = limiter;
	}

	@Override
	public boolean matches(Parse parse) {
		final LimitedStream limitedStream = parse.getFlow()
				.getLimitedStream();

		// TODO Only create closure when really needed.
		final Closure closedLimiter = new Closure(limiter, parse);

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + " ?");

		limitedStream.addLimiter(closedLimiter);

		final boolean accepts = parser.accepts(parse);

		limitedStream.removeLimiter(closedLimiter);

		if (!accepts) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no, no match");

			return false;
		}

		final Stream stream = parse.getStream();

		if (stream.peek() == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : yes, at end");

			return true;
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + ", at limit ?");

		stream.bookmark();
		final boolean atLimiter = limiter.accepts(parse);
		stream.rewind();

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(
					toString() + ", at limit : " + (atLimiter ? "yes" : "no"));

		if (parse.getTrace().isEnabled())
			parse.getTrace()
					.dedent(toString() + " : " + (atLimiter ? "yes" : "no"));

		return atLimiter;
	}

	@Override
	public String toString() {
		return "%match (" + parser.toString() + ") %upto ...";
	}
}