package koopa.cobol.sources.test;

import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.CobolTokens;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.TestSource;

public class CobolTestSource implements TestSource {

	public Source<Token> forSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);
		final SourceFormat initialSourceFormat = SourceFormat.FREE;

		return CobolTokens.getNewSource(reader, grammar, initialSourceFormat);
	}
}
