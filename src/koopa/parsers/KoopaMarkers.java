package koopa.parsers;

import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.LandMarker;
import koopa.parsers.markers.UpMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokenstreams.Marker;

public class KoopaMarkers {
	public static Marker down(final String name) {
		return new DownMarker(name);
	}

	public static Marker up(final String name) {
		return new UpMarker(name);
	}

	public static WaterMarker water() {
		return new WaterMarker();
	}

	public static Marker land() {
		return new LandMarker();
	}
}
