package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This {@linkplain ParserCombinator} consumes tokens until it has reached a
 * certain point in the stream, as identified by a given
 * {@linkplain ParserCombinator}. The match for the limiting parser will be
 * rollbacked, so that from a point of view of the grammar you'll be a the point
 * where the limiting parser will match.
 * <p>
 * The tokens which were skipped will be wrapped with {@linkplain InWater} and
 * {@linkplain OnLand} markers.
 */
public class SkipTo extends UnaryParserDecorator {

	private static final String SYMBOL = "--> ...";

	public SkipTo(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		boolean inWater = false;

		stream.bookmark();
		while (!parser.accepts(parse)) {
			stream.rewind();

			if (!inWater) {
				stream.insert(InWater.getInstance());
				inWater = true;
			}

			final Token skipped = stream.forward();

			if (skipped == null) {
				if (parse.getTrace().isEnabled())
					parse.getTrace().dedent(SYMBOL + " : no");

				return false;
			}

			stream.bookmark();
		}

		stream.rewind();

		if (inWater)
			stream.insert(OnLand.getInstance());

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : yes");

		return true;
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
	}

	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}