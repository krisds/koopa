package koopa.tokens;

public class BasicToken extends TokenBase implements Token {
	protected String text;
	protected Position start;
	protected Position end;

	public BasicToken(String text, Position start, Position end) {
		super();
		this.text = text;
		this.start = start;
		this.end = end;
	}

	public String getText() {
		return text;
	}

	public Position getStart() {
		return start;
	}

	public Position getEnd() {
		return end;
	}

	public int getLength() {
		return text.length();
	}

	public String toString() {
		return "[" + start + "|" + text + "|" + end + "]";
	}

	public void setEnd(Position end) {
		this.end = end;
	}

	public void setStart(Position start) {
		this.start = start;
	}

	public Token subtoken(int beginIndex) {
		if (beginIndex == 0) {
			return this;
		}

		final BasicToken token = new BasicToken(text.substring(beginIndex),
				start.offsetBy(beginIndex), end);

		token.addTags(getTags());

		return token;
	}

	public Token subtoken(int beginIndex, int endIndex) {
		if (beginIndex == 0 && endIndex == text.length()) {
			return this;
		}

		final BasicToken token = new BasicToken(text.substring(beginIndex,
				endIndex), start.offsetBy(beginIndex), start
				.offsetBy(endIndex - 1));

		token.addTags(getTags());

		return token;
	}

	public Token[] split(int cutIndex) {
		if (cutIndex <= 0) {
			return new Token[] { null, this };
		}

		if (cutIndex >= text.length()) {
			return new Token[] { this, null };
		}

		return new Token[] { subtoken(0, cutIndex), subtoken(cutIndex) };
	}
}
