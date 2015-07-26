package koopa.cobol.cics.grammar.test;

import java.io.File;

import koopa.dsl.stage.runtime.AllStagesTest;
import koopa.dsl.stage.util.StageUtil;

/**
 * Triggers all CICS grammar unit tests.
 * <p>
 * <b>When adding a new stage you must also include the compiled results in the
 * overall test suite defined here !</b>
 */
public class EmbeddedCICSGrammarTests extends AllStagesTest {
	public File[] getFiles() {
		return new File("test/cobol/koopa/cobol/cics/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}
}
