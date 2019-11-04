package koopa.cobol.grammar.directives.test;

import java.io.File;

import koopa.cobol.sources.SourceFormat;
import koopa.dsl.stage.util.StageUtil;

public class FixedDirectivesTests extends DirectivesTests {

	@Override
	public File[] getStageFiles() {
		return new File("test/cobol/koopa/cobol/grammar/directives/test/fixed/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	@Override
	protected SourceFormat getSourceFormat() {
		return SourceFormat.FIXED;
	}
}
