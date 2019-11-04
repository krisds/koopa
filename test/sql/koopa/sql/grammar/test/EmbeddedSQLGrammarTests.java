package koopa.sql.grammar.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.core.grammars.Grammar;
import koopa.core.sources.BasicTokens;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.util.StageUtil;
import koopa.sql.grammar.SQLGrammar;

/**
 * Triggers all SQL grammar unit tests.
 * <p>
 * <b>When adding a new stage you must also include the compiled results in the
 * overall test suite defined here !</b>
 */
public class EmbeddedSQLGrammarTests extends GrammarTestSuite {
	@Override
	public File[] getStageFiles() {
		return new File("test/sql/koopa/sql/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	@Override
	public Grammar getGrammar() {
		return SQLGrammar.instance();
	}

	@Override
	public Source getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);

		return BasicTokens.getNewSource("test", reader);
	}
}
