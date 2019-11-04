package koopa.cobol.grammar.preprocessing.test;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;

import koopa.cobol.CobolProject;
import koopa.cobol.CobolTokens;
import koopa.cobol.projects.BasicCobolProject;
import koopa.cobol.sources.SourceFormat;
import koopa.core.grammars.Grammar;
import koopa.core.sources.Source;
import koopa.dsl.stage.runtime.GrammarTestSuite;
import koopa.dsl.stage.util.StageUtil;

public class CobolPreprocessingGrammarTests extends GrammarTestSuite {

	private final CobolProject project = new BasicCobolProject();

	public CobolPreprocessingGrammarTests() {
		project.setDefaultFormat(SourceFormat.FREE);
	}

	@Override
	public File[] getStageFiles() {
		return new File("test/cobol/koopa/cobol/grammar/preprocessing/test/")
				.listFiles(StageUtil.getFilenameFilter());
	}

	@Override
	public Grammar getGrammar() {
		return project.getGrammar();
	}

	@Override
	public Source getSourceForSample(String sample, Grammar grammar) {
		final Reader reader = new StringReader(sample);
		return CobolTokens.getNewSource(reader, project);
	}
}
