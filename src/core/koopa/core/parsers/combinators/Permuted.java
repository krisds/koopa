package koopa.core.parsers.combinators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Permuted extends ParserCombinator {

	private final ParserCombinator[] parsers;

	public Permuted(ParserCombinator[] parsers) {
		this.parsers = parsers;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent("[permuted>");

		List<ParserCombinator> remaining = new ArrayList<ParserCombinator>();
		for (ParserCombinator parser : parsers)
			remaining.add(parser);

		int i = 0;
		while (i < remaining.size()) {
			stream.bookmark();

			if (remaining.get(i).accepts(parse)) {
				stream.commit();
				remaining.remove(i);
				i = 0;

			} else {
				stream.rewind();
				i++;
			}
		}

		boolean accepts = remaining.size() < parsers.length;

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent("<permuted]: " + accepts);

		return accepts;
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
		return "!(...|...)";
	}
}