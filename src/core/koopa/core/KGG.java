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

		File path = new File(args[1]);

		if (!path.exists() || !path.isDirectory()) {
			System.err.println("Not a folder: " + args[1]);
			System.exit(-1);
		}

		File file = new File(path, args[0] + ".kg");
		if (!file.exists() || !file.isFile()) {
			System.err.println("Not a file: " + args[1]);
			System.exit(-1);
		}

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
