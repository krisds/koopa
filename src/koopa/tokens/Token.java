package koopa.tokens;

import java.util.Set;

public interface Token {

	/**
	 * May return null for "virtual" tokens.
	 */
	String getText();

	/**
	 * May return null for "virtual" tokens.
	 */
	Position getStart();

	/**
	 * May return null for "virtual" tokens.
	 */
	Position getEnd();

	void addTag(Object tag);

	boolean hasTag(Object tag);

	int getLength();

	void removeTag(Object tag);

	Set<Object> getTags();

	void setStart(Position start);

	void setEnd(Position end);

	int tagCount();
}