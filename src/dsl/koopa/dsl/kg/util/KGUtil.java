package koopa.dsl.kg.util;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;

import koopa.core.parsers.Parse;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.dsl.kg.grammar.KGGrammar;
import koopa.dsl.kg.source.KGTokens;

public final class KGUtil {

	private KGUtil() {
	}

	/**
	 * Parse the contents of a grammar file, and return the syntax tree.
	 */
	public static Tree getAST(File input) throws IOException {
		try (Reader reader = new FileReader(input)) {
			return getAST(input.getName(), reader);
		}
	}

	/**
	 * Parse the contents of a {@linkplain Reader}, and return the syntax tree.
	 * The name you pass along will be used as a reference name for its
	 * contents.
	 */
	public static Tree getAST(String name, Reader reader) throws IOException {
		final Source source = KGTokens.getNewSource(name, reader);

		final KGGrammar kg = new KGGrammar();

		final Parse parse = Parse.of(source).to(new KoopaTreeBuilder(kg));

		final boolean accepts = kg.grammar().accepts(parse);

		if (!accepts) {
			System.out.println("Parse failed. Got up to: "
					+ parse.getFinalPosition());
			return null;
		}

		final KoopaTreeBuilder builder = parse
				.getTarget(KoopaTreeBuilder.class);
		return builder.getTree();
	}

	public static FilenameFilter getFilenameFilter() {
		return (dir, name) -> name.endsWith(".kg");
	}
}
