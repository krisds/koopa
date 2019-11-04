package koopa.cobol.projects;

import java.io.File;

import koopa.cobol.CobolFiles;
import koopa.cobol.CobolProject;
import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.parsers.ParserCombinator;
import koopa.core.util.TabStops;

/**
 * A {@link CobolProject} which only tracks defaults and returns them for all
 * files. It will not resolve copybooks.
 * <p>
 * Provides a good base for other CobolProject implementations.
 */
public class BasicCobolProject implements CobolProject {

	protected static final CobolGrammar grammar = CobolGrammar.instance();

	private SourceFormat defaultFormat = SourceFormat.FIXED;
	private int defaultTabLength = 1;
	private TabStops tabStops = new TabStops();
	private boolean defaultPreprocessing = false;

	@Override
	public CobolProject duplicate() {
		final BasicCobolProject project = new BasicCobolProject();
		copyBasicSettingsInto(project);
		return project;
	}

	protected void copyBasicSettingsInto(final BasicCobolProject project) {
		project.defaultFormat = defaultFormat;
		project.defaultTabLength = defaultTabLength;
		project.tabStops = tabStops.duplicate();
		project.defaultPreprocessing = defaultPreprocessing;
	}

	@Override
	public File locateCopybook(String textName, String libraryName,
			File sourceFile) {
		return null;
	}

	@Override
	public ParserCombinator parserFor(File file) {
		final boolean isCopybook = CobolFiles.isCopybook(file);
		return isCopybook ? grammar.copybook() : grammar.compilationGroup();
	}

	@Override
	public CobolGrammar getGrammar() {
		return grammar;
	}

	@Override
	public SourceFormat getDefaultFormat() {
		return defaultFormat;
	}

	@Override
	public void setDefaultFormat(SourceFormat format) {
		this.defaultFormat = format;
	}

	@Override
	public SourceFormat getFormat(File file) {
		return getDefaultFormat();
	}

	@Override
	public int getDefaultTabLength() {
		return defaultTabLength;
	}

	@Override
	public void setDefaultTabLength(int tabLength) {
		if (tabLength < 1)
			throw new IllegalArgumentException(
					"Tab length must be 1 or greater. Got: " + tabLength);
		this.defaultTabLength = tabLength;
	}

	@Override
	public int getTabLength(File file) {
		return getDefaultTabLength();
	}

	@Override
	public void setDefaultTabStops(TabStops tabStops) {
		this.tabStops = tabStops;
	}

	@Override
	public TabStops getDefaultTabStops() {
		return tabStops;
	}

	@Override
	public TabStops getTabStops(File file) {
		return tabStops;
	}

	@Override
	public void setDefaultPreprocessing(boolean preprocessing) {
		this.defaultPreprocessing = preprocessing;
	}

	@Override
	public boolean isDefaultPreprocessing() {
		return this.defaultPreprocessing;
	}

	@Override
	public boolean isPreprocessing(File file) {
		return isDefaultPreprocessing();
	}
}
