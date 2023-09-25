package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This parser always fails. Useful as a placeholder.
 * <p>
 * Singleton, as there is no use for multiple instances.
 */
public class FailMatch extends ParserCombinator {

	private static final String SYMBOL = "%%fail%%";

	private static final FailMatch INSTANCE = new FailMatch();

	private FailMatch() {
	}

	public static FailMatch instance() {
		return INSTANCE;
	}

	@Override
	public boolean matches(Parse parse) {
		if (parse.getTrace().isEnabled())
			parse.getTrace().add(SYMBOL + " : no");

		return false;
	}

	/**
	 * This parser always fails, and so does not contribute any keywords.
	 */
	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	/**
	 * This parser always fails, and so does not contribute any keywords.
	 */
	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	/**
	 * This parser always fails, and so never actually consumes any input.
	 */
	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}