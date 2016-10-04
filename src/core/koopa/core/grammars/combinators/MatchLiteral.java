package koopa.core.grammars.combinators;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * A {@linkplain ParserCombinator} which looks for a literal match of a single
 * {@linkplain Token}'s text.
 */
public class MatchLiteral extends GrammaticalCombinator {

	private final String comparableText;

	public MatchLiteral(Grammar grammar, String text) {
		super(grammar, text);
		this.comparableText = grammar.comparableText(text);
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + " ?");
		
		final Token token = parse.getStream().forward();

		if (token == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no, null");

			return false;

		} else if (grammar.comparableText(token.getText()).equals(
				comparableText)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : yes, " + token);

			return true;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no, " + token);

			return false;
		}
	}

	@Override
	public String toString() {
		return "literal " + comparableText;
	}
}