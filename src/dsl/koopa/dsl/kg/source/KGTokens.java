package koopa.dsl.kg.source;

import java.io.Reader;

import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;

public class KGTokens {
	public static Source<Token> getNewSource(String resourceName, Reader reader) {
		Source<Token> source;

		source = new LineSplitter(resourceName, reader);
		source = new KGTokenizer(source);

		return source;
	}
}
