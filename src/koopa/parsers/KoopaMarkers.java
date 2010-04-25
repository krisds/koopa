package koopa.parsers;

import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.LandMarker;
import koopa.parsers.markers.UpMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokenstreams.Marker;

public class KoopaMarkers {
	public static Marker down(final String name) {
		return DownMarker.getMarker(name);
	}

	public static Marker up(final String name) {
		return UpMarker.getMarker(name);
	}

	public static WaterMarker water() {
		return WaterMarker.getInstance();
	}

	public static Marker land() {
		return LandMarker.getInstance();
	}
}
