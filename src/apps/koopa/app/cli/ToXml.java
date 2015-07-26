package koopa.app.cli;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.CobolFiles;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.ParsingCoordinator;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.trees.XMLSerializer;
import koopa.core.util.Tuple;

public class ToXml {

	private static final int BAD_USAGE = -1;
	private static final int SOURCE_DOES_NOT_EXIST = -2;

	private static final int IOEXCEPTION = -10;

	public static void main(String[] args) {

		SourceFormat format = SourceFormat.FIXED;
		boolean preprocess = false;
		List<String> copybookPaths = new LinkedList<String>();

		File source = null;
		File target = null;

		for (int i = 0; i < args.length; i++) {
			String option = args[i];

			if (option.startsWith("--")) {
				if (option.equals("--free-format")) {
					format = SourceFormat.FREE;

				} else if (option.equals("--preprocess")) {
					preprocess = true;

				} else {
					System.out.println("Unknown option: " + option);
					System.exit(BAD_USAGE);
				}

			} else if (option.startsWith("-")) {
				if (option.equals("-I")) {

					i += 1;
					if (i >= args.length) {
						System.out.println("Missing copybook path definition.");
						System.exit(BAD_USAGE);
					}

					copybookPaths.add(args[i]);

				} else {
					System.out.println("Unknown option: " + option);
					System.exit(BAD_USAGE);
				}

			} else if (source == null) {
				source = new File(option);

				if (!source.exists()) {
					System.out.println("Source path does not exist: " + source);
					System.exit(SOURCE_DOES_NOT_EXIST);
				}

			} else if (target == null) {
				target = new File(option);

			} else {
				System.out.println("Usage: ToXml [--free-format] "
						+ "[--preprocess -I <copyboopath>] "
						+ "<source-path> <target-path>");
				System.exit(BAD_USAGE);
			}
		}

		ToXml toXml = new ToXml(format, preprocess, copybookPaths);
		toXml.process(source, target);
	}

	private final ParsingCoordinator coordinator;

	public ToXml(SourceFormat format, boolean preprocessing,
			List<String> copybookPaths) {
		this.coordinator = new ParsingCoordinator();
		coordinator.setFormat(format);
		coordinator.setPreprocessing(preprocessing);

		for (String path : copybookPaths)
			coordinator.addCopybookPath(new File(path));
	}

	private void process(File source, File target) {
		if (source.isFile()) {
			toXml(source, target);

		} else if (source.isDirectory()) {
			File[] files = source
					.listFiles(CobolFiles.getFilenameFilter(false));

			for (File fileInFolder : files) {
				System.out.println(fileInFolder.getPath());
				process(fileInFolder, new File(target, fileInFolder.getName()));
			}
		}
	}

	private void toXml(File source, File target) {
		System.out.println("Processing " + source);

		String targetPath = target.getPath();
		int dot = targetPath.lastIndexOf('.');
		if (dot < 0)
			targetPath = targetPath + ".xml";
		else
			targetPath = targetPath.substring(0, dot) + ".xml";

		target = new File(targetPath);
		System.out.println("Writing XML to " + target);

		File targetFolder = target.getParentFile();
		if (targetFolder != null && !targetFolder.exists())
			targetFolder.mkdirs();

		ParseResults results = null;

		try {
			results = coordinator.parse(source);

		} catch (IOException e) {
			System.out.println("IOException while reading " + source);
			System.exit(IOEXCEPTION);
		}

		Parse parse = results.getParse();

		if (parse.hasErrors())
			for (Tuple<Token, String> error : parse.getErrors())
				System.out.println("Error: " + error.getFirst() + " "
						+ error.getSecond());

		if (parse.hasWarnings())
			for (Tuple<Token, String> warning : parse.getWarnings())
				System.out.println("Warning: " + warning.getFirst() + " "
						+ warning.getSecond());

		if (!results.isValidInput()) {
			System.out.println("Could not parse " + source);
			return;
		}

		final Tree ast = results.getParse().getTarget(KoopaTreeBuilder.class)
				.getTree();

		try {
			XMLSerializer.serialize(ast, target);

		} catch (IOException e) {
			System.out.println("IOException while writing " + target);
			System.out.println(e.getMessage());
			System.exit(IOEXCEPTION);
		}
	}
}
