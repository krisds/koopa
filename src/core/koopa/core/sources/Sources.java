package koopa.core.sources;

import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.util.LinkedList;

import koopa.core.data.Data;
import koopa.core.data.Token;

public final class Sources {

	private Sources() {
	}

	public static LinkedList<Data> getLine(Source source) {
		LinkedList<Data> line = null;

		while (true) {
			final Data d = source.next();

			if (d == null)
				return line;

			if (line == null)
				line = new LinkedList<>();

			line.add(d);

			if (d instanceof Token && ((Token) d).hasTag(END_OF_LINE))
				return line;
		}
	}
}
