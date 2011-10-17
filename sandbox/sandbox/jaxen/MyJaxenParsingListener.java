package sandbox.jaxen;

import java.io.File;

import koopa.parsers.ParseResults;
import koopa.parsers.cobol.CobolParser;
import koopa.parsers.cobol.ParsingListener;


public class MyJaxenParsingListener implements ParsingListener {

	public void beforeParsing(File file, CobolParser config) {
		config.addCommonTreeProcessor(new MyJaxenTreeProcessor());
	}

	public void afterParsing(File file, ParseResults results) {
	}
}
