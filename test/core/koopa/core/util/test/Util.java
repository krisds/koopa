package koopa.core.util.test;

import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Range;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.treeparsers.Tree;

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

	public static Tree tree(String name, Object... parts) {
		Start start = Start.on("test", name);

		Tree tree = new Tree(start);

		for (Object part : parts) {
			if (part instanceof Tree)
				tree.addChild((Tree) part);
			else if (part instanceof String)
				tree.addChild(token((String) part));
			else
				throw new IllegalArgumentException(
						"This is neither a Tree or a String: " + part);
		}

		return tree;
	}

	public static Tree token(String text, Object... tags) {
		Position start = new Position(0, 0, 0);
		Token token = new Token(text, start, start.offsetBy(text.length()));

		if (tags != null)
			token = token.withTags(tags);

		Tree tree = new Tree(token);

		return tree;
	}

}
