package koopa.dsl.stage.grammar.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.grammar.StageGrammar;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.source.StageTokens;
import koopa.dsl.stage.util.StageUtil;

public class StageGrammarTests extends GrammarTestSuite {

	@Override
	public File[] getStageFiles() {
		return new File("test/dsl/koopa/dsl/stage/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	@Override
	public Grammar getGrammar() {
		return new StageGrammar();
	}

	@Override
	public Source getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);

		return StageTokens.getNewSource("", reader);
	}
}
