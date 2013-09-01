package koopa.parsers.cobol;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.parsers.ParseResults;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.generic.IntermediateTokenizer;

public class ParsingCoordinator {
	private List<IntermediateTokenizer> intermediateTokenizers = new LinkedList<IntermediateTokenizer>();

	private List<ParsingListener> parsingListeners = new LinkedList<ParsingListener>();

	private boolean keepingTrackOfTokens = false;

	private SourceFormat format = SourceFormat.FIXED;

	/** EXPERIMENTAL */
	private boolean preprocessing = false;

	/** EXPERIMENTAL */
	private List<File> copybookPaths = new ArrayList<File>();

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

		for (IntermediateTokenizer intermediateTokenizer : this.intermediateTokenizers) {
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

	public void addIntermediateTokenizer(IntermediateTokenizer tokenizer) {
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
}
