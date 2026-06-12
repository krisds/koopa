package koopa.dsl.kg.grammar.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import koopa.core.trees.Tree;
import koopa.core.util.Files;
import koopa.dsl.kg.grammar.KGGrammar;
import koopa.dsl.kg.util.KGUtil;

/**
 * This test comes in handy when tweaking {@linkplain KGGrammar}, as it can
 * quickly be run from within the IDE without having to recompile everything.
 * <p>
 * In the full build you don't really need it as all grammar files will get
 * parsed and processed anyway.
 */
public class ParseIncludedGrammarsTest {

	public static List<File> getKGFiles() {
		return Files.listFilesRecursively(new File("src"),
				KGUtil.getFilenameFilter());
	}

	@TestFactory
	public Stream<DynamicTest> generateGrammarParsingTests() {
		List<File> sources = getKGFiles();

		if (sources == null || sources.isEmpty())
			throw new InternalError("No grammar files.");

		return sources.stream()
			.map(file -> DynamicTest.dynamicTest(
				file.getPath(),
				() -> kgShouldParse(file)
			));
	}

	private void kgShouldParse(File source) throws IOException {
		assertNotNull(source);

		final Tree ast = KGUtil.getAST(source);
		assertNotNull(ast);
	}
}
