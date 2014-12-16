package koopa.core.treegrammars.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import koopa.core.grammars.generator.KGUtil;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGToTreeGrammar {

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String name = args[0];
		String path = args[1];

		File outputPath = new File(path, name + "TreeGrammar.java");

		// Each grammar should have an associated properties file containing
		// some extra info needed for creating a valid Java class. We don't make
		// this part of the actual grammar file because we want to keep any
		// native stuff out of there.
		Properties meta = new Properties();
		meta.load(new FileInputStream(new File(path, name + ".properties")));

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

		CommonTree ast = KGUtil.getKoopaAST(new File(path, name + ".kg"));

		if (ast != null)
			generateTreeParser(ast, meta, imports.toString(), outputPath);
	}

	public static void generateTreeParser(CommonTree ast, Properties meta,
			String imports, File file) throws RecognitionException, IOException {

		Reader templatesIn = new InputStreamReader(
				KGToTreeGrammar.class
						.getResourceAsStream("/koopa/core/treegrammars/generator/treegrammar.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		TreeGrammarGenerator walker = new TreeGrammarGenerator(nodes);
		walker.setTemplateLib(templates);

		String grammar = walker.koopa(meta, imports).toString();

		System.out.println("Generating " + file);
		// System.out.println(grammar);
		FileWriter writer = new FileWriter(file);
		writer.append(grammar);
		writer.close();
	}
}
