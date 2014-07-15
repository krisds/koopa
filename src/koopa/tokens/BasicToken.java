package koopa.tokens;

/**
 * Basic implementation of a {@linkplain Token}. This one keeps track of its own
 * data.
 */
public class BasicToken extends TokenBase implements Token {
	protected final String text;
	protected Position start;
	protected Position end;

	public BasicToken(String text, Position start, Position end) {
		super();
		this.text = text;
		this.start = start;
		this.end = end;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public Position getStart() {
		return start;
	}

	@Override
	public Position getEnd() {
		return end;
	}

	@Override
	public int getLength() {
		return text.length();
	}

	@Override
	public String toString() {
		return "[" + start + "|" + text + "|" + end + "]";
	}

	@Override
	public void setEnd(Position end) {
		this.end = end;
	}

	@Override
	public void setStart(Position start) {
		this.start = start;
	}
}
