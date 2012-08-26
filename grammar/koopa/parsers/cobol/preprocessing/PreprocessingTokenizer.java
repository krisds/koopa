package koopa.parsers.cobol.preprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.grammars.cobolPreprocessing.CobolPreprocessingGrammar;
import koopa.parsers.Parser;
import koopa.parsers.cobol.CobolParser;
import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.UpMarker;
import koopa.tokenizers.PushbackTokenizer;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.IslandTag;
import koopa.tokenizers.generic.BasicPushbackTokenizer;
import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.trees.TreeBuildDirectingSink;
import koopa.trees.antlr.ANTLRTokenTypesLoader;
import koopa.trees.antlr.CommonTreeBuilder;
import koopa.trees.antlr.TokenTypes;
import koopa.trees.antlr.jaxen.Jaxen;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;

public class PreprocessingTokenizer implements Tokenizer {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.preprocessing");

	private CobolParser cobolParser = null;

	private Tokenizer sourceTokenizer = null;
	private QueueingTokenSink sourceSink = null;

	private Parser preprocessingParser = null;

	private Tokenizer copybookTokenizer = null;

	private LinkedList<Token> unsupportedDirective = null;

	public PreprocessingTokenizer(Tokenizer sourceTokenizer,
			CobolParser cobolParser) {
		assert (sourceTokenizer != null);

		if (sourceTokenizer instanceof PushbackTokenizer) {
			this.sourceTokenizer = sourceTokenizer;
		} else {
			this.sourceTokenizer = new BasicPushbackTokenizer(sourceTokenizer);
		}

		this.cobolParser = cobolParser;

		// TODO Token tracking and this ? (Cfr.
		// CobolParser.keepingTrackOfTokens)
		// TODO Token sinks and this ? (Cfr. CobolParser.intermediateTokenizers)
	}

	public Token nextToken() {
		if (this.preprocessingParser == null) {
			// We pass the stream from out parent tokenizer through a
			// specialized parser. The parser is also built on Koopa grammars,
			// which means we can reuse the existing infrastructure. We also
			// don't have to re-implement the grammar rules for these
			// directives; though for now we do have to do some copy-pasting...
			//
			// The tokens coming out of the parser will be captured in a sink.
			// The logic in this tokenizer then works on the results from that
			// sink.
			this.sourceSink = new QueueingTokenSink();
			this.preprocessingParser = new CobolPreprocessingGrammar()
					.preprocessing();

			this.preprocessingParser.accepts(this.sourceTokenizer,
					this.sourceSink);
		}

		while (true) {
			Token token = next();

			if (token == null) {
				// End of input.
				LOGGER.trace(this.hashCode() + " END OF INPUT");
				return token;
			}

			if (token instanceof Marker) {
				if (token instanceof DownMarker) {
					DownMarker down = (DownMarker) token;

					if ("preprocessingDirective".equalsIgnoreCase(down
							.getName())) {

						LinkedList<Token> directive = getPreprocessingDirective();
						final CommonTree tree = getSyntaxTree(directive);

						if (tree == null) {
							LOGGER.debug("No syntax tree for directive: "
									+ directive);
							unsupportedDirective = directive;
							continue;

						} else if (!getTokenTypes().isNodeOfType(tree,
								"copyStatement")) {
							LOGGER.debug("Unsupported: " + tree);
							unsupportedDirective = directive;
							continue;
						}

						LOGGER.debug("Processing a COPY statement");

						final String textName = getValue(tree,
								"//textName//text()");

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

						File copybook = this.cobolParser.lookup(textName,
								libraryName);

						LOGGER.debug("Found copybook at " + copybook);

						try {
							// TODO Pass along ParseResults somehow ?
							this.copybookTokenizer = this.cobolParser
									.getNewTokenizationStage(null,
											new FileReader(copybook));

						} catch (FileNotFoundException e) {
							LOGGER.error("Problem while reading copybook.", e);
							unsupportedDirective = directive;
						}
					}
				}

			} else {
				// The preprocessing parser may have added some tags which can
				// confuse the real parser. So we make sure to clean these up.
				token.removeTag(IslandTag.WATER);
				token.removeTag(IslandTag.LAND);

				LOGGER.trace(this.hashCode() + " -> " + token);
				return token;
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

	private LinkedList<Token> getPreprocessingDirective() {
		Token token;
		LinkedList<Token> directive = new LinkedList<Token>();

		int depth = 0;
		do {
			token = next();
			directive.add(token);

			if (token instanceof DownMarker)
				depth += 1;
			else if (token instanceof UpMarker)
				depth -= 1;

		} while (token != null && depth > 0);

		return directive;
	}

	// TODO Move this to a utility class; I'm sure this will come in handy
	// again.
	private CommonTree getSyntaxTree(List<Token> directive) {
		CommonTreeBuilder builder = new CommonTreeBuilder(getTokenTypes());
		TreeBuildDirectingSink director = new TreeBuildDirectingSink(builder,
				true);
		director.addAll(directive);

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
	private Token next() {
		Token token = null;

		if (this.unsupportedDirective != null) {
			while (this.unsupportedDirective.size() > 0) {
				token = this.unsupportedDirective.removeFirst();
				if (!(token instanceof Marker)) {
					return token;
				}
			}

			this.unsupportedDirective = null;
		}

		if (this.copybookTokenizer != null) {
			token = this.copybookTokenizer.nextToken();

			if (token != null)
				return token;

			this.copybookTokenizer.quit();
			this.copybookTokenizer = null;
		}

		if (this.sourceSink != null) {
			token = this.sourceSink.nextToken();

			if (token != null)
				return token;

			this.sourceSink = null;
		}

		token = this.sourceTokenizer.nextToken();

		return token;
	}

	public void quit() {
		this.sourceTokenizer.quit();
	}

	// TODO Make this part of the CobolPreprocessingGrammar as a static method.
	private static TokenTypes tokenTypes = null;

	public static TokenTypes getTokenTypes() {
		if (tokenTypes == null) {
			try {
				tokenTypes = new ANTLRTokenTypesLoader()
						.load("/koopa/grammars/cobolPreprocessing/antlr/CobolPreprocessing.tokens");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return tokenTypes;
	}

}
