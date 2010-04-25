package koopa.parsers.markers;

import koopa.tokenstreams.Marker;

public final class LandMarker extends Marker {

	private static final LandMarker INSTANCE = new LandMarker();

	private LandMarker() {
	}

	public static LandMarker getInstance() {
		return INSTANCE;
	}

	public String toString() {
		return "]LAND]";
	}

	public String getName() {
		return "land";
	}
}
