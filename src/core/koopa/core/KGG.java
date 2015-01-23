package koopa.core;

import java.io.File;
import java.io.IOException;

import koopa.core.grammars.generator.KGToGrammar;
import koopa.core.treegrammars.generator.KGToTreeGrammar;
import koopa.core.util.KGUtil;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class KGG {

	public static void main(String[] args) {

		File file = new File(args[0]);
		if (!file.exists()) {
			System.err.println("Not found: " + file);
			System.exit(-1);
		}

		if (file.isFile()) {
			translate(file);
			
		} else if (file.isDirectory()) {
			translateAllIn(file);
			
		} else {
			System.err.println("Not a file or folder: " + file);
			System.exit(-1);
		}
	}

	private static void translateAllIn(File folder) {
		File[] files = folder.listFiles();
		
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".kg"))
				translate(file);
			else if (file.isDirectory())
				translateAllIn(file);
		}
	}

	public static void translate(File file) {
		try {
			System.out.println("Reading " + file + "...");
			CommonTree ast = KGUtil.getKoopaAST(file);

			if (KGUtil.isTreeGrammar(ast)) {
				System.out.println("This is a tree grammar...");
				KGToTreeGrammar.translate(file, ast);

			} else {
				System.out.println("This is a regular grammar...");
				KGToGrammar.translate(file, ast);
			}

		} catch (IOException e) {
			System.err.println("Failed to parse the grammar...");
			e.printStackTrace();

		} catch (RecognitionException e) {
			System.err.println("Failed to parse the grammar...");
			e.printStackTrace();
		}
	}
}
