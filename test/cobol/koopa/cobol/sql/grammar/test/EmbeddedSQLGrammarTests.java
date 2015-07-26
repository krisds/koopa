package koopa.cobol.sql.grammar.test;

import java.io.File;

import koopa.dsl.stage.runtime.AllStagesTest;
import koopa.dsl.stage.util.StageUtil;

/**
 * Triggers all SQL grammar unit tests.
 * <p>
 * <b>When adding a new stage you must also include the compiled results in the
 * overall test suite defined here !</b>
 */
public class EmbeddedSQLGrammarTests extends AllStagesTest {
	public File[] getFiles() {
		return new File("test/cobol/koopa/cobol/sql/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}
}
