package koopa.app.components.sourceview;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import koopa.app.components.highlights.Highlights;
import koopa.app.components.highlights.SquiggleUnderlineHighlightPainter;
import koopa.app.components.textual.TextPanel;
import koopa.app.listeners.TokenSelectionListener;
import koopa.cobol.parser.ParseResults;
import koopa.core.data.Token;
import koopa.core.parsers.Messages;
import koopa.core.parsers.Parse;
import koopa.core.targets.TokenTracker;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.util.Tuple;

@SuppressWarnings("serial")
public class SourceView extends TextPanel {

	private TreeBasedDocument document = null;

	private Token selectedToken = null;

	private List<TokenSelectionListener> tokenSelectionListeners = new ArrayList<>();

	public SourceView() {
		setupComponents();
	}

	private void setupComponents() {
		getTextPane().addCaretListener(e -> {
			final Caret caret = getTextPane().getCaret();
			if (!caret.isVisible()
					&& getTextPane().getDocument().getLength() > 0)
				caret.setVisible(true);

			// TODO Add support for Token selection listeners.
			final Token token = document.getTokenAt(e.getDot());
			if (token != selectedToken) {
				selectedToken = token;
				for (TokenSelectionListener listener : tokenSelectionListeners)
					listener.selectedToken(selectedToken);
			}
		});

		getTextPane().addCaretListener(new TokenHighlighter(this));
	}

	public void scrollToToken(Token token) {
		final int offset = document.getOffset(token);

		if (offset >= 0)
			scrollTo(offset);
	}

	public Highlights getNewHighlights() {
		return new Highlights(this);
	}

	public Highlighter getHighlighter() {
		return getTextPane().getHighlighter();
	}

	private void addHighlights(ParseResults results) {
		try {
			final Highlighter highlighter = getTextPane().getHighlighter();
			final HighlightPainter warningPainter = new SquiggleUnderlineHighlightPainter(
					Color.ORANGE);
			final HighlightPainter errorPainter = new SquiggleUnderlineHighlightPainter(
					Color.RED);

			final Messages messages = results.getParse().getMessages();
			for (Tuple<Token, String> warning : messages.getWarnings()) {
				final Token token = warning.getFirst();
				if (token == null)
					continue;

				int offset = document.getOffset(token);
				if (offset < 0)
					return;

				final int delta = offset - token.getStart().getPositionInFile();

				final int start = token.getStart().getPositionInFile();
				final int end = token.getEnd().getPositionInFile() + 1;
				final int len = end - start;
				highlighter.addHighlight(start + delta, start + delta + len,
						warningPainter);
			}

			for (Tuple<Token, String> error : messages.getErrors()) {
				final Token token = error.getFirst();
				if (token == null)
					continue;

				int offset = document.getOffset(token);
				if (offset < 0)
					return;

				final int delta = offset - token.getStart().getPositionInFile();

				final int start = token.getStart().getPositionInFile();
				final int end = token.getEnd().getPositionInFile() + 1;
				final int len = end - start;

				highlighter.addHighlight(start + delta, start + delta + len,
						errorPainter);
			}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setParseResults(ParseResults results) {
		final JTextPane pane = getTextPane();
		pane.getHighlighter().removeAllHighlights();

		final Parse parse = results.getParse();

		// This is the syntax tree which got built.
		final Tree tree = parse.getTarget(KoopaTreeBuilder.class).getTree();

		if (tree == null) {
			document = new TreeBasedDocument();
			document.setContents(null);

		} else {
			// The syntax tree may not be capturing the full source file. There
			// may be more whitespace, for instance. Or the parse may have been
			// incomplete. So we check the token tracker for any tokens after
			// the last one in the tree.
			final Token last = tree.getRawEndToken();
			final List<Token> additionalTokens = parse
					.getTarget(TokenTracker.class).getTokensAfter(last);

			// Based on the syntax tree and the additional tokens we can now
			// build up the final document. This should be the same as the original
			// file, unless there was some preprocessing going on.
			document = new TreeBasedDocument();
			document.setContents(tree, additionalTokens);

			pane.setDocument(document);
			addHighlights(results);
		}
		
		pane.setCaretPosition(0);
	}

	public TreeBasedDocument getDocument() {
		return document;
	}

	public void addTokenSelectionListener(TokenSelectionListener listener) {
		tokenSelectionListeners.add(listener);
	}

	public void removeTokenSelectionListener(TokenSelectionListener listener) {
		tokenSelectionListeners.remove(listener);
	}

	public void close() {
	}
}