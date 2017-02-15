package koopa.cobol.grammar.directives.test;

import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.grammar.directives.DirectivesGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.BasicTokens;
import koopa.core.sources.Source;
import koopa.core.sources.TagAll;
import koopa.dsl.stage.runtime.GrammarTestSuite;

public abstract class DirectivesTests extends GrammarTestSuite {

	public Grammar getGrammar() {
		return new DirectivesGrammar();
	}

	public Source<Token> getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);

		final Source<Token> basicTokens = BasicTokens.getNewSource(null,
				reader);
		final Source<Token> freeTokens = new TagAll(basicTokens,
				getSourceFormat());
		return freeTokens;
	}

	protected abstract SourceFormat getSourceFormat();
}
