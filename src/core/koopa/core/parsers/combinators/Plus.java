package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Plus extends ParserCombinator {

	private final ParserCombinator parser;

	public Plus(ParserCombinator parser) {
		this.parser = parser;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[plus>");

		stream.bookmark();

		if (!parser.accepts(parse)) {
			stream.rewind();

			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent("<plus]: no");

			return false;
		}

		stream.commit();

		while (true) {
			stream.bookmark();

			if (!parser.accepts(parse)) {
				stream.rewind();
				break;
			}

			stream.commit();
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<plus]: yes");

		return true;
	}

	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	public String toString() {
		return "...+";
	}
}