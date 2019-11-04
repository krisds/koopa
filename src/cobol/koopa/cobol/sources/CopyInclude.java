package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.trees.jaxen.Jaxen.getAllText;
import static koopa.core.trees.jaxen.Jaxen.getMatches;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.cobol.CobolProject;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.parser.preprocessing.replacing.Replacing;
import koopa.cobol.parser.preprocessing.replacing.ReplacingPhrase;
import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Replaced;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.data.tags.SyntacticTag;
import koopa.core.parsers.Parse;
import koopa.core.sources.AsReplacing;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.ListSource;
import koopa.core.sources.Source;
import koopa.core.sources.Sources;
import koopa.core.sources.StackOfSources;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.util.LineEndings;

public class CopyInclude extends ChainingSource
		implements Source {

	private static final Logger LOGGER //
			= Logger.getLogger("source.cobol.copy_include");

	private final CobolPreprocessingGrammar grammar;
	private final CobolProject project;
	private StackOfSources inputStack;

	private final LinkedList<Data> pending = new LinkedList<>();

	/**
	 * All COPY statements which got handled are tracked here, in syntax tree
	 * form.
	 */
	private List<Tree> handledCopyStatements = new LinkedList<>();

	public CopyInclude(Source source, CobolPreprocessingGrammar grammar,
			CobolProject project, StackOfSources stack) {
		super(source);

		this.project = project;
		this.inputStack = stack;
		this.grammar = grammar;
	}

	@Override
	protected Data nxt1() {
		while (true) {
			if (!pending.isEmpty())
				return pending.removeFirst();

			// Grab line from source.
			final LinkedList<Data> line = Sources.getLine(source);
			if (line == null)
				return null;

			// pending = line, up to first 'COPY'.
			anythingUpToCopyBecomesPending(line);

			if (line.isEmpty()) {
				// No COPY was found.
				return pending.removeFirst();

			} else {
				// We have a COPY statement. For sure ?

				// Let's grab all the data for the COPY statement.
				final LinkedList<Data> copyStatement = getCopyStatement(line);

				if (copyStatement == null) {
					// We didn't get any data, which means the COPY statement
					// couldn't be detected in full. So we just make all data
					// seen so far pending, and carry on.
					pending.addAll(line);
					return pending.removeFirst();
				}

				// TODO Resolve any continuations.

				// We should have a COPY statement. Right ? Let's try getting
				// the syntax tree.
				final Tree copy = parseCopyStatement(copyStatement);
				if (copy == null) {
					// We didn't get a syntax tree for some reason. The COPY
					// statement was probably mall-formed. So we just make all
					// data seen so far pending, and carry on.
					pending.addAll(line);
					return pending.removeFirst();
				}

				// We now definitely have a COPY statement. Let's try setting
				// everything up.
				final boolean handlingIt = handleCopyStatement(copy,
						copyStatement, line);

				if (!handlingIt) {
					// For some reason the COPY statement could not be handled.
					// So we just make all data seen so far pending, and carry
					// on.
					pending.addAll(copyStatement);
					pending.addAll(line);
					return pending.removeFirst();
				} else
					pending.add(copy);
			}
		}
	}

	private void anythingUpToCopyBecomesPending(LinkedList<Data> line) {
		// "A COPY statement shall be preceded by a space except when it is
		// the first statement in a compilation group."
		boolean canStartCopyHere = true;

		while (true) {
			if (line.isEmpty())
				return;

			final Data d = line.getFirst();

			if (d instanceof Token) {
				final Token t = (Token) d;

				// Did we find a COPY in the program text area, which is not
				// part of a bigger word ?
				if (canStartCopyHere && t.hasTag(AreaTag.PROGRAM_TEXT_AREA)
						&& "copy".equalsIgnoreCase(t.getText())) {
					// Did we really ? E.g. no COPY100, or COPY-FOO ?
					if (isSpace(line, 1)) {
						if (LOGGER.isTraceEnabled())
							LOGGER.trace(
									"Possible start of a COPY statement: " + t);

						// OK then !
						return;
					}
				}

				// Are we at a space ?
				canStartCopyHere = (t.getText().trim().length() == 0);
			}

			line.removeFirst();
			pending.add(d);
		}
	}

	private LinkedList<Data> getCopyStatement(LinkedList<Data> line) {
		LinkedList<Data> copy = new LinkedList<>();

		while (true) {
			// Do we need to read another line ?
			if (line.isEmpty()) {
				// Yes, we do.
				final LinkedList<Data> nextLine = Sources.getLine(source);

				// Did we get another line ?
				if (nextLine != null) {
					// Yes, we did.
					line.addAll(nextLine);

				} else {
					// Nope. So the COPY statement is incomplete.
					// We rewind all tokens by adding them back to the line.
					while (!copy.isEmpty())
						line.addFirst(copy.removeLast());
					// And return null.
					return null;
				}
			}

			// Are we at the start of a pseudo-literal ?
			if (atPseudoLiteral(line)) {
				// Yes, we are. Let's grab all data for that pseudo-literal.
				final LinkedList<Data> pseudoLiteral = getPseudoLiteral(line);
				if (pseudoLiteral != null) {
					// The entire pseudo-literal becomes part of the COPY
					// statement.
					copy.addAll(pseudoLiteral);

				} else {
					// Woops. Seems we couldn't grab the full pseudo-literal.
					// Which leaves the COPY statement incomplete.
					// We rewind all tokens by adding them back to the line.
					while (!copy.isEmpty())
						line.addFirst(copy.removeLast());
					// And return null.
					return null;
				}

			} else {
				// We're not inside a pseudo-literal. So we can take the next
				// item and add it to the copy statement.
				final Data d = line.removeFirst();
				copy.add(d);

				// Once we find a dot, we're done.
				if (d instanceof Token && ".".equals(((Token) d).getText()))
					return copy;
			}
		}
	}

	private boolean atPseudoLiteral(LinkedList<Data> line) {
		return isEqualsSign(line, 0) && isEqualsSign(line, 1);
	}

	private LinkedList<Data> getPseudoLiteral(LinkedList<Data> line) {
		LinkedList<Data> pseudoLiteral = new LinkedList<>();

		pseudoLiteral.add(line.removeFirst());
		pseudoLiteral.add(line.removeFirst());

		while (true) {
			// Do we need more data ?
			if (line.isEmpty()) {
				// Yes, we do.
				final LinkedList<Data> nextLine = Sources.getLine(source);

				// Did we get another line ?
				if (nextLine != null) {
					// Yes, we did.
					line.addAll(nextLine);

				} else {
					// Nope. So the pseudo-literal is incomplete.
					// We rewind all tokens by adding them back to the line.
					while (!pseudoLiteral.isEmpty())
						line.addFirst(pseudoLiteral.removeLast());
					// And return null.
					return null;
				}
			}

			if (atEndOfPseudoLiteral(line)) {
				pseudoLiteral.add(line.removeFirst());
				pseudoLiteral.add(line.removeFirst());
				return pseudoLiteral;
			}

			pseudoLiteral.add(line.removeFirst());
		}
	}

	private boolean atEndOfPseudoLiteral(LinkedList<Data> line) {
		return isEqualsSign(line, 0) && isEqualsSign(line, 1)
				&& !isEqualsSign(line, 2);
	}

	private boolean isEqualsSign(LinkedList<Data> line, int index) {
		if (index >= line.size())
			return false;

		final Data a = line.get(index);
		return a != null && a instanceof Token //
				&& !((Token) a).hasTag(COMMENT)
				&& ((Token) a).getText().equals("=");
	}

	private boolean isSpace(LinkedList<Data> line, int index) {
		while (index < line.size()) {
			final Data d = line.get(index);

			if (d instanceof Token)
				return ((Token) d).hasTag(SyntacticTag.WHITESPACE);

			index += 1;
		}

		return true;
	}

	private Tree parseCopyStatement(LinkedList<Data> copyStatement) {
		final ListSource copyStatementSource //
				= new ListSource(copyStatement);

		// There may be continuations which need to be resolved before we can
		// parse it.
		final ContinuationOfLines continuationOfLines //
				= new ContinuationOfLines(copyStatementSource);

		final KoopaTreeBuilder treeBuilder = new KoopaTreeBuilder(grammar);

		final Parse parse = Parse.of(continuationOfLines).to(treeBuilder);
		final boolean accepts = grammar.copyStatement().accepts(parse);

		return accepts ? treeBuilder.getTree() : null;
	}

	/**
	 * Tries to set up handling of the COPY statement. Tells whether it
	 * succeeded in doing so, or not.
	 * 
	 * @param line
	 */
	private boolean handleCopyStatement(Tree copy,
			LinkedList<Data> copyStatement, LinkedList<Data> line) {

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Processing a COPY statement");

		final String textName = getAllText(copy, "//textName");
		final String libraryName = getAllText(copy, "//libraryName");

		final LineSplitter splitter = inputStack.getSource(LineSplitter.class);
		final File file = (splitter == null) ? null : splitter.getFile();

		if (LOGGER.isDebugEnabled()) {
			if (libraryName == null) {
				if (file == null)
					LOGGER.debug("Looking for copybook " + textName);
				else
					LOGGER.debug("Looking for copybook " + textName
							+ " relative to " + file);
			} else {
				if (file == null)
					LOGGER.debug("Looking for copybook " + textName
							+ " in library " + libraryName);
				else
					LOGGER.debug(
							"Looking for copybook " + textName + " in library "
									+ libraryName + " relative to " + file);
			}
		}

		final File copybook = project.locateCopybook(textName, libraryName, file);
		if (copybook == null) {
			LOGGER.error("Missing copybook " + textName + " in " + libraryName);
			return false;
		}

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Found copybook at " + copybook);

		final FileReader copybookReader;
		try {
			copybookReader = new FileReader(copybook); // lgtm[java/input-resource-leak]

		} catch (IOException e) {
			LOGGER.error("IOException while opening copybook " + copy);
			return false;
		}

		// Look for any REPLACING instructions which need to be activated.
		final List<ReplacingPhrase> replacements = getReplacements(copy);

		// We now have to set up the sources, such that the copybook gets
		// included correctly. We have three sets of data hanging around:
		// * The list of pending tokens.
		// * The tokens in the copybook.
		// * The remainder of the line following the COPY statement.
		//
		// Given that we're using a stack of sources as the main input we have
		// to push these sources in reverse order so that the tokens will appear
		// in the right order. We can leave the pending tokens out though, as
		// they be next in line to be read from here anyway.
		//
		// If there are replacements to be activated, we have to make sure we
		// mark where they start and stop in the token stream.

		// This sets up the remainder of the line.
		if (!line.isEmpty()) {
			final ListSource remainderOfLine = new ListSource(line);
			inputStack.push(remainderOfLine);
		}

		// Mark the end of any REPLACING instructions.
		if (replacements != null) {
			final ListSource turnOffReplacements = new ListSource(
					new ReplacementData(false, false, replacements));
			inputStack.push(turnOffReplacements);
		}

		// This sets up the copybook as a source.
		final List<List<Character>> lineEndings = LineEndings.getChoices();
		final LineSplitter lineSplitter //
				= new LineSplitter(copybook, copybookReader, lineEndings);
		// This marks all tokens coming from the copybook as being replacements
		// for the COPY statement.
		final AsReplacing asReplacing //
				= new AsReplacing(lineSplitter, replaced(copy));
		inputStack.push(asReplacing);

		// Mark the start of any REPLACING instructions.
		if (replacements != null) {
			final ListSource turnOnReplacements = new ListSource(
					new ReplacementData(true, false, replacements));
			inputStack.push(turnOnReplacements);
		}

		handledCopyStatements.add(copy);

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Set up expansion of " + copybook);

		return true;
	}

	private Replaced replaced(Tree copy) {
		final Position start = copy.getStartPosition();
		assert (start != null);

		final Position end = copy.getEndPosition();
		assert (end != null);

		final Replaced context = copy.getStartToken().getReplaced();

		return new Replaced(start, end, context);
	}

	private List<ReplacingPhrase> getReplacements(Tree copy) {
		@SuppressWarnings("unchecked")
		final List<Tree> instructions //
				= (List<Tree>) getMatches(copy,
						"replacing/replacementInstruction");

		if (instructions == null || instructions.isEmpty())
			return null;

		final List<ReplacingPhrase> phrases //
				= Replacing.allPhrasesFrom(instructions);

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Copy defines replacements: " + phrases);

		return phrases;
	}

	public List<Tree> getHandledDirectives() {
		return handledCopyStatements;
	}
}
