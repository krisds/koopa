package koopa.core.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import koopa.core.grammars.generator.KGLexer;
import koopa.core.grammars.generator.KGParser;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public final class KGUtil {

	private KGUtil() {
	}

	private static final boolean SHOW_AST = false;

	public static CommonTree getKoopaAST(File file) throws IOException,
			RecognitionException {

		// System.out.println("Reading " + file);
		Reader reader = new FileReader(file);

		KGLexer lexer = new KGLexer(new ANTLRReaderStream(reader));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		KGParser parser = new KGParser(tokens);

		KGParser.koopa_return koopa = parser.koopa();

		CommonTree ast = (CommonTree) koopa.getTree();
		if (SHOW_AST)
			new ASTFrame("KG", ast).setVisible(true);

		return ast;
	}

	public static boolean isTreeGrammar(CommonTree ast) {
		if (ast.getChildCount() < 1)
			return false;

		CommonTree meta = (CommonTree) ast.getChild(0);
		if (!"META".equalsIgnoreCase(meta.getText()))
			return false;
		if (meta.getChildCount() < 1)
			return false;

		CommonTree tree = (CommonTree) meta.getChild(0);
		return "TREE".equalsIgnoreCase(tree.getText());
	}
}
