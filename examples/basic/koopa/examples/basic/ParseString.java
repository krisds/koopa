package koopa.examples.basic;

import java.io.StringReader;
import java.util.List;

import koopa.cobol.CobolProject;
import koopa.cobol.CobolTokens;
import koopa.cobol.projects.BasicCobolProject;
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

		List<Tree> asts = getCobolAST(text);
		for (Tree ast : asts)
			new TreeFrame(text, ast).setVisible(true);
	}

	private static List<Tree> getCobolAST(String text) {

		final StringReader reader = new StringReader(text);

		final CobolProject project = new BasicCobolProject();
		project.setDefaultFormat(SourceFormat.FREE);

		final ParserCombinator identifier = project.getGrammar().identifier();

		final Source source = CobolTokens.getNewSource(reader, project);

		final Parse parse = Parse.of(source)
				.to(new KoopaTreeBuilder(project.getGrammar()));
		final boolean accepts = identifier.accepts(parse);

		if (!accepts)
			return null;

		final KoopaTreeBuilder builder = parse
				.getTarget(KoopaTreeBuilder.class);
		return builder.getTrees();
	}
}
