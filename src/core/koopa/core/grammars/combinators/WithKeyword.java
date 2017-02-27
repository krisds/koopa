package koopa.core.grammars.combinators;

import koopa.core.data.Data;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;
import koopa.core.streams.Streams;
import koopa.core.util.Memo;

/**
 * This {@linkplain ParserCombinator} provides the basis for others which want
 * to know the {@linkplain Grammar#keyword()} at the point in the
 * {@linkplain Parse} where they're being applied.
 */
public abstract class WithKeyword extends GrammaticalCombinator {

	private static final String NO_KEYWORD = "";

	protected final ParserCombinator parser;

	public WithKeyword(Grammar grammar) {
		super(grammar);
		this.parser = grammar.keyword();
	}

	@Override
	protected boolean matchesAfterSkipped(Parse parse) {
		final String keyword = getKeyword(parse);

		if (keyword == NO_KEYWORD) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add(toString() + " ? no, no keyword");

			return false;

		} else
			return matchesAtKeyword(parse, keyword);
	}

	/**
	 * This returns the keyword at this point in the parse, restoring the state
	 * of the parse to the starting point afterwards.
	 * <p>
	 * We memoize the keywords which were found so that we can reused them if we
	 * get asked for them again at some later point.
	 */
	private String getKeyword(Parse parse) {
		final Memo memo = Memo.forSubject("kw-" + parse.hashCode());

		final Stream stream = parse.getStream();
		final Data peek = stream.peek();

		final String memoizedKeyword = memo.get(peek, String.class);
		if (memoizedKeyword != null)
			return memoizedKeyword;

		stream.bookmark();
		final boolean accepts = parser.accepts(parse);

		final String keyword;
		if (!accepts)
			keyword = NO_KEYWORD;
		else
			keyword = grammar.comparableText(//
					Streams.getProgramTextFromBookmark(grammar, stream));

		stream.rewind();
		memo.put(peek, keyword);
		return keyword;
	}

	/**
	 * To be implemented by subclasses, this is equivalent to
	 * {@link #accepts(Parse)}, but passes along the contents of the
	 * {@linkplain Grammar#keyword()} which was matched.
	 * <p>
	 * This will not get called if there was no keyword.
	 * <p>
	 * If there was a keyword, the stream will be rewound so it has not actually
	 * been consumed yet.
	 */
	protected abstract boolean matchesAtKeyword(Parse parse, String keyword);
}
