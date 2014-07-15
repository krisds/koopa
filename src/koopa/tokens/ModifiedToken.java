package koopa.tokens;

import java.util.HashSet;
import java.util.Set;

/**
 * This token wraps any other {@linkplain Token} and lets you add/remove tags
 * without modifying the original one.
 */
public class ModifiedToken implements Token {

	private final Token wrappedToken;
	private final Set<Object> additionalTags = new HashSet<Object>();
	private final Set<Object> deletedTags = new HashSet<Object>();

	public ModifiedToken(Token wrappedToken) {
		this.wrappedToken = wrappedToken;
	}

	@Override
	public String getText() {
		return wrappedToken.getText();
	}

	@Override
	public void setStart(Position start) {
		wrappedToken.setStart(start);
	}

	@Override
	public Position getStart() {
		return wrappedToken.getStart();
	}

	@Override
	public void setEnd(Position end) {
		wrappedToken.setEnd(end);
	}

	@Override
	public Position getEnd() {
		return wrappedToken.getEnd();
	}

	@Override
	public int getLength() {
		return wrappedToken.getLength();
	}

	/**
	 * Adds an extra tag to the set of tags for this token.
	 * <p>
	 * Note that this does not modify the wrapped token. The additional tags are
	 * maintained in a separate set.
	 */
	@Override
	public void addTag(Object tag) {
		if (deletedTags.contains(tag))
			deletedTags.remove(tag);

		if (!wrappedToken.hasTag(tag))
			additionalTags.add(tag);
	}

	/**
	 * Removes a tag from the set of tags for this token.
	 * <p>
	 * Note that this does not modify the wrapped token. The removed tags are
	 * maintained in a separate set.
	 */
	@Override
	public void removeTag(Object tag) {
		if (additionalTags.contains(tag))
			additionalTags.remove(tag);
		deletedTags.add(tag);
	}

	/**
	 * Checks whether a given tag is known by this token. This is the case when
	 * it was not asked to be removed, and it was either added here or already
	 * part of the original token.
	 */
	@Override
	public boolean hasTag(Object tag) {
		return !deletedTags.contains(tag)
				&& (additionalTags.contains(tag) || wrappedToken.hasTag(tag));
	}

	/**
	 * All tags belonging to this token. This takes the additions and removals
	 * against the original token into account.
	 */
	@Override
	public Set<Object> getTags() {
		Set<Object> tags = new HashSet<Object>();

		tags.addAll(wrappedToken.getTags());
		tags.addAll(additionalTags);
		tags.removeAll(deletedTags);

		return tags;
	}

	@Override
	public int tagCount() {
		return getTags().size();
	}
}
