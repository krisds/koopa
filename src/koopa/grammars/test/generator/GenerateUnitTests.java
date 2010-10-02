package koopa.grammars.test.generator;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
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

public class GenerateUnitTests {

	private static final boolean SHOW_AST = false;

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String target = args[0];

		process(new File(target));
	}

	private static void process(File file) {
		if (!file.exists()) {
			return;

		} else if (file.isDirectory()) {
			File[] files = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".stage");
				}
			});

			for (File stage : files) {
				process(stage);
			}

		} else if (file.getName().endsWith(".stage")) {
			try {
				generate(file);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (RecognitionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void generate(File file) throws IOException,
			RecognitionException {

		System.out.println("Reading " + file);

		Reader reader = new FileReader(file);

		StageLexer lexer = new StageLexer(new ANTLRReaderStream(reader));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		StageParser parser = new StageParser(tokens);

		StageParser.stage_return koopa = parser.stage();

		CommonTree ast = (CommonTree) koopa.getTree();
		if (SHOW_AST) {
			new ASTFrame("Stage " + file.getName(), ast).setVisible(true);
		}

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		StageTreeParser treeParser = new StageTreeParser(nodes);
		treeParser.stage();

		Reader templatesIn = new InputStreamReader(
				GenerateUnitTests.class
						.getResourceAsStream("/koopa/grammars/test/generator/stage.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		// templates.emitDebugStartStopStrings(true);

		nodes = new CommonTreeNodeStream(ast);
		StageGenerator walker = new StageGenerator(nodes);
		walker.setTemplateLib(templates);

		String name = file.getName();
		name = name.substring(0, name.length() - ".stage".length());

		String formatted = walker.stage(name).st.toString(80);

		File outputFile = new File(file.getParent(), name + "Test.java");

		System.out.println("Writing " + outputFile);

		FileWriter fw = new FileWriter(outputFile);
		fw.write(formatted);
		fw.close();
	}
}
