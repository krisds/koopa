package koopa.core.grammars.combinators;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Checks whether the position of the following token in the stream lies within
 * a certain range. That token is <b>not</b> consumed by this parser.
 */
public class TestRange extends GrammaticalCombinator {

	private final int begin;
	private final int end;

	public TestRange(Grammar grammar, int start, int end) {
		super(grammar);
		this.begin = start;
		this.end = end;
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Token peek = parse.getStream().peek();

		if (peek == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, null");

			return false;
		}

		final int startOfToken = peek.getStart().getPositionInLine();
		if (begin >= 0 && startOfToken < begin) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, begins at "
						+ startOfToken + ": " + peek);

			return false;
		}

		final int endOfToken = peek.getEnd().getPositionInLine();
		if (end >= 0 && endOfToken > end) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, ends at " + endOfToken
						+ ": " + peek);

			return false;
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().add(toString() + " : yes, " + peek);

		return true;
	}

	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return "<" + begin + ".." + end + ">";
	}
}