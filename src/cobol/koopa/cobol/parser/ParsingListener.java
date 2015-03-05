package koopa.cobol.parser;

import java.io.File;

public interface ParsingListener {

	void beforeParsing(File file, CobolParser config);

	void afterParsing(File file, ParseResults results);

}
