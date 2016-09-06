package koopa.core.grammars.combinators;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This {@linkplain ParserCombinator} tests whether the text matched by a given
 * parser is a keyword or not. Clients can configure which case (keyword or not)
 * should have this parser accept the input.
 */
public class TestForKeyword extends TestProgramText {

	private final boolean acceptKeyword;

	public TestForKeyword(Grammar grammar, boolean acceptKeyword,
			ParserCombinator parser) {
		super(grammar, parser);
		this.acceptKeyword = acceptKeyword;
	}

	@Override
	protected boolean matchesProgramText(Parse parse, String text) {
		return parse.getStack().isKeyword(grammar.comparableText(text)) == acceptKeyword;
	}

	@Override
	public String toString() {
		if (acceptKeyword)
			return "keyword";
		else
			return "no keyword";
	}
}
