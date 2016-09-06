package koopa.core.parsers.combinators;

import koopa.core.parsers.LimitedStream;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This {@linkplain ParserCombinator} will attempt to match a given
 * {@linkplain ParserCombinator}, while restricting the stream for that one to
 * never pass a positive match for a limiting {@linkplain ParserCombinator}.
 */
public class LimitedTo extends UnaryParserDecorator {

	private final ParserCombinator limiter;

	public LimitedTo(ParserCombinator target, ParserCombinator limiter) {
		super(target);
		this.limiter = limiter;
	}

	@Override
	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		try {
			LimitedStream limitedParseStream = new LimitedStream(stream,
					limiter);

			parse.setStream(limitedParseStream);
			// limitedParseStream.setParse(parse);

			return parser.accepts(parse);

		} finally {
			parse.setStream(stream);
		}
	}

	@Override
	public String toString() {
		return "%limit " + parser + " %by " + limiter;
	}
}