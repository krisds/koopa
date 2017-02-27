package koopa.core.grammars.combinators;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;

/**
 * Checks whether the following token in the stream has a given tag. That token
 * is <b>not</b> consumed by this parser.
 */
public class TestTag extends GrammaticalCombinator {

	private final Object tag;

	public TestTag(Grammar grammar, Object tag) {
		super(grammar);
		this.tag = tag;
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Data d = parse.getStream().peek();

		if (d == null || !(d instanceof Token)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, null");

			return false;

		}

		final Token t = (Token) d;

		if (t.hasTag(tag)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : yes, " + t);

			return true;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " : no, " + t);

			return false;
		}
	}

	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return "@" + tag.toString();
	}
}