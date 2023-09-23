package koopa.core.parsers;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import koopa.core.grammars.Grammar;
import koopa.core.grammars.combinators.Dispatched;
import koopa.core.parsers.combinators.Choice;

public class Optimizer {

	private static final Logger LOGGER = Logger.getLogger("optimization");

	private static final boolean SHOULD_RUN;
	static {
		SHOULD_RUN = !"false".equalsIgnoreCase( //
				System.getProperty("koopa.optimize", "true"));

		if (!SHOULD_RUN && LOGGER.isInfoEnabled())
			LOGGER.info("Optimizer has been turned off.");
	}

	public static boolean shouldRun() {
		return SHOULD_RUN;
	}

	/**
	 * Starting with the first parser, count the number of parsers which we
	 * could use lookahead (with {@linkplain Grammar#keyword()}) for. Start
	 * counting as soon as we see one which does not support lookahead.
	 */
	public static int countLeadingParsersAllowingLookahead(
			ParserCombinator... parsers) {

		int count = 0;
		for (ParserCombinator p : parsers)
			if (p.allowsLookahead())
				count += 1;
			else
				return count;

		return count;
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
	private static Map<String, ParserCombinator> dispatchTable(
			ParserCombinator... parsers) {

		final Map<String, List<ParserCombinator>> mapping = new LinkedHashMap<>();

		for (ParserCombinator p : parsers) {
			final Set<String> keywords = new LinkedHashSet<>();
			p.addAllLeadingKeywordsTo(keywords, new HashSet<>());
			for (String kw : keywords) {
				if (!mapping.containsKey(kw))
					mapping.put(kw, new LinkedList<ParserCombinator>());
				mapping.get(kw).add(p);
			}
		}

		final Map<String, ParserCombinator> dispatchTable = new LinkedHashMap<>();

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

	/**
	 * Build a dispatch table for all parsers, and return a
	 * {@linkplain Dispatched} parser based on it.
	 */
	public static Dispatched dispatched(Grammar grammar,
			ParserCombinator[] parsers) {
		return new Dispatched(grammar, dispatchTable(parsers));
	}

	/**
	 * Build a dispatch table for the selected parsers, and return a
	 * {@linkplain Dispatched} parser based on it.
	 */
	public static Dispatched dispatched(Grammar grammar,
			ParserCombinator[] parsers, int start, int length) {
		final ParserCombinator[] selected = new ParserCombinator[length];
		for (int i = 0; i < length; i++)
			selected[i] = parsers[start + i];
		return new Dispatched(grammar, dispatchTable(selected));
	}
}
