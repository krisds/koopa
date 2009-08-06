package koopa.parsers.markers;

import koopa.tokenstreams.Marker;

public class UpMarker extends Marker {

	private String name = null;

	public UpMarker(String name) {
		assert (name != null);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "]" + name + "]";
	}
}
