package koopa.parsers.markers;

import java.util.HashMap;
import java.util.Map;

import koopa.tokenstreams.Marker;

public final class UpMarker extends Marker {

	private static Map<String, UpMarker> markers = new HashMap<String, UpMarker>();

	private final String name;

	private UpMarker(String name) {
		assert (name != null);
		this.name = name;
	}

	public static UpMarker getMarker(String name) {
		if (!markers.containsKey(name)) {
			markers.put(name, new UpMarker(name));
		}

		return markers.get(name);
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "]" + name + "]";
	}
}
