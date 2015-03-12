package koopa.cobol.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.parser.preprocessing.PreprocessingSource;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.LOCCount;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.Separators;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parser;
import koopa.core.sources.ChainableSource;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.targets.CompositeTarget;
import koopa.core.targets.Target;
import koopa.core.targets.TokenTracker;
import koopa.core.treeparsers.Tree;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.TreeBuildDirectingSink;
import koopa.core.trees.TreeProcessor;
import koopa.core.util.Tuple;

import org.apache.log4j.Logger;

public class CobolParser implements ParserConfiguration {

	private static final Logger LOGGER = Logger.getLogger("parser");

	private List<ChainableSource<Token>> intermediateTokenizers = new LinkedList<ChainableSource<Token>>();
	private List<Target<Data>> tokenSinks = new LinkedList<Target<Data>>();
	private List<TreeProcessor> treeProcessors = null;

	private boolean keepingTrackOfTokens = false;

	private boolean buildTrees = false;

	private SourceFormat format = SourceFormat.FIXED;

	/** EXPERIMENTAL */
	// TODO Extend ParserConfiguration to allow changing these from there.
	private boolean preprocessing = false;
	private List<File> copybookPaths = new ArrayList<File>();

	public ParseResults parse(File file) throws IOException {
		LOGGER.info("Parsing " + file);

		FileReader reader = null;
		try {
			reader = new FileReader(file);
			return parse(file, reader);

		} finally {
			if (reader != null)
				reader.close();
		}
	}

	private ParseResults parse(File file, FileReader reader) throws IOException {
		ParseResults results = new ParseResults(file);

		final boolean isCopybook = file.getName().toUpperCase()
				.endsWith(".CPY");

		// Build the tokenisation stage.
		LOCCount loc = new LOCCount(getNewTokenizationStage(reader));
		Source<Token> source = loc;

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

		KoopaTreeBuilder builder = null;

		CompositeTarget<Data> ct = new CompositeTarget<Data>();

		// Keep track of all tokens passing through here, if so requested.
		if (this.keepingTrackOfTokens && results != null) {
			final TokenTracker tokenTracker = new TokenTracker();
			results.setTokenTracker(tokenTracker);
			ct.addTarget(tokenTracker);
		}

		boolean accepts = false;
		if (!buildTrees()) {
			if (this.tokenSinks.size() > 0)
				for (Target<Data> next : this.tokenSinks)
					ct.addTarget(next);

			// Here we ask the grammar if the tokens can be parsed as a
			// compilation group.
			accepts = parser.accepts(source, ct);

		} else {
			// These objects take care of building an ANTLR tree out of the
			// results from the grammar.
			builder = new KoopaTreeBuilder();
			TreeBuildDirectingSink treeBuilder = new TreeBuildDirectingSink(
					builder, false);

			ct.addTarget(treeBuilder);

			if (this.tokenSinks.size() > 0) {
				for (Target<Data> next : this.tokenSinks) {
					ct.addTarget(next);
				}
			}

			// Here we ask the grammar if the tokens can be parsed as a
			// compilation group. In addition, we direct the parser to build an
			// ast out of the parsed tokens.
			accepts = parser.accepts(source, ct);
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

		// Here we check if the parser really consumed all input. If it didn't
		// we show a glimpse of the next few tokens that should have been
		// consumed.
		if (accepts) {
			while (true) {
				// TODO This logic gets replicated a bit in other places (e.g.
				// TestTokenizer)...
				Token t = source.next();

				if (t == null)
					break;

				if (!grammar.isProgramText(t))
					continue;

				if (grammar.isSeparator(t))
					continue;

				LOGGER.info("Not all input was consumed.");

				results.setValidInput(false);
				results.addError(t, "Not all input was consumed.");

				int count = 0;
				do {
					LOGGER.info("-> " + t);
					count++;
				} while (count < 5 && (t = source.next()) != null);

				if (t != null) {
					LOGGER.info("-> ...");
				}

				accepts = false;
				break;
			}
		}

		// Some of our tokenizers may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of tokenizers, giving each a chance
		// to stop running.
		source.close();

		// It is now safe to quit the method if we want/need to.
		if (!accepts) {
			return results;
		}

		// Grab the LOC statistics.
		results.setNumberOfLines(loc.getNumberOfLines());
		results.setNumberOfLinesWithCode(loc.getNumberOfLinesWithCode());
		results.setNumberOfLinesWithComments(loc.getNumberOfLinesWithComments());

		// If we built trees during parsing, here is where we allow further
		// processing of those trees.
		if (builder != null) {
			for (Tree tree : builder.getTrees()) {
				// ------------------------------------------------------------
				// This used to validate the tree against the full Cobol
				// grammar. In short, this made sure that the tree conforms to
				// the input grammar.
				// We don't do this anymore because I was getting compilation
				// problems with the class which got generated for the full
				// CobolTreeParser.
				//
				// boolean acceptableTree = acceptedByCobolTreeParser(tree,
				// isCopybook);
				//
				// if (acceptableTree) {
				// LOGGER.info("The constructed tree is valid.");
				//
				// } else {
				// LOGGER.info("The constructed tree, however, is invalid.");
				//
				// results.setValidInput(false);
				// results.addError(null, "Constructed tree is invalid.");
				// return results;
				// }
				// ------------------------------------------------------------

				results.setTree(tree);

				// We then allow all tree processors to have a go at the tree.
				for (TreeProcessor processor : getTreeProcessors()) {
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

	public Source<Token> getNewTokenizationStage(Reader reader) {
		// We will be building up our tokenization stage in several steps. Each
		// step takes the preceding tokenizer, and extends its abilities.
		Source<Token> tokenizer;

		// Split the input into lines.
		tokenizer = new LineSplitter(new BufferedReader(reader));
		// Filter out some compiler directives.
		tokenizer = new CompilerDirectives(tokenizer, format);
		// Split up the different areas of each line (depending on the format).
		tokenizer = new ProgramArea(tokenizer, format);
		// Filter out some source formatting directives.
		tokenizer = new SourceFormattingDirectives(tokenizer);

		// In case of fixed format: take care of line continuations
		if (this.format == SourceFormat.FIXED) {
			tokenizer = new LineContinuations(tokenizer);
			tokenizer = new ContinuationWelding(tokenizer);
		}

		// Split up the lines into separators and non-separators.
		tokenizer = new Separators(tokenizer);
		// Find (and mark) pseudo literals.
		tokenizer = new PseudoLiterals(tokenizer);

		// This allows external tools to see all tokens before further
		// processing. At the moment it is not guaranteed that all tokens will
		// make it to the token sinks.
		for (ChainableSource<Token> intermediate : this.intermediateTokenizers) {
			intermediate.setSource(tokenizer);
			tokenizer = intermediate;
		}

		// tokenizer = new Printing(tokenizer, "%% ");

		// EXPERIMENTAL: optional preprocessing stage.
		// TODO Work on this stage.
		if (this.preprocessing) {
			tokenizer = new PreprocessingSource(tokenizer, this);
		}

		return tokenizer;
	}

	private boolean buildTrees() {
		return this.buildTrees
				|| (this.treeProcessors != null && this.treeProcessors.size() > 0);
	}

	private List<TreeProcessor> getTreeProcessors() {
		if (this.treeProcessors == null) {
			this.treeProcessors = new ArrayList<TreeProcessor>();
		}

		return this.treeProcessors;
	}

	public void addTreeProcessor(TreeProcessor treeProcessor) {
		if (this.treeProcessors == null) {
			this.treeProcessors = new ArrayList<TreeProcessor>();
		}

		this.treeProcessors.add(treeProcessor);
	}

	public void addTokenSink(Target<Data> sink) {
		this.tokenSinks.add(sink);
	}

	public void addIntermediateTokenizer(ChainableSource<Token> tokenizer) {
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

	public boolean isPreprocessing() {
		return preprocessing;
	}

	/** EXPERIMENTAL ! */
	public void setPreprocessing(boolean preprocessing) {
		this.preprocessing = preprocessing;
	}

	/** EXPERIMENTAL ! */
	public void setCopybookPath(List<File> copybookPaths) {
		this.copybookPaths = copybookPaths;
	}

	// TODO Smarter lookup system, with variations in extensions.
	public File lookup(final String textName, final String libraryName) {
		if (this.copybookPaths == null)
			return null;

		for (File path : this.copybookPaths) {
			File[] matches = path.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.equalsIgnoreCase(textName + ".cpy");
				}
			});

			if (matches != null && matches.length > 0)
				return matches[0];
		}

		return null;
	}
}
