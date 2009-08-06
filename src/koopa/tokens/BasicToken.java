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
}
