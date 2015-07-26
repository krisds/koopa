package koopa.cobol.parser.preprocessing;

import static koopa.core.trees.jaxen.Jaxen.getMatches;
import static koopa.core.trees.jaxen.Jaxen.getText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.CobolTokens;
import koopa.cobol.Copybooks;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.IslandTag;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;

import org.apache.log4j.Logger;

public class PreprocessingSource extends BasicSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.preprocessing");

	private Grammar grammar = null;
	private Source<Token> sourceTokenizer = null;
	private QueueingTokenSink sourceSink = null;

	private ParserCombinator preprocessingParser = null;

	private Source<Token> copybookTokenizer = null;

	private Tree tree = null;
	private Token activeCopyStatement = null;

	private LinkedList<Data> unsupportedDirective = null;

	private PreprocessingListener listener = null;

	private final SourceFormat format;
	private final File path;
	private final Copybooks copybooks;

	public PreprocessingSource(Source<Token> sourceTokenizer, Grammar grammar,
			SourceFormat format, File path, Copybooks copybooks) {
		assert (sourceTokenizer != null);

		this.grammar = grammar;
		this.sourceTokenizer = sourceTokenizer;
		this.format = format;
		this.path = path;
		this.copybooks = copybooks;
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

			boolean accepts = preprocessingParser.accepts(Parse.of(
					sourceTokenizer).to(sourceSink));

			if (LOGGER.isTraceEnabled())
				LOGGER.trace(hashCode() + " PREPROCESSING GRAMMAR ACCEPTED ? "
						+ accepts);
		}

		while (true) {
			Data data = nextOne();

			if (data == null) {
				// End of input.
				if (LOGGER.isTraceEnabled())
					LOGGER.trace(hashCode() + " END OF INPUT");
				return null;
			}

			if (data instanceof Start) {
				Start down = (Start) data;

				if ("preprocessingDirective".equalsIgnoreCase(down.getName())) {

					if (LOGGER.isDebugEnabled())
						LOGGER.debug(hashCode() + " PreprocessingDirective "
								+ data);

					LinkedList<Data> directive = getPreprocessingDirective();
					tree = getSyntaxTree(directive);

					if (!isCopyStatement(tree)) {
						if (LOGGER.isInfoEnabled())
							LOGGER.info("Unsupported preprocessing directive: "
									+ tree);
						unsupportedDirective = directive;
						continue;
					}

					if (LOGGER.isDebugEnabled())
						LOGGER.debug("Processing a COPY statement");

					final String textName = getText(tree, "//textName//text()");
					final String libraryName = getText(tree,
							"//libraryName//text()");

					if (LOGGER.isDebugEnabled()) {
						if (libraryName == null)
							LOGGER.debug("Looking for copybook " + textName);
						else
							LOGGER.debug("Looking for copybook " + textName
									+ " in library " + libraryName);
					}

					File copybook = copybooks.lookup(textName, libraryName,
							path);
					if (copybook == null) {
						LOGGER.error("Missing copybook " + textName + " in "
								+ libraryName);

						unsupportedDirective = directive;
						continue;
					}

					if (LOGGER.isDebugEnabled())
						LOGGER.debug("Found copybook at " + copybook);

					@SuppressWarnings("unchecked")
					List<Tree> replacementInstructions = (List<Tree>) getMatches(
							tree,
							"copyReplacingPhrase/copyReplacementInstruction");

					ReplacingSource replacing = null;
					if (!replacementInstructions.isEmpty()) {
						if (LOGGER.isDebugEnabled())
							LOGGER.debug("Copy statement defines replacements.");

						replacing = new ReplacingSource(replacementInstructions);
					}

					try {
						if (listener != null)
							listener.startCopying(tree);

						copybookTokenizer = CobolTokens.getNewSource(
								copybook.getAbsolutePath(), //
								new FileReader(copybook), //
								grammar, format, copybook.getParentFile(),
								copybooks);

						if (replacing != null) {
							replacing.setSource(copybookTokenizer);
							copybookTokenizer = replacing;
						}

						activeCopyStatement = new Token(tree.getProgramText(),
								tree.getStartPosition(), tree.getEndPosition());

					} catch (FileNotFoundException e) {
						LOGGER.error("Problem while reading copybook: "
								+ copybook, e);
						unsupportedDirective = directive;
						activeCopyStatement = null;
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
	private Tree getSyntaxTree(List<Data> directive) {
		KoopaTreeBuilder builder = new KoopaTreeBuilder(grammar, true);

		for (Data token : directive)
			builder.push(token);

		final List<Tree> trees = builder.getTrees();
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
		if (unsupportedDirective != null) {
			while (unsupportedDirective.size() > 0) {
				Data data = unsupportedDirective.removeFirst();
				if (!(data instanceof Marker))
					return data;
			}

			unsupportedDirective = null;
		}

		if (copybookTokenizer != null) {
			Token token = copybookTokenizer.next();

			if (token != null)
				return token.asReplacing(activeCopyStatement);

			if (listener != null)
				listener.stopCopying(tree);

			copybookTokenizer.close();
			copybookTokenizer = null;
		}

		if (sourceSink != null) {
			Data data = sourceSink.next();

			if (data != null)
				return data;

			sourceSink = null;
		}

		return sourceTokenizer.next();
	}

	public void close() {
		sourceTokenizer.close();
	}

	private boolean isCopyStatement(Tree tree) {
		if (tree == null)
			return false;

		Data data2 = tree.getData();
		if (!(data2 instanceof Start))
			return false;

		Start start = (Start) data2;
		if (!"copyStatement".equals(start.getName()))
			return false;

		return true;
	}
}
