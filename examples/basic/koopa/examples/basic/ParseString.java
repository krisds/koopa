package koopa.examples.basic;

import java.io.StringReader;
import java.util.List;

import koopa.cobol.CobolTokens;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.trees.ui.TreeFrame;

public class ParseString {

	public static void main(String[] args) {
		String text = "ONE OF NINE";

		CobolGrammar grammar = new CobolGrammar();
		ParserCombinator identifier = grammar.identifier();

		List<Tree> asts = getCobolAST(text, SourceFormat.FREE, grammar,
				identifier);
		for (Tree ast : asts)
			new TreeFrame(text, ast).setVisible(true);
	}

	private static List<Tree> getCobolAST(String text, SourceFormat format,
			CobolGrammar grammar, ParserCombinator identifier) {

		StringReader reader = new StringReader(text);

		Source source = CobolTokens
				.getNewSource(reader, grammar, format);

		Parse parse = Parse.of(source).to(new KoopaTreeBuilder(grammar));
		boolean accepts = identifier.accepts(parse);

		if (!accepts)
			return null;

		KoopaTreeBuilder builder = parse.getTarget(KoopaTreeBuilder.class);
		return builder.getTrees();
	}
}
