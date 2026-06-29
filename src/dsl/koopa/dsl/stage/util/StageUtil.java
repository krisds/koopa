package koopa.dsl.stage.util;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Random;

import koopa.core.parsers.Parse;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.dsl.stage.grammar.StageGrammar;
import koopa.dsl.stage.source.StageTokens;

public final class StageUtil {

	public static final boolean RANDOMIZE_TESTS;
	public static final Random RANDOMIZER;
	public static final int RANDOMIZER_LIMIT;

	static {
		RANDOMIZE_TESTS = "true".equalsIgnoreCase(System.getProperty(
				"koopa.tests.random", "false"));

		final String seed = System.getProperty("koopa.tests.random.seed");
		if (!RANDOMIZE_TESTS)
			RANDOMIZER = null;
		else if (seed == null)
			RANDOMIZER = new Random();
		else
			RANDOMIZER = new Random(seed.hashCode());

		final String limit = System.getProperty("koopa.tests.random.limit");
		if (!RANDOMIZE_TESTS)
			RANDOMIZER_LIMIT = 1;
		else if (limit == null)
			RANDOMIZER_LIMIT = 2;
		else
			RANDOMIZER_LIMIT = Integer.parseInt(limit);

		if (RANDOMIZE_TESTS) {
			System.out.println("Randomizing grammar tests, up to "
					+ RANDOMIZER_LIMIT + " per test definition.");
		}
	}

	private StageUtil() {
	}

	public static Tree getAST(File input) throws IOException {
		return getAST(input, false);
	}

	public static Tree getAST(File input, boolean quiet) throws IOException {
		try (final FileReader reader = new FileReader(input)) {
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
			
		}
	}

	public static FilenameFilter getFilenameFilter() {
		return (dir, name) -> name.endsWith(".stage");
	}
}
