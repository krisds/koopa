package koopa.dsl.kg.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import koopa.core.trees.Tree;
import koopa.templates.TemplateLoader;

public class KGGenerator {

	private static final Generation REGULAR_GRAMMAR = new Generation(
			TemplateLoader.fromResource(KGGenerator.class,
					"/koopa/dsl/kg/generator/regular_grammar.template"));

	private static final Generation TREE_GRAMMAR = new Generation(
			TemplateLoader.fromResource(KGGenerator.class,
					"/koopa/dsl/kg/generator/tree_grammar.template"));

	public static void translate(File grammarFile, Tree ast) {
		try {
			String code = REGULAR_GRAMMAR.generate(grammarFile, ast);

			File path = grammarFile.getParentFile();
			File java = new File(path, grammarFile.getName().replace(".kg",
					"Grammar.java"));

			System.out.println("Generating " + java);
			// System.out.println(code);

			FileWriter writer = new FileWriter(java);
			writer.append(code);
			writer.close();

			System.out.println("Generation complete.");

		} catch (IOException e) {
			System.out.println("Generation failed.");
			e.printStackTrace();
		}
	}

	public static void translateTreeGrammar(File grammarFile, Tree ast) {
		try {
			String code = TREE_GRAMMAR.generate(grammarFile, ast);

			File path = grammarFile.getParentFile();
			File java = new File(path, grammarFile.getName().replace(".kg",
					"TreeGrammar.java"));

			System.out.println("Generating " + java);
			// System.out.println(code);

			FileWriter writer = new FileWriter(java);
			writer.append(code);
			writer.close();

			System.out.println("Generation complete.");

		} catch (IOException e) {
			System.out.println("Generation failed.");
			e.printStackTrace();
		}
	}
}
