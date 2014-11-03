package koopa.cobol.parser.cobol;

import java.io.File;

import koopa.cobol.parser.ParseResults;

public interface ParsingListener {

	void beforeParsing(File file, CobolParser config);

	void afterParsing(File file, ParseResults results);

}
