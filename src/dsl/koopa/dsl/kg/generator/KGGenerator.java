package koopa.dsl.kg.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import koopa.core.trees.Tree;
import koopa.core.util.Files;
import koopa.templates.TemplateLoader;

public class KGGenerator {

	private static final Generation GRAMMAR_TEMPLATE = new Generation(
			TemplateLoader.fromResource(KGGenerator.class,
					"/koopa/dsl/kg/generator/grammar.template"));

	public static void translate(File grammarFile, Tree ast) {
		try {
			String code = GRAMMAR_TEMPLATE.generate(grammarFile, ast);

			File path = grammarFile.getParentFile();
			File java = new File(path, Files.getName(grammarFile)
					+ "Grammar.java");

			System.out.println("Generating " + java);

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
