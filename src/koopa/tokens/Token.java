package koopa.tokens;

import java.util.Set;

public interface Token {

	/**
	 * May return null for "virtual" tokens.
	 */
	public abstract String getText();

	/**
	 * May return null for "virtual" tokens.
	 */
	public abstract Position getStart();

	/**
	 * May return null for "virtual" tokens.
	 */
	public abstract Position getEnd();

	public abstract void addTag(Object tag);

	public abstract boolean hasTag(Object tag);

	public abstract int getLength();

	public abstract void removeTag(Object tag);

	public abstract Set<Object> getTags();

	public abstract void setStart(Position start);

	public abstract void setEnd(Position end);
}