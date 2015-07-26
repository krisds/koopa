package koopa.cobol.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.CobolFiles;
import koopa.cobol.CobolTokens;
import koopa.cobol.Copybooks;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.LOCCount;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.ChainableSource;
import koopa.core.sources.Source;
import koopa.core.targets.Target;
import koopa.core.targets.TokenTracker;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.util.Tuple;

import org.apache.log4j.Logger;

public class CobolParser {

	private static final Logger LOGGER = Logger.getLogger("parser");

	private List<ChainableSource<Token>> intermediateTokenizers = new LinkedList<ChainableSource<Token>>();
	private List<Target<Data>> targets = new LinkedList<Target<Data>>();

	private boolean keepingTrackOfTokens = false;

	private boolean buildTrees = false;

	private SourceFormat format = SourceFormat.FIXED;
	private Copybooks copybooks = new Copybooks();

	/** EXPERIMENTAL */
	// TODO Extend ParserConfiguration to allow changing these from there.
	private boolean preprocessing = false;

	public ParseResults parse(File file) throws IOException {
		if (LOGGER.isInfoEnabled())
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
		final boolean isCopybook = CobolFiles.isCopybook(file);

		// This object holds all grammar productions. It is not thread-safe,
		// meaning that you can only ask it to parse one thing at a time.
		CobolGrammar grammar = new CobolGrammar();

		// Build the tokenisation stage.
		Source<Token> source = CobolTokens.getNewSource(
				file.getCanonicalPath(), reader, grammar, format,
				intermediateTokenizers, file.getParentFile(),
				preprocessing ? copybooks : null);
		LOCCount loc = new LOCCount(source);
		source = loc;

		// Depending on the type of file we ask the grammar for the right
		// parser.
		ParserCombinator parser = null;
		if (isCopybook)
			parser = grammar.copybook();
		else
			parser = grammar.compilationGroup();

		Parse parse = Parse.of(source);
		boolean accepts = false;

		// Keep track of all tokens passing through here, if so requested.
		if (keepingTrackOfTokens) {
			final TokenTracker tokenTracker = new TokenTracker();
			parse.addTarget(tokenTracker);
		}

		if (buildTrees)
			parse.addTarget(new KoopaTreeBuilder(grammar, false));

		if (!targets.isEmpty())
			for (Target<Data> next : targets)
				parse.addTarget(next);

		accepts = parser.accepts(parse);

		ParseResults results = new ParseResults(file);
		results.setValidInput(accepts);
		results.setParse(parse);

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info((accepts ? "Valid file: " : "Invalid file: ") + file);

			if (parse.hasWarnings()) {
				LOGGER.info("There were warnings from the grammar:");

				for (Tuple<Token, String> warning : parse.getWarnings())
					LOGGER.info("  " + warning.getFirst() + ": "
							+ warning.getSecond());
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

				if (grammar.isSeparator(t, null))
					continue;

				results.setValidInput(false);
				parse.error(t, "Not all input was consumed.");

				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Not all input was consumed.");
					int count = 0;
					do {
						LOGGER.info("-> " + t);
						count++;
					} while (count < 5 && (t = source.next()) != null);

					if (t != null)
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
		if (!accepts)
			return results;

		// Grab the LOC statistics.
		results.setNumberOfLines(loc.getNumberOfLines());
		results.setNumberOfLinesWithCode(loc.getNumberOfLinesWithCode());
		results.setNumberOfLinesWithComments(loc.getNumberOfLinesWithComments());

		return results;
	}

	public void addTarget(Target<Data> target) {
		this.targets.add(target);
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

	public void setCopybooks(Copybooks copybooks) {
		this.copybooks = copybooks;
	}
}
