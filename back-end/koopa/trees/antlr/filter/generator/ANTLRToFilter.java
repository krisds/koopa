package koopa.trees.antlr.filter.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class ANTLRToFilter {
	public static void main(String args[]) {
		if (args == null || args.length == 0) {
			System.out.println("Please specify a target.");
			System.exit(-1);
		}

		try {
			generate(new File(args[0]));

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IllegalArgumentException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generate(File propertiesFile)
			throws FileNotFoundException, IOException, IllegalArgumentException {

		if (!propertiesFile.exists() || !propertiesFile.isFile()) {
			throw new IllegalArgumentException("Please specify a legal target.");
		}

		String name = propertiesFile.getName().replace(".filter.properties",
				".g");

		File input = new File(propertiesFile.getParentFile(), name);
		if (!input.exists() || !input.isFile()) {
			throw new IllegalArgumentException(
					"Could not find the grammar corresponding to the filter properties file: "
							+ propertiesFile);
		}

		Properties properties = new Properties();
		properties.load(new FileInputStream(propertiesFile));

		String pack = properties.getProperty("package");

		if (pack == null) {
			throw new IllegalArgumentException(
					"Incomplete specification in filter properties.");
		}

		generate(input, pack);
	}

	public static void generate(File input, String pack) {
		System.out.println("Processing " + input);

		FileReader reader = null;
		FileWriter writer = null;
		try {
			// 1. Basic parsing step; building AST.

			reader = new FileReader(input);

			ANTLRv3Lexer lexer = new ANTLRv3Lexer(new ANTLRReaderStream(reader));

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			ANTLRv3Parser parser = new ANTLRv3Parser(tokens);

			ANTLRv3Parser.grammarDef_return r = parser.grammarDef();

			CommonTree t = (CommonTree) r.getTree();

			// System.out.println(t.toStringTree());

			// 2. Verifying the AST.

			CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);

			ANTLRv3Tree walker = new ANTLRv3Tree(nodes);

			walker.grammarDef();

			// 3. Code generation step.

			Reader templatesIn = new InputStreamReader(
					ANTLRToFilter.class
							.getResourceAsStream("/koopa/trees/antlr/filter/generator/filter.stg"));

			StringTemplateGroup templates = new StringTemplateGroup(
					templatesIn, DefaultTemplateLexer.class);

			nodes = new CommonTreeNodeStream(t);

			ANTLRv3TreeFilter filterMaker = new ANTLRv3TreeFilter(nodes);

			filterMaker.setTemplateLib(templates);

			String code = filterMaker.grammarDef(pack).toString();

			// 4. Saving the result.

			String name = input.getName().replace(".g", "Filter.java");
			// System.out.println(name);

			File output = new File(input.getParentFile(), name);
			System.out.println("Writing output to " + output);

			writer = new FileWriter(output);
			writer.append(code);
			writer.close();

			System.out.println("Code generation complete.");

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);

		} catch (RecognitionException e) {
			e.printStackTrace();
			System.exit(-1);

		} catch (UnsupportedSyntaxException e) {
			e.printStackTrace();
			System.exit(-1);

		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
