package koopa.app.components.sourceview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import koopa.app.listeners.TokenSelectionListener;
import koopa.cobol.data.tags.SyntacticTag;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.cobol.CobolParser;
import koopa.cobol.parser.cobol.ParsingCoordinator;
import koopa.cobol.parser.cobol.ParsingListener;
import koopa.core.data.Range;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.data.tags.IslandTag;
import koopa.core.targets.TokenTracker;

@SuppressWarnings("serial")
public class SourceView extends JPanel implements ParsingListener {

	private JTextPane pane = null;

	private JScrollPane scroll = null;

	// private SourceViewIntermediateTokenizer tokenizer = null;

	private List<Integer> lineOffsets = new ArrayList<Integer>();

	private TokenTracker tokenTracker = null;

	private SourceViewSink sink = null;

	private Token selectedToken = null;

	private List<TokenSelectionListener> tokenSelectionListeners = new ArrayList<TokenSelectionListener>();

	private String searchPattern = null;
	private List<Integer> matchingStartPositions = null;
	private List<Integer> matchingEndPositions = null;

	public SourceView(ParsingCoordinator coordinator) {
		setupComponents();

		coordinator.addParsingListener(this);
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
				if (!caret.isVisible() && pane.getDocument().getLength() > 0) {
					caret.setVisible(true);
				}

				// TODO Add support for Token selection listeners.
				Token token = getTokenAt(e.getDot() + 1);
				if (token != selectedToken) {
					selectedToken = token;
					for (TokenSelectionListener listener : tokenSelectionListeners) {
						listener.selectedToken(selectedToken);
					}
				}
			}
		});

		// new LinePainter(pane, new Color(238, 245, 254));
		new LinePainter(pane, new Color(230, 240, 254));
		new TokenHighlighter(this, pane);

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

	private static Style getDefaultStyle(StyledDocument document) {
		Style style = document.getStyle("water");
		if (style == null) {
			style = document.addStyle("water", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, new Color(192, 238, 250));
			StyleConstants.setForeground(style, Color.GRAY);
		}

		return style;
	}

	private static Style getLandStyle(StyledDocument document) {
		Style style = document.getStyle("land");
		if (style == null) {
			style = document.addStyle("land", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, Color.BLACK);
		}

		return style;
	}

	private static Style getCommentStyle(StyledDocument document) {
		Style style = document.getStyle("comment");
		if (style == null) {
			style = document.addStyle("comment", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, new Color(77, 144, 114));
		}

		return style;
	}

	private static Style getCompilerDirectiveStyle(StyledDocument document) {
		Style style = document.getStyle("compilerDirective");
		if (style == null) {
			style = document.addStyle("compilerDirective", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, new Color(77, 144, 114));
			StyleConstants.setForeground(style, Color.WHITE);
		}

		return style;
	}

	private static Style getStringStyle(StyledDocument document) {
		Style style = document.getStyle("string");
		if (style == null) {
			style = document.addStyle("string", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, new Color(59, 49, 255));
		}

		return style;
	}

	private String getContents(File file) throws IOException {
		StringBuilder builder = new StringBuilder();

		BufferedReader br = null;

		lineOffsets.clear();

		int offset = 0;
		lineOffsets.add(offset);

		try {
			br = new BufferedReader(new FileReader(file));

			char[] buffer = new char[1024];
			int len;

			while ((len = br.read(buffer)) > 0) {
				builder.append(buffer, 0, len);

				for (int i = 0; i < len; i++) {
					if (buffer[i] == '\n') {
						if (buffer[i] == '\r')
							lineOffsets.add(offset + i + 3);
						else
							lineOffsets.add(offset + i + 2);
					}
				}

				offset += len;
			}

			return builder.toString();

		} finally {
			if (br != null)
				br.close();
		}
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

	public void scrollToLine(int line) {
		if (line < 0 || line >= lineOffsets.size())
			throw new IllegalArgumentException("No such line number: " + line);

		scrollTo(lineOffsets.get(line));
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

	public void beforeParsing(File file, CobolParser config) {
		pane.setText("");
		pane.getHighlighter().removeAllHighlights();

		// this.tokenizer = new SourceViewIntermediateTokenizer();
		this.sink = new SourceViewSink();

		// config.addIntermediateTokenizer(this.tokenizer);
		config.addTokenSink(this.sink);
	}

	public void afterParsing(File file, ParseResults results) {
		try {
			final StyledDocument document = new DefaultStyledDocument();

			document.insertString(0, getContents(file),
					getDefaultStyle(document));

			this.tokenTracker = results.getTokenTracker();

			for (Token token : this.tokenTracker.getTokens()) {
				if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
					continue;
				}

				final int start = token.getStart().getPositionInFile() - 1;
				final int end = token.getEnd().getPositionInFile();
				final int len = end - start;

				if (token.hasTag(AreaTag.COMPILER_DIRECTIVE))
					document.setCharacterAttributes(start, len,
							getCompilerDirectiveStyle(document), false);
				else
					document.setCharacterAttributes(start, len,
							getCommentStyle(document), false);
			}

			// for (List<Token> line : tokenizer.getLines()) {
			// for (Token token : line) {
			// final int start = token.getStart().getPositionInFile() - 1;
			// final int end = token.getEnd().getPositionInFile();
			// final int len = end - start;
			//
			// document.setCharacterAttributes(start, len,
			// getCommentStyle(document), false);
			// }
			// }

			final List<List<Token>> lines = sink.getLines();
			for (List<Token> line : lines) {
				for (Token token : line) {

					final Style style;
					if (token.hasTag(SyntacticTag.STRING_LITERAL)) {
						style = getStringStyle(document);

						// } else if
						// (token.hasTag(SyntacticTag.DECIMAL_LITERAL)) {
						// document.setCharacterAttributes(start, len,
						// getStringStyle(document), false);
						//
						// } else if
						// (token.hasTag(SyntacticTag.INTEGER_LITERAL)) {
						// document.setCharacterAttributes(start, len,
						// getStringStyle(document), false);
						//
						// } else if (token.hasTag(SyntacticTag.PSEUDO_LITERAL))
						// {
						// document.setCharacterAttributes(start, len,
						// getStringStyle(document), false);

					} else if (token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
							&& token.hasTag(IslandTag.LAND)) {
						style = getLandStyle(document);

					} else {
						continue;
					}

					for (Range range: token.getRanges()) {
						final int start = range.getStart().getPositionInFile() - 1;
						final int end = range.getEnd().getPositionInFile();
						final int len = end - start;
						document.setCharacterAttributes(start, len, style, false);
					}
				}
			}

			final Highlighter highlighter = pane.getHighlighter();
			final HighlightPainter warningPainter = new SquiggleUnderlineHighlightPainter(
					Color.ORANGE);
			final HighlightPainter errorPainter = new SquiggleUnderlineHighlightPainter(
					Color.RED);

			for (int i = 0; i < results.getWarningCount(); i++) {
				final Token token = results.getWarning(i).getFirst();
				final int start = token.getStart().getPositionInFile() - 1;
				final int end = token.getEnd().getPositionInFile();
				final int len = end - start;

				// document.setCharacterAttributes(start, len,
				// getWarningStyle(document), false);
				highlighter.addHighlight(start, start + len, warningPainter);
			}

			for (int i = 0; i < results.getErrorCount(); i++) {
				final Token token = results.getError(i).getFirst();
				final int start = token.getStart().getPositionInFile() - 1;
				final int end = token.getEnd().getPositionInFile();
				final int len = end - start;

				// document.setCharacterAttributes(start, len,
				// getErrorStyle(document), false);
				highlighter.addHighlight(start, start + len, errorPainter);
			}

			pane.setDocument(document);
			pane.setCaretPosition(0);

		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Token getTokenAt(int position) {
		if (this.tokenTracker == null) {
			return null;

		} else {
			return this.tokenTracker.getTokenAt(position);
		}
	}

	public void addTokenSelectionListener(TokenSelectionListener listener) {
		this.tokenSelectionListeners.add(listener);
	}

	public int getNumberOfLines() {
		return lineOffsets.size();
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
}