package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.tags.AreaTag;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;
import koopa.core.streams.Streams;

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

		final String text = Streams.getProgramTextFromBookmark(grammar, stream);

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

	/**
	 * To be implemented by subclasses, this is equivalent to
	 * {@link #accepts(Parse)}, but passes along the contents of all matched
	 * tokens which are accepted by {@linkplain Grammar#isProgramText(Data)}.
	 * <p>
	 * This will not get called if the {@link #parser} did not match.
	 */
	protected abstract boolean matchesProgramText(Parse parse,
			String programText);

	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		parser.addAllKeywordsInScopeTo(keywords, scopesSeen);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		parser.addAllLeadingKeywordsTo(keywords, scopesSeen);
	}

	@Override
	public boolean allowsLookahead() {
		return parser.allowsLookahead();
	}
}
