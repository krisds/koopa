package koopa.examples.basic;

import java.io.StringReader;
import java.util.List;

import koopa.app.components.astview.ASTFrame;
import koopa.cobol.CobolTokens;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.Source;
import koopa.core.targets.Target;
import koopa.core.treeparsers.Tree;
import koopa.core.trees.KoopaTreeBuilder;

public class ParseString {

	public static void main(String[] args) {
		String text = "ONE OF NINE";

		CobolGrammar grammar = new CobolGrammar();
		ParserCombinator identifier = grammar.identifier();

		List<Tree> asts = getCobolAST(text, SourceFormat.FREE, identifier);
		for (Tree ast : asts)
			new ASTFrame(text, ast).setVisible(true);
	}

	private static List<Tree> getCobolAST(String text, SourceFormat format,
			ParserCombinator identifier) {

		StringReader reader = new StringReader(text);

		Source<Token> source = CobolTokens.getNewSource(reader, format);

		KoopaTreeBuilder builder = new KoopaTreeBuilder();
		Target<Data> target = builder.getTarget();

		boolean accepts = identifier.accepts(Parse.of(source, target));

		if (accepts)
			return builder.getTrees();
		else
			return null;
	}

}
