package koopa.app.components.sourceview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import koopa.app.components.highlights.Highlights;
import koopa.app.components.highlights.SquiggleUnderlineHighlightPainter;
import koopa.app.listeners.TokenSelectionListener;
import koopa.cobol.parser.ParseResults;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.util.Tuple;

@SuppressWarnings("serial")
public class SourceView extends JPanel {

	private TreeBasedDocument document = null;

	private JTextPane pane = null;

	private JScrollPane scroll = null;

	private Token selectedToken = null;

	private List<TokenSelectionListener> tokenSelectionListeners = new ArrayList<TokenSelectionListener>();

	private String searchPattern = null;
	private List<Integer> matchingStartPositions = null;
	private List<Integer> matchingEndPositions = null;

	public SourceView() {
		setupComponents();
	}

	private void setupComponents() {
		pane = new JTextPane() {
			public boolean getScrollableTracksViewportWidth() {
				return false;
			}
		};

		pane.setEditable(false);
		pane.getCaret().setVisible(true);
		pane.setMargin(new Insets(0, 5, 0, 0));

		pane.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				final Caret caret = pane.getCaret();
				if (!caret.isVisible() && pane.getDocument().getLength() > 0)
					caret.setVisible(true);

				// TODO Add support for Token selection listeners.
				final Token token = document.getTokenAt(e.getDot());
				if (token != selectedToken) {
					selectedToken = token;
					for (TokenSelectionListener listener : tokenSelectionListeners)
						listener.selectedToken(selectedToken);
				}
			}
		});

		// new LinePainter(pane, new Color(238, 245, 254));
		new LinePainter(pane, new Color(230, 240, 254));
		pane.addCaretListener(new TokenHighlighter(this));

		scroll = new JScrollPane(pane);

		LineNumberView linenumbers = new LineNumberView(pane);
		linenumbers.setForeground(Color.GRAY);
		linenumbers.setFont(new Font("Courier", Font.PLAIN, 14));
		scroll.setRowHeaderView(linenumbers);

		scroll.setBorder(null);

		pane.moveCaretPosition(0);
		pane.setCaretPosition(0);

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
	}

	public void scrollTo(int positionInFile) {
		if (positionInFile > 0) {
			pane.setCaretPosition(positionInFile - 1);
		} else {
			pane.setCaretPosition(0);
		}

		centerLineWithCaretInScrollPane();

		pane.requestFocus();
	}

	public void scrollToStart() {
		scrollTo(0);
	}

	public void scrollToToken(Token token) {
		final int offset = document.getOffset(token);

		if (offset >= 0)
			scrollTo(offset + 1);
	}

	public void scrollToLine(int line) {
		final int offset = document.getOffsetForLine(line);

		if (offset >= 0)
			scrollTo(offset + 1);
	}

	private void centerLineWithCaretInScrollPane() {
		centerPositionInScrollPane(pane.getCaretPosition());
	}

	private void centerPositionInScrollPane(int position) {
		// Based on:
		// http://forums.sun.com/thread.jspa?threadID=5358397&start=15&tstart=0
		try {
			JViewport viewport = scroll.getViewport();
			Rectangle r = pane.modelToView(position);

			if (r == null)
				return;

			int extentHeight = viewport.getExtentSize().height;
			int viewHeight = viewport.getViewSize().height;
			int y = Math.max(0, r.y - (extentHeight / 2));
			y = Math.min(y, viewHeight - extentHeight);
			viewport.setViewPosition(new Point(0, y));

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public int getNumberOfLines() {
		return document.getNumberOfLines();
	}

	public boolean find(String search) throws PatternSyntaxException {
		final int fromIndex = pane.getCaretPosition() + 1;
		if (searchPattern == null || !searchPattern.equals(search)) {
			searchPattern = search;

			String text = pane.getText();

			if (text == null)
				return false;

			final Pattern p = Pattern.compile(searchPattern,
					Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(text);

			matchingStartPositions = new ArrayList<Integer>();
			matchingEndPositions = new ArrayList<Integer>();

			while (m.find()) {
				matchingStartPositions.add(m.start());
				matchingEndPositions.add(m.end());
			}
		}

		if (matchingStartPositions.isEmpty())
			return false;

		int startPosition = matchingStartPositions.get(0);
		int endPosition = matchingEndPositions.get(0);

		for (int i = 0; i < matchingStartPositions.size(); i++) {
			if (matchingStartPositions.get(i) >= fromIndex) {
				startPosition = matchingStartPositions.get(i);
				endPosition = matchingEndPositions.get(i);
				break;
			}
		}

		// scrollTo(startPosition);
		centerPositionInScrollPane(startPosition);
		pane.select(startPosition, endPosition);

		return true;
	}

	public Highlights getNewHighlights() {
		return new Highlights(this);
	}

	public void setParseResults(ParseResults results) {
		final Tree tree = results.getParse().getTarget(KoopaTreeBuilder.class)
				.getTree();

		document = new TreeBasedDocument();
		document.setContents(tree);

		pane.getHighlighter().removeAllHighlights();
		pane.setDocument(document);
		addHighlights(results);
		pane.setCaretPosition(0);
	}

	private void addHighlights(ParseResults results) {
		try {
			final Highlighter highlighter = pane.getHighlighter();
			final HighlightPainter warningPainter = new SquiggleUnderlineHighlightPainter(
					Color.ORANGE);
			final HighlightPainter errorPainter = new SquiggleUnderlineHighlightPainter(
					Color.RED);

			// TODO Positions here are off when there are replacements.
			// TODO Also, text may be missing, as it's based on the AST...

			final Parse parse = results.getParse();
			for (Tuple<Token, String> warning : parse.getWarnings()) {
				final Token token = warning.getFirst();
				final int start = token.getStart().getPositionInFile() - 1;
				final int end = token.getEnd().getPositionInFile();
				final int len = end - start;
				highlighter.addHighlight(start, start + len, warningPainter);
			}

			for (Tuple<Token, String> error : parse.getErrors()) {
				final Token token = error.getFirst();
				if (token == null)
					continue;
				final int start = token.getStart().getPositionInFile() - 1;
				final int end = token.getEnd().getPositionInFile();
				final int len = end - start;

				highlighter.addHighlight(start, start + len, errorPainter);
			}
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TreeBasedDocument getDocument() {
		return document;
	}

	public Highlighter getHighlighter() {
		return pane.getHighlighter();
	}

	public void addTokenSelectionListener(TokenSelectionListener listener) {
		tokenSelectionListeners.add(listener);
	}

	public void removeTokenSelectionListener(TokenSelectionListener listener) {
		tokenSelectionListeners.remove(listener);
	}
}