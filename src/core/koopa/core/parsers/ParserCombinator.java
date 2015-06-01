package koopa.core.parsers;

import java.util.Set;

import koopa.core.sources.Source;
import koopa.core.targets.Target;

public abstract class ParserCombinator {

	/**
	 * This method should <b>not</b> get called directly by clients! They should
	 * use {@linkplain #accepts(Source, Target)} instead.
	 */
	public final boolean accepts(Parse parse) {
		Stack stack = parse.getStack();

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

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
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

	public boolean isKeyword(String word, Stack.Frame frame) {
		return frame.up().isKeyword(word);
	}

	/**
	 * Is this parser matching a rule with the given name ?
	 */
	public boolean isMatching(String name) {
		return false;
	}
}
