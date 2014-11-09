package koopa.core.util.test;

import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Range;

public final class Util {
	public static List<Range> asListOfRanges(int... positions) {
		List<Range> ranges = new ArrayList<Range>();

		for (int i = 0; i < positions.length; i += 2) {
			int from = positions[i];
			int to = positions[i + 1];
			ranges.add(new Range(new Position(from, 0, from), new Position(to,
					0, to)));
		}

		return ranges;
	}
}
