package koopa.app.cli;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.app.ApplicationConfig;
import koopa.cobol.CobolFiles;
import koopa.cobol.CobolProject;
import koopa.cobol.parser.CobolParser;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.util.CopybookPaths;
import koopa.core.data.Token;
import koopa.core.parsers.Messages;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.trees.XMLSerializer;
import koopa.core.util.Tuple;

public class ToXml {

	private static final int BAD_USAGE = -1;

	private static final int IOEXCEPTION = -10;

	public static void main(String[] args) {

		final CommandLineOptions options;
		try {
			options = new CommandLineOptions(args);

		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.exit(BAD_USAGE);
			return;
		}

		ToXml toXml = new ToXml(options.getFormat(), options.isPreprocess(),
				options.getCopybookPaths());

		List<String> other = options.getOther();
		if (other.size() != 2) {
			System.err.println("Usage: [--free-format] "
					+ "[--preprocess -I <copybookpath>] <source> <target>");
			System.exit(BAD_USAGE);
			return;
		}

		File source = new File(other.get(0));
		File target = new File(other.get(1));
		toXml.process(source, target);
	}

	private final CobolParser parser;

	public ToXml(SourceFormat format, boolean preprocessing,
			List<String> copybookPaths) {

		final CobolProject project = ApplicationConfig.getANewProject();

		project.setDefaultFormat(format);
		project.setDefaultPreprocessing(preprocessing);

		if (!(project instanceof CopybookPaths)) {
			System.err.println(
					"Defined copybook paths, but this project doesn't accept them: "
							+ project.getClass());
			System.exit(BAD_USAGE);
		}

		for (String path : copybookPaths)
			((CopybookPaths) project).addCopybookPath(new File(path));

		this.parser = new CobolParser();
		this.parser.setProject(project);
		// We need the tree to dump it.
		this.parser.setBuildTrees(true);
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
			results = parser.parse(source);

		} catch (IOException e) {
			System.out.println("IOException while reading " + source);
			System.exit(IOEXCEPTION);
		}

		final Messages messages = results.getParse().getMessages();

		if (messages.hasErrors())
			for (Tuple<Token, String> error : messages.getErrors())
				System.out.println(
						"Error: " + error.getFirst() + " " + error.getSecond());

		if (messages.hasWarnings())
			for (Tuple<Token, String> warning : messages.getWarnings())
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
