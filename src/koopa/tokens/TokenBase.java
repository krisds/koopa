package koopa.tokens;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TokenBase {
	private Set<Object> tags;

	public TokenBase() {
		this.tags = new HashSet<Object>();
	}

	public void addTag(Object tag) {
		this.tags.add(tag);
	}

	public void removeTag(Object tag) {
		this.tags.remove(tag);
	}

	public boolean hasTag(Object tag) {
		return this.tags.contains(tag);
	}

	public Set<Object> getTags() {
		return this.tags;
	}

	public void addTags(Collection<Object> tags) {
		this.tags.addAll(tags);
	}

	public int tagCount() {
		return this.tags.size();
	}
}
