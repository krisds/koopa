package koopa.app.components.sourceview;

import static koopa.app.components.sourceview.GetStyle.forTokenInDocument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.trees.Tree;

public class TreeBasedDocument extends DefaultStyledDocument implements
		StyledDocument {

	private static final long serialVersionUID = 1L;

	private List<Integer> offsetsForLines = new ArrayList<Integer>();
	private Map<Token, Integer> offsetsForTokens = new HashMap<Token, Integer>();
	private Map<Integer, Token> tokensForOffsets = new HashMap<Integer, Token>();

	public void setContents(Tree tree) {
		try {
			clear();

			int offset = 0;
			offsetsForLines.add(0);
			for (Token token : tree.allTokens()) {
				final AttributeSet style = forTokenInDocument(token, this);

				insertString(offset, token.getText(), style);
				offsetsForTokens.put(token, offset);
				tokensForOffsets.put(offset, token);

				offset += token.getLength();

				if (token.hasTag(AreaTag.END_OF_LINE))
					offsetsForLines.add(offset);
			}

		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public int getNumberOfLines() {
		return offsetsForLines.size();
	}

	public int getOffsetForLine(int line) {
		return offsetsForLines.get(line);
	}
}
