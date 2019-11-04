package koopa.app.components.textual;

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
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

import koopa.app.Textual;
import koopa.app.components.sourceview.LineNumberView;

public class TextPanel extends JPanel implements Textual {

	private static final long serialVersionUID = 1L;

	private JTextPane text = null;
	private JScrollPane scroll = null;

	private String searchPattern = null;
	private List<Integer> matchingStartPositions = null;
	private List<Integer> matchingEndPositions = null;

	public TextPanel() {
		setupComponents();
	}

	private void setupComponents() {
		text = new JTextPane() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean getScrollableTracksViewportWidth() {
				return false;
			}
		};

		text.setEditable(false);
		text.getCaret().setVisible(true);
		text.setMargin(new Insets(0, 5, 0, 0));

		EmptyBorder eb = new EmptyBorder(new Insets(10, 10, 10, 10));
		text.setBorder(eb);
		text.setMargin(new Insets(5, 5, 5, 5));

		scroll = new JScrollPane();
		scroll.setViewportView(text);

		LineNumberView linenumbers = new LineNumberView(text);
		linenumbers.setForeground(Color.GRAY);
		linenumbers.setFont(new Font("Courier", Font.PLAIN, 14));
		scroll.setRowHeaderView(linenumbers);

		add(scroll);

		text.moveCaretPosition(0);
		text.setCaretPosition(0);

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
	}

	public void scrollTo(int positionInFile) {
		if (positionInFile >= 0)
			text.setCaretPosition(positionInFile);
		else
			text.setCaretPosition(0);

		centerLineWithCaretInScrollPane();

		text.requestFocus();
	}

	public void scrollToStart() {
		scrollTo(0);
	}

	private void centerLineWithCaretInScrollPane() {
		centerPositionInScrollPane(text.getCaretPosition());
	}

	private void centerPositionInScrollPane(int position) {
		// Based on:
		// http://forums.sun.com/thread.jspa?threadID=5358397&start=15&tstart=0
		try {
			JViewport viewport = scroll.getViewport();
			Rectangle r = text.modelToView(position);

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

	@Override
	public boolean find(String pattern) throws PatternSyntaxException {
		final int fromIndex = text.getCaretPosition() + 1;
		if (searchPattern == null || !searchPattern.equals(pattern)) {
			searchPattern = pattern;

			final String content = text.getText();

			if (content == null)
				return false;

			final Pattern p = Pattern.compile(searchPattern,
					Pattern.CASE_INSENSITIVE);
			final Matcher m = p.matcher(content);

			matchingStartPositions = new ArrayList<>();
			matchingEndPositions = new ArrayList<>();

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
		text.select(startPosition, endPosition);

		return true;
	}

	public void setStyledDocument(StyledDocument document) {
		text.setStyledDocument(document);
	}

	@Override
	public void setBackground(Color bg) {
		if (text != null)
			text.setBackground(bg);
		if (scroll != null)
			scroll.getViewport().setBackground(bg);
	}

	protected JTextPane getTextPane() {
		return text;
	}

	/* Copied from javax.swing.text.PlainDocument */
	@Override
	public int getAdjustedLineCount() {
		// There is an implicit break being modeled at the end of the
		// document to deal with boundary conditions at the end. This
		// is not desired in the line count, so we detect it and remove
		// its effect if throwing off the count.
		Element map = text.getDocument().getDefaultRootElement();
		int n = map.getElementCount();
		Element lastLine = map.getElement(n - 1);
		if ((lastLine.getEndOffset() - lastLine.getStartOffset()) > 1) {
			return n;
		}

		return n - 1;
	}

	@Override
	public void scrollToLine(int line) {
		Element map = text.getDocument().getDefaultRootElement();
		Element lastLine = map.getElement(line);
		scrollTo(lastLine.getStartOffset());
	}
}