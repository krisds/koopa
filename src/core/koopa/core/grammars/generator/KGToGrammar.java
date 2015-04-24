package koopa.core.grammars.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import koopa.core.KGG;
import koopa.core.util.Files;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGToGrammar {

	public static void main(String[] args) {
		KGG.main(args);
	}

	public static String generate(File grammarFile, CommonTree ast)
			throws IOException, RecognitionException {

		File path = grammarFile.getParentFile();

		// The following is for testing purposes.
		// CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		// KGTreeParser treeParser = new KGTreeParser(nodes);
		// treeParser.koopa();

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

		// The grammar may need some native code to support it. One way of
		// doing that is by defining a ".natives" file which contains some
		// extra code to be injected in the final grammar.
		File nativesFile = new File(path, grammarFile.getName().replace(".kg",
				".natives"));

		String natives = null;
		if (nativesFile.exists())
			natives = Files.getText(nativesFile);

		// We can then throw everything to the StringTemplate processor.
		Reader templatesIn = new InputStreamReader(
				KGToGrammar.class
						.getResourceAsStream("/koopa/core/grammars/generator/koopa.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		// templates.emitDebugStartStopStrings(true);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGGenerator walker = new KGGenerator(nodes);
		walker.setTemplateLib(templates);

		String formatted = walker.koopa(meta, imports.toString(), natives)
				.toString();

		return formatted;
	}

	public static void translate(File grammarFile, CommonTree ast) {
		try {
			String code = generate(grammarFile, ast);

			File path = grammarFile.getParentFile();
			File java = new File(path, grammarFile.getName().replace(".kg",
					"Grammar.java"));

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
}
