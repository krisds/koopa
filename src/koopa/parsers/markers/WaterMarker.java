package koopa.parsers.markers;

import koopa.tokenstreams.Marker;

public final class WaterMarker extends Marker {

	private static final WaterMarker INSTANCE = new WaterMarker();

	private WaterMarker() {
	}

	public static WaterMarker getInstance() {
		return INSTANCE;
	}

	public String toString() {
		return "[WATER[";
	}

	public String getName() {
		return "water";
	}
}
