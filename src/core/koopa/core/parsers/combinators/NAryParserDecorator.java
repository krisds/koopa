package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.ParserCombinator;

/**
 * A {@linkplain ParserCombinator} which combines many
 * {@linkplain ParserCombinator}s to create a new one.
 */
public abstract class NAryParserDecorator extends ParserCombinator {

	protected final ParserCombinator[] parsers;

	public NAryParserDecorator(ParserCombinator... parsers) {
		this.parsers = parsers;
	}

	/**
	 * Will pass the message on to all {@link #parsers}.
	 */
	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		for (ParserCombinator parser : parsers)
			parser.addAllKeywordsInScopeTo(keywords);
	}

	/**
	 * Will pass the message on to all {@link #parsers}.
	 */
	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		for (ParserCombinator parser : parsers)
			parser.addAllLeadingKeywordsTo(keywords);
	}

	/**
	 * Will return <code>true</code> if and only if any parser in
	 * {@link #parsers} answers <code>true</code>.
	 */
	@Override
	public boolean canMatchEmptyInputs() {
		for (ParserCombinator parser : parsers)
			if (parser.canMatchEmptyInputs())
				return true;

		return false;
	}
}