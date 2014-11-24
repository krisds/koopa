package koopa.core.trees.antlr.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import koopa.core.grammars.generator.KGUtil;
import koopa.core.trees.antlr.ANTLRTokens;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class KGToANTLR {

	public static void main(String[] args) throws IOException,
			RecognitionException {

		String name = args[0];
		String path = args[1];

		File outputPath = new File(path, "antlr/");

		// Each grammar should have an associated properties file containing
		// some extra info needed for creating a valid Java class. We don't make
		// this part of the actual grammar file because we want to keep any
		// native stuff out of there.
		Properties meta = new Properties();
		meta.load(new FileInputStream(new File(path, name + ".properties")));

		List<String> extraTokens = new ArrayList<String>();
		StringBuilder treeParsers = new StringBuilder();

		for (String key : meta.stringPropertyNames()) {
			if (!key.startsWith("antlr."))
				continue;

			String token = key.substring("antlr.".length());
			String rule = meta.getProperty(key);

			extraTokens.add(token);

			treeParsers.append(token);
			treeParsers.append(" : ");
			treeParsers.append(rule);
			treeParsers.append(" ;\n\n");
		}

		String pack = meta.getProperty("package") + ".antlr";

		CommonTree ast = KGUtil.getKoopaAST(new File(path, name + ".kg"));

		// TODO How to inherit the (partial) tree parsers ?? Do they still get
		// compiled ??

		if (ast != null) {
			// TODO Split up these two targets into two separate applications.
			// E.g. for the preprocessor we're interested in the tokens but not
			// in the tree parser.
			generateTokens(ast, extraTokens, new File(path), new File(
					outputPath, name + ".tokens"));
			generateTreeParser(ast, name, pack, treeParsers.toString(),
					new File(outputPath, name + "TreeParser.g"));
		}
	}

	public static void generateTokens(CommonTree ast, List<String> extraTokens,
			File path, File file) throws IOException, RecognitionException {

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGToANTLRTokens toTokens = new KGToANTLRTokens(nodes);
		toTokens.setPath(path);
		toTokens.koopa();

		for (String extraToken : extraTokens) {
			String trimmed = extraToken.trim();
			if (trimmed.length() > 0)
				toTokens.node(trimmed);
		}

		ANTLRTokens types = toTokens.getTokenTypes();
		// System.out.println(types);

		System.out.println("Generating " + file);
		FileWriter writer = new FileWriter(file);
		writer.append(types.toString());
		writer.close();
	}

	public static void generateTreeParser(CommonTree ast, String name,
			String pack, String usercode, File file)
			throws RecognitionException, IOException {
		Reader templatesIn = new InputStreamReader(
				KGToANTLR.class
						.getResourceAsStream("/koopa/core/trees/antlr/generator/treegrammar.stg"));
		StringTemplateGroup templates = new StringTemplateGroup(templatesIn,
				DefaultTemplateLexer.class);

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		KGToANTLRTreeGrammar walker = new KGToANTLRTreeGrammar(nodes);
		walker.setTemplateLib(templates);

		String grammar = walker.koopa(name, pack, usercode).toString();

		System.out.println("Generating " + file);
		// System.out.println(grammar);
		FileWriter writer = new FileWriter(file);
		writer.append(grammar);
		writer.close();
	}
}
