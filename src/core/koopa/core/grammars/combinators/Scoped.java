package koopa.core.grammars.combinators;

import java.util.Iterator;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;
import koopa.core.streams.BaseStream;
import koopa.core.targets.HoldingTarget;

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

	@Override
	public boolean accepts(Parse parse) {
		final boolean accepts = super.accepts(parse);

		if (accepts) {
			final BaseStream baseStream = parse.getFlow().getBaseStream();
			final HoldingTarget target = baseStream.getTarget();
			final Token t = target.peekAtLastToken();
			if (t != null) {
				final Position start = t.getStart();
				if (parse.getFinalPosition().compareTo(start) < 0)
					parse.setFinalMatch(start, parse.getStack().getHead());
			}
		}

		return accepts;
	}

	@Override
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

				} else if (depth == 0) {
					count += 1;
					if (count > 1)
						return false;
				}

			} else if (depth == 0 && grammar.isProgramText(next)
					&& !grammar.canBeSkipped(next, parse)) {
				count += 1;
				if (count > 1)
					return false;
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
	public void addAllKeywordsInScopeTo(Set<String> keywords, Set<String> scopesSeen) {
		// No need to figure out all our keywords twice.
		if (scopesSeen.contains(name))
			return;
		
		scopesSeen.add(name);
		if (allowKeywords)
			parser.addAllLeadingKeywordsTo(keywords, scopesSeen);
	}

	@Override
	public void addAllLeadingKeywordsTo(Set<String> keywords, Set<String> scopesSeen) {
		// No need to figure out all our keywords twice.
		if (scopesSeen.contains(name))
			return;
		
		scopesSeen.add(name);
		if (allowKeywords)
			parser.addAllLeadingKeywordsTo(keywords, scopesSeen);		
	}

	@Override
	public boolean allowsKeywords() {
		return allowKeywords;
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