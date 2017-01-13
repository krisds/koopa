package koopa.cobol.parser;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.cobol.CobolFiles;
import koopa.cobol.CobolTokens;
import koopa.cobol.Copybooks;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.LOCCount;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.Stream;
import koopa.core.sources.Source;
import koopa.core.streams.BaseStream;
import koopa.core.targets.NullTarget;
import koopa.core.targets.Target;
import koopa.core.targets.TokenTracker;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.util.Files;
import koopa.core.util.Tuple;

public class CobolParser {

	private static final Logger LOGGER = Logger.getLogger("parser");

	private static final CobolGrammar grammar = new CobolGrammar();

	private List<Target<Data>> targets = new LinkedList<Target<Data>>();

	private boolean keepingTrackOfTokens = false;

	private boolean buildTrees = false;

	private SourceFormat format = SourceFormat.FIXED;
	private Copybooks copybooks = new Copybooks();

	// TODO Extend ParserConfiguration to allow changing these from there.
	private boolean preprocessing = false;

	public ParseResults parse(File file) throws IOException {
		if (LOGGER.isInfoEnabled())
			LOGGER.info("Parsing " + file);

		Reader reader = null;
		try {
			reader = Files.getReader(file);
			return parse(file, reader);

		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public ParseResults parse(File file, Reader reader) throws IOException {
		final Parse parse = getParseSetup(file, reader);
		return parse(file, parse);
	}

	public ParseResults parse(File file, Parse parse) throws IOException {
		final boolean isCopybook = CobolFiles.isCopybook(file);

		// Depending on the type of file we ask the grammar for the right
		// parser.
		final ParserCombinator parser;
		if (isCopybook)
			parser = grammar.copybook();
		else
			parser = grammar.compilationGroup();

		boolean accepts = parser.accepts(parse);

		final ParseResults results = new ParseResults(file);
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

		// Lets figure out whether we have seen all program text.
		// This will also push any remaining tokens to the token tracker, if one
		// was set up.
		final Stream tail = new BaseStream(parse.getFlow().getSource(),
				new NullTarget<Data>());
		tail.bookmark();

		final boolean sawMoreProgramText = grabRemainingProgramText(grammar,
				tail, parse.getTarget(TokenTracker.class));

		// Here we check if the parser really consumed all input. If it didn't
		// we try to flag the point of failure as best we can.
		if (accepts && sawMoreProgramText) {
			accepts = false;
			results.setValidInput(false);

			String msg = "Incomplete parse.";

			final Frame finalFrame = parse.getFinalFrame();
			if (finalFrame != null)
				msg += " Last successful match: " + finalFrame.toTrace() + ".";

			if (LOGGER.isTraceEnabled())
				LOGGER.trace(msg);

			tail.rewind();
			tail.bookmark();
			final Position finalPosition = parse.getFinalPosition();
			final Token token = findTokenAt(tail, finalPosition);

			if (token != null)
				parse.error(token, msg);
		}

		tail.rewind();
		parse.done();

		// It is now safe to quit the method if we want/need to.
		if (!accepts)
			return results;

		// Grab the LOC statistics.
		LOCCount loc = parse.getSource(LOCCount.class);
		results.setNumberOfLines(loc.getNumberOfLines());
		results.setNumberOfLinesWithCode(loc.getNumberOfLinesWithCode());
		results.setNumberOfLinesWithComments(
				loc.getNumberOfLinesWithComments());

		return results;
	}

	public Parse getParseSetup(File file) throws IOException {
		return getParseSetup(file, Files.getReader(file));
	}

	public Parse getParseSetup(File file, Reader reader) throws IOException {
		Parse parse;
		// Build the tokenisation stage.
		Source<Token> source = CobolTokens.getNewSource(file, reader, grammar,
				format, preprocessing ? copybooks : null);
		LOCCount loc = new LOCCount(source);
		source = loc;

		parse = Parse.of(source);

		// Keep track of all tokens passing through here, if so requested.
		TokenTracker tokenTracker = null;
		if (keepingTrackOfTokens) {
			tokenTracker = new TokenTracker();
			parse.to(tokenTracker);
		}

		if (buildTrees)
			parse.to(new KoopaTreeBuilder(grammar, false));

		if (!targets.isEmpty())
			for (Target<Data> next : targets)
				parse.to(next);
		return parse;
	}

	public void addTarget(Target<Data> target) {
		this.targets.add(target);
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

	private boolean grabRemainingProgramText(CobolGrammar grammar,
			Stream stream, TokenTracker tracker) {

		boolean sawMoreProgramText = false;

		while (true) {
			final Token t = stream.forward();

			// End-of-input ?
			if (t == null)
				break;

			// If we're tracking tokens, push them to the tracker.
			if (tracker != null)
				tracker.push(t);

			// Have we found more program text ?
			if (!sawMoreProgramText && grammar.isProgramText(t)
					&& !grammar.canBeSkipped(t, null))
				sawMoreProgramText = true;

			// Stop after we found program text, unless we're tracking all
			// tokens.
			if (sawMoreProgramText && tracker == null)
				break;
		}

		return sawMoreProgramText;
	}

	private Token findTokenAt(Stream tail, Position best) {
		Token token = tail.forward();
		Token first = token;
		while (token != null && token.getStart().compareTo(best) < 0)
			token = tail.forward();

		if (token == null)
			token = first;
		return token;
	}
}
