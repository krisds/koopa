package koopa.dsl.kg.sources.test;

import java.io.Reader;
import java.io.StringReader;

import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.kg.source.KGTokens;
import koopa.dsl.stage.runtime.TestSource;

public class KGTestSource implements TestSource {

	public Source<Token> forSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);

		return KGTokens.getNewSource("", reader);
	}
}
