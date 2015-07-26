package koopa.dsl.kg.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.dsl.kg.grammar.KGGrammar;
import koopa.dsl.kg.source.KGTokens;

public final class KGUtil {

	private KGUtil() {
	}

	public static Tree getAST(File input) throws IOException {
		final Source<Token> source = KGTokens.getNewSource(//
				input.getName(), new FileReader(input));

		final KGGrammar kg = new KGGrammar();

		final Parse parse = Parse.of(source).to(new KoopaTreeBuilder(kg));

		boolean accepts = kg.grammar().accepts(parse);

		if (!accepts) {
			System.out.println("Parse failed.");
			return null;
		}

		final KoopaTreeBuilder builder = parse
				.getTarget(KoopaTreeBuilder.class);
		Tree ast = builder.getTree();

		return ast;
	}

	public static boolean isTreeGrammar(Tree ast) {
		return ast.getDescendant("header", "tree") != null;
	}
}
