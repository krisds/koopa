package koopa.examples.basic;

import java.io.StringReader;
import java.util.List;

import koopa.app.components.astview.ASTFrame;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.parser.CobolParser;
import koopa.core.data.Token;
import koopa.core.parsers.Parser;
import koopa.core.sources.Source;
import koopa.core.treeparsers.Tree;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.TreeBuildDirectingSink;

public class ParseString {

	public static void main(String[] args) {
		String text = "ZERO OF NINE";

		CobolGrammar grammar = new CobolGrammar();
		Parser identifier = grammar.identifier();

		List<Tree> asts = getCobolAST(text, identifier);
		for (Tree ast : asts)
			new ASTFrame(text, ast).setVisible(true);
	}

	private static List<Tree> getCobolAST(String text, Parser identifier) {
		StringReader reader = new StringReader(text);

		CobolParser parser = new CobolParser();
		Source<Token> source = parser.getNewTokenizationStage(reader);

		KoopaTreeBuilder builder = new KoopaTreeBuilder();
		TreeBuildDirectingSink treeBuilder = new TreeBuildDirectingSink(
				builder, false);

		boolean accepts = identifier.accepts(source, treeBuilder);

		if (accepts)
			return builder.getTrees();
		else
			return null;
	}

}
