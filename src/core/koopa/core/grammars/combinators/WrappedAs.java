package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class WrappedAs extends ParserCombinator {

	private final Grammar grammar;
	private final ParserCombinator parser;
	private final String name;

	public WrappedAs(Grammar grammar, ParserCombinator parser, String name) {
		this.grammar = grammar;
		this.parser = parser;
		this.name = name;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(name + " ? " + stream.peekMore() + "...");

		stream.bookmark();
		stream.insert(Start.on(grammar.getNamespace(), name));

		boolean accepts = parser.accepts(parse);

		if (accepts) {
			stream.insert(End.on(grammar.getNamespace(), name));
			stream.commit();

		} else {
			stream.rewind();
		}

		return accepts;
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}

	public boolean isMatching(String n) {
		return name.equals(n);
	}

	public String toString() {
		return "... %as " + name;
	}
}