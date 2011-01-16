package sandbox.treefilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.grammars.cobol.CobolGrammar;
import koopa.grammars.cobol.CobolVerifier;
import koopa.grammars.cobol.antlr.CobolTreeParser;
import koopa.parsers.Parser;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.CharacterStringTokenizer;
import koopa.tokenizers.cobol.ContinuationsTokenizer;
import koopa.tokenizers.cobol.ContinuedTokenizer;
import koopa.tokenizers.cobol.LineSplittingTokenizer;
import koopa.tokenizers.cobol.ProgramAreaTokenizer;
import koopa.tokenizers.cobol.SeparatorTokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;
import koopa.trees.TreeBuildDirectingSink;
import koopa.trees.antlr.ANTLRTokenTypesLoader;
import koopa.trees.antlr.CommonTreeBuilder;
import koopa.trees.antlr.TokenTypes;
import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FilteredTreeNodeStream;
import koopa.util.ASTFrame;
import koopa.util.Tuple;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class TreeFilterTest {

	private static final boolean EXIT_ON_FIRST_ERROR = false;
	private static final boolean SHOW_AST_WHEN_NOT_ACCEPTABLE = false;

	public static void main(String[] args) throws IOException {
		File folder = new File("testsuite/cobol85");
		// File folder = new File("testsuite/koopa");

		File[] sources = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				name = name.toUpperCase();
				return name.endsWith(".CBL") || name.endsWith(".CPY");
			}
		});

		TokenTypes types = getTokenTypes("Cobol",
				"/koopa/grammars/cobol/antlr/");

		int count = 0;
		List<File> erroneous = new LinkedList<File>();
		for (File file : sources) {
			System.out.println("Processing " + file);
			if (parse(file, types)) {
				count += 1;

			} else {
				erroneous.add(file);
				if (EXIT_ON_FIRST_ERROR) {
					break;
				}
			}
		}

		System.out.println("Found " + sources.length + " sources.");
		System.out.println(count + " of these parsed successfully.");

		if (!erroneous.isEmpty()) {
			System.out
					.println("Following files were found not to parse correctly:");
			for (File file : erroneous) {
				System.out.println("  " + file);
			}
		}
	}

	public static boolean parse(File file, TokenTypes types) throws IOException {
		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		FileReader reader = new FileReader(file);
		// FileReader reader = new FileReader("test.txt");

		// We will be building up our tokenizer in several stages. Each stage
		// takes the preceding tokenizer, and extends its abilities.
		Tokenizer tokenizer;

		// The tokenizers in this sequence should generate the expected tokens.
		tokenizer = new LineSplittingTokenizer(new BufferedReader(reader));
		tokenizer = new ProgramAreaTokenizer(tokenizer);
		tokenizer = new SeparatorTokenizer(tokenizer);
		tokenizer = new ContinuationsTokenizer(tokenizer);
		tokenizer = new ContinuedTokenizer(tokenizer);
		tokenizer = new CharacterStringTokenizer(tokenizer);

		// Here we filter out all tokens which are not part of the program text
		// area (comments are not considered part of this area). This leaves us
		// with the pure code, which should be perfect for processing by a
		// parser.
		tokenizer = new FilteringTokenizer(tokenizer, AreaTag.PROGRAM_TEXT_AREA);

		// Here we filter out all pure whitespace separators. This leaves us
		// with only the "structural" tokens which are of interest to a parser.
		tokenizer = new FilteringTokenizer(tokenizer, new TokenFilter() {
			public boolean accepts(Token token) {
				return !token.hasTag(SyntacticTag.SEPARATOR)
						|| (!token.getText().trim().equals("")
								&& !token.getText().equals(",") && !token
								.getText().equals(";"));
			}
		});

		// This object holds all grammar productions. It is not thread-safe,
		// meaning that you can only ask it to parse one thing at a time.
		CobolGrammar grammar = new CobolGrammar();

		// These objects take care of building an ANTLR tree out of the results
		// from the grammar.
		CommonTreeBuilder builder = new CommonTreeBuilder(types);
		// TODO Set true for hiding water, false for including it.
		TreeBuildDirectingSink treeBuilder = new TreeBuildDirectingSink(
				builder, true);

		// This object does some extra verification on the output of the
		// grammar.
		CobolVerifier verifier = new CobolVerifier();
		verifier.setNextSink(treeBuilder);

		// Depending on the type of file we ask the grammar for the right
		// parser.
		Parser parser = null;
		if (isCopybook) {
			parser = grammar.copybook();
		} else {
			parser = grammar.compilationGroup();
		}

		// We then ask the parser to parse the input.
		boolean accepts = parser.accepts(tokenizer, verifier);

		if (accepts) {
			System.out.println("Input is valid.");

		} else {
			System.out.println("Input is invalid.");
		}

		if (grammar.hasWarnings()) {
			System.out.println("There were warnings from the grammar:");
			final List<Tuple<Token, String>> warnings = grammar.getWarnings();
			for (Tuple<Token, String> warning : warnings) {
				System.out.println("  " + warning.getFirst() + ": "
						+ warning.getSecond());
			}
		}

		if (verifier.hasWarnings()) {
			System.out.println("There were warnings from the verifier:");
			final List<Tuple<Token, String>> warnings = verifier.getWarnings();
			for (Tuple<Token, String> warning : warnings) {
				System.out.println("  " + warning.getFirst() + ": "
						+ warning.getSecond());
			}
		}

		if (verifier.hasErrors()) {
			System.out.println("There were errors from the verifier:");
			final List<Tuple<Token, String>> errors = verifier.getErrors();
			for (Tuple<Token, String> error : errors) {
				System.out.println("  " + error.getFirst() + ": "
						+ error.getSecond());
			}

			accepts = false;
		}

		Token t = tokenizer.nextToken();
		if (t != null) {
			System.out.println("Not all input was consumed.");

			int count = 0;
			do {
				System.out.println("-> " + t);
				count++;
			} while (count < 5 && (t = tokenizer.nextToken()) != null);

			if (t != null) {
				System.out.println("-> ...");
			}

			accepts = false;
		}

		// Some of our tokenizers may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of tokenizers, giving each a chance
		// to stop running.
		tokenizer.quit();

		if (accepts) {
			for (CommonTree tree : builder.getTrees()) {
				boolean acceptableTree = acceptedByCobolTreeParser(tree,
						isCopybook);

				if (acceptableTree) {
					System.out.println("The constructed tree is valid.");
					accepts = true;

					if (acceptedByMyAdaptiveTreeParser(tree, isCopybook)) {
						System.out
								.println("Adaptive match was successful as well.");
					} else {
						System.out
								.println("Adaptive match, however, was NOT successful.");
					}

				} else {
					System.out
							.println("The constructed tree, however, is invalid.");
					accepts = false;

					if (SHOW_AST_WHEN_NOT_ACCEPTABLE) {
						new ASTFrame("AST", tree).setVisible(true);
					}
				}
			}
		}

		System.out.println();

		return accepts;
	}

	private static boolean acceptedByCobolTreeParser(CommonTree tree,
			boolean isCopybook) {
		// System.out.println(tree.toStringTree());

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
		CobolTreeParser parser = new CobolTreeParser(nodes);

		try {
			if (isCopybook) {
				parser.copybook();
			} else {
				parser.compilationGroup();
			}

			return parser.getNumberOfSyntaxErrors() == 0;

		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private static boolean acceptedByMyAdaptiveTreeParser(CommonTree tree,
			boolean isCopybook) {
		// System.out.println(tree.toStringTree());

		Filter filter = null;
		if (isCopybook) {
			filter = new MyAdaptiveTreeParserFilter().copybook();
		} else {
			filter = new MyAdaptiveTreeParserFilter().compilationGroup();
		}

		FilteredTreeNodeStream filteredStream = new FilteredTreeNodeStream(
				tree, filter);
		MyAdaptiveTreeParser parser = new MyAdaptiveTreeParser(filteredStream);

		try {
			if (isCopybook) {
				parser.copybook();
			} else {
				parser.compilationGroup();
			}

			return parser.getNumberOfSyntaxErrors() == 0;

		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private static TokenTypes getTokenTypes(String name, String path)
			throws IOException {

		return new ANTLRTokenTypesLoader().load(path + name + ".tokens");
	}
}
