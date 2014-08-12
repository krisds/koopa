package koopa.parsers.cobol;

import java.io.File;

import koopa.parsers.ParseResults;

public interface ParsingListener {

	void beforeParsing(File file, CobolParser config);

	void afterParsing(File file, ParseResults results);

}
