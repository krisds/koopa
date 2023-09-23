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
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		parser.addAllKeywordsInScopeTo(keywords, scopesSeen);
	}

	/**
	 * Will pass the message on to {@link #parser}.
	 */
	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		parser.addAllLeadingKeywordsTo(keywords, scopesSeen);
	}

	/**
	 * Will pass the message on to {@link #parser}.
	 */
	@Override
	public boolean allowsLookahead() {
		return parser.allowsLookahead();
	}
	
	/**
	 * Will pass the message on to {@link #parser}.
	 */
	@Override
	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}
}