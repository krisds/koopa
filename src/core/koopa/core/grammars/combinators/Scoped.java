package koopa.core.grammars.combinators;

import java.util.Iterator;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.Stream;

public class Scoped extends FutureParser {

	private final Grammar grammar;
	private final String name;

	/**
	 * Choices for visibility of {@linkplain Marker}s.
	 */
	public enum Visibility {
		/** Always present in the stream. */
		PUBLIC,

		/**
		 * Present when there is more than one (non-separator, non-comment)
		 * child.
		 */
		HIDING,

		/** Never present in the stream. */
		PRIVATE;

		public boolean addsMarkers() {
			return this != PRIVATE;
		}

		public boolean allowsMarkersToBeHidden() {
			return this == HIDING;
		}
	}

	private final Visibility visibility;
	private final boolean allowKeywords;

	public Scoped(Grammar grammar, String name, Visibility visibility,
			boolean allowKeywords) {
		this.grammar = grammar;
		this.name = name;
		this.visibility = visibility;
		this.allowKeywords = allowKeywords;
	}

	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(
					toString() + " ? " + stream.peekMore() + "...");

		stream.bookmark();
		if (visibility.addsMarkers())
			stream.insert(Start.on(grammar.getNamespace(), name));

		final boolean accepts = parser.accepts(parse);

		if (accepts) {
			if (visibility.allowsMarkersToBeHidden()) {
				if (!markerBecomesHidden(parse))
					stream.insert(End.on(grammar.getNamespace(), name));

			} else if (visibility.addsMarkers())
				stream.insert(End.on(grammar.getNamespace(), name));

			stream.commit();

		} else {
			stream.rewind();
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace()
					.dedent(toString()
							+ " : "
							+ (accepts ? ("yes, up to " + stream.peekMore() + "...")
									: "no"));

		return accepts;
	}

	private boolean markerBecomesHidden(Parse parse) {
		final Stream stream = parse.getStream();
		final Iterator<Data> it = stream.backToBookmarkIterator();

		int depth = 0;
		int count = 0;

		while (it.hasNext()) {
			final Data next = it.next();

			if (next instanceof End) {
				depth += 1;

			} else if (next instanceof Start) {
				depth -= 1;

				if (depth < 0) {
					if (count != 1)
						return false;

					it.remove();
					return true;

				} else if (depth == 0)
					count += 1;

			} else if (depth == 0) {
				if (next instanceof Token) {
					Token token = (Token) next;
					if (grammar.isProgramText(token)
							&& !grammar.canBeSkipped(token, parse))
						// && !grammar.isComment(token))
						count += 1;
				}
			}
		}

		return count == 1;
	}

	/**
	 * It's subtle, but when asking a scoped parser for all keywords "in scope",
	 * we're asking for all keywords in the scope it's being referenced from.
	 * <p>
	 * If we were to add all keywords within its own scope, then the keywords
	 * list for the root scope would end up containing all keywords in the
	 * grammar. For instance, a Cobol program would know about all SQL-related
	 * keywords found in an EXEC SQL. This is not what we want.
	 * <p>
	 * Instead what we need is to add all leading keywords of our own scope.
	 * This should give the parent scope just enough information about tokens it
	 * probably should know about, without telling it about all tokens. Taking
	 * the Cobol program example again, it would now only know about the markers
	 * for the overall structure of the program, and little else.
	 */
	@Override
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		if (allowKeywords)
			parser.addAllLeadingKeywordsTo(keywords);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		if (allowKeywords)
			parser.addAllLeadingKeywordsTo(keywords);
	}

	@Override
	public boolean isKeyword(String word, Frame frame) {
		if (!allowKeywords)
			return false;
		else
			return super.isKeyword(word, frame);
	}

	@Override
	public boolean isMatching(String n) {
		return name.equals(n);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "def " + name;
	}
}