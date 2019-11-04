package koopa.core.data.markers;

import koopa.core.data.Marker;

/**
 * Marks the start of "water". Anything data following this has not really been
 * parsed.
 * <p>
 * This is set up as a singleton class.
 */
public final class InWater extends Marker {

	private static final InWater INSTANCE = new InWater();

	private InWater() {
	}

	public static InWater getInstance() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "[WATER[";
	}

	@Override
	public String getName() {
		return "water";
	}
}
