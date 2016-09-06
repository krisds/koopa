package koopa.core.grammars.combinators;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

/**
 * This {@linkplain ParserCombinator} tests whether the text matched by a given
 * parser is in a given case or not. Clients can configure which case (upper or
 * lower, all of it or some) should have this parser accept the input.
 */
public class TestForCase extends TestProgramText {

	private final boolean isUppercase;
	private final boolean trueForAll;

	public TestForCase(Grammar grammar, boolean isUppercase,
			boolean trueForAll, ParserCombinator parser) {
		super(grammar, parser);
		this.isUppercase = isUppercase;
		this.trueForAll = trueForAll;
	}

	@Override
	protected boolean matchesProgramText(Parse parse, String text) {
		if (isUppercase) {
			if (trueForAll)
				return allWordsAreUppercase(parse, text);

			else
				return someWordsHaveLowercase(parse, text);

		} else {
			if (trueForAll)
				return allWordsAreLowercase(parse, text);

			else
				return someWordsHaveUppercase(parse, text);
		}
	}

	private boolean allWordsAreUppercase(Parse parse, String text) {
		return text.equals(text.toUpperCase());
	}

	private boolean someWordsHaveLowercase(Parse parse, String text) {
		return !text.equals(text.toUpperCase());
	}

	private boolean allWordsAreLowercase(Parse parse, String text) {
		return text.equals(text.toLowerCase());
	}

	private boolean someWordsHaveUppercase(Parse parse, String text) {
		return !text.equals(text.toLowerCase());
	}

	@Override
	public String toString() {
		if (isUppercase) {
			if (trueForAll)
				return "all uppercase";
			else
				return "some lowercase";
		} else {
			if (trueForAll)
				return "all lowercase";
			else
				return "some uppercase";
		}
	}
}
