package koopa.parsers.test;

import koopa.parsers.Block;
import koopa.parsers.FutureParser;
import koopa.parsers.KoopaGrammar;
import koopa.parsers.Parser;

public class TestGrammar extends KoopaGrammar {
	public Parser apply(Block func) {
		return super.apply(func);
	}

	public Parser assign(String name, Parser parser) {
		return super.assign(name, parser);
	}

	public Parser choice(Parser... parsers) {
		return super.choice(parsers);
	}

	public Parser star(Parser parser) {
		return super.star(parser);
	}

	public Parser optional(Parser parser) {
		return super.optional(parser);
	}

	public Parser permuted(Parser... parsers) {
		return super.permuted(parsers);
	}

	public Parser returning(String name) {
		return super.returning(name);
	}

	public Parser token(String text) {
		return super.token(text);
	}

	public FutureParser scoped(String name, Parser parser) {
		FutureParser future = super.scoped(name);
		future.setParser(parser);
		return future;
	}

	public Parser sequence(Parser... parsers) {
		return super.sequence(parsers);
	}

	public Parser skipto(Parser parser) {
		return super.skipto(parser);
	}
}
