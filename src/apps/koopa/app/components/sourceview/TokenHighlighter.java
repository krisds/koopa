package koopa.app.components.sourceview;

import java.awt.Color;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import koopa.app.components.highlights.Highlights;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.data.tags.IslandTag;
import koopa.core.data.tags.SyntacticTag;

public class TokenHighlighter implements CaretListener {

	private final SourceView view;
	private final Highlights highlights;

	public TokenHighlighter(SourceView view) {
		this.view = view;
		this.highlights = view.getNewHighlights();
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		highlights.removeAllHighlights();

		if (e.getDot() != e.getMark())
			return;

		final Token token = view.getDocument().getTokenAt(e.getDot());
		if (token == null)
			return;

		highlights.addHighlight(token, colorFor(token));
	}

	private Color colorFor(Token token) {
		if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA))
			return Color.YELLOW;

		if (token.hasTag(IslandTag.WATER))
			return Color.YELLOW;

		if (token.hasTag(SyntacticTag.SEPARATOR)
				&& token.getText().trim().length() == 0)
			return Color.YELLOW;

		return Color.ORANGE;
	}
}
