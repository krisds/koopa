package koopa.app.components.highlights;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import koopa.core.data.Position;
import koopa.core.data.Range;
import koopa.core.data.Token;

public class Highlights {

	private final Highlighter highlighter;
	private List<Object> hls = new ArrayList<Object>();

	public Highlights(JTextPane view) {
		this.highlighter = view.getHighlighter();
	}

	public void addHighlight(Token token, Color color) {
		for (Range range : token.getRanges())
			addHighlight(range.getStart(), range.getEnd(), color);
	}

	public void addHighlight(Position start, Position end, Color color) {
		try {
			int from = start.getPositionInFile() - 1;
			int to = end.getPositionInFile();
			DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
					color);
			hls.add(highlighter.addHighlight(from, to, painter));

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public void removeAllHighlights() {
		for (Object hl : hls)
			highlighter.removeHighlight(hl);

		hls.clear();
	}
}
