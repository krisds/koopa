package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Not extends ParserCombinator {

	private final ParserCombinator parser;

	public Not(ParserCombinator parser) {
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[not>");

		stream.bookmark();
		final boolean accepted = parser.accepts(parse);
		stream.rewind();

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<not]");

		return !accepted;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "%not " + parser.toString();
	}
}