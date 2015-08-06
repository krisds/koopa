package koopa.cobol.parser.preprocessing;

import static koopa.core.trees.Trees.getTree;
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
import koopa.core.trees.Tree;

import org.apache.log4j.Logger;

public class PreprocessingSource extends BasicSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.preprocessing");

	private static final ParserCombinator PPP = new CobolPreprocessingGrammar()
			.preprocessing();

	private final Grammar grammar;
	private final SourceFormat format;
	private final Copybooks copybooks;

	/**
	 * The stack of inputs tracks the open source files. Initially there will be
	 * only one, that for the main file. Upon encountering COPY statements new
	 * inputs will be opened and take place on top of the stack. The idea is
	 * that we always prioritize the top most input as the one to be read from.
	 */
	private Input inputs = null;

	private LinkedList<Data> unsupportedDirective = null;
	private PreprocessingListener listener = null;

	public PreprocessingSource(Source<Token> source, Grammar grammar,
			SourceFormat format, File path, Copybooks copybooks) {
		assert (source != null);

		this.grammar = grammar;
		this.format = format;
		this.copybooks = copybooks;

		this.inputs = new Input(path, source);
	}

	@Override
	protected Token nxt1() {
		while (true) {
			final Data data = nextFromInput();

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
					Tree tree = getTree(grammar, directive);

					if (tree != null && tree.isNode("copyStatement"))
						configureHandlingOfCopyStatement(tree, directive);

					else if (tree != null && tree.isNode("replaceStatement")) {
						// TODO Handle them. Here ?
						unsupportedDirective = directive;

					} else {
						if (LOGGER.isInfoEnabled())
							LOGGER.info("Unsupported preprocessing directive: "
									+ tree);
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

	private void configureHandlingOfCopyStatement(Tree tree,
			LinkedList<Data> directive) {
		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Processing a COPY statement");

		final String textName = getText(tree, "//textName//text()");
		final String libraryName = getText(tree, "//libraryName//text()");

		if (LOGGER.isDebugEnabled()) {
			if (libraryName == null)
				LOGGER.debug("Looking for copybook " + textName);
			else
				LOGGER.debug("Looking for copybook " + textName
						+ " in library " + libraryName);
		}

		File copybook = copybooks.lookup(textName, libraryName, inputs.path);
		if (copybook == null) {
			LOGGER.error("Missing copybook " + textName + " in " + libraryName);
			unsupportedDirective = directive;
			return;
		}

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Found copybook at " + copybook);

		final ReplacingSource replacing = getOptionalSourceForReplacements(tree);
		trySettingUpCopybookTokenizer(copybook, replacing, tree, directive);
	}

	/**
	 * Checks if the COPY statement defines replacements, and returns a new
	 * {@linkplain Source} to handle them if it did.
	 */
	private ReplacingSource getOptionalSourceForReplacements(Tree tree) {
		ReplacingSource replacing = null;

		@SuppressWarnings("unchecked")
		List<Tree> replacementInstructions = (List<Tree>) getMatches(tree,
				"copyReplacingPhrase/copyReplacementInstruction");

		if (!replacementInstructions.isEmpty()) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug("Copy statement defines replacements.");

			replacing = new ReplacingSource(replacementInstructions);
		}

		return replacing;
	}

	/**
	 * Try to establish the given copybook file as a new source of tokens.
	 */
	private void trySettingUpCopybookTokenizer(File copybook,
			ReplacingSource replacing, Tree tree,
			LinkedList<Data> originalDirective) {
		try {
			if (listener != null)
				listener.startCopying(tree);

			Source<Token> newSource = CobolTokens
					.getNewSource(
							copybook.getAbsolutePath(), //
							new FileReader(copybook), //
							grammar, format, copybook.getParentFile(),
							(Copybooks) null);

			// Note that we don't pass the Copybooks instance when asking for a
			// new source. This will prevent the generation of an extra
			// PreprocessingSource, keeping this one as the only one in the
			// entire configuration of Sources.

			if (replacing != null) {
				replacing.setSource(newSource);
				newSource = replacing;
			}

			// Each input tracks the COPY statement which triggered it. In
			// addition, each token will get linked to the COPY statement it's
			// replacing. The same is true for the COPY statement itself.
			final Token activeCopyStatement = (Token) inputs.asReplacing( //
					new Token(//
							tree.getProgramText(), //
							tree.getStartPosition(), //
							tree.getEndPosition()));

			inputs = inputs.push(new Input(newSource, copybook,
					activeCopyStatement));

		} catch (FileNotFoundException e) {
			LOGGER.error("Problem while reading copybook: " + copybook, e);
			unsupportedDirective = originalDirective;
		}
	}

	private LinkedList<Data> getPreprocessingDirective() {
		LinkedList<Data> directive = new LinkedList<Data>();

		int depth = 0;
		do {
			final Data data = nextFromInput();
			directive.add(data);

			if (data == null)
				return directive;
			else if (data instanceof Start)
				depth += 1;
			else if (data instanceof End)
				depth -= 1;

		} while (depth > 0);

		return directive;
	}

	/**
	 * Tries the following sources of tokens in turn until it gets a token:
	 * <ol>
	 * <li>The tokens from an unsupported preprocessing directive.</li>
	 * <li>The tokens from one of the inputs (in reverse order).</li>
	 * </ol>
	 */
	private Data nextFromInput() {
		if (unsupportedDirective != null) {
			while (unsupportedDirective.size() > 0) {
				Data data = unsupportedDirective.removeFirst();
				if (!(data instanceof Marker))
					return data;
			}

			unsupportedDirective = null;
		}

		while (inputs != null) {
			final Data data = inputs.next();

			if (data != null)
				return data;

			inputs = inputs.pop();
		}

		return null;
	}

	public void close() {
		while (inputs != null) {
			inputs.close();
			inputs = inputs.pop();
		}
	}

	/**
	 * An {@linkplain Input} tracks a {@linkplain Source} and any COPY statement
	 * which may have activated it.
	 */
	private static class Input {
		public final Source<Token> source;
		public final File path;
		private final Token activeCopyStatement;

		private QueueingTokenSink buffer = null;
		private boolean bufferReady = false;
		private Input nextInput = null;

		public Input(File path, Source<Token> source) {
			this(source, path, null);
		}

		public Input push(Input input) {
			input.nextInput = this;
			return input;
		}

		public Input pop() {
			return nextInput;
		}

		public Input(Source<Token> source, File path, Token activeCopyStatement) {
			this.source = source;
			this.path = path;
			this.activeCopyStatement = activeCopyStatement;
		}

		/**
		 * We pass the stream from our source through a specialized parser. The
		 * parser is also built on Koopa grammars, which means we can reuse the
		 * existing infrastructure.
		 * <p>
		 * The tokens coming out of the parser will be captured in a buffer. Our
		 * logic then works on the results from that buffer.
		 */
		private void ensureBufferIsReady() {
			if (bufferReady)
				return;

			buffer = new QueueingTokenSink();

			final boolean accepts = PPP.accepts( //
					Parse.of(source).to(buffer));

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("PREPROCESSING GRAMMAR ACCEPTED " + path + " ? "
						+ accepts);

			bufferReady = true;
		}

		public Data next() {
			ensureBufferIsReady();
			return asReplacing(next1());
		}

		private Data asReplacing(Data data) {
			if (data == null)
				return null;
			else if (activeCopyStatement != null && data instanceof Token)
				return ((Token) data).asReplacing(activeCopyStatement);
			else
				return data;
		}

		private Data next1() {
			if (buffer != null) {
				Data data = buffer.next();

				if (data != null)
					return data;

				buffer = null;
			}

			return source.next();
		}

		public void close() {
			source.close();
		}
	}
}
