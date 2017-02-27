package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.io.Reader;

public class BasicTokens {
	public static Source getNewSource(String resourceName,
			Reader reader) {

		// Split lines...
		final LineSplitter lineSplitter //
				= new LineSplitter(resourceName, reader);

		// And mark everything as program text...
		final TagAll tagAllAsProgramText //
				= new TagAll(lineSplitter, PROGRAM_TEXT_AREA);

		// Separate the tokens...
		final TokenSeparator tokenSeparator //
				= new TokenSeparator(
						tagAllAsProgramText);

		return tokenSeparator;
	}
}
