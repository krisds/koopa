package koopa.app.components.markdownview;

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

public class MarkdownView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextPane pane = null;

	private JScrollPane scroll = null;

	private List<Integer> lineOffsets = new ArrayList<>();

	public MarkdownView(String resourcePath) {
		setupComponents();
		load(resourcePath);
	}

	private void setupComponents() {
		pane = new JTextPane();

		pane.setEditable(false);
		pane.getCaret().setVisible(true);
		pane.setMargin(new Insets(0, 5, 0, 0));

		scroll = new JScrollPane(pane);
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
			Style style = defaultStyle = document.addStyle("deflt", null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, false);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style, 14);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, Color.BLACK);
		}

		return defaultStyle;
	}

	private static Style[] headingStyles = new Style[5];

	private static Style getHeadingStyle(StyledDocument document, int heading) {
		if (heading > headingStyles.length)
			heading = headingStyles.length;
		heading -= 1;

		if (headingStyles[heading] == null) {
			Style style = headingStyles[heading] = document.addStyle("heading",
					null);

			StyleConstants.setItalic(style, false);
			StyleConstants.setBold(style, true);
			StyleConstants.setFontFamily(style, "Courier");
			StyleConstants.setFontSize(style,
					14 + (headingStyles.length - heading) * 2);
			// StyleConstants.setBackground(style, Color.WHITE);
			StyleConstants.setForeground(style, Color.BLACK);
		}

		return headingStyles[heading];
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

	private void load(String resourcePath) {
		final StyledDocument document = new DefaultStyledDocument();

		setupTabStops();

		colorize(document, resourcePath);

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

	private void colorize(StyledDocument document, String resourcePath) {

		InputStream resourceStream = null;
		InputStreamReader reader = null;
		BufferedReader buffer = null;

		try {
			resourceStream = MarkdownView.class
					.getResourceAsStream(resourcePath);

			reader = new InputStreamReader(resourceStream);

			buffer = new BufferedReader(reader);

			String line = null;
			while ((line = buffer.readLine()) != null) {
				int heading = 0;
				for (int i = 0; i < line.length(); i++)
					if (line.charAt(i) == '#')
						heading += 1;
					else
						break;

				if (heading > 0)
					document.insertString(document.getLength(),
							line.substring(heading).trim() + "\n",
							getHeadingStyle(document, heading));
				else
					document.insertString(document.getLength(), line + "\n",
							getDefaultStyle(document));
			}

		} catch (BadLocationException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (buffer != null)
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			if (resourceStream != null)
				try {
					resourceStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}