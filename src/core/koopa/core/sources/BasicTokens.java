package koopa.core.sources;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.sources.NarrowingSource.narrowing;
import static koopa.core.sources.WideningSource.widening;

import java.io.Reader;

import koopa.core.data.Data;
import koopa.core.data.Token;

public class BasicTokens {
	public static Source<Token> getNewSource(String resourceName,
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
						widening(tagAllAsProgramText, Token.class, Data.class));

		return narrowing(tokenSeparator, Token.class);
	}
}
