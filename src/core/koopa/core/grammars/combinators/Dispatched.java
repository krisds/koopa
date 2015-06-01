package koopa.core.grammars.combinators;

import java.util.Map;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public class Dispatched extends ParserCombinator {

	private final Grammar grammar;
	private final Map<String, ParserCombinator> lookupTable;

	public Dispatched(Grammar grammar, Map<String, ParserCombinator> lookupTable) {
		this.grammar = grammar;
		this.lookupTable = lookupTable;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		grammar.skipSeparators(parse);

		Token peek = stream.peek();
		if (peek == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add("dispatch: null");
			return false;
		}

		String text = peek.getText().toUpperCase();
		if (!lookupTable.containsKey(text)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add("dispatch: " + text + " - not found");
			return false;
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().add("dispatch: " + text);

		ParserCombinator parser = lookupTable.get(text);
		return parser.accepts(parse);
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		for (ParserCombinator parser : lookupTable.values())
			parser.addAllKeywordsInScopeTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		for (String key : lookupTable.keySet())
			keywords.add(key);
	}

	public String toString() {
		return "$(...|...)";
	}
}