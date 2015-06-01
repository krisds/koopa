package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Star extends ParserCombinator {

	private final ParserCombinator parser;

	public Star(ParserCombinator parser) {
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[star>");

		while (true) {
			stream.bookmark();

			if (!parser.accepts(parse)) {
				stream.rewind();
				break;
			}

			stream.commit();
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<star]: yes");

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
		return "...*";
	}
}