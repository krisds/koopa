package koopa.core.grammars.combinators;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.Iterator;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This {@linkplain ParserCombinator} provides the basis for testing the
 * {@linkplain AreaTag#PROGRAM_TEXT_AREA} matched by a given parser.
 */
public abstract class TestProgramText extends GrammaticalCombinator {

	protected final ParserCombinator parser;

	public TestProgramText(Grammar grammar, ParserCombinator parser) {
		super(grammar);
		this.parser = parser;
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace()
					.indent(toString() + " ? " + stream.peekMore() + "...");

		stream.bookmark();

		final boolean accepts = parser.accepts(parse);

		if (!accepts) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " ? no");

			stream.rewind();
			return false;
		}

		final String text = getMatchedProgramText(stream);

		if (!matchesProgramText(parse, text)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.dedent(toString() + ": no, was: '" + text + "'");

			stream.rewind();
			return false;

		} else {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.dedent(toString() + ": yes, is: '" + text + "'");

			stream.commit();
			return true;
		}
	}

	private String getMatchedProgramText(final Stream stream) {
		final StringBuilder programText = new StringBuilder();

		final Iterator<Data> it = stream.fromBookmarkIterator();
		while (it.hasNext()) {
			final Data d = it.next();

			if (!(d instanceof Token))
				continue;

			final Token t = (Token) d;

			if (t.hasTag(PROGRAM_TEXT_AREA))
				programText.append(t.getText());
		}

		return programText.toString();
	}

	/**
	 * To be implemented by subclasses, this is equivalent to
	 * {@link #accepts(Parse)}, but passes along the contents of the
	 * {@linkplain AreaTag#PROGRAM_TEXT_AREA} which was matched.
	 * <p>
	 * This will not get called if the {@link #parser} did not match.
	 */
	protected abstract boolean matchesProgramText(Parse parse,
			String programText);

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllKeywordsInScopeTo(keywords);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}
}
