package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.ParserCombinator;

/**
 * A {@linkplain ParserCombinator} which takes one {@linkplain ParserCombinator}
 * to create a new one.
 */
public abstract class UnaryParserDecorator extends ParserCombinator {

	protected final ParserCombinator parser;

	public UnaryParserDecorator(ParserCombinator parser) {
		this.parser = parser;
	}

	/**
	 * Will pass the message on to {@link #parser}.
	 */
	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	/**
	 * Will pass the message on to {@link #parser}.
	 */
	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	/**
	 * Will pass the message on to {@link #parser}.
	 */
	@Override
	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}
}