package koopa.core.parsers.combinators;

import java.util.Set;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This checks whether the stream is in a position where we can expect to match
 * a given {@linkplain ParserCombinator}. It's basically a positive lookahead.
 */
public class At extends UnaryParserDecorator {

	public At(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + " ?");

		stream.bookmark();
		final boolean accepted = parser.accepts(parse);
		stream.rewind();

		if (parse.getTrace().isEnabled())
			parse.getTrace()
					.dedent(toString() + " : " + (accepted ? "yes" : "no"));

		return accepted;
	}

	/**
	 * This parser just tests the context of the stream it is in, and so does
	 * not contribute any keywords.
	 */
	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	/**
	 * This parser just tests the context of the stream it is in, and so does
	 * not contribute any keywords.
	 */
	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
	}

	/**
	 * This parser just tests the context of the stream it is in, and so does
	 * not contribute any keywords.
	 */
	@Override
	public boolean allowsLookahead() {
		return false;
	}
	
	/**
	 * This parser just tests the context of the stream it is in, and so never
	 * actually consumes any input.
	 */
	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return "%at " + parser.toString();
	}
}