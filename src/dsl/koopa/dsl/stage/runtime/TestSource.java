package koopa.dsl.stage.runtime;

import koopa.core.data.Token;
import koopa.core.sources.Source;

public interface TestSource {
	Source<Token> forSample(String sample);
}
