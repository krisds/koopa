package koopa.core.sources.test.samples;

import java.util.LinkedHashSet;
import java.util.Set;

class Annotation {

	private final Set<String> required = new LinkedHashSet<>();
	private final Set<String> forbidden = new LinkedHashSet<>();

	public Annotation() {
	}

	public Annotation(Annotation annotation) {
		this.required.addAll(annotation.required);
		this.forbidden.addAll(annotation.forbidden);
	}

	public void add(String category, boolean required) {
		if (required)
			this.required.add(category);
		else
			this.forbidden.add(category);
	}

	public Set<String> getRequired() {
		return required;
	}

	public Set<String> getForbidden() {
		return forbidden;
	}

	public void mergeWith(Annotation other) {
		// Offsets are not overwritten.
		required.addAll(other.required);
		forbidden.addAll(other.forbidden);
	}
}