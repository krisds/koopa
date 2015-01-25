package koopa.core.data.markers;

import java.util.HashMap;
import java.util.Map;

import koopa.core.data.Marker;

/**
 * Marks the start of a structure/branch. Think of this like an opening tag in
 * XML.
 * <p>
 * This uses a singleton-like approach, in that there can be no two instances of
 * this which share the same name and namespace.
 */
public final class Start extends Marker {

	private static Map<String, Start> markers = new HashMap<String, Start>();

	private final String namespace;
	private final String name;

	private Start(String namespace, String name) {
		assert (namespace != null);
		assert (name != null);

		this.namespace = namespace;
		this.name = name;
	}

	public static Start on(String namespace, String name) {
		String key = namespace + ":" + name;

		if (!markers.containsKey(key))
			markers.put(key, new Start(namespace, name));

		return markers.get(key);
	}

	public String getNamspace() {
		return this.namespace;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String toString() {
		return "<" + namespace + ":" + name + ">";
	}
}
