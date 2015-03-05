package koopa.cobol.parser.cobol.preprocessing;

import static koopa.core.trees.jaxen.Jaxen.getMatch;

import java.util.Collection;

import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.treeparsers.Tree;

public class ReplacingPhrase {

	public static enum Mode {
		MATCHING, LEADING, TRAILING;

		public static Mode from(Tree instruction) {
			if (getMatch(instruction, "leading") != null)
				return LEADING;
			else if (getMatch(instruction, "trailing") != null)
				return TRAILING;
			else
				return MATCHING;
		}
	}

	private final Mode mode;
	private final ReplacingPhraseOperand replacing;
	private final ReplacingPhraseOperand by;

	public ReplacingPhrase(Tree instruction) {
		this.mode = Mode.from(instruction);
		this.replacing = new ReplacingPhraseOperand(getMatch(instruction,
				"copyOperandName[1]"));
		this.by = new ReplacingPhraseOperand(getMatch(instruction,
				"copyOperandName[2]"));
	}

	public boolean matches(Source<Token> source) {
		return replacing.matches(source, mode);
	}

	public ReplacingPhraseOperand getOperand() {
		return replacing;
	}

	public ReplacingPhraseOperand getCorrespondingOperand() {
		return by;
	}

	public Collection<? extends Token> getCorrespondingTokens() {
		return by.getTokens();
	}

	@Override
	public String toString() {
		return "REPLACING " + mode + " " + replacing + " BY " + by;
	}
}
