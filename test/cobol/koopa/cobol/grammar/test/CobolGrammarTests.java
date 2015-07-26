package koopa.cobol.grammar.test;

import java.io.File;

import koopa.dsl.stage.runtime.AllStagesTest;
import koopa.dsl.stage.util.StageUtil;

public class CobolGrammarTests extends AllStagesTest {

	public File[] getFiles() {
		return new File("test/cobol/koopa/cobol/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}
}
