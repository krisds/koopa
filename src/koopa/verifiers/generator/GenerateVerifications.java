package koopa.verifiers.generator;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import koopa.util.ASTFrame;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class GenerateVerifications {

	private static final boolean SHOW_AST = false;

	public static void main(String[] args) throws IOException,
			RecognitionException {

		if (args == null || args.length < 3) {
			System.out
					.println("Please provide a name, package name and output folder.");
			System.exit(-9);
		}

		String name = args[0];
		String pack = args[1];
		String folder = args[2];

		File target = new File(folder);
		if (!target.exists() || !target.isDirectory()) {
			System.out.println("Please provide a valid output folder.");
			System.exit(-2);
		}

		File source = new File(folder + name + ".scoring");
		if (!source.exists() || !source.isFile()) {
			System.out.println("No valid scoring file found.");
			System.exit(-1);
		}

		generate(source, target, name, pack);
	}

	public static void generate(File source, File targetFolder, String name,
			String pack) throws IOException, RecognitionException {

		System.out.println("Reading " + source);

		Reader reader = new FileReader(source);

		ScoringLexer lexer = new ScoringLexer(new ANTLRReaderStream(reader));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		ScoringParser parser = new ScoringParser(tokens);

		ScoringParser.scoring_return scoring = parser.scoring();

		CommonTree ast = (CommonTree) scoring.getTree();
		if (SHOW_AST) {
			new ASTFrame("Scoring " + source.getName(), ast).setVisible(true);
		}

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		ScoringTreeParser treeParser = new ScoringTreeParser(nodes);
		treeParser.scoring();

		Reader templatesIn = new InputStreamReader(GenerateVerifications.class
				.getResourceAsStream("/koopa/verifiers/generator/scoring.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		// templates.emitDebugStartStopStrings(true);

		nodes = new CommonTreeNodeStream(ast);
		ScoringGenerator walker = new ScoringGenerator(nodes);
		walker.setTemplateLib(templates);

		String formatted = walker.scoring(name, pack).st.toString(80);
		// System.out.println(formatted);

		File outputFile = new File(targetFolder, name + "Verifier.java");

		System.out.println("Writing " + outputFile);

		FileWriter fw = new FileWriter(outputFile);
		fw.write(formatted);
		fw.close();
	}
}
