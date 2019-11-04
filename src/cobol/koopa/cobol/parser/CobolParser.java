package koopa.cobol.parser;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;

import koopa.cobol.CobolProject;
import koopa.cobol.CobolTokens;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.LOCCount;
import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.parsers.Messages;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.Stream;
import koopa.core.sources.Source;
import koopa.core.streams.BaseStream;
import koopa.core.targets.NullTarget;
import koopa.core.targets.TokenTracker;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.util.Files;
import koopa.core.util.Tuple;

public class CobolParser {

	private static final Logger LOGGER = Logger.getLogger("parser");

	private boolean keepingTrackOfTokens = false;

	private boolean buildTrees = false;

	private CobolProject project = null;

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
		final long start = System.currentTimeMillis();
		final ParseResults results = doParse(file, parse);
		final long end = System.currentTimeMillis();
		LOGGER.trace("Parse took: " + (end-start) + " ms");
		results.setTime(end-start);
		return results;
	}
	
	private ParseResults doParse(File file, Parse parse) throws IOException {
		boolean accepts = project.parserFor(file).accepts(parse);

		final ParseResults results = new ParseResults(file);
		results.setValidInput(accepts);
		results.setParse(parse);

		final Messages messages = parse.getMessages();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info((accepts ? "Valid file: " : "Invalid file: ") + file);

			if (messages.hasWarnings()) {
				LOGGER.info("There were warnings from the grammar:");

				for (Tuple<Token, String> warning : messages.getWarnings())
					LOGGER.info("  " + warning.getFirst() + ": "
							+ warning.getSecond());
			}
		}

		// Lets figure out whether we have seen all program text.
		// This will also push any remaining tokens to the token tracker, if one
		// was set up.
		final Stream tail = new BaseStream(parse.getFlow().getSource(),
				new NullTarget());
		tail.bookmark();

		final boolean sawMoreProgramText = grabRemainingProgramText(
				project.getGrammar(), tail,
				parse.getTarget(TokenTracker.class));

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

			messages.error(token, msg);
		}

		tail.rewind();
		parse.done();

		if (!accepts && messages.getErrorCount() == 0) {
			String msg = "Failed to parse.";

			final Frame finalFrame = parse.getFinalFrame();
			if (finalFrame != null)
				msg += " Last successful match: " + finalFrame.toTrace() + ".";

			messages.error(null, msg);
		}
		
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
		// Build the tokenisation stage.
		final Source source = new LOCCount(
				CobolTokens.getNewSource(file, reader, project));

		final Parse parse = Parse.of(source);

		// Keep track of all tokens passing through here, if so requested.
		TokenTracker tokenTracker = null;
		if (keepingTrackOfTokens) {
			tokenTracker = new TokenTracker();
			parse.to(tokenTracker);
		}

		if (buildTrees)
			parse.to(new KoopaTreeBuilder(project.getGrammar(), false));

		return parse;
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

	public void setProject(CobolProject project) {
		this.project = project;
	}

	private boolean grabRemainingProgramText(CobolGrammar grammar,
			Stream stream, TokenTracker tracker) {

		boolean sawMoreProgramText = false;

		while (true) {
			final Data d = stream.forward();

			// End-of-input ?
			if (d == null)
				break;

			// If we're tracking data, push them to the tracker.
			if (tracker != null)
				tracker.push(d);

			// Have we found more program text ?
			if (!sawMoreProgramText //
					&& d instanceof Token //
					&& grammar.isProgramText(d) //
					&& !grammar.canBeSkipped(d, null))
				sawMoreProgramText = true;

			// Stop after we found program text, unless we're tracking all
			// tokens.
			if (sawMoreProgramText && tracker == null)
				break;
		}

		return sawMoreProgramText;
	}

	private Token findTokenAt(Stream tail, Position best) {
		Data d = tail.forward();
		Token first = null;

		while (true) {
			if (d == null)
				return first;

			if (d instanceof Token) {
				final Token token = (Token) d;

				if (first == null)
					first = token;

				if (token.getStart().compareTo(best) >= 0)
					return token;
			}

			d = tail.forward();
		}
	}
}
