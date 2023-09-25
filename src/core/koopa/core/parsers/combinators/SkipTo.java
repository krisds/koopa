package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.grammars.combinators.MatchEndOfFile;
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

	public SkipTo(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + " ?");

		boolean inWater = false;

		stream.bookmark();
		while (!parser.accepts(parse)) {
			stream.rewind();

			if (!inWater) {
				stream.insert(InWater.getInstance());
				inWater = true;
			}

			final Data skipped = stream.forward();

			if (skipped == null) {
				if (parser instanceof MatchEndOfFile) {
					stream.bookmark();
					break;
				}

				if (parse.getTrace().isEnabled())
					parse.getTrace().dedent(toString() + " : no");

				return false;
			}

			if (parse.getTrace().isEnabled())
				parse.getTrace().add("skipped " + skipped);

			stream.bookmark();
		}

		stream.rewind();

		if (inWater)
			stream.insert(OnLand.getInstance());

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(toString() + " : yes");

		return true;
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	@Override
	public boolean allowsLookahead() {
		return false;
	}

	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return "--> " + parser.toString();
	}
}