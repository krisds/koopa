package koopa.cobol.parser.preprocessing;

import org.apache.log4j.Logger;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;
import koopa.core.targets.Pipe;

/**
 * This takes a {@linkplain Source} of {@linkplain Token}s, and parses all known
 * preprocessing directives found in it. The result is another
 * {@linkplain Source}, this time of {@linkplain Data}, which holds the original
 * tokens and {@linkplain Marker}s for the parsed directives.
 * <p>
 * Note that this class does not apply any of the directives it finds. It only
 * detects them, and makes them available for further processing.
 */
class SourceWithParsedPreprocessingDirectives extends ChainingSource<Token, Data> implements Source<Data> {
	private static final Logger LOGGER = Logger.getLogger("tokenising.preprocessing");
	private static final ParserCombinator PREPROCESSING_PARSER = new CobolPreprocessingGrammar().preprocessing();

	private Pipe<Data> dataFromParser = null;
	private boolean sourceHasBeenParsed = false;
	private int depth = 0;

	public SourceWithParsedPreprocessingDirectives(Source<Token> source) {
		super(source);
	}

	/**
	 * We pass the stream from our source through a specialized parser (
	 * {@linkplain CobolPreprocessingGrammar#preprocessing()}. This parser is
	 * also built on Koopa grammars, which means we can reuse the existing
	 * infrastructure.
	 * <p>
	 * The tokens coming out of the parser will be captured in a
	 * {@linkplain Pipe}, from which they will be forwarded again to the client.
	 */
	private void ensureSourceHasBeenParsed() {
		if (sourceHasBeenParsed)
			return;

		dataFromParser = new Pipe<Data>();

		final boolean accepts = PREPROCESSING_PARSER.accepts(Parse.of(source).to(dataFromParser));

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(accepts ? "ACCEPTED by preprocessing grammar" : "REJECTED by preprocessing grammar");

		sourceHasBeenParsed = true;
	}

	@Override
	protected Data nxt1() {
		ensureSourceHasBeenParsed();

		while (dataFromParser != null) {
			Data data = dataFromParser.next();

			if (data == null) {
				dataFromParser = null;

			} else if (data instanceof Start) {
				// We don't want the outermost wrapper.
				depth += 1;
				if (depth > 0 + 1)
					return data;

			} else if (data instanceof End) {
				// We don't want the outermost wrapper.
				depth -= 1;
				if (depth > 0)
					return data;

			} else
				return data;
		}

		// The original source may hold more tokens.
		return source.next();
	}

	public void close() {
		dataFromParser = null;
		source.close();
	}
}