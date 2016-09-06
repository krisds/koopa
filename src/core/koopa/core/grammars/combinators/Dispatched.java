package koopa.core.grammars.combinators;

import java.util.Map;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This is kind of an optimizing {@linkplain ParserCombinator} which can choose
 * directly between a selection of many {@linkplain ParserCombinator}s by
 * looking at the very next {@linkplain Token} in the stream. I.e. it dispatches
 * to a specific parser based on the value of the upcoming token.
 */
public class Dispatched extends GrammaticalCombinator {

	private static final String SYMBOL = "$(...|...)";

	private final Map<String, ParserCombinator> lookupTable;

	/**
	 * Note: this constructor assumes that the keys in the lookup table have
	 * been passed through {@linkplain Grammar#comparableText(String)}.
	 */
	public Dispatched(Grammar grammar, Map<String, ParserCombinator> lookupTable) {
		super(grammar);
		this.lookupTable = lookupTable;
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Token peek = parse.getStream().peek();

		if (peek == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(SYMBOL + " : no, null");

			return false;
		}

		final String text = grammar.comparableText(peek.getText());
		if (!lookupTable.containsKey(text)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(SYMBOL + " : no, did not find " + peek);

			return false;
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ? at " + peek);

		final ParserCombinator parser = lookupTable.get(text);
		final boolean accepted = parser.accepts(parse);

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : " + (accepted ? "yes" : "no"));

		return accepted;
	}

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		for (ParserCombinator parser : lookupTable.values())
			parser.addAllKeywordsInScopeTo(keywords);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		for (String key : lookupTable.keySet())
			keywords.add(key);
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}