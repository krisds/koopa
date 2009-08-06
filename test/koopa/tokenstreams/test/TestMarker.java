package koopa.tokenstreams.test;

import koopa.tokenstreams.Marker;

public class TestMarker extends Marker {
	private Object value = null;

	public TestMarker(Object value) {
		this.value = value;
	}

	public String toString() {
		return "<<" + value.toString() + ">>";
	}

	public String getName() {
		return toString();
	}
}
