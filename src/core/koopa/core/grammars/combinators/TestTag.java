package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * Checks whether the following token in the stream has a given tag. That token
 * is <b>not</b> consumed by this parser.
 * <p>
 * This will skip all intermediate separators.
 */
public class TestTag extends ParserCombinator {

	private final Grammar grammar;
	private final Object tag;

	public TestTag(Grammar grammar, Object tag) {
		this.grammar = grammar;
		this.tag = tag;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		grammar.skipSeparators(parse);

		final Token token = stream.forward();

		if (token == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " has tag " + tag + " : no");

			return false;
		}

		if (token.hasTag(tag)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " has tag " + tag + " : yes");

			stream.rewind(token);
			return true;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(token + " has tag " + tag + " : no");

			stream.rewind(token);
			return false;
		}
	}

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public boolean canMatchEmptyInputs() {
		return true;
	}

	public String toString() {
		return "@" + tag.toString();
	}
}