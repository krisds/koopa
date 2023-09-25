package koopa.core.parsers;

import java.util.Set;

import koopa.core.grammars.Grammar;

/**
 * A parser combinator is the basic building block for doing the actual parsing.
 * Koopa is based on the idea of parsing expression grammars (of PEGs), and it
 * is the parser combinators which implement the individual parts for that.
 */
public abstract class ParserCombinator {

	/**
	 * Whether or not this parser will accept the provided input.
	 * <p>
	 * This method fires of the entire process of parsing by invoking the
	 * {@link #matches(Parse)} method.
	 * <p>
	 * It will also commit the stream afterwards if it was the root parser.
	 */
	public boolean accepts(Parse parse) {
		final Stack stack = parse.getStack();

		stack.push(this);
		try {
			return matches(parse);

		} finally {
			stack.pop();
			if (stack.isEmpty())
				parse.getStream().commit();
		}
	}

	/**
	 * Actual parser combinators must implement this according to whatever logic
	 * they need.
	 */
	protected abstract boolean matches(Parse parse);

	// ------------------------------------------------------------------------
	// Support for automatic keywords...

	/**
	 * Add all keywords in scope to the given set.
	 * <p>
	 * By default this leaves the set untouched.
	 */
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	/**
	 * Add all leading keywords in scope to the given set.
	 * <p>
	 * By default this leaves the set untouched.
	 */
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	/**
	 * Can the leading keywords be used for lookahead ? That is, must the first
	 * thing matched by this parser be an element returned by
	 * {@link #addAllLeadingKeywordsTo(Set, Set)} ?
	 * <p>
	 * By default this returns <code>false</code>, disabling lookahead for this
	 * parser, thereby defaulting to the old behaviour.
	 */
	public boolean allowsLookahead() {
		return false;
	}

	/**
	 * Whether or not this parser can say that it {@linkplain #accepts(Parse)}
	 * without actually having consumed anything from the stream.
	 * <p>
	 * <b>By default this answers <code>false</code>.</b> So it's saying it will
	 * consume a token, which seems a reasonable thing for a parser to do.
	 */
	public boolean canMatchEmptyInputs() {
		return false;
	}

	/**
	 * Whether or not this parser allows keywords to be passed through its
	 * scope.
	 * <p>
	 * By default this returns <code>true</code>.
	 */
	public boolean allowsKeywords() {
		return true;
	}

	/**
	 * Whether or not this parser can say that the given word is a keyword in
	 * its own scope.
	 * <p>
	 * We assume that the given word has been passed through
	 * {@linkplain Grammar#comparableText(String)} already.
	 * <p>
	 * By default this returns <code>false</code>.
	 */
	public boolean isKeywordInScope(String word) {
		return false;
	}

	/**
	 * Is this parser matching a rule with the given name ?
	 * <p>
	 * By default this returns <code>false</code>.
	 */
	public boolean isMatching(String name) {
		return false;
	}

	// ========================================================================

	private static int hashCounter = 0;
	private final int HASHCODE = hashCounter++;

	/**
	 * For {@linkplain ParserCombinator} instances, equality boils down to
	 * object identity.
	 */
	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}

	/**
	 * Hashcodes for {@linkplain ParserCombinator} objects are nothing more than
	 * a sequentially generated identifier.
	 */
	@Override
	public int hashCode() {
		return HASHCODE;
	}
}
