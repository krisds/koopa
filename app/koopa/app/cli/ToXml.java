package koopa.app.cli;

import java.io.File;
import java.io.IOException;

import koopa.app.parsers.ExtendedParserConfiguration;
import koopa.app.parsers.ParseResults;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokens.Token;
import koopa.trees.antlr.CommonTreeSerializer;
import koopa.util.Tuple;

import org.antlr.runtime.tree.CommonTree;

public class ToXml {

	private static final int BAD_USAGE = -1;
	private static final int FILE_DOES_NOT_EXIST = -2;
	private static final int IOEXCEPTION = -3;

	private static final int INPUT_IS_INVALID = 1;
	private static final int INPUT_IS_VALID = 0;

	public static void main(String[] args) {
		if (args == null || args.length < 2 || args.length > 3) {
			System.out
					.println("Usage: GetASTAsXML [--free-format] <cobol-input-file> <xml-output-file>");
			System.exit(BAD_USAGE);
		}

		SourceFormat format = SourceFormat.FIXED;
		String inputFilename = args[0];
		String outputFilename = args[1];

		if (args.length == 3) {
			String option = args[0];
			if (option.equals("--free-format")) {
				format = SourceFormat.FREE;

			} else {
				System.out.println("Unknown option: " + option);
				System.exit(BAD_USAGE);
			}

			inputFilename = args[1];
			outputFilename = args[2];
		}

		final File cobolFile = new File(inputFilename);
		if (!cobolFile.exists()) {
			System.out.println("Input file does not exist: " + cobolFile);
			System.exit(FILE_DOES_NOT_EXIST);
		}

		final ExtendedParserConfiguration parser = new ExtendedParserConfiguration();
		parser.setFormat(format);
		parser.setBuildTrees(true);

		ParseResults results = null;

		try {
			results = parser.parse(cobolFile);

		} catch (IOException e) {
			System.out.println("IOException while reading " + cobolFile);
			System.exit(IOEXCEPTION);
		}

		if (results.getErrorCount() > 0) {
			for (int i = 0; i < results.getErrorCount(); i++) {
				final Tuple<Token, String> error = results.getError(i);
				System.out.println("Error: " + error.getFirst() + " "
						+ error.getSecond());
			}
		}

		if (results.getWarningCount() > 0) {
			for (int i = 0; i < results.getWarningCount(); i++) {
				final Tuple<Token, String> warning = results.getWarning(i);
				System.out.println("Warning: " + warning.getFirst() + " "
						+ warning.getSecond());
			}
		}

		if (!results.isValidInput()) {
			System.out.println("Could not parse " + cobolFile);
			System.exit(INPUT_IS_INVALID);
		}

		final CommonTree ast = results.getTree();

		final File xmlFile = new File(outputFilename);
		try {
			CommonTreeSerializer.serialize(ast, xmlFile);

		} catch (IOException e) {
			System.out.println("IOException while writing " + xmlFile);
			System.exit(IOEXCEPTION);
		}

		System.exit(INPUT_IS_VALID);
	}
}
