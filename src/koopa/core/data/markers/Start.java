package koopa.core.data.markers;

import java.util.HashMap;
import java.util.Map;

import koopa.core.data.Marker;

/**
 * Marks the start of a structure/branch. Think of this like an opening tag in
 * XML.
 * <p>
 * This uses a singleton-like approach, in that there can be no two instances of
 * this which share the same name.
 */
public final class Start extends Marker {

	private static Map<String, Start> markers = new HashMap<String, Start>();

	private final String name;

	private Start(String name) {
		assert (name != null);
		this.name = name;
	}

	public static Start on(String name) {
		if (!markers.containsKey(name))
			markers.put(name, new Start(name));

		return markers.get(name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String toString() {
		return "<" + name + ">";
	}
}
