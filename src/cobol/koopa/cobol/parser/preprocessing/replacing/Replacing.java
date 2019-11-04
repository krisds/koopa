package koopa.cobol.parser.preprocessing.replacing;

import static koopa.core.trees.jaxen.Jaxen.getMatch;

import java.util.ArrayList;
import java.util.List;

import koopa.cobol.parser.preprocessing.replacing.ReplacingPhrase.Mode;
import koopa.core.trees.Tree;

public final class Replacing {

	private Replacing() {
	}

	public static List<ReplacingPhrase> allPhrasesFrom(List<Tree> definitions) {
		final List<ReplacingPhrase> replacingPhrases = new ArrayList<>(definitions.size());

		for (Tree replacement : definitions)
			replacingPhrases.add(phraseFrom(replacement));

		return replacingPhrases;
	}

	private static ReplacingPhrase phraseFrom(Tree definition) {
		final Mode mode = Mode.from(definition);

		final ReplacingPhraseOperand replacing = ReplacingPhraseOperand.from(//
				getMatch(definition, "replacementOperand[1]"));
		final ReplacingPhraseOperand by = ReplacingPhraseOperand.from(//
				getMatch(definition, "replacementOperand[2]"));

		// "For purposes of matching, text-1, word-1, and literal-3 are treated
		// as pseudo-text containing only text-1, word-1, or literal-3,
		// respectively."
		//
		// So we can match everything the same way we match pseudo-text.

		switch (mode) {
		case MATCHING:
			return new ReplaceMatching(replacing, by);
		case LEADING:
			return new ReplaceLeading(replacing, by);
		case TRAILING:
			return new ReplaceTrailing(replacing, by);
		default:
			return new ReplaceNone();
		}
	}
}
