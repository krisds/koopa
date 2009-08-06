package koopa.parsers.markers;

import koopa.tokenstreams.Marker;

public class LandMarker extends Marker {

	public LandMarker() {
	}

	public String toString() {
		return "~~//";
	}

	public String getName() {
		return "land";
	}
}
