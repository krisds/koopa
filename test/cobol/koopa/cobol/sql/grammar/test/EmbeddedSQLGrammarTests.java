package koopa.cobol.sql.grammar.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.CobolTokens;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sql.grammar.SQLGrammar;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.util.StageUtil;

/**
 * Triggers all SQL grammar unit tests.
 * <p>
 * <b>When adding a new stage you must also include the compiled results in the
 * overall test suite defined here !</b>
 */
public class EmbeddedSQLGrammarTests extends GrammarTestSuite {
	public File[] getStageFiles() {
		return new File("test/cobol/koopa/cobol/sql/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	public Grammar getGrammar() {
		return new SQLGrammar();
	}

	public Source<Token> getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);
		final SourceFormat initialSourceFormat = SourceFormat.FREE;

		return CobolTokens.getNewSource(reader, grammar, initialSourceFormat);
	}
}
