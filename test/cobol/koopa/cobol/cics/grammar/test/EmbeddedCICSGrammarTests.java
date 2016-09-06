package koopa.cobol.cics.grammar.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.CobolTokens;
import koopa.cobol.cics.grammar.CICSGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.util.StageUtil;

/**
 * Triggers all CICS grammar unit tests.
 */
public class EmbeddedCICSGrammarTests extends GrammarTestSuite {
	public File[] getStageFiles() {
		return new File("test/cobol/koopa/cobol/cics/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	public Grammar getGrammar() {
		return new CICSGrammar();
	}

	public Source<Token> getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);
		final SourceFormat initialSourceFormat = SourceFormat.FREE;

		return CobolTokens.getNewSource(reader, grammar, initialSourceFormat);
	}
}
