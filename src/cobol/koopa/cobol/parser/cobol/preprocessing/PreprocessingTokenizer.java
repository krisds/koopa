package koopa.cobol.parser.cobol.preprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.parser.cobol.CobolParser;
import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.IslandTag;
import koopa.core.parsers.Parser;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;
import koopa.core.trees.TreeBuildDirectingSink;
import koopa.core.trees.antlr.CommonKoopaToken;
import koopa.core.trees.antlr.CommonTreeBuilder;
import koopa.core.trees.antlr.jaxen.Jaxen;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;

public class PreprocessingTokenizer extends BasicSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.preprocessing");

	private CobolParser cobolParser = null;

	private Source<Token> sourceTokenizer = null;
	private QueueingTokenSink sourceSink = null;

	private Parser preprocessingParser = null;

	private Source<Token> copybookTokenizer = null;

	private LinkedList<Data> unsupportedDirective = null;

	public PreprocessingTokenizer(Source<Token> sourceTokenizer,
			CobolParser cobolParser) {
		assert (sourceTokenizer != null);

		this.sourceTokenizer = sourceTokenizer;
		this.cobolParser = cobolParser;

		// TODO Token tracking and this ? (Cfr.
		// CobolParser.keepingTrackOfTokens)
		// TODO Token sinks and this ? (Cfr. CobolParser.intermediateTokenizers)
	}

	@Override
	protected Token nxt1() {
		if (preprocessingParser == null) {
			// We pass the stream from out parent tokenizer through a
			// specialized parser. The parser is also built on Koopa grammars,
			// which means we can reuse the existing infrastructure. We also
			// don't have to re-implement the grammar rules for these
			// directives; though for now we do have to do some copy-pasting...
			//
			// The tokens coming out of the parser will be captured in a sink.
			// The logic in this tokenizer then works on the results from that
			// sink.
			sourceSink = new QueueingTokenSink();
			preprocessingParser = new CobolPreprocessingGrammar()
					.preprocessing();

			boolean accepts = preprocessingParser.accepts(sourceTokenizer,
					sourceSink);
			LOGGER.trace(hashCode() + " PREPROCESSING GRAMMAR ACCEPTED ? "
					+ accepts);
		}

		while (true) {
			Data data = nextOne();

			if (data == null) {
				// End of input.
				LOGGER.trace(hashCode() + " END OF INPUT");
				return null;
			}

			if (data instanceof Start) {
				Start down = (Start) data;

				if ("preprocessingDirective".equalsIgnoreCase(down.getName())) {

					LOGGER.trace(hashCode() + " PreprocessingDirective " + data);

					LinkedList<Data> directive = getPreprocessingDirective();
					final CommonTree tree = getSyntaxTree(directive);

					if (tree == null) {
						LOGGER.debug("No syntax tree for directive: "
								+ directive);
						unsupportedDirective = directive;
						continue;

					}
					
					CommonKoopaToken token = (CommonKoopaToken) tree.getToken();
					Data data2 = token.getKoopaData();
					if (!(data2 instanceof Start)) {
						LOGGER.debug("Unsupported: " + tree);
						unsupportedDirective = directive;
						continue;
					}
					
					Start start = (Start) data2;
					if (!"copyStatement".equals(start.getName())) {
						LOGGER.debug("Unsupported: " + tree);
						unsupportedDirective = directive;
						continue;
					}

					LOGGER.debug("Processing a COPY statement");

					final String textName = getValue(tree, "//textName//text()");

					final String libraryName = getValue(tree,
							"//libraryName//text()");

					// TODO In case of unsupported features: add tokens back
					// to the original stream and bail out.

					if (LOGGER.isDebugEnabled()) {
						if (libraryName == null)
							LOGGER.debug("Looking for copybook " + textName);
						else
							LOGGER.debug("Looking for copybook " + textName
									+ " in library " + libraryName);
					}

					File copybook = cobolParser.lookup(textName, libraryName);

					LOGGER.debug("Found copybook at " + copybook);

					try {
						// TODO Pass along ParseResults somehow ?
						copybookTokenizer = cobolParser
								.getNewTokenizationStage(null, new FileReader(
										copybook));

					} catch (FileNotFoundException e) {
						LOGGER.error("Problem while reading copybook.", e);
						unsupportedDirective = directive;
					}
				}

			} else if (data instanceof Token) {
				Token t = (Token) data;
				// The preprocessing parser may have added some tags which can
				// confuse the real parser. So we make sure to clean these up.
				t = t.withoutTags(IslandTag.WATER, IslandTag.LAND);

				LOGGER.trace(hashCode() + " -> " + t);
				return t;
			}
		}
	}

	// TODO Move this to a utility class; I'm sure this will come in handy
	// again.
	private String getValue(CommonTree tree, String xpath) {
		final List<?> values = Jaxen.evaluate(tree, xpath);
		if (values == null || values.size() != 1)
			return null;
		else
			return ((CommonTree) values.get(0)).getText();
	}

	private LinkedList<Data> getPreprocessingDirective() {
		Data token;
		LinkedList<Data> directive = new LinkedList<Data>();

		int depth = 0;
		do {
			token = nextOne();
			directive.add(token);

			if (token instanceof Start)
				depth += 1;
			else if (token instanceof End)
				depth -= 1;

		} while (token != null && depth > 0);

		return directive;
	}

	// TODO Move this to a utility class; I'm sure this will come in handy
	// again.
	private CommonTree getSyntaxTree(List<Data> directive) {
		CommonTreeBuilder builder = new CommonTreeBuilder();
		TreeBuildDirectingSink director = new TreeBuildDirectingSink(builder,
				true);

		for (Data token : directive) {
			director.push(token);
		}

		final List<CommonTree> trees = builder.getTrees();
		return trees == null || trees.size() != 1 ? null : trees.get(0);
	}

	/**
	 * Tries the following sources of tokens in turn until it gets a token:
	 * <ol>
	 * <li>The tokens from an unsupported preprocessing directive.</li>
	 * <li>The tokens from a copybook.</li>
	 * <li>The tokens from the preprocessor grammar.</li>
	 * <li>The parent tokenizer.</li>
	 * </ol>
	 * 
	 * @return The next available token.
	 */
	private Data nextOne() {
		Data token = null;

		if (unsupportedDirective != null) {
			while (unsupportedDirective.size() > 0) {
				token = unsupportedDirective.removeFirst();
				if (!(token instanceof Marker))
					return token;
			}

			unsupportedDirective = null;
		}

		if (copybookTokenizer != null) {
			token = copybookTokenizer.next();

			if (token != null)
				return token;

			copybookTokenizer.close();
			copybookTokenizer = null;
		}

		if (sourceSink != null) {
			token = sourceSink.next();

			if (token != null)
				return token;

			sourceSink = null;
		}

		token = sourceTokenizer.next();

		return token;
	}

	@Override
	public void close() {
		sourceTokenizer.close();
	}
}
