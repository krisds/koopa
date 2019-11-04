package koopa.dsl.stage.util;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import koopa.core.parsers.Parse;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.dsl.stage.grammar.StageGrammar;
import koopa.dsl.stage.source.StageTokens;

public final class StageUtil {

	private StageUtil() {
	}

	public static Tree getAST(File input) throws IOException {
		return getAST(input, false);
	}

	public static Tree getAST(File input, boolean quiet) throws IOException {
		FileReader reader = null;
		try {
			reader = new FileReader(input);
			final Source source = StageTokens.getNewSource(//
					input.getName(), reader);

			final StageGrammar kg = new StageGrammar();

			final Parse parse = Parse.of(source).to(new KoopaTreeBuilder(kg));
			parse.getTrace().quiet(quiet);

			boolean accepts = kg.stage().accepts(parse);

			if (!accepts) {
				System.out.println(
						"Parse failed. Got up to: " + parse.getFinalPosition());
				return null;
			}

			final KoopaTreeBuilder builder = parse
					.getTarget(KoopaTreeBuilder.class);
			Tree ast = builder.getTree();

			return ast;
			
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public static FilenameFilter getFilenameFilter() {
		return (dir, name) -> name.endsWith(".stage");
	}
}
