package koopa.app.components.sourceview;

import static koopa.app.components.sourceview.GetStyle.forTokenInDocument;
import static koopa.app.components.sourceview.GetStyle.forUnparsed;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import koopa.core.data.Token;
import koopa.core.trees.Tree;

// TODO This vs Code class.
public class TreeBasedDocument extends DefaultStyledDocument
		implements StyledDocument {

	private static final long serialVersionUID = 1L;

	private List<Integer> offsetsForLines = new ArrayList<>();
	private Map<Token, Integer> offsetsForTokens = new HashMap<>();
	private Map<Integer, Token> tokensForOffsets = new HashMap<>();

	public void setContents(Tree tree) {
		setContents(tree, null);
	}

	public void setContents(Tree tree, List<Token> additionalTokens) {
		try {
			clear();
			
			if (tree == null)
				return;

			int offset = 0;
			offsetsForLines.add(0);
			for (Token token : tree.allTokens()) {
				final AttributeSet style = forTokenInDocument(token, this);

				insertString(offset, getText(token), style);
				offsetsForTokens.put(token, offset);
				tokensForOffsets.put(offset, token);

				offset += token.getLength();

				if (token.hasTag(END_OF_LINE))
					offsetsForLines.add(offset);
			}

			if (additionalTokens != null && additionalTokens.size() > 0) {
				final AttributeSet unparsed = forUnparsed(this);
				for (Token token : additionalTokens) {
					insertString(offset, getText(token), unparsed);
					offsetsForTokens.put(token, offset);
					tokensForOffsets.put(offset, token);

					offset += token.getLength();

					if (token.hasTag(END_OF_LINE))
						offsetsForLines.add(offset);
				}
			}

		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getText(Token token) {
		// Make tab characters clearly visible.
		return token.getText().replaceAll("\\t", "\u2192");
	}

	private void clear() {
		offsetsForTokens.clear();
		tokensForOffsets.clear();
		offsetsForLines.clear();
	}

	public Token getTokenAt(int offset) {
		while (offset >= 0)
			if (tokensForOffsets.containsKey(offset))
				return tokensForOffsets.get(offset);
			else
				offset -= 1;

		return null;
	}

	public int getOffset(Token token) {
		if (offsetsForTokens.containsKey(token))
			return offsetsForTokens.get(token);
		else
			return -1;
	}
}
