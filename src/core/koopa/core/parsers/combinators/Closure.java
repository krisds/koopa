package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;

public class Closure extends UnaryParserDecorator {

	private final Frame headAtTimeOfCreation;

	public Closure(ParserCombinator parser, Parse parse) {
		super(parser);

		// This grabs the context for this closure.
		this.headAtTimeOfCreation = parse.getStack().getHead();
	}

	@Override
	protected boolean matches(Parse parse) {
		final Frame headAtTimeOfMatching = parse.getStack().getHead();

		// We change the parse context/stack to the one we grabbed earlier.
		parse.getStack().setHead(headAtTimeOfCreation);

		// And let the parse proceed with that.
		final boolean accepts = parser.accepts(parse);

		// After which we restore the context/stack to what it was.
		parse.getStack().setHead(headAtTimeOfMatching);

		return accepts;
	}

	@Override
	public String toString() {
		return "{ " + parser + " }";
	}
}
