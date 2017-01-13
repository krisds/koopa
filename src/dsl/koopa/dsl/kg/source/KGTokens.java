package koopa.dsl.kg.source;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.sources.NarrowingSource.narrowing;
import static koopa.core.sources.WideningSource.widening;

import java.io.Reader;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.BashStyleComments;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.sources.TagAll;
import koopa.core.sources.TokenSeparator;

public class KGTokens {
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
						widening(Data.class, tagAllAsProgramText, Token.class));

		// And mark comments...
		return new BashStyleComments(narrowing(tokenSeparator, Token.class));
	}
}
