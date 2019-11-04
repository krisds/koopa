package koopa.core.grammars;

import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;

import java.util.HashMap;
import java.util.Map;

import koopa.core.grammars.combinators.Dispatched;
import koopa.core.grammars.combinators.MatchAny;
import koopa.core.grammars.combinators.MatchEndOfFile;
import koopa.core.grammars.combinators.MatchKeyword;
import koopa.core.grammars.combinators.MatchLiteral;
import koopa.core.grammars.combinators.MatchNumber;
import koopa.core.grammars.combinators.MatchToken;
import koopa.core.grammars.combinators.OptimizingChoice;
import koopa.core.grammars.combinators.OptimizingPermuted;
import koopa.core.grammars.combinators.Scoped;
import koopa.core.grammars.combinators.Scoped.Visibility;
import koopa.core.grammars.combinators.TestForKeyword;
import koopa.core.grammars.combinators.TestRange;
import koopa.core.grammars.combinators.TestTag;
import koopa.core.grammars.combinators.WrappedAs;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Optimizer;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.At;
import koopa.core.parsers.combinators.Balancing;
import koopa.core.parsers.combinators.Choice;
import koopa.core.parsers.combinators.FailMatch;
import koopa.core.parsers.combinators.LimitedTo;
import koopa.core.parsers.combinators.MatchTree;
import koopa.core.parsers.combinators.Nested;
import koopa.core.parsers.combinators.Not;
import koopa.core.parsers.combinators.NotEmpty;
import koopa.core.parsers.combinators.NotNested;
import koopa.core.parsers.combinators.Opt;
import koopa.core.parsers.combinators.Optional;
import koopa.core.parsers.combinators.Permuted;
import koopa.core.parsers.combinators.Plus;
import koopa.core.parsers.combinators.Sequence;
import koopa.core.parsers.combinators.SkipTo;
import koopa.core.parsers.combinators.Star;
import koopa.core.parsers.combinators.UpTo;
import koopa.core.parsers.combinators.WithOption;

/**
 * This provides the basis for implementing full grammars. It basically gives
 * you a form of parser combinators with which you can define more complex
 * grammar rules.
 * <p>
 * Note that you shouldn't be using this class directly. Instead the actual code
 * will get generated from Koopa grammar definitions.
 */
public abstract class KoopaGrammar extends Grammar {

	public KoopaGrammar() {
	}

	protected FutureParser scoped(final String name) {
		return scoped(name, PUBLIC, true);
	}

	protected FutureParser scoped(final String name,
			final Visibility visibility) {
		return scoped(name, visibility, true);
	}

	protected FutureParser scoped(final String name,
			final Visibility visibility, boolean allowKeywords) {
		return new Scoped(this, name, visibility, allowKeywords);
	}

	protected ParserCombinator as(final String name,
			final ParserCombinator parser) {
		return new WrappedAs(this, parser, name);
	}

	protected ParserCombinator skipto(final ParserCombinator parser) {
		return new SkipTo(parser);
	}

	protected ParserCombinator not(final ParserCombinator parser) {
		return new Not(parser);
	}

	protected ParserCombinator at(final ParserCombinator parser) {
		return new At(parser);
	}

	protected ParserCombinator star(final ParserCombinator parser) {
		return new Star(parser);
	}

	protected ParserCombinator plus(final ParserCombinator parser) {
		return new Plus(parser);
	}

	protected ParserCombinator sequence(final ParserCombinator... parsers) {
		if (parsers != null && parsers.length == 1)
			return parsers[0];
		else
			return new Sequence(parsers);
	}

	protected ParserCombinator choice(final ParserCombinator... parsers) {
		// TODO Set a minimum length requirement on parsers ? Is it worth doing
		// this for small numbers ?
		if (Optimizer.shouldRun())
			return new OptimizingChoice(this, parsers);
		else
			return new Choice(parsers);
	}

	protected ParserCombinator permuted(final ParserCombinator... parsers) {
		// TODO Set a minimum length requirement on parsers ? Is it worth doing
		// this for small numbers ?
		if (Optimizer.shouldRun())
			return new OptimizingPermuted(this, parsers);
		else
			return new Permuted(parsers);
	}

	protected ParserCombinator optional(final ParserCombinator parser) {
		return new Optional(parser);
	}

	protected ParserCombinator optional(final ParserCombinator... parsers) {
		return new Optional(sequence(parsers));
	}

	protected ParserCombinator literal(final String text) {
		return new MatchLiteral(this, text);
	}

	protected ParserCombinator token(final String text) {
		return new MatchToken(this, text);
	}

	protected ParserCombinator keyword(final String text) {
		return new MatchKeyword(this, text);
	}

	protected ParserCombinator number(final String text) {
		return new MatchNumber(this, text);
	}

	protected ParserCombinator any() {
		return new MatchAny(this);
	}

	protected ParserCombinator tagged(final Object tag) {
		return new TestTag(this, tag);
	}

	protected ParserCombinator opt(final Opt opt,
			final ParserCombinator... parsers) {
		return new WithOption(opt, sequence(parsers));
	}

	protected ParserCombinator limited(final ParserCombinator target,
			final ParserCombinator limiter) {
		return new LimitedTo(target, limiter);
	}

	protected ParserCombinator upTo(ParserCombinator target,
			ParserCombinator limiter) {
		return new UpTo(target, limiter);
	}

	protected ParserCombinator dispatched(final String[] keys,
			final ParserCombinator[] parsers) {

		assert (keys.length == parsers.length);

		final Map<String, ParserCombinator> lookupTable = new HashMap<>();
		for (int i = 0; i < keys.length; i++)
			lookupTable.put(comparableText(keys[i]), parsers[i]);

		return new Dispatched(this, lookupTable);
	}

	protected ParserCombinator eof() {
		return new MatchEndOfFile(this);
	}

	protected ParserCombinator notAKeyword(final ParserCombinator parser) {
		return new TestForKeyword(this, false, parser);
	}

	protected ParserCombinator notNested(final ParserCombinator parser) {
		return new NotNested(parser);
	}

	protected ParserCombinator nested(final ParserCombinator parser) {
		return new Nested(parser);
	}

	protected ParserCombinator todo() {
		return FailMatch.instance();
	}

	/**
	 * The last parser will be used as the target. The preceding ones defining
	 * the pairs to be balanced.
	 */
	protected ParserCombinator balancing(ParserCombinator... parsers) {
		final int length = parsers.length;

		assert (length >= 3 && length % 2 == 1);

		final ParserCombinator target = parsers[length - 1];
		final ParserCombinator[] pairs = new ParserCombinator[length - 1];

		for (int i = 0; i < length - 1; i++)
			pairs[i] = parsers[i];

		return new Balancing(this, target, pairs);
	}

	protected ParserCombinator upto(ParserCombinator parser,
			ParserCombinator edge) {
		return new UpTo(parser, edge);
	}

	protected ParserCombinator notEmpty(ParserCombinator parser) {
		return new NotEmpty(parser);
	}

	protected ParserCombinator ranged(int begin, int end) {
		return new TestRange(this, begin, end);
	}

	protected ParserCombinator tree(final String name) {
		return tree(null, name, null);
	}

	protected ParserCombinator tree(final String namespace, final String name) {
		return tree(namespace, name, null);
	}

	protected ParserCombinator tree(String name, ParserCombinator parser) {
		return new MatchTree(null, name, parser);
	}

	protected ParserCombinator tree(String namespace, String name,
			ParserCombinator parser) {
		return new MatchTree(namespace, name, parser);
	}

	// ========================================================================

	@Override
	public ParserCombinator keyword() {
		return any();
	}
}
