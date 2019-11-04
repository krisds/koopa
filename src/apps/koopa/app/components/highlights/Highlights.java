package koopa.app.components.highlights;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import koopa.app.components.sourceview.SourceView;
import koopa.core.data.Position;
import koopa.core.data.Range;
import koopa.core.data.Token;

// TODO Make it work against a TextPanel ?
public class Highlights {

	private final SourceView sourceView;
	private List<Object> hls = new ArrayList<>();

	public Highlights(SourceView sourceView) {
		this.sourceView = sourceView;
	}

	public void addHighlight(Token token, Color color) {
		int offset = sourceView.getDocument().getOffset(token);
		if (offset < 0)
			return;

		int delta = offset - token.getStart().getPositionInFile();
		for (Range range : token.getRanges())
			addHighlight(delta, range.getStart(), range.getEnd(), color);
	}

	private void addHighlight(int delta, Position start, Position end,
			Color color) {
		try {
			int from = start.getPositionInFile() + delta;
			int to = end.getPositionInFile() + delta + 1;
			DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
					color);
			hls.add(sourceView.getHighlighter().addHighlight(from, to, painter));

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public void removeAllHighlights() {
		final Highlighter highlighter = sourceView.getHighlighter();

		for (Object hl : hls)
			highlighter.removeHighlight(hl);

		hls.clear();
	}
}
