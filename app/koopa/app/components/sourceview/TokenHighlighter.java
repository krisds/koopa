package koopa.app.components.sourceview;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.IslandTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;

public class TokenHighlighter implements CaretListener {

	private SourceView view = null;
	private Highlighter highlighter = null;

	public TokenHighlighter(SourceView view, JTextComponent pane) {
		this.view = view;
		this.highlighter = pane.getHighlighter();
		pane.addCaretListener(this);
	}

	private List<Object> hls = new ArrayList<Object>();

	public void caretUpdate(CaretEvent e) {
		final Token token = this.view.getTokenAt(e.getDot() + 1);

		// System.out.println(token);

		clear();

		if (token == null) {
			return;
		}

		if (token != null) {
			highlight(token, colorFor(token));
		}
	}

	private Color colorFor(Token token) {
		if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
			return Color.YELLOW;
		}

		if (token.hasTag(IslandTag.WATER)) {
			return Color.YELLOW;
		}

		if (token.hasTag(SyntacticTag.SEPARATOR)
				&& token.getText().trim().length() == 0) {
			return Color.YELLOW;
		}

		return Color.ORANGE;
	}

	private void highlight(Token token, Color color) {
		if (token instanceof CompositeToken) {
			CompositeToken composite = (CompositeToken) token;
			for (int i = 0; i < composite.size(); i++) {
				highlight(composite.getToken(i), color);
			}

		} else {
			set(token.getStart().getPositionInFile(), token.getEnd()
					.getPositionInFile(), color);
		}
	}

	private void clear() {
		for (Object hl : this.hls) {
			this.highlighter.removeHighlight(hl);
		}

		this.hls.clear();
	}

	private void set(int start, int end, Color color) {
		try {
			this.hls.add(this.highlighter.addHighlight(start - 1, end,
					new DefaultHighlighter.DefaultHighlightPainter(color)));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
