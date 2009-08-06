package koopa.grammars.generator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import koopa.grammars.generator.KGLexer;
import koopa.grammars.generator.KGParser;
import koopa.util.ASTFrame;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGG {

	private static final boolean SHOW_AST = false;

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String name = args[0];
		String pack = args[1];
		String path = args[2];

		if (!path.endsWith("/"))
			path += "/";

		String code = generate(name, pack, path);

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

	public static String generate(String name, String pack, String path)
			throws IOException, RecognitionException {

		if (!path.endsWith("/"))
			path += "/";

		Reader reader = new FileReader(path + name + ".kg");

		KGLexer lexer = new KGLexer(new ANTLRReaderStream(reader));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		KGParser parser = new KGParser(tokens);

		KGParser.koopa_return koopa = parser.koopa();

		CommonTree ast = (CommonTree) koopa.getTree();
		if (SHOW_AST) {
			new ASTFrame("KG", ast).setVisible(true);
		}

		// The following is for testing purposes.
		// CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		// KGTreeParser treeParser = new KGTreeParser(nodes);
		// treeParser.koopa();

		Reader templatesIn = new InputStreamReader(KGG.class
				.getResourceAsStream("/koopa/grammars/generator/koopa.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		// templates.emitDebugStartStopStrings(true);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGGenerator walker = new KGGenerator(nodes);
		walker.setTemplateLib(templates);

		String formatted = walker.koopa(name, pack,
				contents(path + name + ".kg-imports"),
				contents(path + name + ".kg-usercode")).toString();

		// System.out.println(formatted);

		return formatted;
	}

	private static String contents(String filename) {
		if (filename == null) {
			return null;
		}

		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer buffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				buffer.append(line);
				buffer.append('\n');
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
