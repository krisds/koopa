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

	private static Map<String, Start> markers = new HashMap<>();

	private final String namespace;
	private final String name;

	private Start(String namespace, String name) {
		assert (namespace != null);
		assert (name != null);

		this.namespace = namespace;
		this.name = name;
	}

	public static Start on(String namespace, String name) {
		final String key = namespace + ":" + name;

		if (!markers.containsKey(key))
			markers.put(key, new Start(namespace, name));

		return markers.get(key);
	}

	public String getNamespace() {
		return this.namespace;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public End matchingEnd() {
		return End.on(namespace, name);
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
		return "<" + namespace + ":" + name + ">";
	}
}
