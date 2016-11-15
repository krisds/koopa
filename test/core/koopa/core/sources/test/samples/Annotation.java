package koopa.core.sources.test.samples;

import java.util.LinkedHashSet;
import java.util.Set;

import koopa.core.util.Strings;

class Annotation {

	private Set<String> categories = new LinkedHashSet<String>();

	public void add(String category) {
		categories.add(category);
	}

	public Set<String> getCategories() {
		return categories;
	}

	@Override
	public String toString() {
		return Strings.join("/", categories);
	}

	public void mergeWith(Annotation other) {
		// Offsets are not overwritten.
		categories.addAll(other.categories);
	}
}