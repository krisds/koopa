package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Optional extends ParserCombinator {

	private final ParserCombinator parser;

	public Optional(ParserCombinator parser) {
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[optional>");

		stream.bookmark();

		boolean accepts = parser.accepts(parse);
		if (accepts) {
			stream.commit();

		} else {
			stream.rewind();
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<optional]: " + accepts);

		return true;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "[...]";
	}
}