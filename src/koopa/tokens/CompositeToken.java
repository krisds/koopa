package koopa.tokens;

import java.util.LinkedList;
import java.util.List;

public class CompositeToken extends TokenBase implements Token {

	private List<Token> tokens = null;
	private Position start = null;
	private Position end = null;
	private StringBuffer text = null;

	public CompositeToken() {
		this.tokens = new LinkedList<Token>();
	}

	public void addToken(Token token) {
		assert (token != null);

		if (start == null) {
			start = token.getStart();
			text = new StringBuffer();
		}

		tokens.add(token);

		text.append(token.getText());
		end = token.getEnd();
	}

	public Token removeToken(int index) {
		Token token = tokens.remove(index);
		if (token != null) {
			// Need to update the buffered string.
			text.delete(0, token.getLength());
		}
		return token;
	}

	public Token getToken(int index) {
		return tokens.get(index);
	}

	public int size() {
		return tokens.size();
	}

	public Position getEnd() {
		return end;
	}

	public Position getStart() {
		return start;
	}

	public String getText() {
		return text.toString();
	}

	public int getLength() {
		return text.length();
	}

	public String toString() {
		return "[" + start + "|" + getText() + "|" + end + "|#" + tokens.size()
				+ "]";
	}

	public void addTag(Object tag) {
		super.addTag(tag);
		for (Token token : this.tokens) {
			token.addTag(tag);
		}
	}

	public void removeTag(Object tag) {
		super.removeTag(tag);
		for (Token token : this.tokens) {
			token.removeTag(tag);
		}
	}

	public void setEnd(Position end) {
		this.end = end;
	}

	public void setStart(Position start) {
		this.start = start;
	}
}
