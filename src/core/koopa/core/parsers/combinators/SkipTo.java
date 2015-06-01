package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class SkipTo extends ParserCombinator {

	private final ParserCombinator parser;

	public SkipTo(ParserCombinator parser) {
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();
		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[skipto>");

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
					parse.getTrace().dedent("<skipto]: no");

				return false;
			}

			stream.bookmark();
		}

		stream.rewind();

		if (inWater)
			stream.insert(OnLand.getInstance());

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<skipto]: yes");

		return true;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "--> ...";
	}
}