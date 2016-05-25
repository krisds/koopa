package koopa.core.data;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import koopa.core.trees.Tree;

public class Replaced {

	private final Tree data;
	private final Replaced context;

	private final Position start;
	private final Position end;

	public Replaced(Tree data, Replaced context) {
		this.data = data;
		this.context = context;

		this.start = data.getRawStart();
		this.end = data.getRawEnd();
	}

	public Tree getData() {
		return data;
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

	public static Set<Replaced> getAllIn(Iterator<Token> tokens) {
		Set<Replaced> all = new LinkedHashSet<Replaced>();

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

	@Override
	public String toString() {
		return data.getProgramText();
	}
}
