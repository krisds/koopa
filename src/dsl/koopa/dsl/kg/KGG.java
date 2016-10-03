package koopa.dsl.kg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.core.grammars.KoopaGrammar;
import koopa.core.trees.Tree;
import koopa.core.util.Files;
import koopa.dsl.kg.generator.KGGenerator;
import koopa.dsl.kg.util.KGUtil;

/**
 * Main class to generate {@linkplain KoopaGrammar}s from .kg source files.
 */
public class KGG {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No path given.");
			System.exit(-1);
		}
		
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
		final List<File> sources = Files.listFilesRecursively(folder,
				KGUtil.getFilenameFilter());
		for (File file : sources)
			translate(file);
	}

	public static void translate(File file) {
		try {
			System.out.println("Reading " + file + "...");
			Tree ast = KGUtil.getAST(file);
			KGGenerator.translate(file, ast);

		} catch (IOException e) {
			System.err.println("Failed to parse the grammar...");
			e.printStackTrace();
		}
	}
}
