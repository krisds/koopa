package koopa.app.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.grammars.cobol.CobolGrammar;
import koopa.grammars.cobol.CobolVerifier;
import koopa.grammars.cobol.antlr.CobolTreeParser;
import koopa.parsers.Parser;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.CharacterStringTokenizer;
import koopa.tokenizers.cobol.CompilerDirectivesTokenizer;
import koopa.tokenizers.cobol.ContinuationWeldingTokenizer;
import koopa.tokenizers.cobol.LineContinuationTokenizer;
import koopa.tokenizers.cobol.LineSplittingTokenizer;
import koopa.tokenizers.cobol.ProgramAreaTokenizer;
import koopa.tokenizers.cobol.SeparatorTokenizer;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.SourceFormattingDirectivesFilter;
import koopa.tokenizers.cobol.TokenTrackerTokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.generic.FilteringTokenizer;
import koopa.tokenizers.generic.IntermediateTokenizer;
import koopa.tokens.Token;
import koopa.tokens.TokenFilter;
import koopa.tokenstreams.TokenSink;
import koopa.trees.TreeBuildDirectingSink;
import koopa.trees.antlr.ANTLRTokenTypesLoader;
import koopa.trees.antlr.CommonTreeBuilder;
import koopa.trees.antlr.CommonTreeProcessor;
import koopa.trees.antlr.TokenTypes;
import koopa.util.Tuple;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.log4j.Logger;

public class CobolParser implements ParserConfiguration {

	private static final Logger LOGGER = Logger.getLogger("parser");

	private TokenTypes tokenTypes = null;
	private List<IntermediateTokenizer> intermediateTokenizers = new LinkedList<IntermediateTokenizer>();
	private List<TokenSink> tokenSinks = new LinkedList<TokenSink>();
	private List<CommonTreeProcessor> treeProcessors = null;

	private boolean keepingTrackOfTokens = false;

	private boolean buildTrees = false;

	private SourceFormat format = SourceFormat.FIXED;

	public ParseResults parse(File file) throws IOException {
		LOGGER.info("Parsing " + file);

		ParseResults results = new ParseResults(file);

		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		FileReader reader = new FileReader(file);

		// We will be building up our tokenizer in several stages. Each stage
		// takes the preceding tokenizer, and extends its abilities.
		Tokenizer tokenizer;

		// The tokenizers in this sequence should generate the expected tokens.
		tokenizer = new LineSplittingTokenizer(new BufferedReader(reader));
		tokenizer = new CompilerDirectivesTokenizer(tokenizer);
		tokenizer = new ProgramAreaTokenizer(tokenizer, format);
		tokenizer = new SourceFormattingDirectivesFilter(tokenizer);

		if (this.format == SourceFormat.FIXED) {
			tokenizer = new LineContinuationTokenizer(tokenizer);
			tokenizer = new ContinuationWeldingTokenizer(tokenizer);
		}

		tokenizer = new SeparatorTokenizer(tokenizer);
		tokenizer = new CharacterStringTokenizer(tokenizer);

		if (this.keepingTrackOfTokens) {
			final TokenTrackerTokenizer tokenTracker = new TokenTrackerTokenizer(
					tokenizer);

			results.setTokenTracker(tokenTracker.getTokenTracker());

			tokenizer = tokenTracker;
		}

		// This allows external tools to see all tokens before further
		// processing. At the moment it is not guaranteed that all tokens will
		// make it to the token sinks.
		for (IntermediateTokenizer intermediate : this.intermediateTokenizers) {
			intermediate.setPreviousTokenizer(tokenizer);
			tokenizer = intermediate;
		}

		// Here we filter out all tokens which are not part of the program text
		// area (comments are not considered part of this area). This leaves us
		// with the pure code, which should be perfect for processing by a
		// parser.
		tokenizer = new FilteringTokenizer(tokenizer, AreaTag.PROGRAM_TEXT_AREA);

		// Here we filter out all pure whitespace separators. This leaves us
		// with only the "structural" tokens which are of interest to a parser.
		tokenizer = new FilteringTokenizer(tokenizer, new TokenFilter() {
			public boolean accepts(Token token) {
				if (!token.hasTag(SyntacticTag.SEPARATOR)) {
					return true;
				}

				final String text = token.getText();
				return !text.trim().equals("") && !text.equals(",")
						&& !text.equals(";");
			}
		});

		// This object holds all grammar productions. It is not thread-safe,
		// meaning that you can only ask it to parse one thing at a time.
		CobolGrammar grammar = new CobolGrammar();

		// Depending on the type of file we ask the grammar for the right
		// parser.
		Parser parser = null;
		if (isCopybook) {
			parser = grammar.copybook();
		} else {
			parser = grammar.compilationGroup();
		}

		CommonTreeBuilder builder = null;

		// This object does some extra verification on the output of the
		// grammar.
		CobolVerifier verifier = new CobolVerifier();

		boolean accepts = false;
		if (!buildTrees()) {
			if (this.tokenSinks.size() > 0) {
				TokenSink sink = verifier;
				for (TokenSink next : this.tokenSinks) {
					sink.setNextSink(next);
					sink = next;
				}
			}

			// Here we ask the grammar if the tokens can be parsed as a
			// compilation group.
			accepts = parser.accepts(tokenizer, verifier);

		} else {
			// These objects take care of building an ANTLR tree out of the
			// results from the grammar.
			builder = new CommonTreeBuilder(getTokenTypes());
			TreeBuildDirectingSink treeBuilder = new TreeBuildDirectingSink(
					builder, false);

			verifier.setNextSink(treeBuilder);

			if (this.tokenSinks.size() > 0) {
				TokenSink sink = treeBuilder;
				for (TokenSink next : this.tokenSinks) {
					sink.setNextSink(next);
					sink = next;
				}
			}

			// Here we ask the grammar if the tokens can be parsed as a
			// compilation group. In addition, we direct the parser to build an
			// ast out of the parsed tokens.
			accepts = parser.accepts(tokenizer, verifier);
		}

		if (accepts) {
			LOGGER.info("Valid file: " + file);
			results.setValidInput(true);

		} else {
			LOGGER.info("Invalid file: " + file);
			results.setValidInput(false);
		}

		if (grammar.hasWarnings()) {
			LOGGER.info("There were warnings from the grammar:");

			final List<Tuple<Token, String>> warnings = grammar.getWarnings();

			for (Tuple<Token, String> warning : warnings) {
				LOGGER.info("  " + warning.getFirst() + ": "
						+ warning.getSecond());

				results.addWarning(warning.getFirst(), warning.getSecond());
			}
		}

		if (verifier.hasWarnings()) {
			LOGGER.info("There were warnings from the verifier:");

			final List<Tuple<Token, String>> warnings = verifier.getWarnings();

			for (Tuple<Token, String> warning : warnings) {
				LOGGER.info("  " + warning.getFirst() + ": "
						+ warning.getSecond());

				results.addWarning(warning.getFirst(), warning.getSecond());
			}
		}

		if (verifier.hasErrors()) {
			LOGGER.info("There were errors from the verifier:");

			final List<Tuple<Token, String>> errors = verifier.getErrors();

			for (Tuple<Token, String> error : errors) {
				LOGGER.info("  " + error.getFirst() + ": " + error.getSecond());

				results.addError(error.getFirst(), error.getSecond());
			}

			results.setValidInput(false);
			accepts = false;
		}

		// Here we check if the parser really consumed all input. If it didn't
		// we show a glimpse of the next few tokens that should have been
		// consumed.
		if (accepts) {
			Token t = tokenizer.nextToken();
			if (t != null) {
				LOGGER.info("Not all input was consumed.");

				results.setValidInput(false);
				results.addError(t, "Not all input was consumed.");

				int count = 0;
				do {
					LOGGER.info("-> " + t);
					count++;
				} while (count < 5 && (t = tokenizer.nextToken()) != null);

				if (t != null) {
					LOGGER.info("-> ...");
				}

				accepts = false;
			}
		}

		// Some of our tokenizers may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of tokenizers, giving each a chance
		// to stop running.
		tokenizer.quit();

		// It is now safe to quit the method if we want/need to.
		if (!accepts) {
			return results;
		}

		// If we built trees during parsing, here is where we allow further
		// processing of those trees.
		if (builder != null) {
			for (CommonTree tree : builder.getTrees()) {
				// This validates the tree against the full Cobol grammar. In
				// short, this makes sure that the tree conforms to the input
				// grammar.
				boolean acceptableTree = acceptedByCobolTreeParser(tree,
						isCopybook);

				if (acceptableTree) {
					LOGGER.info("The constructed tree is valid.");

				} else {
					LOGGER.info("The constructed tree, however, is invalid.");

					results.setValidInput(false);
					results.addError(null, "Constructed tree is invalid.");
					return results;
				}

				results.setTree(tree);

				// We then allow all tree processors to have a go at the tree.
				for (CommonTreeProcessor processor : getCommonTreeProcessors()) {
					if (processor.processes(tree, file)) {
						LOGGER.info("Adaptive match ("
								+ processor.getClass().getSimpleName()
								+ ") was successful as well.");

					} else {
						LOGGER.info("Adaptive match ("
								+ processor.getClass().getSimpleName()
								+ "), however, was NOT successful.");

						results.setValidInput(false);
						results.addError(null, "Adaptive match ("
								+ processor.getClass().getSimpleName()
								+ ") failed.");
						return results;
					}
				}
			}
		}

		return results;
	}

	private TokenTypes getTokenTypes() {
		if (tokenTypes == null) {
			try {
				tokenTypes = new ANTLRTokenTypesLoader()
						.load("/koopa/grammars/cobol/antlr/Cobol.tokens");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return this.tokenTypes;
	}

	private static boolean acceptedByCobolTreeParser(CommonTree tree,
			boolean isCopybook) {
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
			e.printStackTrace();
			return false;
		}
	}

	private boolean buildTrees() {
		return this.buildTrees
				|| (this.treeProcessors != null && this.treeProcessors.size() > 0);
	}

	private List<CommonTreeProcessor> getCommonTreeProcessors() {
		if (this.treeProcessors == null) {
			this.treeProcessors = new ArrayList<CommonTreeProcessor>();
		}

		return this.treeProcessors;
	}

	public void addCommonTreeProcessor(CommonTreeProcessor treeProcessor) {
		if (this.treeProcessors == null) {
			this.treeProcessors = new ArrayList<CommonTreeProcessor>();
		}

		this.treeProcessors.add(treeProcessor);
	}

	public void addTokenSink(TokenSink sink) {
		this.tokenSinks.add(sink);
	}

	public void addIntermediateTokenizer(IntermediateTokenizer tokenizer) {
		assert (tokenizer != null);
		this.intermediateTokenizers.add(tokenizer);
	}

	public void setKeepingTrackOfTokens(boolean keepingTrackOfTokens) {
		this.keepingTrackOfTokens = keepingTrackOfTokens;
	}

	public boolean isKeepingTrackOfTokens() {
		return keepingTrackOfTokens;
	}

	public void setBuildTrees(boolean buildTrees) {
		this.buildTrees = buildTrees;
	}

	public void setFormat(SourceFormat format) {
		this.format = format;
	}

	public SourceFormat getFormat() {
		return this.format;
	}
}
