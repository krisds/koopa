package koopa.dsl.kg.grammar.test;

import java.io.File;

import koopa.dsl.stage.runtime.AllStagesTest;
import koopa.dsl.stage.util.StageUtil;

public class KGGrammarTests extends AllStagesTest {

	public File[] getFiles() {
		return new File("test/dsl/koopa/dsl/kg/grammar/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}
}
