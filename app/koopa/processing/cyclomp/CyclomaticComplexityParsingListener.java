package koopa.processing.cyclomp;

import java.io.File;

import koopa.parsers.ParseResults;
import koopa.parsers.cobol.CobolParser;
import koopa.parsers.cobol.ParsingListener;

public class CyclomaticComplexityParsingListener implements ParsingListener {

	public void beforeParsing(File file, CobolParser config) {
		config.addCommonTreeProcessor(new CyclomaticComplexityProcessor());
	}

	public void afterParsing(File file, ParseResults results) {
	}
}
