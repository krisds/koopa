package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Choice extends ParserCombinator {

	private final ParserCombinator[] parsers;

	public Choice(ParserCombinator[] parsers) {
		this.parsers = parsers;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		for (int i = 0; i < parsers.length; i++) {
			final ParserCombinator parser = parsers[i];

			stream.bookmark();
			if (parser.accepts(parse)) {
				stream.commit();
				return true;

			} else {
				stream.rewind();

				if (parse.getTrace().isEnabled() && i + 1 < parsers.length)
					parse.getTrace().add("or");
			}
		}

		return false;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		for (ParserCombinator parser : parsers)
			parser.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		for (ParserCombinator parser : parsers)
			parser.addAllLeadingKeywordsTo(keywords);
	}

	public boolean canMatchEmptyInputs() {
		for (ParserCombinator parser : parsers)
			if (parser.canMatchEmptyInputs())
				return true;

		return false;
	}

	public String toString() {
		return "...|...";
	}
}