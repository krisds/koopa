package koopa.app.cc;

import java.io.File;

import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.cobol.CobolParser;
import koopa.cobol.parser.cobol.ParsingListener;

public class CyclomaticComplexityParsingListener implements ParsingListener {

	public void beforeParsing(File file, CobolParser config) {
		config.addCommonTreeProcessor(new CyclomaticComplexityProcessor());
	}

	public void afterParsing(File file, ParseResults results) {
	}
}
