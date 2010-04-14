package koopa.app.parsers;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import koopa.tokenizers.generic.IntermediateTokenizer;

public class ParsingCoordinator {
	private List<IntermediateTokenizer> intermediateTokenizers = new LinkedList<IntermediateTokenizer>();

	private List<ParsingListener> parsingListeners = new LinkedList<ParsingListener>();

	public void addParsingListener(ParsingListener listener) {
		this.parsingListeners.add(listener);
	}

	public ParseResults parse(File file) throws IOException {
		ExtendedParserConfiguration config = new ExtendedParserConfiguration();

		for (IntermediateTokenizer intermediateTokenizer : this.intermediateTokenizers) {
			config.addIntermediateTokenizer(intermediateTokenizer);
		}

		fireBeforeParsing(file, config);

		ParseResults results = config.parse(file);

		fireAfterParsing(file, results);

		return results;
	}

	private void fireBeforeParsing(File file, ExtendedParserConfiguration config) {
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
}
