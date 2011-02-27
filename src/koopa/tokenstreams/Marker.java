package koopa.tokenstreams;

import java.util.Set;

import koopa.tokens.Position;
import koopa.tokens.Token;

public abstract class Marker implements Token {

	public abstract String getName();

	public void addTag(Object tag) {
	}

	public Position getEnd() {
		return null;
	}

	public int getLength() {
		return 0;
	}

	public Position getStart() {
		return null;
	}

	public Set<Object> getTags() {
		return null;
	}

	public String getText() {
		return null;
	}

	public boolean hasTag(Object tag) {
		return false;
	}

	public void removeTag(Object tag) {
	}

	public void setEnd(Position end) {
	}

	public void setStart(Position start) {
	}

	public int tagCount() {
		return 0;
	}

	public Token subtoken(int beginIndex) {
		return null;
	}

	public Token subtoken(int beginIndex, int endIndex) {
		return null;
	}

	public Token[] split(int cutIndex) {
		return null;
	}
}
