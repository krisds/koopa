package koopa.parsers.markers;

import java.util.HashMap;
import java.util.Map;

import koopa.tokenstreams.Marker;

public final class DownMarker extends Marker {

	private static Map<String, DownMarker> markers = new HashMap<String, DownMarker>();

	private final String name;

	private DownMarker(String name) {
		assert (name != null);
		this.name = name;
	}

	public static DownMarker getMarker(String name) {
		if (!markers.containsKey(name)) {
			markers.put(name, new DownMarker(name));
		}

		return markers.get(name);
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "[" + name + "[";
	}
}
