package koopa.core.parsers;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.combinators.Choice;

public class Optimizer {

	private static final boolean SHOULD_RUN;
	static {
		SHOULD_RUN = !"false".equalsIgnoreCase( //
				System.getProperty("koopa.optimize", "true"));

		if (!SHOULD_RUN)
			System.out.println("Optimizer has been turned off.");
	}

	public static boolean shouldRun() {
		return SHOULD_RUN;
	}

	/**
	 * Can we use lookahead (at {@linkplain Grammar#keyword()}) to decide which
	 * of the given parsers to trigger ?
	 */
	public static boolean canUseLookaheadInChoice(ParserCombinator... parsers) {
		for (ParserCombinator p : parsers)
			if (!p.allowsLookahead())
				return false;

		return true;
	}

	/**
	 * Build a dispatch table for the given parsers, mapping keywords to (a
	 * choice) of possible parsers.
	 * <p>
	 * The dispatch table's keys and choices respect the order in which the
	 * grammar writer has defined the different choices in the grammar. This is
	 * an essential feature as Koopa grammars rely on manual ordering to resolve
	 * conflicts.
	 */
	public static Map<String, ParserCombinator> dispatchTable(
			ParserCombinator... parsers) {

		final Map<String, List<ParserCombinator>> mapping //
				= new LinkedHashMap<String, List<ParserCombinator>>();

		for (ParserCombinator p : parsers) {
			final Set<String> keywords = new LinkedHashSet<String>();
			p.addAllLeadingKeywordsTo(keywords);
			for (String kw : keywords) {
				if (!mapping.containsKey(kw))
					mapping.put(kw, new LinkedList<ParserCombinator>());
				mapping.get(kw).add(p);
			}
		}

		final Map<String, ParserCombinator> dispatchTable = new LinkedHashMap<String, ParserCombinator>();

		for (String kw : mapping.keySet()) {
			final List<ParserCombinator> choices = mapping.get(kw);
			if (choices.size() == 1)
				dispatchTable.put(kw, choices.get(0));
			else
				dispatchTable.put(kw, new Choice(
						choices.toArray(new ParserCombinator[choices.size()])));
		}

		return dispatchTable;
	}
}
