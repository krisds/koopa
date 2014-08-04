package koopa.core.data.markers;

import java.util.HashMap;
import java.util.Map;

import koopa.core.data.Marker;

/**
 * Marks the end of a structure/branch. Think of this like an closing tag in
 * XML.
 * <p>
 * This uses a singleton-like approach, in that there can be no two instances of
 * this which share the same name.
 */
public final class End extends Marker {

	private static Map<String, End> markers = new HashMap<String, End>();

	private final String name;

	private End(String name) {
		assert (name != null);
		this.name = name;
	}

	public static End on(String name) {
		if (!markers.containsKey(name))
			markers.put(name, new End(name));

		return markers.get(name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String toString() {
		return "</" + name + ">";
	}
}
