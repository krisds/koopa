package koopa.core.data;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Replaced {

	private final Replaced context;

	private final Position start;
	private final Position end;

	public Replaced(Position start, Position end, Replaced context) {
		this.context = context;

		this.start = start;
		this.end = end;
	}

	public Replaced getContext() {
		return context;
	}

	public Position getStart() {
		return start;
	}

	public Position getEnd() {
		return end;
	}

	/**
	 * Given an iteration of tokens, this returns the set of replacements which
	 * were found to be active inside them.
	 */
	@Deprecated
	public static Set<Replaced> getAllIn(Iterator<Token> tokens) {
		Set<Replaced> all = new LinkedHashSet<>();

		while (tokens.hasNext()) {
			final Token token = tokens.next();
			if (!token.isReplacement())
				continue;

			Replaced replaced = token.getReplaced();
			while (replaced != null && !all.contains(replaced)) {
				all.add(replaced);
				replaced = replaced.getContext();
			}
		}

		return all;
	}
}
