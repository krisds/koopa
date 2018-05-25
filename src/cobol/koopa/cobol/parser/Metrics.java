package koopa.cobol.parser;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.IslandTag.LAND;
import static koopa.core.data.tags.IslandTag.WATER;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.targets.TokenTracker;

public class Metrics {

	public static float getCoverage(ParseResults results) {
		if (!results.isValidInput())
			return 0;

		final Parse parse = results.getParse();
		final TokenTracker tokenTracker = parse.getTarget(TokenTracker.class);

		if (tokenTracker == null)
			return 0;

		int land = 0;
		int water = 0;

		for (Token token : tokenTracker.getTokens()) {
			if (!isSignificantToken(token))
				continue;

			if (token.hasTag(LAND))
				land += 1;

			else if (token.hasTag(WATER))
				water += 1;
		}

		if (land == 0 && water == 0)
			return 100;

		return 100f * land / ((float) land + (float) water);
	}

	public static int getSignificantTokenCount(ParseResults results) {
		final TokenTracker tokenTracker = results.getParse().getTarget(
				TokenTracker.class);

		if (tokenTracker == null)
			return 0;

		int count = 0;

		for (Token token : tokenTracker.getTokens())
			if (isSignificantToken(token))
				count += 1;

		return count;
	}
	
	private static boolean isSignificantToken(Token token) {
		// Ignoring everything that's not program text.
		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return false;

		// Ignore all comments within the program text.
		if (token.hasTag(COMMENT))
			return false;

		// Ignoring whitespace.
		if (token.hasTag(SEPARATOR) && token.getText().trim().length() == 0)
			return false;
		
		return true;
	}
}
