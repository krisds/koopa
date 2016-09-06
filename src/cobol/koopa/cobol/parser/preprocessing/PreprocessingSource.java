package koopa.cobol.parser.preprocessing;

import static koopa.core.trees.Trees.getTree;
import static koopa.core.trees.jaxen.Jaxen.getMatches;
import static koopa.core.trees.jaxen.Jaxen.getAllText;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.cobol.CobolTokens;
import koopa.cobol.Copybooks;
import koopa.cobol.parser.preprocessing.replacing.Replacing;
import koopa.cobol.parser.preprocessing.replacing.ReplacingSource;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Replaced;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.IslandTag;
import koopa.core.grammars.Grammar;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;
import koopa.core.sources.StackOfSources;
import koopa.core.trees.Tree;
import koopa.core.util.Files;

/**
 * This is a {@linkplain Source} of {@linkplain Token}s which applies (or at
 * least tries to apply) the Cobol preprocessing logic:
 * <ul>
 * <li>Expansion of copybooks (initiated by <code>COPY</code> statements).</li>
 * <li>Replacement of text (initiated by <code>COPY REPLACING</code> and
 * <code>REPLACE</code> statements).</li>
 * </ul>
 */
public class PreprocessingSource extends BasicSource<Token> implements Source<Token> {

	private static final Logger LOGGER = Logger.getLogger("source.cobol.preprocessing");

	private final Grammar grammar;
	private final SourceFormat format;
	private final Copybooks copybooks;

	/**
	 * The stack of inputs tracks the open source files. Initially there will be
	 * only one, for the main file. Upon encountering preprocessing directives
	 * new inputs will be opened and take place on top of the stack. The idea is
	 * that we always prioritize the top most input as the one to be read from.
	 */
	private StackOfSources<Data, PreprocessorInput> inputsBeingProcessed;

	/**
	 * REPLACE statements may also be acting on the overall input. That is what
	 * this stage will be taking care of.
	 */
	private ReplacingSource inputsAfterReplacements;

	/**
	 * All preprocessing directives which got handled are tracked here, in
	 * syntax tree form.
	 */
	private List<Tree> handledDirectives;

	/**
	 * If we don't support the preprocessing directive its raw content will be
	 * spliced into the output again.
	 */
	private LinkedList<Data> unsupportedDirective = null;

	public PreprocessingSource(Source<Token> source, Grammar grammar, SourceFormat format, File file,
			Copybooks copybooks) {
		assert (source != null);

		this.grammar = grammar;
		this.format = format;
		this.copybooks = copybooks;

		// We set up our inputs to start with the main source file.
		this.inputsBeingProcessed = new StackOfSources<Data, PreprocessorInput>();
		this.inputsBeingProcessed.push(new PreprocessorInput(file, source));

		// And make sure all that passes through the REPLACE statement stage.
		this.inputsAfterReplacements = new ReplacingSource();
		this.inputsAfterReplacements.setSource(inputsBeingProcessed);

		this.handledDirectives = new LinkedList<Tree>();
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
						LOGGER.debug(hashCode() + " PreprocessingDirective " + data);

					LinkedList<Data> directive = getPreprocessingDirective();
					Tree tree = getTree(grammar, directive);

					if (tree != null && tree.isNode("copyStatement"))
						handleCopyStatement(tree, directive);

					else if (tree != null && tree.isNode("replaceStatement"))
						handleReplaceStatement(tree, directive);

					else {
						if (LOGGER.isInfoEnabled())
							LOGGER.info("Unsupported preprocessing directive: " + tree);
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

	/**
	 * Tries the following sources of tokens in turn until it gets a token:
	 * <ol>
	 * <li>The tokens from an unsupported preprocessing directive.</li>
	 * <li>The tokens from one of the inputs (in reverse order), after
	 * replacements (if any).</li>
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

		return inputsAfterReplacements.next();
	}

	private void handleCopyStatement(Tree copyStatement, LinkedList<Data> directive) {
		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Processing a COPY statement");

		final String textName = getAllText(copyStatement, "//textName");
		final String libraryName = getAllText(copyStatement, "//libraryName");

		if (LOGGER.isDebugEnabled()) {
			if (libraryName == null)
				LOGGER.debug("Looking for copybook " + textName);
			else
				LOGGER.debug("Looking for copybook " + textName + " in library " + libraryName);
		}

		File copybook = copybooks.locate(textName, libraryName, inputsBeingProcessed.peek().getFile());
		if (copybook == null) {
			LOGGER.error("Missing copybook " + textName + " in " + libraryName);
			unsupportedDirective = directive;
			return;
		}

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Found copybook at " + copybook);

		trySettingUpCopybookTokenizer(copybook, copyStatement, directive);

		addHandledDirective(copyStatement);
	}

	/**
	 * Try to establish the given copybook file as a new source of tokens.
	 */
	private void trySettingUpCopybookTokenizer(File copybook, Tree copyStatement, LinkedList<Data> originalDirective) {
		try {
			Source<Token> newSource = CobolTokens.getNewSource(//
					copybook.getAbsolutePath(), //
					Files.getReader(copybook), //
					grammar, format, copybook, (Copybooks) null);

			// Note that we don't pass the Copybooks instance when asking for a
			// new source. This will prevent the generation of an extra
			// PreprocessingSource, keeping this one as the only one in the
			// entire configuration of Sources.

			// Each input tracks the COPY statement which triggered it. In
			// addition, each token will get linked to the COPY statement it's
			// replacing. The same is true for the COPY statement itself.
			final Replaced replacement = new Replaced(//
					copyStatement.getRawStart(), //
					copyStatement.getRawEnd(), //
					inputsBeingProcessed.peek().getReplaced());
			final ReplacingSource replacing = getOptionalSourceForReplacements(copyStatement);
			final PreprocessorInput forCopybook = new PreprocessorInput(copybook, newSource, replacing, replacement);
			inputsBeingProcessed.push(forCopybook);

		} catch (FileNotFoundException e) {
			LOGGER.error("Problem while reading copybook: " + copybook, e);
			unsupportedDirective = originalDirective;
		}
	}

	/**
	 * Checks if the statement defines replacements, and returns a new
	 * {@linkplain ReplacingSource} to handle them if it did.
	 */
	private ReplacingSource getOptionalSourceForReplacements(Tree tree) {
		ReplacingSource replacing = null;

		@SuppressWarnings("unchecked")
		List<Tree> replacementInstructions = (List<Tree>) getMatches(tree, "replacing/replacementInstruction");

		if (!replacementInstructions.isEmpty()) {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug("Statement defines replacements.");

			replacing = new ReplacingSource();
			replacing.pushReplacements(Replacing.allPhrasesFrom(replacementInstructions));
		}

		return replacing;
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

	private void handleReplaceStatement(Tree replaceStatement, LinkedList<Data> directive) {
		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Processing a REPLACE statement");

		// "Once encountered, a format 1 REPLACE statement has one of three
		// states:"
		// "a) active, meaning it is the current statement in use for replace
		// processing for the compilation group;"
		// "b) inactive, meaning it is not currently in use for replace
		// processing but is held in a last-in first-out queue, from which it
		// may be popped and made active or canceled in accordance with the
		// rules for subsequent REPLACE statements encountered in the
		// compilation group;"
		// "c) canceled, meaning it is removed from use for replace processing
		// for the remainder of the compilation group or, if inactive, it is
		// removed from the queue of inactive statements for the remainder of
		// the compilation group."

		final Tree replacing = replaceStatement.getChild("replacing");
		if (replacing != null) {
			final boolean also = replacing.hasChild("also");

			if (LOGGER.isDebugEnabled())
				LOGGER.debug("This REPLACE " + (also ? "ALSO " : "") + "activates replacements");

			if (also) {
				// "A format 1 REPLACE statement with the ALSO phrase results in
				// the following:
				// 1. the active REPLACE statement is made inactive and is
				// pushed into the queue of inactive REPLACE statements.
				// 2. The current REPLACE statement is expanded into a single
				// REPLACE statement, without the ALSO phrase, having as its
				// operands all the operands of the current statement followed
				// by the operands of the most recent statement pushed into the
				// queue of inactive REPLACE statements. The expanded REPLACE
				// statement is placed in the active state."

				// We do not create a new REPLACE statement which is the
				// combination of all previously active ones with the new one.
				// Instead we leave all REPLACE statements active, but add the
				// new one with a higher precedence. This will give us the same
				// effect as having a combined REPLACE statement.
				@SuppressWarnings("unchecked")
				List<Tree> replacementInstructions = (List<Tree>) getMatches(replacing, "replacementInstruction");
				inputsAfterReplacements.pushReplacements(Replacing.allPhrasesFrom(replacementInstructions));

			} else {
				// "A format 1 REPLACE statement without the ALSO phrase cancels
				// the active REPLACE statement and cancels any REPLACE
				// statements in the queue of inactive REPLACE statements."

				inputsAfterReplacements.clearAllReplacements();

				// "Then the current REPLACE statement is placed in the active
				// state."

				@SuppressWarnings("unchecked")
				List<Tree> replacementInstructions = (List<Tree>) getMatches(replacing, "replacementInstruction");
				inputsAfterReplacements.pushReplacements(Replacing.allPhrasesFrom(replacementInstructions));
			}

			addHandledDirective(replaceStatement);
			return;
		}

		final Tree off = replaceStatement.getChild("off");
		if (off != null) {
			boolean last = off.hasChild("last");

			if (LOGGER.isDebugEnabled())
				LOGGER.debug("This REPLACE deactivates " + (last ? "LAST " : "") + "replacements");

			if (!last) {
				// "A format 2 REPLACE statement without the LAST phrase cancels
				// the active REPLACE statement and cancels all REPLACE
				// statements in the queue of inactive REPLACE statements, if
				// any."

				inputsAfterReplacements.clearAllReplacements();

			} else {
				// "A format 2 REPLACE statement with the LAST phrase cancels
				// the active REPLACE statement and pops the last statement that
				// was pushed into the queue of inactive REPLACE statements, if
				// any. The popped statement, if any, is placed in the active
				// state."

				// In our implementation this means popping the list of
				// replacements with the highest precedence.
				inputsAfterReplacements.popReplacements();
			}

			addHandledDirective(replaceStatement);
			return;
		}

		// We expect a REPLACE to define either replacement clauses, or an OFF
		// directive. If we haven't found either we'll log that, but carry on
		// regardless.
		LOGGER.error("Unexpected structure for REPLACE statement at: " + replaceStatement.getRawStart());
		unsupportedDirective = directive;
	}

	public void addHandledDirective(Tree directive) {
		handledDirectives.add(directive);
	}

	public List<Tree> getHandledDirectives() {
		return handledDirectives;
	}

	public void close() {
		inputsBeingProcessed.close();
	}

	@SuppressWarnings("unchecked")
	public <S extends Source<? extends Data>> S getSource(Class<S> clazz) {
		if (clazz.isAssignableFrom(this.getClass()))
			return (S) this;

		S instance = inputsAfterReplacements.getSource(clazz);
		if (instance != null)
			return instance;

		return null;
	}

}
