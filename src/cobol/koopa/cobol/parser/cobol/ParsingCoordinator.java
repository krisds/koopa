package koopa.cobol.parser.cobol;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.parser.ParseResults;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.sources.ChainableSource;

public class ParsingCoordinator {
	private List<ChainableSource<Token>> intermediateTokenizers = new LinkedList<ChainableSource<Token>>();

	private List<ParsingListener> parsingListeners = new LinkedList<ParsingListener>();

	private boolean keepingTrackOfTokens = false;

	private SourceFormat format = SourceFormat.FIXED;

	/** EXPERIMENTAL */
	private boolean preprocessing = false;

	/** EXPERIMENTAL */
	private List<File> copybookPaths = new ArrayList<File>();

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
		this.copybookPaths.addAll(parsingCoordinator.copybookPaths);
	}

	public SourceFormat getFormat() {
		return format;
	}

	public void setFormat(SourceFormat format) {
		this.format = format;
	}

	public void addParsingListener(ParsingListener listener) {
		this.parsingListeners.add(listener);
	}

	public ParseResults parse(File file) throws IOException {
		CobolParser parser = new CobolParser();

		parser.setFormat(this.format);
		parser.setKeepingTrackOfTokens(keepingTrackOfTokens);

		for (ChainableSource<Token> intermediateTokenizer : this.intermediateTokenizers) {
			parser.addIntermediateTokenizer(intermediateTokenizer);
		}

		parser.setPreprocessing(this.preprocessing);
		parser.setCopybookPath(this.copybookPaths);

		fireBeforeParsing(file, parser);

		parser.setBuildTrees(true);
		ParseResults results = parser.parse(file);

		fireAfterParsing(file, results);

		return results;
	}

	private void fireBeforeParsing(File file, CobolParser config) {
		for (ParsingListener listener : this.parsingListeners) {
			listener.beforeParsing(file, config);
		}
	}

	private void fireAfterParsing(File file, ParseResults results) {
		for (ParsingListener listener : this.parsingListeners) {
			listener.afterParsing(file, results);
		}
	}

	public void addIntermediateTokenizer(ChainableSource<Token> tokenizer) {
		this.intermediateTokenizers.add(tokenizer);
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

		this.copybookPaths.add(path);
	}

	/** EXPERIMENTAL ! */
	public List<File> getCopybookPaths() {
		return new ArrayList<File>(copybookPaths);
	}

	/** EXPERIMENTAL ! */
	public void removeCopybookPath(File path) {
		copybookPaths.remove(path);
	}
}
