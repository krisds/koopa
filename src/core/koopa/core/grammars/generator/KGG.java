package koopa.core.grammars.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import koopa.core.util.Util;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGG {

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String name = args[0];
		String path = args[1];

		if (!path.endsWith("/"))
			path += "/";

		String code = generate(name, path);

		try {
			System.out.println("Generating " + path + name + "Grammar.java");
			FileWriter writer = new FileWriter(path + name + "Grammar.java");
			writer.append(code);
			writer.close();
			System.out.println("Generation complete.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Generation failed.");
			e.printStackTrace();
		}
	}

	public static String generate(String name, String path) throws IOException,
			RecognitionException {

		CommonTree ast = KGUtil.getKoopaAST(new File(path, name + ".kg"));

		// The following is for testing purposes.
		// CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		// KGTreeParser treeParser = new KGTreeParser(nodes);
		// treeParser.koopa();

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

		// We can then throw everything to the StringTemplate processor.

		Reader templatesIn = new InputStreamReader(
				KGG.class
						.getResourceAsStream("/koopa/core/grammars/generator/koopa.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		// templates.emitDebugStartStopStrings(true);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGGenerator walker = new KGGenerator(nodes);
		walker.setTemplateLib(templates);

		String natives = null;
		if ((new File(path + name + ".natives")).exists())
			natives = Util.contents(path + name + ".natives");

		String formatted = walker.koopa(meta, imports.toString(), natives)
				.toString();

		return formatted;
	}
}
