package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.LimitedStream;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class LimitedTo extends ParserCombinator {

	private final ParserCombinator target;
	private final ParserCombinator limiter;

	public LimitedTo(ParserCombinator target, ParserCombinator limiter) {
		this.target = target;
		this.limiter = limiter;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		try {
			LimitedStream limitedParseStream = new LimitedStream(stream,
					limiter);

			parse.setStream(limitedParseStream);
			// limitedParseStream.setParse(parse);

			return target.accepts(parse);

		} finally {
			parse.setStream(stream);
		}
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		target.addAllKeywordsInScopeTo(keywords);
		// Not: limiter.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		target.addAllLeadingKeywordsTo(keywords);
	}

	public boolean canMatchEmptyInputs() {
		return target.canMatchEmptyInputs();
	}

	public String toString() {
		return "%limit " + target + " %by " + limiter;
	}
}