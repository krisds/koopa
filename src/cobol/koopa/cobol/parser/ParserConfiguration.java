package koopa.cobol.parser;

import java.io.File;
import java.io.IOException;


public interface ParserConfiguration {
	public ParseResults parse(File file) throws IOException;
}
