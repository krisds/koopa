package koopa.app.parsers;

import java.io.File;

public interface ParsingListener {

	void beforeParsing(File file, ExtendedParserConfiguration config);

	void afterParsing(File file, ParseResults results);

}
