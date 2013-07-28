package koopa.app.components.grammarview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

import koopa.app.components.sourceview.LineNumberView;
import koopa.app.components.sourceview.LinePainter;
import koopa.grammars.generator.KGLexer;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

public class GrammarView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextPane pane = null;

	private JScrollPane scroll = null;

	private List<Integer> lineOffsets = new ArrayList<Integer>();

	public GrammarView(String pathToGrammarResource) {
		setupComponents();
		loadGrammar(pathToGrammarResource);
	}

	private void setupComponents() {
		pane = new JTextPane() {
			private static final long serialVersionUID = 1L;

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

	private static Style nativeStyle = null;

	private static Style getNativeStyle(StyledDocument document) {
		if (nativeStyle == null) {
			Style style = nativeStyle = document.addStyle("native", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, Color.GRAY);
		}

		return nativeStyle;
	}

	private String getContents(InputStream inputStream) throws IOException {
		StringBuilder builder = new StringBuilder();

		BufferedReader br = null;

		lineOffsets.clear();

		int offset = 0;
		lineOffsets.add(offset);

		try {
			br = new BufferedReader(new InputStreamReader(inputStream));

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
		try {

			final StyledDocument document = (StyledDocument) pane.getDocument();

			setupTabStops();

			document.insertString(0, getContents(GrammarView.class
					.getResourceAsStream(pathToGrammarResource)),
					getDefaultStyle(document));

			colorize(document, pathToGrammarResource);

			pane.setCaretPosition(1);
			pane.setCaretPosition(0);

		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private void colorize(StyledDocument document, String pathToGrammarResource) {
		try {
			final InputStream resourceStream = GrammarView.class
					.getResourceAsStream(pathToGrammarResource);

			final InputStreamReader reader = new InputStreamReader(
					resourceStream);

			KGLexer lexer = new KGLexer(new ANTLRReaderStream(reader));

			while (true) {
				CommonToken token = (CommonToken) lexer.nextToken();

				if (token.getType() == Token.EOF)
					break;

				Style style = null;
				if (token.getType() == KGLexer.COMMENT) {
					style = getCommentStyle(document);

				} else if ("def".equals(token.getText())
						|| "end".equals(token.getText())) {
					style = getKeywordStyle(document);

				} else if (token.getType() == KGLexer.IDENTIFIER) {
					if (!token.getText().toUpperCase().equals(token.getText()))
						style = getIdentifierStyle(document);

				} else if (token.getType() == KGLexer.NATIVE_CODE) {
					style = getNativeStyle(document);
				}

				if (style != null) {
					final int start = token.getStartIndex();
					final int stop = token.getStopIndex();
					final int len = stop - start + 1;

					document.setCharacterAttributes(start, len, style, false);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cobol grammar");

		final GrammarView grammarView = new GrammarView(
				"/koopa/grammars/cobol/Cobol.kg");
		frame.add(grammarView);

		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}