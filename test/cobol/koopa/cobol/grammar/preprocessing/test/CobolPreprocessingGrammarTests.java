package koopa.cobol.grammar.preprocessing.test;

import java.io.File;

import koopa.dsl.stage.runtime.AllStagesTest;
import koopa.dsl.stage.util.StageUtil;

public class CobolPreprocessingGrammarTests extends AllStagesTest {

	public File[] getFiles() {
		return new File("test/cobol/koopa/cobol/grammar/preprocessing/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}
}
