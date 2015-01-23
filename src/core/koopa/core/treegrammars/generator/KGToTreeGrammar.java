package koopa.core.treegrammars.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import koopa.core.KGG;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGToTreeGrammar {

	public static void main(String[] args) {
		KGG.main(args);
	}

	public static void translate(File grammarFile, CommonTree ast) {
		try {
			String code = generate(grammarFile, ast);

			File path = grammarFile.getParentFile();
			File java = new File(path, grammarFile.getName().replace(".kg",
					"TreeGrammar.java"));

			System.out.println("Generating " + java);
			FileWriter writer = new FileWriter(java);
			writer.append(code);
			writer.close();
			System.out.println("Generation complete.");

		} catch (IOException e) {
			System.out.println("Generation failed.");
			e.printStackTrace();

		} catch (RecognitionException e) {
			System.out.println("Generation failed.");
			e.printStackTrace();
		}
	}

	private static String generate(File grammarFile, CommonTree ast)
			throws RecognitionException, IOException {
		File path = grammarFile.getParentFile();

		// Each grammar should have an associated properties file containing
		// some extra info needed for creating a valid Java class. We don't make
		// this part of the actual grammar file because we want to keep any
		// native stuff out of there.
		Properties meta = new Properties();

		File propertiesFile = new File(path, grammarFile.getName().replace(
				".kg", ".properties"));
		meta.load(new FileInputStream(propertiesFile));

		// One of the things the properties file should define are all the
		// required imports. We collect them here into actual valid Java import
		// statements.
		StringBuilder imports = new StringBuilder();
		for (String key : meta.stringPropertyNames()) {
			if (key.startsWith("import.")) {
				String importName = key.substring("import.".length());
				String packageName = meta.getProperty(key);

				imports.append("import ");
				imports.append(packageName);
				imports.append(".");
				imports.append(importName);
				imports.append(";\n");

			} else if (key.startsWith("static.")) {
				String importName = key.substring("static.".length());
				String packageName = meta.getProperty(key);

				imports.append("import static ");
				imports.append(packageName);
				imports.append(".");
				imports.append(importName);
				imports.append(";\n");
			}
		}

		return generateTreeParser(ast, meta, imports.toString());
	}

	private static String generateTreeParser(CommonTree ast, Properties meta,
			String imports) throws RecognitionException, IOException {

		Reader templatesIn = new InputStreamReader(
				KGToTreeGrammar.class
						.getResourceAsStream("/koopa/core/treegrammars/generator/treegrammar.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		TreeGrammarGenerator walker = new TreeGrammarGenerator(nodes);
		walker.setTemplateLib(templates);

		String grammar = walker.koopa(meta, imports).toString();
		return grammar;
	}
}
