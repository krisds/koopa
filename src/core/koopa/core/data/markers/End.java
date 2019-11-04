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

	private static Map<String, End> markers = new HashMap<>();

	private final String namespace;
	private final String name;

	private End(String namespace, String name) {
		assert (namespace != null);
		assert (name != null);

		this.namespace = namespace;
		this.name = name;
	}

	public static End on(String namespace, String name) {
		String key = namespace + ":" + name;

		if (!markers.containsKey(key))
			markers.put(key, new End(namespace, name));

		return markers.get(key);
	}

	public String getNamespace() {
		return this.namespace;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}

	@Override
	public String toString() {
		return "</" + namespace + ":" + name + ">";
	}
}
