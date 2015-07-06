package koopa.cobol.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.cobol.Copybooks;
import koopa.cobol.sources.SourceFormat;

public class ParsingCoordinator {

	private boolean keepingTrackOfTokens = false;
	// TODO buildTrees option ?

	private SourceFormat format = SourceFormat.FIXED;

	/** EXPERIMENTAL */
	private boolean preprocessing = false;

	/** EXPERIMENTAL */
	private Copybooks copybooks = new Copybooks();

	public ParsingCoordinator() {
	}

	/**
	 * Creates a new coordinator which is a (partial) copy of the given one. In
	 * particular the new coordinator will use the same format, and
	 * preprocessing configuration as the given coordinator.
	 */
	public ParsingCoordinator(ParsingCoordinator parsingCoordinator) {
		this.keepingTrackOfTokens = parsingCoordinator.keepingTrackOfTokens;
		this.format = parsingCoordinator.format;
		this.preprocessing = parsingCoordinator.preprocessing;
		this.copybooks.addAllFrom(parsingCoordinator.copybooks);
	}

	public SourceFormat getFormat() {
		return format;
	}

	public void setFormat(SourceFormat format) {
		this.format = format;
	}

	public ParseResults parse(File file) throws IOException {
		CobolParser parser = new CobolParser();

		parser.setFormat(format);
		parser.setKeepingTrackOfTokens(keepingTrackOfTokens);

		parser.setPreprocessing(preprocessing);
		parser.setCopybooks(copybooks);

		parser.setBuildTrees(true);
		ParseResults results = parser.parse(file);

		return results;
	}

	public boolean isKeepingTrackOfTokens() {
		return keepingTrackOfTokens;
	}

	public void setKeepingTrackOfTokens(boolean keepingTrackOfTokens) {
		this.keepingTrackOfTokens = keepingTrackOfTokens;
	}

	/** EXPERIMENTAL ! */
	public boolean isPreprocessing() {
		return preprocessing;
	}

	/** EXPERIMENTAL ! */
	public void setPreprocessing(boolean preprocessing) {
		this.preprocessing = preprocessing;
	}

	/** EXPERIMENTAL ! */
	public void addCopybookPath(File path) {
		if (path == null)
			return;

		this.copybooks.addPath(path);
	}

	/** EXPERIMENTAL ! */
	public List<File> getCopybookPaths() {
		return copybooks.getPaths();
	}

	/** EXPERIMENTAL ! */
	public void removeCopybookPath(File path) {
		copybooks.removePath(path);
	}
}
