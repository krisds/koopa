package koopa.processing.cyclomp;

import java.io.File;

import koopa.app.parsers.ExtendedParserConfiguration;
import koopa.app.parsers.ParseResults;
import koopa.app.parsers.ParsingListener;

public class CyclomaticComplexityParsingListener implements ParsingListener {

	public void beforeParsing(File file, ExtendedParserConfiguration config) {
		config.addCommonTreeProcessor(new CyclomaticComplexityProcessor());
	}

	public void afterParsing(File file, ParseResults results) {
	}
}
