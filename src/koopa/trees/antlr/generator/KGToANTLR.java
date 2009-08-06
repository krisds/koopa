package koopa.trees.antlr.generator;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import koopa.grammars.generator.KGLexer;
import koopa.grammars.generator.KGParser;
import koopa.trees.antlr.TokenTypes;
import koopa.util.ASTFrame;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGToANTLR {

	private static final boolean SHOW_AST = false;

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String name = args[0];
		String pack = args[1];
		String path = args[2];
		String outputPath = args[3];

		if (!path.endsWith("/"))
			path += "/";

		if (!outputPath.endsWith("/"))
			outputPath += "/";

		CommonTree ast = getKoopaAST(path + name + ".kg");

		if (ast != null) {
			generateTokens(ast, contents(path + name + ".antlr-tokens"),
					outputPath + name + ".tokens");
			generateTreeParser(ast, name, pack, contents(path + name
					+ ".antlr-rules"), outputPath + name + "TreeParser.g");
		}
	}

	private static CommonTree getKoopaAST(String filename)
			throws FileNotFoundException, IOException, RecognitionException {
		System.out.println("Reading " + filename);
		Reader reader = new FileReader(filename);

		KGLexer lexer = new KGLexer(new ANTLRReaderStream(reader));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		KGParser parser = new KGParser(tokens);

		KGParser.koopa_return koopa = parser.koopa();

		CommonTree ast = (CommonTree) koopa.getTree();
		if (SHOW_AST) {
			new ASTFrame("KG", ast).setVisible(true);
		}
		return ast;
	}

	public static void generateTokens(CommonTree ast, String extraTokens,
			String filename) throws IOException, RecognitionException {

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGToANTLRTokens toTokens = new KGToANTLRTokens(nodes);
		toTokens.koopa();

		for (String extraToken : extraTokens.split("\n")) {
			String trimmed = extraToken.trim();
			if (trimmed != null && trimmed.length() > 0) {
				toTokens.node(trimmed);
			}
		}

		TokenTypes types = toTokens.getTokenTypes();
		// System.out.println(types);

		System.out.println("Generating " + filename);
		FileWriter writer = new FileWriter(filename);
		writer.append(types.toString());
		writer.close();
	}

	public static void generateTreeParser(CommonTree ast, String name,
			String pack, String usercode, String filename)
			throws RecognitionException, IOException {
		Reader templatesIn = new InputStreamReader(
				KGToANTLR.class
						.getResourceAsStream("/koopa/trees/antlr/generator/treegrammar.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGToANTLRTreeGrammar walker = new KGToANTLRTreeGrammar(nodes);
		walker.setTemplateLib(templates);

		String grammar = walker.koopa(name, pack, usercode).toString();

		System.out.println("Generating " + filename);
		// System.out.println(grammar);
		FileWriter writer = new FileWriter(filename);
		writer.append(grammar);
		writer.close();
	}

	private static String contents(String filename) {
		if (filename == null) {
			return null;
		}

		System.out.println("Reading " + filename);

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
