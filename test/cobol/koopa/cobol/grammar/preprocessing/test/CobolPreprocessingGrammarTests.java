package koopa.cobol.grammar.preprocessing.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.CobolTokens;
import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.util.StageUtil;

public class CobolPreprocessingGrammarTests extends GrammarTestSuite {

	public File[] getStageFiles() {
		return new File("test/cobol/koopa/cobol/grammar/preprocessing/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}
	
	public Grammar getGrammar() {
		return new CobolPreprocessingGrammar();
	}
	
	public Source<Token> getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);
		final SourceFormat initialSourceFormat = SourceFormat.FREE;

		return CobolTokens.getNewSource(reader, grammar, initialSourceFormat);
	}
}
