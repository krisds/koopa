package koopa.dsl.kg;

import java.io.File;
import java.io.IOException;

import koopa.core.trees.Tree;
import koopa.dsl.kg.generator.KGGenerator;
import koopa.dsl.kg.util.KGUtil;

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
			Tree ast = KGUtil.getAST(file);

			if (KGUtil.isTreeGrammar(ast)) {
				System.out.println("This is a tree grammar...");
				KGGenerator.translateTreeGrammar(file, KGUtil.getAST(file));

			} else {
				System.out.println("This is a regular grammar...");
				KGGenerator.translate(file, KGUtil.getAST(file));
			}

		} catch (IOException e) {
			System.err.println("Failed to parse the grammar...");
			e.printStackTrace();
		}
	}
}
