package koopa.core.grammars.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.grammars.Block;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.grammars.Opt;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parser;

/**
 * This class exposes all parser combinator methods for testing. It can be
 * configured with a list of Strings to be used as separators.
 */
public class TestGrammar extends KoopaGrammar {

	private final Set<String> separators;

	public TestGrammar(String... separators) {
		this.separators = new HashSet<String>(Arrays.asList(separators));
	}

	// ========================================================================

	@Override
	protected String getNamespace() {
		return "test";
	}

	@Override
	protected boolean isSeparator(String text) {
		return separators.contains(text);
	}

	@Override
	public boolean isProgramText(Token token) {
		return true;
	}

	@Override
	protected FutureParser scoped(String name) {
		return super.scoped(name);
	}

	@Override
	public Parser apply(Block func) {
		return super.apply(func);
	}

	@Override
	public Parser assign(String name, Parser parser) {
		return super.assign(name, parser);
	}

	@Override
	public Parser choice(Parser... parsers) {
		return super.choice(parsers);
	}

	@Override
	public Parser star(Parser parser) {
		return super.star(parser);
	}

	@Override
	protected Parser plus(Parser parser) {
		return super.plus(parser);
	}

	@Override
	public Parser optional(Parser parser) {
		return super.optional(parser);
	}

	@Override
	public Parser permuted(Parser... parsers) {
		return super.permuted(parsers);
	}

	@Override
	public Parser returning(String name) {
		return super.returning(name);
	}

	@Override
	public Parser token(String text) {
		return super.token(text);
	}

	@Override
	public Parser sequence(Parser... parsers) {
		return super.sequence(parsers);
	}

	@Override
	public Parser skipto(Parser parser) {
		return super.skipto(parser);
	}

	@Override
	protected Parser not(Parser parser) {
		return super.not(parser);
	}

	@Override
	protected Parser any() {
		return super.any();
	}

	@Override
	protected Parser tagged(Object tag) {
		return super.tagged(tag);
	}

	@Override
	protected Parser opt(Opt opt, Parser parser) {
		return super.opt(opt, parser);
	}

	@Override
	protected Parser limited(Parser target, Parser limiter) {
		return super.limited(target, limiter);
	}

	@Override
	protected Parser dispatched(String[] keys, Parser[] parsers) {
		return super.dispatched(keys, parsers);
	}
}
