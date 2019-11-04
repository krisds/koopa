package koopa.core.data.markers;

import koopa.core.data.Marker;

/**
 * Marks the start of "land". Anything data following this should hold usable
 * information.
 * <p>
 * This is set up as a singleton class.
 */
public final class OnLand extends Marker {

	private static final OnLand INSTANCE = new OnLand();

	private OnLand() {
	}

	public static OnLand getInstance() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "]LAND]";
	}

	@Override
	public String getName() {
		return "land";
	}
}
