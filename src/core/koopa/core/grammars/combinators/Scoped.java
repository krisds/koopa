package koopa.core.grammars.combinators;

import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;
import koopa.core.util.WeakSet;

public class Scoped extends FutureParser {

	private final Grammar grammar;
	private final String name;

	// Using this for memoization because, as it turns out, it occurs often
	// enough that the same grammar rule gets evaluated on the same token.
	// If we already know it has failed before then we can shortcircuit a
	// lot of duplicate work.
	private final WeakSet<Token> failures;
	private final boolean publik;

	public Scoped(Grammar grammar, String name, boolean publik) {
		this.grammar = grammar;
		this.name = name;
		this.failures = new WeakSet<Token>();
		this.publik = publik;
	}

	public boolean matches(Parse parse) {
		Stream stream = parse.getStream();
		Token peek = stream.peek();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(name + " ? " + stream.peekMore() + "...");

		if (failures.has(stream.peek())) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(name + ": no (memoized)");

			return false;
		}

		parse.getStack().getHead().makeScoped();

		stream.bookmark();
		if (publik)
			stream.insert(Start.on(grammar.getNamespace(), name));

		boolean accepts = parser.accepts(parse);

		if (accepts) {
			if (publik)
				stream.insert(End.on(grammar.getNamespace(), name));

			stream.commit();

		} else {
			stream.rewind();
			failures.put(stream.peek());
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(
					name + (accepts ? ": yes " : ": no ") + peek + " - up to "
							+ stream.peekMore() + "...");

		return accepts;
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
	public void addAllKeywordsInScopeTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
		parser.addAllLeadingKeywordsTo(keywords);
	}

	public boolean canMatchEmptyInputs() {
		return parser.canMatchEmptyInputs();
	}

	public boolean isMatching(String n) {
		return name.equals(n);
	}

	public String toString() {
		return "def " + name;
	}
}