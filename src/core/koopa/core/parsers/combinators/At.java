package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This checks whether the stream is in a position where we can expect to match
 * a given thing. It's basically a positive lookahead.
 */
public class At extends ParserCombinator {

	private final ParserCombinator parser;

	public At(ParserCombinator parser) {
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[at>");

		stream.bookmark();
		final boolean accepted = parser.accepts(parse);
		stream.rewind();

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<at]");

		return accepted;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "%at " + parser.toString();
	}
}