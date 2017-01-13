package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.trees.jaxen.Jaxen.getMatches;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.parser.preprocessing.replacing.Replacing;
import koopa.cobol.parser.preprocessing.replacing.ReplacingPhrase;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.tags.SyntacticTag;
import koopa.core.parsers.Parse;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.ListSource;
import koopa.core.sources.NarrowingSource;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;

// TODO Extract common stuff with CopyInclude ?
public class Replace extends ChainingSource<Data, Data> implements Source<Data> {

	private static final Logger LOGGER //
			= Logger.getLogger("source.cobol.replace");

	private final CobolPreprocessingGrammar grammar;

	private final LinkedList<Data> pending = new LinkedList<Data>();

	/**
	 * All REPLACE statements which got handled are tracked here, in syntax tree
	 * form.
	 */
	private List<Tree> handledReplaceStatements = new LinkedList<Tree>();

	public Replace(Source<Data> source, CobolPreprocessingGrammar grammar) {
		super(source);

		this.grammar = grammar;
	}

	@Override
	protected Data nxt1() {
		while (true) {
			if (!pending.isEmpty())
				return pending.removeFirst();

			// Grab line from source.
			final LinkedList<Data> line = getLine();
			if (line == null)
				return null;

			// pending = line, up to first 'REPLACE'.
			anythingUpToReplaceBecomesPending(line);

			if (line.isEmpty()) {
				// No REPLACE was found.
				return pending.removeFirst();

			} else {
				// We have a REPLACE statement. For sure ?

				// Let's grab all the data for the REPLACE statement.
				final LinkedList<Data> replaceStatement = getReplaceStatement(
						line);

				if (replaceStatement == null) {
					// We didn't get any data, which means the REPLACE statement
					// couldn't be detected in full. So we just make all data
					// seen so far pending, and carry on.
					pending.addAll(line);
					return pending.removeFirst();
				}

				// We should have a REPLACE statement. Right ? Let's try getting
				// the syntax tree.
				final Tree replace = parseReplaceStatement(replaceStatement);
				if (replace == null) {
					// We didn't get a syntax tree for some reason. The REPLACE
					// statement was probably mall-formed. So we just make all
					// data seen so far pending, and carry on.
					pending.addAll(line);
					return pending.removeFirst();
				}

				// We now definitely have a REPLACE statement. Let's try setting
				// everything up.
				final boolean handlingIt = handleReplaceStatement(replace,
						replaceStatement, line);

				if (!handlingIt) {
					// For some reason the REPLACE statement could not be
					// handled. So we just make all data seen so far pending,
					// and carry on.
					pending.addAll(line);
					return pending.removeFirst();
				}
			}
		}
	}

	private LinkedList<Data> getLine() {
		LinkedList<Data> line = null;

		while (true) {
			final Data d = source.next();

			if (d == null)
				return line;

			if (line == null)
				line = new LinkedList<Data>();

			line.add(d);

			if (d instanceof Token && ((Token) d).hasTag(END_OF_LINE))
				return line;
		}
	}

	private void anythingUpToReplaceBecomesPending(LinkedList<Data> line) {
		// "A REPLACE statement shall be preceded by a space except when it is
		// the first statement in a compilation group."
		boolean canStartReplaceHere = true;

		while (true) {
			if (line.isEmpty())
				return;

			final Data d = line.getFirst();

			if (d instanceof Token) {
				final Token t = (Token) d;

				// Are we at a REPLACE ?
				if (canStartReplaceHere
						&& "replace".equalsIgnoreCase(t.getText())) {
					// Are we really ? E.g. no REPLACE100, or REPLACE-FOO ?
					if (isSpace(line, 1)) {
						if (LOGGER.isTraceEnabled())
							LOGGER.trace(
									"Possible start of a REPLACE statement: "
											+ t);

						return;
					}
				}

				// Are we at a space ?
				canStartReplaceHere = (t.getText().trim().length() == 0);
			}

			line.removeFirst();
			pending.add(d);
		}
	}

	private LinkedList<Data> getReplaceStatement(LinkedList<Data> line) {
		LinkedList<Data> replace = new LinkedList<Data>();

		while (true) {
			// Do we need to read another line ?
			if (line.isEmpty()) {
				// Yes, we do.
				final LinkedList<Data> nextLine = getLine();

				// Did we get another line ?
				if (nextLine != null) {
					// Yes, we did.
					line.addAll(nextLine);

				} else {
					// Nope. So the REPLACE statement is incomplete.
					// We rewind all tokens by adding them back to the line.
					while (!replace.isEmpty())
						line.addFirst(replace.removeLast());
					// And return null.
					return null;
				}
			}

			// Are we at the start of a pseudo-literal ?
			if (atPseudoLiteral(line)) {
				// Yes, we are. Let's grab all data for that pseudo-literal.
				final LinkedList<Data> pseudoLiteral = getPseudoLiteral(line);
				if (pseudoLiteral != null) {
					// The entire pseudo-literal becomes part of the REPLACE
					// statement.
					replace.addAll(pseudoLiteral);

				} else {
					// Woops. Seems we couldn't grab the full pseudo-literal.
					// Which leaves the REPLACE statement incomplete.
					// We rewind all tokens by adding them back to the line.
					while (!replace.isEmpty())
						line.addFirst(replace.removeLast());
					// And return null.
					return null;
				}

			} else {
				// We're not inside a pseudo-literal. So we can take the next
				// item and add it to the REPLACE statement.
				final Data d = line.removeFirst();
				replace.add(d);

				// Once we find a dot, we're done.
				if (d instanceof Token && ".".equals(((Token) d).getText()))
					return replace;
			}
		}
	}

	private boolean atPseudoLiteral(LinkedList<Data> line) {
		return isEqualsSign(line, 0) && isEqualsSign(line, 1);
	}

	private LinkedList<Data> getPseudoLiteral(LinkedList<Data> line) {
		LinkedList<Data> pseudoLiteral = new LinkedList<Data>();

		pseudoLiteral.add(line.removeFirst());
		pseudoLiteral.add(line.removeFirst());

		while (true) {
			// Do we need more data ?
			if (line.isEmpty()) {
				// Yes, we do.
				final LinkedList<Data> nextLine = getLine();

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

	private Tree parseReplaceStatement(LinkedList<Data> replaceStatement) {
		final ListSource<Data> replaceStatementSource //
				= new ListSource<Data>(replaceStatement);
		final Source<Token> source = new NarrowingSource<Data, Token>(
				replaceStatementSource, Token.class);

		final KoopaTreeBuilder treeBuilder = new KoopaTreeBuilder(grammar);

		final Parse parse = Parse.of(source).to(treeBuilder);
		final boolean accepts = grammar.replaceStatement().accepts(parse);

		return accepts ? treeBuilder.getTree() : null;
	}

	/**
	 * Tries to set up handling of the REPLACE statement. Tells whether it
	 * succeeded in doing so, or not.
	 */
	private boolean handleReplaceStatement(Tree replace,
			LinkedList<Data> replaceStatement, LinkedList<Data> line) {

		if (replace.hasChild("off")) {
			final boolean last //
					= (replace.getDescendant("off", "last") != null);

			if (LOGGER.isDebugEnabled())
				LOGGER.debug("Processing a REPLACE "
						+ (last ? "LAST OFF" : "OFF") + " statement ...");

			final ReplacementData data = new ReplacementData(false, !last,
					null);

			pending.add(data);
			if (!line.isEmpty())
				pending.addAll(line);

			handledReplaceStatements.add(replace);

			return true;

		} else if (replace.hasChild("replacing")) {
			final boolean also //
					= (replace.getDescendant("replacing", "also") != null);

			if (LOGGER.isDebugEnabled())
				LOGGER.debug("Processing a REPLACE " + (also ? "ALSO " : "")
						+ "statement ...");

			// Look for any REPLACING instructions which need to be activated.
			final List<ReplacingPhrase> replacements = getReplacements(replace);

			final ReplacementData data = new ReplacementData(true, !also,
					replacements);

			pending.add(data);
			if (!line.isEmpty())
				pending.addAll(line);

			handledReplaceStatements.add(replace);

			return true;

		} else {
			// Something strange is afoot. Like someone messing with the
			// grammar...

			LOGGER.error("Processing an unkown REPLACE statement: "
					+ replace.getAllText());

			return false;
		}
	}

	private List<ReplacingPhrase> getReplacements(Tree replace) {
		@SuppressWarnings("unchecked")
		final List<Tree> instructions //
				= (List<Tree>) getMatches(replace,
						"replacing/replacementInstruction");

		if (instructions == null || instructions.isEmpty())
			return null;

		final List<ReplacingPhrase> phrases //
				= Replacing.allPhrasesFrom(instructions);

		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Replace defines replacements: " + phrases);

		return phrases;
	}

	public List<Tree> getHandledDirectives() {
		return handledReplaceStatements;
	}
}
