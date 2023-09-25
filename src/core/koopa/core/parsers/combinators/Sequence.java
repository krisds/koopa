package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

public class Sequence extends ParserCombinator {

	private final ParserCombinator[] parsers;
	private final int length;

	public Sequence(ParserCombinator[] parsers) {
		assert (parsers != null && parsers.length > 0);

		this.parsers = parsers;
		this.length = parsers.length;
	}

	@Override
	public boolean matches(Parse parse) {
		for (ParserCombinator parser : parsers)
			if (!parser.accepts(parse))
				return false;

		return true;
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		for (ParserCombinator parser : parsers)
			parser.addAllKeywordsInScopeTo(keywords, scopesSeen);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		for (int i = 0; i < length; i++) {
			parsers[i].addAllLeadingKeywordsTo(keywords, scopesSeen);
			if (!parsers[i].canMatchEmptyInputs())
				break;
		}
	}

	@Override
	public boolean allowsLookahead() {
		for (int i = 0; i < length; i++) {
			if (!parsers[i].canMatchEmptyInputs())
				return parsers[i].allowsLookahead();
			else if (!parsers[i].allowsLookahead())
				return false;
		}

		return true;
	}

	@Override
	public boolean canMatchEmptyInputs() {
		for (ParserCombinator parser : parsers)
			if (!parser.canMatchEmptyInputs())
				return false;

		return true;
	}

	@Override
	public String toString() {
		return "(...)";
	}
}