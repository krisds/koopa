package sandbox.jaxen;

import java.io.File;

import koopa.app.parsers.ExtendedParserConfiguration;
import koopa.app.parsers.ParseResults;
import koopa.app.parsers.ParsingListener;


public class MyJaxenParsingListener implements ParsingListener {

	public void beforeParsing(File file, ExtendedParserConfiguration config) {
		config.addCommonTreeProcessor(new MyJaxenTreeProcessor());
	}

	public void afterParsing(File file, ParseResults results) {
	}
}
