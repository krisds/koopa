package koopa.dsl.stage.runtime;

import java.io.File;

public interface SampleBasedTest {
	File[] getFiles();

	void setData(String grammarName, String testSourceName, String targetName,
			boolean shouldAccept, String sample);

}
