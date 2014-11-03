package koopa.cobol.parser;

import koopa.cobol.data.tags.SyntacticTag;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.data.tags.IslandTag;
import koopa.core.targets.TokenTracker;

public class Metrics {

	public static float getCoverage(ParseResults results) {
		if (!results.isValidInput()) {
			return 0;
		}

		final TokenTracker tokenTracker = results.getTokenTracker();
		if (tokenTracker == null) {
			return 0;
		}

		int land = 0;
		int water = 0;

		for (Token token : tokenTracker.getTokens()) {
			// Ignoring everything that's not program text.
			if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				continue;
			}

			// Ignoring whitespace.
			if (token.hasTag(SyntacticTag.SEPARATOR)
					&& token.getText().trim().length() == 0) {
				continue;
			}

			if (token.hasTag(IslandTag.LAND)) {
				land += 1;

			} else if (token.hasTag(IslandTag.WATER)) {
				water += 1;
			}
		}

		if (land == 0 && water == 0) {
			return 100;
		}

		return 100f * land / ((float) land + (float) water);
	}

	public static int getSignificantTokenCount(ParseResults results) {
		final TokenTracker tokenTracker = results.getTokenTracker();
		if (tokenTracker == null) {
			return 0;
		}

		int count = 0;

		for (Token token : tokenTracker.getTokens()) {
			// Ignoring everything that's not program text.
			if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				continue;
			}

			// Ignoring whitespace.
			if (token.hasTag(SyntacticTag.SEPARATOR)
					&& token.getText().trim().length() == 0) {
				continue;
			}

			count += 1;
		}

		return count;
	}
}
