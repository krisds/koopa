package koopa.app.components.grammarview;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.data.tags.SyntacticTag.WORD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

import koopa.app.ApplicationSupport;
import koopa.app.components.sourceview.LineNumberView;
import koopa.app.components.sourceview.LinePainter;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.dsl.kg.source.KGTokens;

public class GrammarView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextPane pane = null;

	private JScrollPane scroll = null;

	private List<Integer> lineOffsets = new ArrayList<>();

	private Map<String, Integer> ruleNameOffsets = new HashMap<>();

	public GrammarView(String pathToGrammarResource) {
		setupComponents();
		loadGrammar(pathToGrammarResource);
	}

	private void setupComponents() {
		pane = new JTextPane() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean getScrollableTracksViewportWidth() {
				return false;
			}
		};

		pane.setEditable(false);
		pane.getCaret().setVisible(true);
		pane.setMargin(new Insets(0, 5, 0, 0));

		new LinePainter(pane, new Color(230, 240, 254));

		scroll = new JScrollPane(pane);

		LineNumberView linenumbers = new LineNumberView(pane);
		linenumbers.setForeground(Color.GRAY);
		linenumbers.setFont(new Font("Courier", Font.PLAIN, 14));
		scroll.setRowHeaderView(linenumbers);

		scroll.setBorder(null);

		pane.setCaretPosition(0);

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
	}

	// TODO There are also style definitions in SourceView. Extract to a common
	// definitions class ?

	private static Style defaultStyle = null;

	private static Style getDefaultStyle(StyledDocument document) {
		if (defaultStyle == null) {
			Style style = defaultStyle = document.addStyle("default", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, Color.BLACK);
		}

		return defaultStyle;
	}

	private static Style commentStyle = null;

	private static Style getCommentStyle(StyledDocument document) {
		if (commentStyle == null) {
			Style style = commentStyle = document.addStyle("comment", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, new Color(77, 144, 114));
		}

		return commentStyle;
	}

	private static Style keywordStyle = null;

	private static Style getKeywordStyle(StyledDocument document) {
		if (keywordStyle == null) {
			Style style = keywordStyle = document.addStyle("keyword", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, true);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, new Color(157, 0, 122));
		}

		return keywordStyle;
	}

	private static Style identifierStyle = null;

	private static Style getIdentifierStyle(StyledDocument document) {
		if (identifierStyle == null) {
			Style style = identifierStyle = document.addStyle("identifier",
					null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, new Color(42, 143, 189));
		}

		return identifierStyle;
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
		// Based on:
		// http://forums.sun.com/thread.jspa?threadID=5358397&start=15&tstart=0
		try {
			JViewport viewport = scroll.getViewport();
			Rectangle r = pane.modelToView(pane.getCaretPosition());
			int extentHeight = viewport.getExtentSize().height;
			int viewHeight = viewport.getViewSize().height;
			int y = Math.max(0, r.y - (extentHeight / 2));
			y = Math.min(y, viewHeight - extentHeight);
			viewport.setViewPosition(new Point(0, y));

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private void loadGrammar(String pathToGrammarResource) {
		final StyledDocument document = new DefaultStyledDocument();

		setupTabStops();

		colorize(document, pathToGrammarResource);

		pane.setDocument(document);

		pane.setCaretPosition(1);
		pane.setCaretPosition(0);
	}

	private void setupTabStops() {
		// Ugly piece of code; needed because default tab indentation is too
		// big.
		StyleContext sc = StyleContext.getDefaultStyleContext();

		Toolkit t = Toolkit.getDefaultToolkit();
		FontMetrics fm = t.getFontMetrics(new Font("Courier", Font.PLAIN, 14));
		int cw = fm.stringWidth("    ");

		final TabStop[] tabStops = new TabStop[60];
		for (int i = 0; i < tabStops.length; i++)
			tabStops[i] = new TabStop((i + 1) * cw);

		TabSet tabs = new TabSet(tabStops);
		AttributeSet paraSet = sc.addAttribute(SimpleAttributeSet.EMPTY,
				StyleConstants.TabSet, tabs);

		pane.setParagraphAttributes(paraSet, false);
	}

	private void colorize(StyledDocument document,
			String pathToGrammarResource) {
		// TODO I should really parse the input and query the tree for coloring
		// things. Pure tokens will no longer be enough.

		InputStream resourceStream = null;
		InputStreamReader reader = null;
		try {
			resourceStream = GrammarView.class
					.getResourceAsStream(pathToGrammarResource);

			reader = new InputStreamReader(
					resourceStream);

			final Source source = KGTokens.getNewSource(pathToGrammarResource,
					reader);

			boolean justSawDef = false;
			while (true) {
				final Data d = source.next();

				if (d == null)
					break;

				if (!(d instanceof Token))
					continue;

				final Token token = (Token) d;

				Style style = null;
				if (token.hasTag(COMMENT)) {
					style = getCommentStyle(document);
					justSawDef = false;

				} else if ("def".equals(token.getText())) {
					style = getKeywordStyle(document);
					justSawDef = true;

				} else if ("end".equals(token.getText())) {
					style = getKeywordStyle(document);
					justSawDef = false;

				} else if (token.hasTag(WORD)) {
					// TODO Picking up on the above TODO, here is why: an
					// identifier may consist of multiple tokens. So the code
					// below is no longer correct.
					if (!token.getText().toUpperCase().equals(token.getText()))
						style = getIdentifierStyle(document);

					if (justSawDef)
						ruleNameOffsets.put(token.getText(),
								token.getStart().getPositionInFile());

					justSawDef = false;

					// TODO This too now requires a parse tree to detect.
					// } else if (token.hasTag(KGTag.NATIVE_CODE_BLOCK)) {
					// style = getNativeStyle(document);
					// justSawDef = false;

				} else if (token.hasTag(WHITESPACE)) {
					// Nop.

				} else {
					justSawDef = false;
				}

				if (style == null)
					style = getDefaultStyle(document);

				document.insertString(token.getStart().getPositionInFile(),
						token.getText(), style);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (resourceStream != null)
					resourceStream.close();
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {
		final GrammarView grammarView = new GrammarView(
				"/koopa/cobol/grammar/Cobol.kg");

		ApplicationSupport.inFrame("Cobol grammar", grammarView)
				.setVisible(true);
	}

	public void showRule(String name) {
		if (name == null || !ruleNameOffsets.containsKey(name))
			pane.setCaretPosition(0);
		else
			pane.setCaretPosition(ruleNameOffsets.get(name));

		centerLineWithCaretInScrollPane();
	}
}