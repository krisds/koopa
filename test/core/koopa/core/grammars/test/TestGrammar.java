package koopa.core.grammars.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Opt;

/**
 * This class exposes all parser combinator methods for testing. It can be
 * configured with a list of Strings to be used as separators.
 */
public class TestGrammar extends KoopaGrammar {

	private final Set<String> separators;

	public TestGrammar(String... separators) {
		this.separators = new HashSet<>(Arrays.asList(separators));
	}

	// ========================================================================

	@Override
	public String getNamespace() {
		return "test";
	}

	@Override
	public boolean isCaseSensitive() {
		return false;
	}

	@Override
	public boolean isProgramText(Data d) {
		return true;
	}

	@Override
	public boolean canBeSkipped(Data d, Parse parse) {
		return d instanceof Token && separators.contains(((Token) d).getText());
	}

	@Override
	public FutureParser scoped(String name) {
		return super.scoped(name);
	}

	@Override
	public ParserCombinator choice(ParserCombinator... parsers) {
		return super.choice(parsers);
	}

	@Override
	public ParserCombinator star(ParserCombinator parser) {
		return super.star(parser);
	}

	@Override
	public ParserCombinator plus(ParserCombinator parser) {
		return super.plus(parser);
	}

	@Override
	public ParserCombinator optional(ParserCombinator parser) {
		return super.optional(parser);
	}

	@Override
	public ParserCombinator permuted(ParserCombinator... parsers) {
		return super.permuted(parsers);
	}

	@Override
	public ParserCombinator token(String text) {
		return super.token(text);
	}

	@Override
	public ParserCombinator number(String text) {
		return super.number(text);
	}

	@Override
	public ParserCombinator sequence(ParserCombinator... parsers) {
		return super.sequence(parsers);
	}

	@Override
	public ParserCombinator skipto(ParserCombinator parser) {
		return super.skipto(parser);
	}

	@Override
	public ParserCombinator not(ParserCombinator parser) {
		return super.not(parser);
	}

	@Override
	public ParserCombinator any() {
		return super.any();
	}

	@Override
	public ParserCombinator tagged(Object tag) {
		return super.tagged(tag);
	}

	@Override
	public ParserCombinator opt(Opt opt, ParserCombinator... parsers) {
		return super.opt(opt, parsers);
	}

	@Override
	public ParserCombinator limited(ParserCombinator target,
			ParserCombinator limiter) {
		return super.limited(target, limiter);
	}

	@Override
	public ParserCombinator upTo(ParserCombinator target,
			ParserCombinator limiter) {
		return super.upTo(target, limiter);
	}

	@Override
	public ParserCombinator dispatched(String[] keys,
			ParserCombinator[] parsers) {
		return super.dispatched(keys, parsers);
	}

	@Override
	public ParserCombinator as(String name, ParserCombinator parser) {
		return super.as(name, parser);
	}

	@Override
	public ParserCombinator eof() {
		return super.eof();
	}

	@Override
	public ParserCombinator literal(String text) {
		return super.literal(text);
	}

	@Override
	public ParserCombinator notAKeyword(ParserCombinator parser) {
		return super.notAKeyword(parser);
	}

	@Override
	public ParserCombinator notNested(ParserCombinator parser) {
		return super.notNested(parser);
	}

	@Override
	public ParserCombinator nested(ParserCombinator parser) {
		return super.nested(parser);
	}

	@Override
	public ParserCombinator balancing(ParserCombinator... parsers) {
		return super.balancing(parsers);
	}

	@Override
	public ParserCombinator at(ParserCombinator parser) {
		return super.at(parser);
	}

	@Override
	public ParserCombinator keyword(String text) {
		return super.keyword(text);
	}

	@Override
	public ParserCombinator optional(ParserCombinator... parsers) {
		return super.optional(parsers);
	}

	@Override
	public ParserCombinator notEmpty(ParserCombinator parser) {
		return super.notEmpty(parser);
	}

	@Override
	public ParserCombinator ranged(int begin, int end) {
		return super.ranged(begin, end);
	}

	@Override
	protected ParserCombinator tree(String name) {
		return super.tree(name);
	}

	@Override
	protected ParserCombinator tree(String namespace, String name) {
		return super.tree(namespace, name);
	}

	@Override
	protected ParserCombinator tree(String name, ParserCombinator parser) {
		return super.tree(name, parser);
	}

	@Override
	protected ParserCombinator tree(String namespace, String name,
			ParserCombinator parser) {
		return super.tree(namespace, name, parser);
	}
}
