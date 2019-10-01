package koopa.core.util;

import java.util.Arrays;

/**
 * Support for tab stop.
 */
public class TabStops {

	private int[] stops = new int[0];

	/**
	 * True if no tab stops are defined.
	 */
	public boolean undefined() {
		return stops.length == 0;
	}

	/**
	 * Return the smallest tab stop which is greater than the given position. If
	 * no such stop is defined, returns <code>-1</code> instead.
	 */
	public int tabStopAfter(int position) {
		for (int i = 0; i < stops.length; i++)
			if (stops[i] > position)
				return stops[i];

		return -1;
	}

	/**
	 * Set the tab stops as encoded in a comma separated string.
	 * <p>
	 * The string should contain no spaces, have only numbers, and list them in
	 * ascending order.
	 */
	public TabStops fromString(String csv) {
		csv = csv.trim();

		if (csv.length() == 0) {
			stops = new int[0];
			return this;
		}

		final String[] values = csv.split(",");
		final int newStops[] = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			try {
				newStops[i] = Integer.parseInt(values[i]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(
						"Tab stops must be all numeric values.", e);
			}

			if (i > 0 && newStops[i] < newStops[i - 1])
				throw new IllegalArgumentException(
						"Tab stops must be in ascending order.");
		}

		stops = newStops;

		return this;
	}

	/**
	 * Returns the tab stops as a comma separated list.
	 */
	@Override
	public String toString() {
		if (undefined())
			return "";

		final StringBuilder b = new StringBuilder();

		b.append(stops[0]);
		for (int i = 1; i < stops.length; i++) {
			b.append(',');
			b.append(stops[i]);
		}

		return b.toString();
	}

	/**
	 * Returns a copy of this.
	 */
	public TabStops duplicate() {
		final TabStops duplicate = new TabStops();
		duplicate.stops = Arrays.copyOf(stops, stops.length);
		return duplicate;
	}
}
