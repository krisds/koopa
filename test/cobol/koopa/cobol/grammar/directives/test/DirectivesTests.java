package koopa.cobol.grammar.directives.test;

import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.grammar.directives.DirectivesGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.grammars.Grammar;
import koopa.core.sources.BasicTokens;
import koopa.core.sources.Source;
import koopa.core.sources.TagAll;
import koopa.dsl.stage.runtime.GrammarTestSuite;

public abstract class DirectivesTests extends GrammarTestSuite {

	@Override
	public Grammar getGrammar() {
		return DirectivesGrammar.instance();
	}

	@Override
	public Source getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);

		final Source basicTokens = BasicTokens.getNewSource(null,
				reader);
		final Source freeTokens = new TagAll(basicTokens,
				getSourceFormat());
		return freeTokens;
	}

	protected abstract SourceFormat getSourceFormat();
}
