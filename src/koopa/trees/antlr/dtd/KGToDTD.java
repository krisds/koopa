package koopa.trees.antlr.dtd;

import java.io.FileNotFoundException;
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

public class KGToDTD {

	private static final boolean SHOW_AST = false;

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String name = args[0];
		String path = args[1];
		String outputPath = args[2];

		if (!path.endsWith("/"))
			path += "/";

		if (!outputPath.endsWith("/"))
			outputPath += "/";

		CommonTree ast = getKoopaAST(path + name + ".kg");

		if (ast != null) {
			generateDTD(ast, name, outputPath + name + ".dtd");
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

	public static void generateDTD(CommonTree ast, String name, String filename)
			throws RecognitionException, IOException {

		Reader templatesIn = new InputStreamReader(KGToDTD.class
				.getResourceAsStream("/koopa/trees/antlr/dtd/dtd.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGToDTDForSerializedANTLR walker = new KGToDTDForSerializedANTLR(nodes);
		walker.setTemplateLib(templates);

		String dtd = walker.koopa().toString();

		dtd = simplify(dtd);

		System.out.println("Generating " + filename);

		FileWriter writer = new FileWriter(filename);
		writer.append(dtd);
		writer.append('\n');
		writer.close();
	}

	private static String simplify(String dtd) {
		// This doesn't do a full analysis on what expressions can be
		// simplified, but it does take care of some of the more annoying
		// things.

		int len;

		do {
			len = dtd.length();
			// System.out.println("DTD length: " + len);

			dtd = dtd.replaceAll("t\\|(t\\|)+", "t\\|");
			dtd = dtd.replaceAll("t,(t,)+", "t\\+,");

			dtd = dtd.replaceAll("t\\|t\\)", "t\\)");

			dtd = dtd.replaceAll("\\(\\(t\\)", "\\(t");
			dtd = dtd.replaceAll("\\(t\\)\\)", "t\\)");
			dtd = dtd.replaceAll("\\(t\\),", "t,");
			dtd = dtd.replaceAll("\\(t\\)\\?", "t\\?");
			dtd = dtd.replaceAll("\\(t\\)\\+", "t\\+");
			dtd = dtd.replaceAll("\\(t\\)\\*", "t\\*");

			dtd = dtd.replaceAll("t\\+,t\\?", "t\\+");
			dtd = dtd.replaceAll("t\\?,t\\+", "t\\+");

		} while (len != dtd.length());

		return dtd;
	}
}
