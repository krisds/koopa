package koopa.tokens;

import java.util.HashSet;
import java.util.Set;

public class TokenBase {
	private Set<Object> tags;

	public TokenBase() {
		this.tags = new HashSet<Object>();
	}

	public void addTag(Object tag) {
		tags.add(tag);
	}

	public void removeTag(Object tag) {
		tags.remove(tag);
	}

	public boolean hasTag(Object tag) {
		return tags.contains(tag);
	}

	public Set<Object> getTags() {
		return tags;
	}
}
